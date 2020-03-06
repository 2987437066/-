package com.example.app.interfaces.fenlei;


import com.example.app.interfaces.IBaseView;
import com.example.app.interfaces.IPersenter;
import com.example.app.model.bean.FenLeiBean;
import com.example.app.model.bean.FenLei_listBean;

public interface FenLeiContract {
    interface View extends IBaseView {
        void FenLeiTabDataReturn(FenLeiBean fenLeiBean);

        void FenLeiListDataReturn(FenLei_listBean fenLei_listBean);
    }

    interface Persenter extends IPersenter<View> {
        void getFenLeiTabData();

        void getFenLeiListData(int id);
    }
}
