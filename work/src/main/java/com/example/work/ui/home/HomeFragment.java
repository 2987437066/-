package com.example.work.ui.home;

import com.example.work.R;
import com.example.work.base.BaseFragmnet;
import com.example.work.interfaces.home.HomeConstract;
import com.example.work.models.bean.IndexBean;
import com.example.work.persenter.home.HomePersenter;

public class HomeFragment extends BaseFragmnet<HomeConstract.Persenter> implements HomeConstract.View {
    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        persenter.getHomeData();
    }

    @Override
    protected HomeConstract.Persenter createPersenter() {
        return new HomePersenter();
    }

    @Override
    public void getHomeDataReturn(IndexBean result) {

    }

    @Override
    public void showTips(String msg) {

    }
}
