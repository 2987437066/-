package com.example.tsetframework.base;

import com.example.tsetframework.interfaces.IPersenter;
import com.example.tsetframework.interfaces.IView;

import java.lang.ref.WeakReference;
import java.util.IdentityHashMap;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePersenter<V extends IView> implements IPersenter<V> {

    protected V mView;

    private WeakReference<V> weakReference; //弱引用view
    protected CompositeDisposable compositeDisposable;
    @Override
    public void attachView(V view) {
        weakReference = new WeakReference<>(view);
        this.mView = weakReference.get();
    }

    @Override
    public void detachView() {
        this.mView = null;
        unSubscribe();
    }

    private void unSubscribe() {
        if (compositeDisposable != null){
            compositeDisposable.clear();
        }
    }

    //添加观察者和被观察者的操作类
    //Disposable
    protected void addSubscribe(Disposable disposable){
        if(compositeDisposable == null) compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(disposable);
    }
}
