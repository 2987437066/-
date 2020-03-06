package com.example.work.ui;

import android.util.Log;

import com.example.work.R;
import com.example.work.base.BaseActivity;
import com.example.work.interfaces.test.TestConstract;
import com.example.work.models.bean.ChaptersBean;
import com.example.work.persenter.test.TestPersenter;

public class TestActivity extends BaseActivity<TestConstract.Persenter> implements TestConstract.View{
    @Override
    protected int getLayout() {
        return R.layout.activity_test;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        persenter.getChapters();
    }

    @Override
    protected TestConstract.Persenter createPersenter() {
        return new TestPersenter();
    }

    @Override
    public void getChaptersReturn(ChaptersBean result) {
        Log.i("Test",result.getData().toString());
    }
}
