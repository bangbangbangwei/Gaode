package com.dc.weidu.presenter;

import com.dc.weidu.contract.LoginContract;
import com.dc.weidu.contract.ShouBannerContract;
import com.example.lib_core.net.OkhttpCallback;

import java.util.HashMap;

public class ShouBannerPresenter extends ShouBannerContract.ShouBannerPresenter {

    @Override
    public void setShouBanner(HashMap<String, String> params) {
        model.getShouBanner(params, new OkhttpCallback() {
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

