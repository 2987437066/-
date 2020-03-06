package com.example.app.interfaces.desc;


import com.example.app.interfaces.IBaseView;
import com.example.app.interfaces.IPersenter;
import com.example.app.model.bean.GoodsDescBean;
import com.example.app.model.bean.GoodsDescListBean;

public interface DescContract {

    interface View extends IBaseView {
        void DescDataReturn(GoodsDescBean goodsDescBean);
        void DescListDataReturn(GoodsDescListBean goodsDescListBean);
    }

    interface Persenter extends IPersenter<View> {
        void getDescData(int id);
        void getDescListData(int id);
    }
}
