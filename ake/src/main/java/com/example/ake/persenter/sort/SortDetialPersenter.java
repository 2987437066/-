package com.example.ake.persenter.sort;


import com.example.ake.base.BasePersenter;
import com.example.ake.common.CommonSubscriber;
import com.example.ake.interfaces.sort.SortConstract;
import com.example.ake.models.HttpManager;
import com.example.ake.models.bean.SortDetialBean;
import com.example.ake.models.bean.SortDetialGoodsBean;
import com.example.ake.utils.RxUtils;

public class SortDetialPersenter extends BasePersenter<SortConstract.DetailView> implements SortConstract.DetailPersenter {

    @Override
    public void getSortDetailTab(int id) {
        addSubscribe(HttpManager.getInstance().getShopApi().getSortDetialTab(id)
                .compose(RxUtils.<SortDetialBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<SortDetialBean>(mView) {
                    @Override
                    public void onNext(SortDetialBean sortDetialBean) {
                        mView.getSortDetailReturn(sortDetialBean);
                    }
                }));
    }

    @Override
    public void getSortDetailGoods(int id, int page, int size) {
        addSubscribe(HttpManager.getInstance().getShopApi().getSortDetailGoods(id,page,size)
                .compose(RxUtils.<SortDetialGoodsBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<SortDetialGoodsBean>(mView) {
                    @Override
                    public void onNext(SortDetialGoodsBean sortDetialGoodsBean) {
                        mView.getSortDetailGoodsReturn(sortDetialGoodsBean);
                    }
                }));
    }
}
