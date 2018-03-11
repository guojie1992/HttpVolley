package com.example.httpvolley.bean;

/**
 * Created by dell on 2018/3/11.
 */

public class Result {
    public SK sk;
    public Today today;
    public int error_code;

    public String toString(){
        return "Result{"+
                "sk="+sk+
                ",today="+today+
                ",error_code"+error_code+"}";
    }
}
