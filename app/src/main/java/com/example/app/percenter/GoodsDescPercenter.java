package com.example.app.percenter;


import com.example.app.base.BasePersenter;
import com.example.app.interfaces.desc.DescContract;
import com.example.app.model.CommonSubscriber;
import com.example.app.model.bean.GoodsDescBean;
import com.example.app.model.bean.GoodsDescListBean;
import com.example.app.model.http.HttpManager;
import com.example.app.utils.RxUtils;

public class GoodsDescPercenter extends BasePersenter<DescContract.View> implements DescContract.Persenter {
    @Override
    public void getDescData(int id) {
        addSubscribe(HttpManager.getGoodsDescApi().getGoodsDesc(id)
        .compose(RxUtils.<GoodsDescBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<GoodsDescBean>(mView){

            @Override
            public void onNext(GoodsDescBean goodsDescBean) {
                mView.DescDataReturn(goodsDescBean);
            }
        }));
    }

    @Override
    public void getDescListData(int id) {
        addSubscribe(HttpManager.getGoodsDescApi().getGoodsList(id,1,100)
                .compose(RxUtils.<GoodsDescListBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<GoodsDescListBean>(mView){

                    @Override
                    public void onNext(GoodsDescListBean goodsDescListBean) {
                        mView.DescListDataReturn(goodsDescListBean);
                    }
                }));
    }
}
