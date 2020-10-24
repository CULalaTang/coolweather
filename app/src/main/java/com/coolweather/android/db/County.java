package com.coolweather.android.db;

import org.litepal.crud.DataSupport;

/**
 * author:chenhao
 * email::
 * time:2020/10/20
 * desc:
 * version:1.0
 */
public class County extends DataSupport {
    private int id;
    //县的名字
    private String countyName;
    //县所对应天气
    private String weatherId;
    //当前县所属市id
    private int cityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(String weatherId) {
        this.weatherId = weatherId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
