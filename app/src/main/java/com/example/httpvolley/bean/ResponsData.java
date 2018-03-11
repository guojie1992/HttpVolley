package com.example.httpvolley.bean;

/**
 * Created by dell on 2018/3/11.
 */

public class ResponsData {
    public String resultCode;
    public String reason;
    public Result result;
    int error_code;

    public String toString(){
        return "ResponseData{"+
                "resultCode='"+resultCode+'\''+
                ",reason='"+reason+'\''+
                ",result='"+result+'\''+
                ",error_code"+error_code+'\''+"}";
    }
}
