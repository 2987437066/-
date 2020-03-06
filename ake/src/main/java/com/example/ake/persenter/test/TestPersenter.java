package com.example.ake.persenter.test;


import com.example.ake.base.BasePersenter;
import com.example.ake.common.CommonSubscriber;
import com.example.ake.interfaces.test.TestConstract;
import com.example.ake.models.HttpManager;
import com.example.ake.models.bean.FuLiBean;
import com.example.ake.utils.RxUtils;

public class TestPersenter extends BasePersenter<TestConstract.View> implements TestConstract.Persenter {
    @Override
    public void getFuLi() {
        addSubscribe(HttpManager.getInstance().getFuLiApi().getFuLi()
        .compose(RxUtils.<FuLiBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<FuLiBean>(mView) {
                    @Override
                    public void onNext(FuLiBean fuLiBean) {
                        mView.getFuLiReturn(fuLiBean);
                    }
                }));

    }
}
