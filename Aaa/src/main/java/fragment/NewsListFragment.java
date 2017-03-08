package fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.googl.xcdq.mytest2.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import adapter.NewsFragmentAdapter;
import adapter.NewsListFragmentAdapter;
import butterknife.ButterKnife;
import config.NewsConfig;
import entity.NewsInfo;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by xcdq on 2017/3/7.
 */

public class NewsListFragment extends Fragment {
    private View mView;
    private RecyclerView mRecyclerView;
    private NewsListFragmentAdapter mAdapter;
    private List<NewsInfo> datas;
    private String type;
    private String uyl;
    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                datas = (List<NewsInfo>) msg.obj;
                mAdapter = new NewsListFragmentAdapter();
                mAdapter.addDatasToAdapter(datas);
                mRecyclerView.setAdapter(mAdapter);
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.news_list_fragment_layout, null);
        ButterKnife.bind(this, mView);
        type = getArguments().getString("type");
        initWidget();
        return mView;
    }

    private void initWidget() {
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.RecyclerView_NewsListFragment);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);


        requestNews();

    }

    private void requestNews() {
        uyl = NewsConfig.getUrl(type);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder().get().url(uyl).build();
                    Response response = client.newCall(request).execute();
                    String jsonData = response.body().string();

                    Message msg = new Message();
                    msg.what = 1;
                    msg.obj = jsonParse(jsonData);
                    handler.sendMessage(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private List<NewsInfo> jsonParse(String jsonData) {
        List<NewsInfo> data = new ArrayList<>();
        try {
            JSONObject obj1 = new JSONObject(jsonData);
            if (obj1.getString("reason").equals("成功的返回")) {
                JSONObject obj2 = obj1.getJSONObject("result");
                if (obj2.getString("stat").equals("1")) {
                    JSONArray arr1 = obj2.getJSONArray("data");
                    for (int i = 0; i < arr1.length(); i++) {
                        NewsInfo info = new NewsInfo();
                        JSONObject o = arr1.getJSONObject(i);
                        info.title = o.getString("title");
                        info.date = o.getString("date");
                        info.url = o.getString("url");
                        info.thumbnail_pic = o.getString("thumbnail_pic_s");
                        data.add(info);
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }

}
