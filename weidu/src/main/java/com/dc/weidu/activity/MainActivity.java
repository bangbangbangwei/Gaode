package com.dc.weidu.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dc.weidu.R;
import com.dc.weidu.bean.LoginBean;
import com.dc.weidu.contract.LoginContract;
import com.dc.weidu.presenter.LoginPresenter;
import com.example.lib_core.base.mvp.BaseMvpActivity;
import com.example.lib_core.base.mvp.BasePresenter;
import com.google.gson.Gson;

import java.util.HashMap;

public class MainActivity extends BaseMvpActivity<LoginContract.ILoginModel,LoginContract.LoginPresenter> implements LoginContract.ILoginView{


    private EditText name;
    private EditText pwd;
    private CheckBox cb_jz;
    private TextView log_resgin;
    private Button btn_login;
    HashMap<String, String> params;
    @Override
    public void success(String res) {
        LoginBean loginBean = new Gson().fromJson(res, LoginBean.class);
        if ("登录成功".equals(loginBean.getMessage())){
            Intent intent = new Intent(MainActivity.this,DifferentActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void initView() {
        initFindView();
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = MainActivity.this.name.getText().toString();
                String pwd = MainActivity.this.pwd.getText().toString();
                params = new HashMap<>();
                params.put("phone",phone);
                params.put("pwd",pwd);
                presenter.setLoginList(params);
            }
        });
        log_resgin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ResginActivity.class);
                startActivityForResult(intent,1000);
            }
        });

    }

    private void initFindView() {
        name = findViewById(R.id.name);
        pwd = findViewById(R.id.pwd);
        cb_jz = findViewById(R.id.cb_jz);
        log_resgin = findViewById(R.id.log_resgin);
        btn_login = findViewById(R.id.btn_login);
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public BasePresenter initPresenter() {
        return new LoginPresenter();
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000 && resultCode == 2000){
            String phone = data.getStringExtra("phone");
            String s_pwd = data.getStringExtra("pwd");
            name.setText(phone);
            pwd.setText(s_pwd);
        }
    }
}
