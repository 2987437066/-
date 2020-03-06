package com.example.ake.interfaces.home;


import com.example.ake.interfaces.IBasePersenter;
import com.example.ake.interfaces.IBaseView;
import com.example.ake.models.bean.IndexBean;

public interface HomeConstract {
    interface View extends IBaseView {
        void getHomeDataReturn(IndexBean result);
    }

    interface Persenter extends IBasePersenter<View> {
        void getHomeData();
    }
}
