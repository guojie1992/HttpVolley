package com.example.httpvolley.bean;

/**
 * Created by dell on 2018/3/11.
 */

public class SK {
    public String temp;
    public String wind_direction;
    public String wind_strength;
    public String humidity;
    public String time;

    public String toString(){
        return "SK{"+
                "temp='"+temp+'\''+
                ",wind_direction='"+wind_direction+'\''+
                ",wind_strength='"+wind_strength+'\''+
                ",humidity='"+humidity+'\''+
                ",time='"+time+'\''+"}";
    }

}
