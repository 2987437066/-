package com.example.ake.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ake.R;
import com.example.ake.base.BaseAdapter;
import com.example.ake.common.Constant;
import com.example.ake.models.bean.IndexBean;

import java.util.List;

public class HotAdapter extends BaseAdapter {
    public HotAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.layout_hot_item;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        IndexBean.DataBean.HotGoodsListBean TopList= (IndexBean.DataBean.HotGoodsListBean) o;
        ImageView hot_iv = (ImageView) holder.getView(R.id.hot_iv);
        TextView hot_name = (TextView) holder.getView(R.id.hot_name);
        TextView hot_title = (TextView) holder.getView(R.id.hot_title);
        TextView hot_price = (TextView) holder.getView(R.id.hot_price);
        Glide.with(mContext).load(TopList.getList_pic_url()).into(hot_iv);
        hot_name.setText(TopList.getName());
        hot_title.setText(TopList.getGoods_brief());
        hot_price.setText(Constant.PRICE_MODEL.replace("$",TopList.getRetail_price()));
    }
}
