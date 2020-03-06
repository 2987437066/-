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

public class Rec_home_livingHomeAdapter extends BaseAdapter {
    public Rec_home_livingHomeAdapter(List mDatas) {
        super(mDatas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_home_livinghome;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {

        ShouYeBean.DataBean.CategoryListBean.GoodsListBean list = (ShouYeBean.DataBean.CategoryListBean.GoodsListBean) mDatas.get(positon);
        ImageView img = (ImageView) holder.getView(R.id.iv_item_home_livinghome);
        TextView name = (TextView) holder.getView(R.id.tv_item_home_livinghometitle);
        TextView price = (TextView) holder.getView(R.id.tv_item_home_livinghomeprice);
        name.setText(list.getName());
        price.setText("￥"+list.getRetail_price());
        Glide.with(mContext).load(list.getList_pic_url()).into(img);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }
}
