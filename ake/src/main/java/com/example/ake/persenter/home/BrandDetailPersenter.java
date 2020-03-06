package com.example.ake.persenter.home;


import com.example.ake.base.BasePersenter;
import com.example.ake.common.CommonSubscriber;
import com.example.ake.interfaces.home.BrandDetailConstract;
import com.example.ake.models.HttpManager;
import com.example.ake.models.bean.BrandDetialBean;
import com.example.ake.utils.RxUtils;

public class BrandDetailPersenter extends BasePersenter<BrandDetailConstract.View> implements BrandDetailConstract.Persenter {
    @Override
    public void getBrandDetail(int page,int sieze) {
        addSubscribe(HttpManager.getInstance().getShopApi().getBrandDetailBean(page,sieze)
                .compose(RxUtils.<BrandDetialBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<BrandDetialBean>(mView){

                    @Override
                    public void onNext(BrandDetialBean brandDetialBean) {
                        mView.getBrandDetailReturn(brandDetialBean);
                    }
                }));
    }
}
