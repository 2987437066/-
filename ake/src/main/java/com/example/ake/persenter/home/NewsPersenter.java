package com.example.ake.persenter.home;


import com.example.ake.base.BasePersenter;
import com.example.ake.common.CommonSubscriber;
import com.example.ake.interfaces.home.NewsConstract;
import com.example.ake.models.HttpManager;
import com.example.ake.models.bean.NewsDetailBean;
import com.example.ake.utils.RxUtils;

public class NewsPersenter extends BasePersenter<NewsConstract.View> implements NewsConstract.Persenter {
    @Override
    public void getNewsDetailBean() {
        addSubscribe(HttpManager.getInstance().getShopApi().getNewsDetailBean()
                .compose(RxUtils.<NewsDetailBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<NewsDetailBean>(mView){

                    @Override
                    public void onNext(NewsDetailBean newsDetailBean) {
                        mView.getNewsDetailReturn(newsDetailBean);
                    }
                }));
    }
}
