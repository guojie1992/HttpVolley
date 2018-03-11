package com.example.httpvolley.httpvolley;

/**
 * Created by lvsimple23@163.com on 2018/3/10.
 */

public class VolleyBrother {
    public static<T,M> void sendJsonRequest(T requestInfo,String url,Class<M> response,DataListener<M> dataListener){
        HttpService httpService = new JsonHttpService();
        HttpListener httpListener = new JsonHttpListener(response,dataListener);
        HttpTask<T> httpTask = new HttpTask<T>(requestInfo,url,httpService,httpListener);
        ThreadPoolManager.getourInstace().excute(httpTask);
    }
}
