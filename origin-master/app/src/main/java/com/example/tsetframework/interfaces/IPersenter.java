package com.example.tsetframework.interfaces;

public interface IPersenter<V extends IView> {

    void attachView(V view);
    void detachView();
}
