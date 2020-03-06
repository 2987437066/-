package com.example.ake.interfaces.shop;


import com.example.ake.interfaces.IBasePersenter;
import com.example.ake.interfaces.IBaseView;
import com.example.ake.models.bean.VerifyBean;

public interface RegisterConstract {
    interface View extends IBaseView {
        void getVerifyReturn(VerifyBean result);
    }

    interface Persenter extends IBasePersenter<View> {
        void getVerify();
    }
}
