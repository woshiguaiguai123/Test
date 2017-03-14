package com.googl.xcdq.mytest2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class Main3Activity extends AppCompatActivity {

    private VideoView mVideoView;
    private ProgressBar mProgressBar;
    private TextView downLoadRate;//加载速度
    private TextView loadRate;//加载百分比

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mVideoView = (VideoView) findViewById(R.id.demo_e_vv);
        mProgressBar = (ProgressBar) findViewById(R.id.demo_e_prb);
        downLoadRate = (TextView) findViewById(R.id.demo_e_tvDownloadRate);
        loadRate = (TextView) findViewById(R.id.demo_e_tvLoadRate);

        mVideoView.setVideoPath(VideoUrlRes.getTestVideo2());
        mVideoView.setMediaController(new MediaController(this));

        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mVideoView.setBufferSize(1024 * 512);
            }
        });
        mVideoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer mp, int what, int extra) {
                switch (what) {
                    case MediaPlayer.MEDIA_INFO_BUFFERING_START:
                        startBuffer();
                        break;
                    case MediaPlayer.MEDIA_INFO_BUFFERING_END:
                        endBuffer();
                        break;
                    case MediaPlayer.MEDIA_INFO_DOWNLOAD_RATE_CHANGED:
                        downLoadRate.setText(extra + "/kb");
                }
                return true;
            }
        });
        mVideoView.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            @Override
            public void onBufferingUpdate(MediaPlayer mp, int percent) {
                loadRate.setText(percent + "%");
            }
        });
    }

    private void endBuffer() {
        mVideoView.start();
        mProgressBar.setVisibility(View.INVISIBLE);
        downLoadRate.setVisibility(View.INVISIBLE);
        loadRate.setVisibility(View.INVISIBLE);
    }

    private void startBuffer() {
        if (mVideoView.isPlaying()) mVideoView.pause();
        mProgressBar.setVisibility(View.VISIBLE);
        downLoadRate.setVisibility(View.VISIBLE);
        loadRate.setVisibility(View.VISIBLE);
        //初始化缓冲值
        downLoadRate.setText("");
        loadRate.setText("");
    }
}
