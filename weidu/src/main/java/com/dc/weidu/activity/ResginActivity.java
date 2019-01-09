package com.dc.weidu.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dc.weidu.R;
import com.dc.weidu.bean.LoginBean;
import com.dc.weidu.contract.ResginContract;
import com.dc.weidu.presenter.ResginPresenter;
import com.example.lib_core.base.mvp.BaseMvpActivity;
import com.example.lib_core.base.mvp.BasePresenter;
import com.google.gson.Gson;

import java.util.HashMap;

public class ResginActivity extends BaseMvpActivity<ResginContract.IResginModel,ResginContract.ResginPresenter> implements ResginContract.IResginView{

    private EditText res_name;
    private EditText res_pwd;
    private EditText res_yam;
    private Button btn_resgin;
    private HashMap<String, String> params;

    @Override
    public void success(String res) {
        LoginBean loginBean = new Gson().fromJson(res, LoginBean.class);
        if ("注册成功".equals(loginBean.getMessage())){
            Intent intent = new Intent();
            intent.putExtra("phone",res_name.getText().toString());
            intent.putExtra("pwd",res_pwd.getText().toString());
            setResult(2000,intent);
            finish();
        }
    }

    @Override
    protected void initView() {
        initFindView();
        btn_resgin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String res_name = ResginActivity.this.res_name.getText().toString();
                String res_pwd = ResginActivity.this.res_pwd.getText().toString();
                params = new HashMap<>();
                params.put("phone",res_name);
                params.put("pwd",res_pwd);
                presenter.setResgin(params);
                Toast.makeText(ResginActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFindView() {
        res_name = findViewById(R.id.res_name);
        res_pwd = findViewById(R.id.res_pwd);
        res_yam = findViewById(R.id.res_yzm);
        btn_resgin = findViewById(R.id.btn_resgin);
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_resgin;
    }

    @Override
    public BasePresenter initPresenter() {
        return new ResginPresenter();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void failure(String msg) {

    }
}
