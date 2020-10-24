package com.coolweather.android.db;

import org.litepal.crud.DataSupport;

/**
 * author:chenhao
 * email::
 * time:2020/10/20
 * desc:
 * version:1.0
 */
public class City extends DataSupport {
    private int id;
    //市的名字
    private String cityName;
    //市的代号
    private int cityCode;
    //当前市所属省的代号
    private int provinceId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }
}
