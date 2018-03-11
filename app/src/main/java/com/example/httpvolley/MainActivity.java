package com.example.httpvolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.httpvolley.bean.ResponsData;
import com.example.httpvolley.httpvolley.DataListener;
import com.example.httpvolley.httpvolley.VolleyBrother;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    //具体的请求地址可以自己上聚合网申请：
    private String url = "http://v.juhe.cn/weather/index?&cityname=长沙&key=使用自己的key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
    }

    public void onclick(View view) {
        VolleyBrother.sendJsonRequest(null, url, ResponsData.class, new DataListener<ResponsData>() {
            @Override
            public void onSuccess(ResponsData responsData) {
                textView.setText("城市:" + responsData.result.today.city + "今天有" + responsData.result.today.temperature + "度");
            }

            @Override
            public void onFalure() {

            }
        });
    }
}
