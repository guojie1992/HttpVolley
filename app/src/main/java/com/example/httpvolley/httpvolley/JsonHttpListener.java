package com.example.httpvolley.httpvolley;

import android.os.Handler;
import android.os.Looper;

import com.alibaba.fastjson.JSON;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by lvsimple23@163.com on 2018/3/10.
 */

public class JsonHttpListener<M> implements HttpListener {
    //响应结果转为对象
    Class<M> responseClass;
    //定义接口
    DataListener<M> dataListener;
    //线程切换
    Handler handler = new Handler(Looper.getMainLooper());

    public JsonHttpListener(Class<M> responseClass , DataListener dataListener){
        this.responseClass = responseClass;
        this.dataListener = dataListener;
    }
    @Override
    public void onSuccess(InputStream inputStream/*拿到的是网络响应结果*/) {
        //把响应的结果byte数据转为String数据
        String content = getContent(inputStream);
        //把转换好的结果（例如：json字符串）再转换为对象
        final M response = JSON.parseObject(content,responseClass);
        //把结果传送到调用层
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(dataListener != null){
                    dataListener.onSuccess(response);
                }
            }
        });
    }

    //流转字符串
    private String getContent(InputStream inputStream) {
        String content = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            try {
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line + "\n");
                }
            } catch (IOException e) {
                System.out.println("Error" + e.toString());
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    System.out.println("Error" + e.toString());
                }
            }
            return stringBuilder.toString();
        }catch(Exception exception){
            exception.printStackTrace();
        }
        return content;
    }

    @Override
    public void onfalure() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (dataListener != null){
                    dataListener.onFalure();
                }
            }
        });
    }
}
