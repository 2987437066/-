package com.example.app.interfaces.home;


import com.example.app.interfaces.IBaseView;
import com.example.app.interfaces.IPersenter;
import com.example.app.model.bean.ShouYeBean;

public interface HomeContract {
    interface View extends IBaseView {
        void HomeDataReturn(ShouYeBean shouYeBean);
    }

    interface Persenter extends IPersenter<View> {
        void getHomeData();
    }
}
