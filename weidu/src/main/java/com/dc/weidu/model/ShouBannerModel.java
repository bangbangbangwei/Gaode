package com.dc.weidu.model;

import com.dc.weidu.api.UserApi;
import com.dc.weidu.contract.LoginContract;
import com.dc.weidu.contract.ShouBannerContract;
import com.example.lib_core.net.OkhttpCallback;
import com.example.lib_core.net.OkhttpUtils;

import java.util.HashMap;

public class ShouBannerModel implements ShouBannerContract.IShouBannerModel {

    @Override
    public void getShouBanner(HashMap<String, String> params, OkhttpCallback okhttpCallback) {
        OkhttpUtils.getInstance().doGet(UserApi.USER_ShouBanner,params,okhttpCallback);
    }
}
