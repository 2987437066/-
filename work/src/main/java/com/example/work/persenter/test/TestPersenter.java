package com.example.work.persenter.test;

import com.example.work.base.BasePersenter;
import com.example.work.common.CommonSubscriber;
import com.example.work.interfaces.test.TestConstract;
import com.example.work.models.HttpManager;
import com.example.work.models.bean.ChaptersBean;
import com.example.work.utils.RxUtils;

public class TestPersenter extends BasePersenter<TestConstract.View> implements TestConstract.Persenter{
    @Override
    public void getChapters() {
        addSubscribe(HttpManager.getInstance().getWanApi().getChapters()
                .compose(RxUtils.<ChaptersBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<ChaptersBean>(mView) {

                    @Override
                    public void onNext(ChaptersBean chaptersBean) {
                        mView.getChaptersReturn(chaptersBean);
                    }
                }));
    }
}
