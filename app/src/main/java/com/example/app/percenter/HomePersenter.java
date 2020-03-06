package com.example.app.percenter;


import com.example.app.base.BasePersenter;
import com.example.app.interfaces.home.HomeContract;
import com.example.app.model.CommonSubscriber;
import com.example.app.model.bean.ShouYeBean;
import com.example.app.model.http.HttpManager;
import com.example.app.utils.RxUtils;

public class HomePersenter extends BasePersenter<HomeContract.View> implements HomeContract.Persenter{

    @Override
    public void getHomeData() {
        addSubscribe(HttpManager.getHomeApi().getShouYeBean()
                .compose(RxUtils.<ShouYeBean> rxScheduler())
                .subscribeWith(new CommonSubscriber<ShouYeBean>(mView){
                    @Override
                    public void onNext(ShouYeBean shouYeBean) {
                        mView.HomeDataReturn(shouYeBean);
                    }
                }));
    }
}
