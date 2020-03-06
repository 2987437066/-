package com.example.app.adapter;

import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app.R;
import com.example.app.base.BaseAdapter;
import com.example.app.model.bean.CatalogItem;

import java.util.List;


public class Rec_sortAdapter extends BaseAdapter {

    public Rec_sortAdapter(List mDatas) {
        super(mDatas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_fenlei;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {
        CatalogItem list = (CatalogItem) mDatas.get(positon);
        ImageView img = (ImageView) holder.getView(R.id.iv_item_fenleii_img);
        Glide.with(mContext).load(list.img).into(img);

        TextView title = (TextView) holder.getView(R.id.tv_item_fenlei_title);
        title.setText(list.name);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }
}
