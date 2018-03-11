package com.example.httpvolley.httpvolley;

import java.io.InputStream;

/**
 * 封装响应
 */

public interface HttpListener {
    //接受上一个接口的结果
    void onSuccess(InputStream inputStream);
    void onfalure();
}
