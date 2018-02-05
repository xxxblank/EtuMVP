package com.xpjun.mymvp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.xpjun.etumvp.BaseDataActivity;
import com.xpjun.etumvp.toplayer.RequirePresenter;

@RequirePresenter(MainActivityPresenter.class)
public class MainActivity extends BaseDataActivity<MainActivityPresenter,String> {

    private TextView text;
    private MainActivityPresenter presenter;

    @Override
    protected void initData() {
        presenter = getPresenter();
    }

    @Override
    protected void initView() {
        text = $(R.id.text);
        click(text);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.text:
                presenter.getText();
        }
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    public void setText(String s) {
        text.setText(s);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (presenter!=null) presenter.getText();
    }

    @Override
    public void dataCallback(String s) {
        Toast.makeText(this,"datacallback",Toast.LENGTH_SHORT).show();
        setText(s);
    }
}
