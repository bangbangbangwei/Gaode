package com.dc.weidu.model;

import com.dc.weidu.api.UserApi;
import com.dc.weidu.contract.LoginContract;
import com.example.lib_core.net.OkhttpCallback;
import com.example.lib_core.net.OkhttpUtils;

import java.util.HashMap;

public class LoginModel implements LoginContract.ILoginModel{

    @Override
    public void getLogin(HashMap<String, String> params, OkhttpCallback okhttpCallback) {
        OkhttpUtils.getInstance().doPost(UserApi.USER_LOGIN,params,okhttpCallback);
    }

}
