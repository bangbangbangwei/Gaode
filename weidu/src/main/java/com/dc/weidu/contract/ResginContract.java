package com.dc.weidu.contract;

import com.dc.weidu.model.ResginModel;
import com.example.lib_core.base.mvp.BasePresenter;
import com.example.lib_core.base.mvp.IBaseModel;
import com.example.lib_core.base.mvp.IBaseView;
import com.example.lib_core.net.OkhttpCallback;

import java.util.HashMap;

public interface ResginContract {
    abstract class ResginPresenter extends BasePresenter<IResginModel,IResginView>{
        @Override
        public IResginModel getModel() {
            return new ResginModel();
        }
        public abstract void setResgin(HashMap<String,String> params);
    }
    public interface IResginModel extends IBaseModel {
        void setResginList(HashMap<String,String> params, OkhttpCallback okhttpCallback);
    }
    public interface IResginView extends IBaseView {
        void success(String res);
        void failure(String s);
    }
}
