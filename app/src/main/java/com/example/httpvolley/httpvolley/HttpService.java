package com.example.httpvolley.httpvolley;

/**
 * 封装请求
 */

public interface HttpService {
    void setUrl(String url);
    void setRequestData(byte[] requestData);
    void excute();

    //两个接口之间的关系
    void setHttpCallBack(HttpListener httpListener);

    //两个接口和在一起就是一个Http请求任务；
}
