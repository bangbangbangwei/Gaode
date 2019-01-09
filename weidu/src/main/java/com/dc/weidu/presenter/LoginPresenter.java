package com.dc.weidu.presenter;

import com.dc.weidu.contract.LoginContract;
import com.example.lib_core.net.OkhttpCallback;

import java.util.HashMap;

public class LoginPresenter extends LoginContract.LoginPresenter {

    @Override
    public void setLoginList(HashMap<String, String> params) {
        model.getLogin(params, new OkhttpCallback() {
            @Override
            public void failure(String msg) {
                view.failure(msg);
            }

            @Override
            public void success(String result) {
                view.success(result);
            }
        });
    }
}
