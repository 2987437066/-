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

public class Rec_specialAdapter extends BaseAdapter {


    public Rec_specialAdapter(List mDatas) {
        super(mDatas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_special;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {
        ShouYeBean.DataBean.TopicListBean list = (ShouYeBean.DataBean.TopicListBean) mDatas.get(positon);
        ImageView img = (ImageView) holder.getView(R.id.iv_item_special_img);
        TextView title = (TextView) holder.getView(R.id.tv_item_special_title);
        TextView desc = (TextView) holder.getView(R.id.tv_item_special_desc);

        title.setText(list.getTitle()+"<font color=\"#FF0000\"> &yen;"+list.getPrice_info()+"元起</font>");
        desc.setText(list.getSubtitle());
        Glide.with(mContext).load(list.getItem_pic_url()).into(img);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }
}
