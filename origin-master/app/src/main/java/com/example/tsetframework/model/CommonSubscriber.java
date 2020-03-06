package com.example.tsetframework.model;

import android.text.TextUtils;


import com.example.tsetframework.interfaces.IView;

import io.reactivex.subscribers.ResourceSubscriber;


public abstract class CommonSubscriber<T> extends ResourceSubscriber<T> {

    private IView mView;
    private String errorMsg;
    private boolean isShowErrorState = false;

    protected CommonSubscriber(IView view){
        mView = view;
    }

    protected CommonSubscriber(IView view, String emsg){
        mView = view;
        errorMsg = emsg;
    }

    protected CommonSubscriber(IView view, boolean isError){
        mView = view;
        isShowErrorState = isError;
    }

    protected CommonSubscriber(IView view, String emsg, boolean isError){
        mView = view;
        errorMsg = emsg;
        isShowErrorState = isError;
    }

    @Override
    public void onError(Throwable t) {
        //LoadingUtil.getInstance().hideLoading();
        if(mView == null) return;
        if(errorMsg != null && TextUtils.isEmpty(errorMsg)){
            mView.showError(errorMsg);
        }
    }

    @Override
    public void onComplete() {
        //LoadingUtil.getInstance().hideLoading();
    }
}
