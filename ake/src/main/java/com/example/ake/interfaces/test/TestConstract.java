package com.example.ake.interfaces.test;


import com.example.ake.interfaces.IBasePersenter;
import com.example.ake.interfaces.IBaseView;
import com.example.ake.models.bean.FuLiBean;

public interface TestConstract {
    interface View extends IBaseView {
        void getFuLiReturn(FuLiBean fuLi);
    }

    interface Persenter extends IBasePersenter<View> {
        void getFuLi();
    }
}
