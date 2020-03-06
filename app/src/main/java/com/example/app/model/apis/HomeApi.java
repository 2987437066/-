package com.example.app.model.apis;


import com.example.app.model.bean.ShouYeBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface HomeApi {

    @GET("index/index")
    Flowable<ShouYeBean> getShouYeBean();
}
