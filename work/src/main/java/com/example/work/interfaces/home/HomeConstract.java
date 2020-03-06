package com.example.work.interfaces.home;

import com.example.work.interfaces.IBasePersenter;
import com.example.work.interfaces.IBaseView;
import com.example.work.models.bean.IndexBean;

public interface HomeConstract {
    interface View extends IBaseView {
        void getHomeDataReturn(IndexBean result);
    }

    interface Persenter extends IBasePersenter<View> {
        void getHomeData();
    }
}
