package com.dc.weidu.presenter;

import com.dc.weidu.contract.ResginContract;
import com.example.lib_core.net.OkhttpCallback;

import java.util.HashMap;

public class ResginPresenter extends ResginContract.ResginPresenter {

    @Override
    public void setResgin(HashMap<String, String> params) {
        model.setResginList(params, new OkhttpCallback() {
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
