package com.example.ake.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ake.R;
import com.example.ake.base.BaseAdapter;
import com.example.ake.common.Constant;
import com.example.ake.models.bean.RelatedBottonBean;

import java.util.List;

public class RelateBottonAdapter extends BaseAdapter {

    public RelateBottonAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.layout_relatebotton_item;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        RelatedBottonBean.DataBean.GoodsListBean bottonBean= (RelatedBottonBean.DataBean.GoodsListBean) o;
        ImageView iv = (ImageView) holder.getView(R.id.botton_iv);
        TextView name = (TextView) holder.getView(R.id.bottom_name);
        TextView price = (TextView) holder.getView(R.id.bottom_price);
        Glide.with(mContext).load(bottonBean.getList_pic_url()).into(iv);
        name.setText(bottonBean.getName());
        price.setText(Constant.PRICE_MODEL.replace("$",bottonBean.getRetail_price()+""));
    }
}
