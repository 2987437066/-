package com.example.tsetframework.model.apis;

import com.example.tsetframework.model.bean.TextBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface TextApi {

    @GET("goods/hot")
     Flowable<TextBean> getTextBean();
}
