package com.dc.weidu.contract;

import com.dc.weidu.model.ShouBannerModel;
import com.example.lib_core.base.mvp.BasePresenter;
import com.example.lib_core.base.mvp.IBaseModel;
import com.example.lib_core.base.mvp.IBaseView;
import com.example.lib_core.net.OkhttpCallback;

import java.util.HashMap;

public interface ShouBannerContract {
     abstract class ShouBannerPresenter extends BasePresenter<IShouBannerModel,IShouBannerView> {
         @Override
         public IShouBannerModel getModel() {
             return new ShouBannerModel();
         }
         public abstract void setShouBanner(HashMap<String,String> params);
     }
    interface IShouBannerModel extends IBaseModel{
        void getShouBanner(HashMap<String,String> params, OkhttpCallback okhttpCallback);
    }
    interface IShouBannerView extends IBaseView {
        void success(String res);
        void failure(String s);
    }
}
