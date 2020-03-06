package com.example.ake.persenter.topic;


import com.example.ake.base.BasePersenter;
import com.example.ake.common.CommonSubscriber;
import com.example.ake.interfaces.topic.TopicConstract;
import com.example.ake.models.HttpManager;
import com.example.ake.models.bean.TopicBean;
import com.example.ake.utils.RxUtils;

public class TopicPersenter extends BasePersenter<TopicConstract.View> implements TopicConstract.Persenter {
    @Override
    public void getTopicData() {
        addSubscribe(HttpManager.getInstance().getShopApi().getTopicData()
                .compose(RxUtils.<TopicBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<TopicBean>(mView){

                    @Override
                    public void onNext(TopicBean topicBean) {
                        mView.getTopicDataReturn(topicBean);
                    }
                }));
    }
}
