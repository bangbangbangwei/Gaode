package com.dc.weidu.model;

import com.dc.weidu.api.UserApi;
import com.dc.weidu.contract.ResginContract;
import com.example.lib_core.net.OkhttpCallback;
import com.example.lib_core.net.OkhttpUtils;

import java.util.HashMap;

public class ResginModel implements ResginContract.IResginModel {
    @Override
    public void setResginList(HashMap<String, String> params,OkhttpCallback okhttpCallback) {
        OkhttpUtils.getInstance().doPost(UserApi.USER_RESGIN,params,okhttpCallback);
    }
}
