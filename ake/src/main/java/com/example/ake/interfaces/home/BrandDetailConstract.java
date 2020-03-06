package com.example.ake.interfaces.home;


import com.example.ake.interfaces.IBasePersenter;
import com.example.ake.interfaces.IBaseView;
import com.example.ake.models.bean.BrandDetialBean;

public interface BrandDetailConstract {
    interface View extends IBaseView {
        //返回数据结果
        void getBrandDetailReturn(BrandDetialBean result);
    }

    interface Persenter extends IBasePersenter<View> {
        //获取数据
        void getBrandDetail(int page, int size);
    }
}
