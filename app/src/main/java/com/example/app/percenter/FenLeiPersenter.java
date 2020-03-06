package com.example.app.percenter;


import com.example.app.base.BasePersenter;
import com.example.app.interfaces.fenlei.FenLeiContract;
import com.example.app.model.CommonSubscriber;
import com.example.app.model.bean.FenLeiBean;
import com.example.app.model.bean.FenLei_listBean;
import com.example.app.model.http.HttpManager;
import com.example.app.utils.RxUtils;

public class FenLeiPersenter extends BasePersenter<FenLeiContract.View> implements FenLeiContract.Persenter{

    @Override
    public void getFenLeiTabData() {
        addSubscribe(HttpManager.getFenLeiApi().getFenLeiTabBean()
                .compose(RxUtils.<FenLeiBean> rxScheduler())
                .subscribeWith(new CommonSubscriber<FenLeiBean>(mView){
                    @Override
                    public void onNext(FenLeiBean fenLeiBean) {
                        mView.FenLeiTabDataReturn(fenLeiBean);
                    }
                }));
    }

    @Override
    public void getFenLeiListData(int id) {
        addSubscribe(HttpManager
                .getFenLeiApi()
                .getFenLeiListBean(id)
                .compose(RxUtils.<FenLei_listBean> rxScheduler())
                .subscribeWith(new CommonSubscriber<FenLei_listBean>(mView){
                    @Override
                    public void onNext(FenLei_listBean result) {
                        mView.FenLeiListDataReturn(result);
                    }
                }));
    }
}
