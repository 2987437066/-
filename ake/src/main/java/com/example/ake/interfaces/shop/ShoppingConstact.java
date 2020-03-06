package com.example.ake.interfaces.shop;


import com.example.ake.interfaces.IBasePersenter;
import com.example.ake.interfaces.IBaseView;
import com.example.ake.models.bean.CartBean;

public interface ShoppingConstact {
    interface View extends IBaseView {
        void getCartIndexReturn(CartBean result);
    }

    interface Presenter extends IBasePersenter<View> {
        void getCartIndex();
    }
}
