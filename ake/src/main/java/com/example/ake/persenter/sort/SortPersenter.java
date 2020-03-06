package com.example.ake.persenter.sort;


import com.example.ake.base.BasePersenter;
import com.example.ake.common.CommonSubscriber;
import com.example.ake.interfaces.sort.SortConstract;
import com.example.ake.models.HttpManager;
import com.example.ake.models.bean.TabItemBean;
import com.example.ake.models.bean.VtlNameBean;
import com.example.ake.utils.RxUtils;

public class SortPersenter extends BasePersenter<SortConstract.View> implements SortConstract.Persenter {
    @Override
    public void getSort() {
        addSubscribe(HttpManager.getInstance().getShopApi().getVtlNames()
                .compose(RxUtils.<VtlNameBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<VtlNameBean>(mView) {
                    @Override
                    public void onNext(VtlNameBean vtlNameBean) {
                        mView.getSortReturn(vtlNameBean);
                    }
                }));
    }

    @Override
    public void getSortItem(int id) {
        addSubscribe(HttpManager.getInstance().getShopApi().getSortItems(id)
                .compose(RxUtils.<TabItemBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<TabItemBean>(mView) {
                    @Override
                    public void onNext(TabItemBean tabItemBean) {
                        mView.getSortItemReturn(tabItemBean);
                    }
                }));
    }
}
