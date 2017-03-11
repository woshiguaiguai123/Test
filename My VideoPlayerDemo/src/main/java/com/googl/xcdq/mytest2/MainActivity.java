package com.googl.xcdq.mytest2;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.session.MediaController;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.widget.VideoView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private SurfaceView mSurfaceView;
    private TextureView mTextureView;
    private MediaPlayer mediaPlayer;
    private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mVideoView = (VideoView) findViewById(R.id.vv_main);
//        mVideoView.setVideoPath(VideoUrlRes.getTestVideo1());
//        mVideoView.start();
//        android.widget.MediaController mediaController=new android.widget.MediaController(this);
//        mVideoView.setMediaController(mediaController);


        mTextureView = (TextureView) findViewById(R.id.tvvvv);
        mTextureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
            private Surface mSurface1;

            @Override
            public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
                try {
                    mediaPlayer = new MediaPlayer();
                    mSurface1 = new Surface(surface);
                    mediaPlayer.setSurface(mSurface1);
                    mediaPlayer.setDataSource(VideoUrlRes.getTestVideo1());
                    mediaPlayer.prepareAsync();
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            mediaPlayer.start();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

            }

            @Override
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
                mediaPlayer.stop();
                mSurface1.release();
                mSurface1 = null;
                return false;
            }

            @Override
            public void onSurfaceTextureUpdated(SurfaceTexture surface) {

            }
        });
        mTextureView.setAlpha(0.5f);
        mTextureView.setRotation(1f);

//        mSurfaceView = (SurfaceView) findViewById(R.id.sv_main);
//        final SurfaceHolder sh = mSurfaceView.getHolder();
//        sh.addCallback(new SurfaceHolder.Callback() {
//            @Override
//            public void surfaceCreated(SurfaceHolder holder) {
//                //拿到mediaplayer的对象
//                mediaPlayer = new MediaPlayer();
//                //关联mediaplayer和surfaceview
//                mediaPlayer.setDisplay(sh);
//                try {
//                    //设置资源
//                    mediaPlayer.setDataSource(VideoUrlRes.getTestVideo1());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                //设置异步加载
//                mediaPlayer.prepareAsync();
//                //是指一个什么时候加载完成的一个监听
//                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                    @Override
//                    public void onPrepared(MediaPlayer mp) {
//                        //开始播放视屏
//                        mediaPlayer.start();
//                    }
//                });
//            }
//
//            @Override
//            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
//
//            }
//
//            @Override
//            public void surfaceDestroyed(SurfaceHolder holder) {
//
//            }
//        });
    }
}
