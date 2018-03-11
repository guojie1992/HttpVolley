package com.example.httpvolley.httpvolley;

import com.alibaba.fastjson.JSON;

import java.io.UnsupportedEncodingException;

/**
 * Created by dell on 2018/3/9.
 */

public class HttpTask<T> implements Runnable {
    //接口引用
    private HttpListener httpListener;
    private HttpService httpService;

    //请求参数以对象的形式发送，使用泛型
    public<T> HttpTask(T requestInfo,String url,HttpService httpService,HttpListener httpListener){
        this.httpService = httpService;
        this.httpListener = httpListener;
        httpService.setUrl(url);
        //是两个接口相关联
        httpService.setHttpCallBack(httpListener);
        if(requestInfo != null){
            String requestContent = JSON.toJSONString(requestInfo);
            //设置请求参数
            try {
                httpService.setRequestData(requestContent.getBytes("utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void run() {
        httpService.excute();
    }
}
