package com.example.app.adapter;

import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app.R;
import com.example.app.base.BaseAdapter;
import com.example.app.model.bean.GoodsDescListBean;

import java.util.List;

public class Rec_home_descAdapter extends BaseAdapter {
    public Rec_home_descAdapter(List mDatas) {
        super(mDatas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_home_yisi;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {
        GoodsDescListBean.DataBeanX.DataBean list = (GoodsDescListBean.DataBeanX.DataBean) mDatas.get(positon);
        ImageView img = (ImageView) holder.getView(R.id.iv_item_shouye_yisi);
        TextView name = (TextView) holder.getView(R.id.tv_item_shouye_yisiname);
        TextView price = (TextView) holder.getView(R.id.tv_item_shouye_yisiprice);

        name.setText(list.getName());
        price.setText(list.getRetail_price()+"元起");
        Glide.with(mContext).load(list.getList_pic_url()).into(img);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }
}
