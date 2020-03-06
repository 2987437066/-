package com.example.ake.models.api;


import com.example.ake.models.bean.FuLiBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface FuLiApi {

    @GET("data/%E7%A6%8F%E5%88%A9/10/3")
    Flowable<FuLiBean> getFuLi();
}
