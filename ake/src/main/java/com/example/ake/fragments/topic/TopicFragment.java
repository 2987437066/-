package com.example.ake.fragments.topic;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.ake.R;
import com.example.ake.adapter.TopicAdapter;
import com.example.ake.base.BaseFragment;
import com.example.ake.interfaces.topic.TopicConstract;
import com.example.ake.models.bean.TopicBean;
import com.example.ake.persenter.topic.TopicPersenter;

import java.util.ArrayList;

import butterknife.BindView;

public class TopicFragment extends BaseFragment<TopicConstract.Persenter> implements TopicConstract.View {

    @BindView(R.id.topic_recy)
    RecyclerView mTopic_recy;
    private ArrayList<TopicBean.DataBean.TopicListBean> topicBean;
    private TopicAdapter topicAdapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_topic;
    }

    @Override
    protected void initView() {
        topicBean = new ArrayList<>();
        topicAdapter = new TopicAdapter(topicBean, context);
        mTopic_recy.setLayoutManager(new LinearLayoutManager(getContext()));
        mTopic_recy.setAdapter(topicAdapter);
    }

    @Override
    protected void initData() {
        persenter.getTopicData();
    }

    @Override
    protected TopicConstract.Persenter createPersenter() {
        return new TopicPersenter();
    }

    @Override
    public void getTopicDataReturn(TopicBean result) {
        topicAdapter.updata(result.getData().getTopicList());
    }
}
