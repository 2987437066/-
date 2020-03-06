package com.example.ake.persenter.shop;


import com.example.ake.base.BasePersenter;
import com.example.ake.common.CommonSubscriber;
import com.example.ake.interfaces.shop.ShoppingConstact;
import com.example.ake.models.HttpManager;
import com.example.ake.models.bean.CartBean;
import com.example.ake.utils.RxUtils;

public class ShoppingPresenter extends BasePersenter<ShoppingConstact.View> implements ShoppingConstact.Presenter{
    @Override
    public void getCartIndex() {
        addSubscribe(HttpManager.getInstance().getShopApi().getCartIndex()
                .compose(RxUtils.<CartBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<CartBean>(mView) {
                    @Override
                    public void onNext(CartBean cartBean) {
                        mView.getCartIndexReturn(cartBean);
                    }
                }));
    }
}
