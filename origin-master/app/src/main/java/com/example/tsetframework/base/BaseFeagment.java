package com.example.tsetframework.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tsetframework.interfaces.IPersenter;
import com.example.tsetframework.interfaces.IView;

public abstract class BaseFeagment<V extends IView,P extends IPersenter> extends Fragment implements IView {
    protected Context context;
    protected Activity activity;
    protected P persenter;

    protected abstract int getLayout();
    protected abstract void initView();
    protected abstract P createPersenter();
    protected abstract void initDate();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayout(), null);
        return inflate;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = this.getContext();
        activity = this.getActivity();
        initView();
        persenter = createPersenter();
        persenter.attachView(this);
        initDate();
    }

    @Override
    public void onResume() {
        super.onResume();
        if(persenter != null){
            persenter.attachView(this);
        }
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(persenter != null){
            persenter.detachView();
        }
    }
}
