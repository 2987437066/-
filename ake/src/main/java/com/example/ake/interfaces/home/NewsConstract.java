package com.example.ake.interfaces.home;


import com.example.ake.interfaces.IBasePersenter;
import com.example.ake.interfaces.IBaseView;
import com.example.ake.models.bean.NewsDetailBean;

public interface NewsConstract {
    interface View extends IBaseView {
        //返回数据结果
        void getNewsDetailReturn(NewsDetailBean result);
    }

    interface Persenter extends IBasePersenter<View> {
        //获取数据
        void getNewsDetailBean();
    }
}
