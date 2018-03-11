package com.example.httpvolley.bean;

/**
 * Created by dell on 2018/3/11.
 */

public class Today {
    public String       temperature;
    public String       weather;
    public String       weather_id;
    public String       wind;
    public String       city;
    public String       dressing_index;
    public String       dressing_advice;
    public String       uv_index;
    public String       comfort_index;
    public String       wash_index;
    public String       travel_index;
    public String       exercise_index;
    public String       drying_index ;

    public String toString(){
        return "Today{"+
                ",temperature='"+temperature+'\''+
                ",weather='"+weather+'\''+
                ",weather_id='"+weather_id+'\''+
                ",wind='"+wind+'\''+
                ",city='"+city+'\''+
                ",dressing_index='"+dressing_index+'\''+
                ",dressing_advice='"+dressing_advice+'\''+
                ",uv_index='"+uv_index+'\''+
                ",comfort_index='"+comfort_index+'\''+
                ",wash_index='"+wash_index+'\''+
                ",travel_index='"+travel_index+'\''+
                ",exercise_index='"+exercise_index+'\''+
                ",drying_index='"+drying_index+'\''+"}";
    }
}
