package com.example.work.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.work.interfaces.IBasePersenter;
import com.example.work.interfaces.IBaseView;

import butterknife.Unbinder;

public abstract class BaseActivity <P extends IBasePersenter> extends AppCompatActivity implements IBaseView {
    protected  P persenter;
    Unbinder unbinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();
        persenter = createPersenter();
        if (persenter != null){
            persenter.attachView(this);
        }
        initData();
    }

    protected abstract P createPersenter();

    protected abstract int getLayout();

    protected abstract void initData();

    protected abstract void initView();

    /**
     * 用来显示提示信息
     * @param msg
     */
    @Override
    public void showTips(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    /**
     * activity移除的时候解绑persenter和v层
     * 解绑当前activity的butterknife
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(persenter != null){
            persenter.detachView();
        }
        if(unbinder != null){
            unbinder.unbind();
        }
    }

}
