package com.dc.weidu.contract;

import com.dc.weidu.model.LoginModel;
import com.example.lib_core.base.mvp.BasePresenter;
import com.example.lib_core.base.mvp.IBaseModel;
import com.example.lib_core.base.mvp.IBaseView;
import com.example.lib_core.net.OkhttpCallback;

import java.util.HashMap;

public interface LoginContract {
     abstract class LoginPresenter extends BasePresenter<ILoginModel,ILoginView>{
         @Override
         public ILoginModel getModel() {
             return new LoginModel();
         }
         public abstract void setLoginList(HashMap<String,String> params);
     }
    interface ILoginModel extends IBaseModel{
        void getLogin(HashMap<String,String> params, OkhttpCallback okhttpCallback);
    }
    interface ILoginView extends IBaseView{
        void success(String res);
        void failure(String s);
    }
}
