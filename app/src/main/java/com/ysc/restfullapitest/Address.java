package com.ysc.restfullapitest;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ysc on 2017/7/17.
 */

public class Address {

    private String IpAddress;
    private String Province;
    private String City;

    public Address(JSONObject object) {
        try {
            this.IpAddress = object.getString("IPAddress");
            this.Province = object.getString("Province");
            this.City = object.getString("City");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Address(String ipaddress, String province, String city) {
        this.IpAddress = ipaddress;
        this.Province = province;
        this.City = city;
    }

    public String getIpAddress() {
        return this.IpAddress;
    }

    public String getProvince() {
        return this.Province;
    }
    public String getCity() {
        return this.City;
    }
}
