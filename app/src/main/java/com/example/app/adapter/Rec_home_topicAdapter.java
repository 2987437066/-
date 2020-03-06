package com.example.app.adapter;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app.R;
import com.example.app.base.BaseAdapter;
import com.example.app.model.bean.ShouYeBean;

import java.util.List;

public class Rec_home_topicAdapter extends BaseAdapter {


    public Rec_home_topicAdapter(List mDatas) {
        super(mDatas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_home_topic;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {
        ShouYeBean.DataBean.TopicListBean list = (ShouYeBean.DataBean.TopicListBean) mDatas.get(positon);
        ImageView img = (ImageView) holder.getView(R.id.iv_item_topic);
        TextView title = (TextView) holder.getView(R.id.tv_item_topic_title);
        TextView price = (TextView) holder.getView(R.id.tv_item_topic_price);
        TextView desc = (TextView) holder.getView(R.id.tv_item_topic_desc);

        title.setText(list.getTitle());
        price.setText(list.getPrice_info()+"元起");
        desc.setText(list.getSubtitle());
        Glide.with(mContext).load(list.getItem_pic_url()).into(img);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }
}
