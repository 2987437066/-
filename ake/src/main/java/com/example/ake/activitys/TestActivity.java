package com.example.ake.activitys;

import android.util.Log;
import android.widget.FrameLayout;

import androidx.fragment.app.FragmentTransaction;


import com.example.ake.R;
import com.example.ake.base.BaseActivity;
import com.example.ake.fragments.home.HomeFragment;
import com.example.ake.interfaces.test.TestConstract;
import com.example.ake.models.bean.FuLiBean;
import com.example.ake.persenter.test.TestPersenter;

import butterknife.BindView;

public class TestActivity extends BaseActivity<TestConstract.Persenter> implements TestConstract.View {

    @BindView(R.id.fl)
    FrameLayout frameLayout;


    @Override
    protected int getLayout() {
        return R.layout.test;
    }

    @Override
    protected void initView() {
        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fl,homeFragment).commit();
    }

    @Override
    protected void initData() {
        persenter.getFuLi();
    }

    @Override
    protected TestConstract.Persenter createPersenter() {
        return new TestPersenter();
    }

    @Override
    public void getFuLiReturn(FuLiBean fuLi) {
        Log.i("shuju",fuLi.toString());
    }
}
