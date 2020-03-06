package com.example.work.interfaces;

public interface IBasePersenter<V extends IBaseView> {
    //关联V层的数据
    void attachView(V view);
    //取消V层的关联
    void detachView();
}
