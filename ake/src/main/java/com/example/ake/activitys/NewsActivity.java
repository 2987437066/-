package com.example.ake.activitys;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ake.R;
import com.example.ake.base.BaseActivity;
import com.example.ake.interfaces.home.NewsConstract;
import com.example.ake.models.bean.NewsDetailBean;
import com.example.ake.persenter.home.NewsPersenter;

import butterknife.BindView;

public class NewsActivity extends BaseActivity<NewsConstract.Persenter> implements NewsConstract.View {

    @BindView(R.id.news_banner)
    ImageView iv;
    @BindView(R.id.news_name)
    TextView tv;

    @Override
    protected int getLayout() {
        return R.layout.activity_news;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        persenter.getNewsDetailBean();
    }

    @Override
    protected NewsConstract.Persenter createPersenter() {
        return new NewsPersenter();
    }

    @Override
    public void getNewsDetailReturn(NewsDetailBean result) {
        updateBanner(result.getData().getBannerInfo().getImg_url(),result.getData().getBannerInfo().getName());
    }

    private void updateBanner(String url,String name) {
        Glide.with(this).load(url).into(iv);
        tv.setText(name);
    }
}
