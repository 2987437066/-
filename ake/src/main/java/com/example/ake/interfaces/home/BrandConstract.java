package com.example.ake.interfaces.home;


import com.example.ake.interfaces.IBasePersenter;
import com.example.ake.interfaces.IBaseView;
import com.example.ake.models.bean.BrandBean;
import com.example.ake.models.bean.BrandGoodsBean;

public interface BrandConstract {
    interface View extends IBaseView {
        //返回数据结果
        void getBrandInfoReturn(BrandBean result);
        void getBrandGoodsReturn(BrandGoodsBean result);
    }

    interface Persenter extends IBasePersenter<View> {
        //获取数据
        void getBrandInfo(String id);
        void getBrandGoods(String brandId, int page, int size);
    }
}
