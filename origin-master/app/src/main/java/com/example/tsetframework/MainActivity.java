package com.example.tsetframework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tsetframework.base.BaseActivity;
import com.example.tsetframework.interfaces.IPersenter;
import com.example.tsetframework.interfaces.IView;
import com.example.tsetframework.interfaces.text.TextContract;
import com.example.tsetframework.model.bean.TextBean;
import com.example.tsetframework.persenter.TextPercenter;

public class MainActivity extends BaseActivity implements TextContract.View {


    private TextView tv;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        tv = findViewById(R.id.tv_main);
        tv.setText("框架测试");
    }

    @Override
    protected IPersenter createPersenter() {
        return new TextPercenter();
    }

    @Override
    protected void initDate() {
        ((TextPercenter)persenter).getText();
    }

    @Override
    public void textReturn(TextBean textBean) {
        String name = textBean.getData().getBannerInfo().getName();
        tv.setText(name);
    }
}
