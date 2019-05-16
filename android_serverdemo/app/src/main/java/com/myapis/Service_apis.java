package com.myapis;

import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by aplite_pc302 on 12/7/18.
 */

interface Service_apis {
    @GET("topics")
    Observable<List<Topic>> getTopics();

    @POST("topics")
    Observable<String> addTopics(@Body HashMap<String,String> request);
}
