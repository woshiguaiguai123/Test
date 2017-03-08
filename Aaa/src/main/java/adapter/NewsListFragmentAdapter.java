package adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.googl.xcdq.mytest2.R;

import java.util.List;

import entity.NewsInfo;

/**
 * Created by xcdq on 2017/3/8.
 */

public class NewsListFragmentAdapter extends RecyclerView.Adapter<NewsListFragmentAdapter.ViewHolder> {
    private View view;
    private List<NewsInfo> datas;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_newslistfragment, null);
        ViewHolder mViewHolder = new ViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NewsInfo data=datas.get(position);
        holder.mImageView.setImageResource(R.mipmap.ic_launcher_round);
        holder.titlenews.setText(data.title);
        holder.datenews.setText(data.date);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        private TextView titlenews, datenews;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.iv_newsphoto);
            titlenews = (TextView) itemView.findViewById(R.id.tv_title_newslist);
            datenews = (TextView) itemView.findViewById(R.id.tv_date_newslist);
        }
    }
    public void addDatasToAdapter(List<NewsInfo> datas){
        this.datas=datas;
    }
}
