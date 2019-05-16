package com.myapis;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by aplite_pc302 on 12/7/18.
 */

public class TopicController {
    TopicView topicview;

    public TopicController(TopicView topicview) {
        this.topicview = topicview;
    }


    public void getTopicList() {
        ApiClient.getservices().getTopics()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Topic>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Topic> topics) {
                        if (topics.size() > 0) {
                            topicview.updateAdapter(topics);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void addTopic(String id, String name, String des) {
//                id,name,des
        HashMap<String, String> hm = new HashMap();
        hm.put("id", id);
        hm.put("name", name);
        hm.put("description", des);
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        String chatmsgs = gson.toJson(hm);
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(chatmsgs).getAsJsonObject();

        ApiClient.getservices().addTopics(hm)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("TAG", s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG", e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
