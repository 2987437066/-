package com.example.work.interfaces.test;

import com.example.work.interfaces.IBasePersenter;
import com.example.work.interfaces.IBaseView;
import com.example.work.models.bean.ChaptersBean;

public interface TestConstract {
    interface View extends IBaseView{
        void getChaptersReturn(ChaptersBean result);
    }

    interface Persenter extends IBasePersenter<View> {
        void getChapters();
    }
}
