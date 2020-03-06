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

public class Rec_home_directAdapter extends BaseAdapter {

    public Rec_home_directAdapter(List mDatas) {
        super(mDatas);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_home_direct;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {
        ShouYeBean.DataBean.BrandListBean  baean = (ShouYeBean.DataBean.BrandListBean) mDatas.get(positon);
        ImageView img = (ImageView) holder.getView(R.id.iv_item_home_direct);
        TextView tv = (TextView) holder.getView(R.id.tv_item_home_ck);
        TextView price = (TextView) holder.getView(R.id.tv_item_home_price);
        tv.setText(baean.getName());
        price.setText(baean.getFloor_price()+"元起");
        Glide.with(mContext).load(baean.getNew_pic_url()).into(img);
    }
}
