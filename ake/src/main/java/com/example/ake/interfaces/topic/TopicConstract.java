package com.example.ake.interfaces.topic;


import com.example.ake.interfaces.IBasePersenter;
import com.example.ake.interfaces.IBaseView;
import com.example.ake.models.bean.TopicBean;

public interface TopicConstract {
    interface View extends IBaseView {
        void getTopicDataReturn(TopicBean result);
    }

    interface Persenter extends IBasePersenter<View> {
        void getTopicData();
    }
}
