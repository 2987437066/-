package com.example.work.persenter.home;

import com.example.work.base.BasePersenter;
import com.example.work.common.CommonSubscriber;
import com.example.work.interfaces.home.HomeConstract;
import com.example.work.models.HttpManager;
import com.example.work.models.bean.IndexBean;
import com.example.work.utils.RxUtils;

public class HomePersenter extends BasePersenter<HomeConstract.View> implements HomeConstract.Persenter{
    @Override
    public void getHomeData() {
        addSubscribe(HttpManager.getInstance().getShopApi().getIndexData()
                .compose(RxUtils.<IndexBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<IndexBean>(mView){

                    @Override
                    public void onNext(IndexBean indexBean) {
                        mView.getHomeDataReturn(indexBean);
                    }
                }));
    }
}
