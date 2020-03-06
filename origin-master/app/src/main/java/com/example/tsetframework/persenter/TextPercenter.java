package com.example.tsetframework.persenter;

import com.example.tsetframework.base.BasePersenter;
import com.example.tsetframework.interfaces.text.TextContract;
import com.example.tsetframework.model.CommonSubscriber;
import com.example.tsetframework.model.bean.TextBean;
import com.example.tsetframework.model.http.HttpManager;
import com.example.tsetframework.utils.RxUtils;

public class TextPercenter extends BasePersenter<TextContract.View> implements TextContract.Percenter {

    @Override
    public void getText() {
        addSubscribe(HttpManager.getTextApi().getTextBean()
        .compose(RxUtils.<TextBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<TextBean>(mView){

            @Override
            public void onNext(TextBean textBean) {
                mView.textReturn(textBean);
            }
        }));
    }
}
