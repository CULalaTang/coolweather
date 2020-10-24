package com.coolweather.android.db;

import org.litepal.crud.DataSupport;

/**
 * author:chenhao
 * email::
 * time:2020/10/20
 * desc:
 * version:1.0
 */
public class Province extends DataSupport {

    private int id;
    //记录省的名字
    private String provinceName;
    //省代号
    private int provinceCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }
}
