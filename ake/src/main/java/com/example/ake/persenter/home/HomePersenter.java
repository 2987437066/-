package com.example.ake.persenter.home;


import com.example.ake.base.BasePersenter;
import com.example.ake.common.CommonSubscriber;
import com.example.ake.interfaces.home.HomeConstract;
import com.example.ake.models.HttpManager;
import com.example.ake.models.bean.IndexBean;
import com.example.ake.utils.RxUtils;

public class HomePersenter  extends BasePersenter<HomeConstract.View> implements HomeConstract.Persenter {
    //获取主页的具体实现
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
