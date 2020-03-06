package com.example.tsetframework.base;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tsetframework.interfaces.IPersenter;
import com.example.tsetframework.interfaces.IView;

public abstract class BaseActivity<V extends IView,P extends IPersenter> extends AppCompatActivity implements IView {
    protected Context context;
    protected P persenter;

    protected abstract int getLayout();
    protected abstract void initView();
    protected abstract P createPersenter();
    protected abstract void initDate();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        context = this;
        initView();
        persenter = createPersenter();
        if (persenter != null){
            persenter.attachView(this);
            initDate();
        }
    }

    @Override
    public void showError(String error) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (persenter != null){
            persenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (persenter != null){
            persenter.detachView();
        }
    }
}
