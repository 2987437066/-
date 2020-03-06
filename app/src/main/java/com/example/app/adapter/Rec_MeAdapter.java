package com.example.app.adapter;

import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app.R;
import com.example.app.base.BaseAdapter;
import com.example.app.model.bean.MeBean;

import java.util.List;

public class Rec_MeAdapter extends BaseAdapter {

    public Rec_MeAdapter(List mDatas) {
        super(mDatas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_me;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {
        MeBean list = (MeBean) mDatas.get(positon);
        ImageView img = (ImageView) holder.getView(R.id.iv_me_item);
        TextView tv = (TextView) holder.getView(R.id.tv_me_item_text);

        tv.setText(list.getText());
        Glide.with(mContext).load(list.getImgpath()).into(img);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }
}
