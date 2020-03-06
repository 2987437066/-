package com.example.work.models.api;

import com.example.work.models.bean.IndexBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface ShopApi {

    @GET("index")
    Flowable<IndexBean> getIndexData();

}
