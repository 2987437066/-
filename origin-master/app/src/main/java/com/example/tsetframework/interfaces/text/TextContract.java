package com.example.tsetframework.interfaces.text;

import com.example.tsetframework.interfaces.IPersenter;
import com.example.tsetframework.interfaces.IView;
import com.example.tsetframework.model.bean.TextBean;

public interface TextContract {
    interface View extends IView{
        void textReturn(TextBean textBean);
    }
    interface Percenter extends IPersenter<View>{
        void getText();
    }
}
