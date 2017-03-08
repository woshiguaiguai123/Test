package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.googl.xcdq.mytest2.R;

import java.util.ArrayList;
import java.util.List;

import adapter.NewsFragmentAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xcdq on 2017/3/7.
 */

public class NewsFragment extends Fragment {
    private View mView;
    private List<Fragment> fragments;
    private List<String> titles;
    private NewsFragmentAdapter newsFragmentAdapter;
    private String[] types = {"top", "shehui", "guonei", "guoji", "yule", "tiyu", "junshi", "keji", "caijing", "shishang"};
    @BindView(R.id.tablayout_news_fragment)
    TabLayout mTabLayout;
    @BindView(R.id.ViewPager_news_fragment)
    ViewPager mViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.layout_fragment_news, null);
        ButterKnife.bind(this,mView);
        initDatas();
        return mView;
    }

    private void initDatas() {
        newsFragmentAdapter = new NewsFragmentAdapter(getFragmentManager());
        fragments = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            NewsListFragment fragment = new NewsListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("type", types[i]);
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        titles = new ArrayList<>();
        titles.add("头条");
        titles.add("社会");
        titles.add("国内");
        titles.add("国际");
        titles.add("娱乐");
        titles.add("体育");
        titles.add("军事");
        titles.add("科技");
        titles.add("财经");
        titles.add("时尚");

        newsFragmentAdapter.addDatasAdapter(fragments, titles);
        mViewPager.setAdapter(newsFragmentAdapter);
        mTabLayout.setupWithViewPager(mViewPager);//把TabLayout和ViewPager关联上
    }

}
