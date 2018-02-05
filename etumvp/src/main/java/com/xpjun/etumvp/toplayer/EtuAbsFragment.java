package com.xpjun.etumvp.toplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by Rirsa on 2018/2/2.
 * 顶层fragment类
 */

public abstract class EtuAbsFragment<PresenterType extends Presenter>
        extends Fragment {

    private ViewHelper<PresenterType> helper = new ViewHelper<>(this);

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        helper.onCreatedView(savedInstanceState);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        helper.onResult(requestCode,resultCode,data);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        helper.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        helper.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        helper.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        helper.onStop();
    }

    @Override
    public void onStart() {
        super.onStart();
        helper.onStart();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        helper.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        helper.onDestroy();
    }
}
