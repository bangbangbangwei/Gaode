package com.dc.weidu.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.dc.weidu.R;
import com.dc.weidu.contract.ShouBannerContract;
import com.example.lib_core.base.BaseFragment;
import com.example.lib_core.base.mvp.BasePresenter;
import com.recker.flybanner.FlyBanner;

public class FragmentShouye extends BaseFragment implements ShouBannerContract.IShouBannerView {

    private FlyBanner shouBanner;

    @Override
    protected int bindLayoutId() {
        return R.layout.fragmentshouye;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        shouBanner = view.findViewById(R.id.ShouBanner);

    }

    @Override
    public void success(String res) {

    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void failure(String s) {

    }
}
