package com.example.httpvolley.httpvolley;

/**
 * Created by lvsimple23@163.com on 2018/3/10.
 */

public interface DataListener<M> {
    //传回成功的泛型对象
    void onSuccess(M m);

    void onFalure();
}
