package com.example.httpvolley.httpvolley;

import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by lvsimple23@163.com on 2018/3/9.
 */

public class JsonHttpService implements HttpService {

    private String url;
    private byte[] requestData;
    //持有另外一个接口的引用
    HttpListener httpListener;

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void setRequestData(byte[] requestData) {
        this.requestData = requestData;
    }

    @Override
    public void setHttpCallBack(HttpListener httpListener) {
        this.httpListener = httpListener;
    }

    //真的网络操作实现方法
    @Override
    public void excute() {
        HttpconnectPost();
    }
    HttpURLConnection httpURLConnection = null;
    public void HttpconnectPost(){
        URL url = null;
        try {
            url = new URL(this.url);
            httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setConnectTimeout(6000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setReadTimeout(3000);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Content-Type","application/json; charset=UTF-8");
            httpURLConnection.connect();
            //使用字节流发送数据
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(outputStream);
            //判断请求数据是否为空，并写入输出流
            if(requestData != null){
                bos.write(requestData);
            }
            bos.flush();
            outputStream.close();
            bos.close();
            //字符流写入数据
            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
                InputStream inputStream = httpURLConnection.getInputStream();
                httpListener.onSuccess(inputStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
