package com.example.ake.interfaces.sort;


import com.example.ake.interfaces.IBasePersenter;
import com.example.ake.interfaces.IBaseView;
import com.example.ake.models.bean.RelatedBean;
import com.example.ake.models.bean.RelatedBottonBean;

public interface GoodInfoConstract {
     interface View extends IBaseView {
        void getRelatedDataReturn(RelatedBean result);
        void getRelateBottonRetrun(RelatedBottonBean result);
    }

     interface Persenter extends IBasePersenter<View> {
        void getRelatedData(int id);
        void getBottonData(int id);
    }
}
