package com.xpjun.mymvp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xpjun.etumvp.EtuAbsActivity;
import com.xpjun.etumvp.RequirePresenter;

@RequirePresenter(MainPresenter.class)
public class MainActivity extends EtuAbsActivity<MainPresenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //test
        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().getText();
            }
        });
    }

    public void setText(String asdf) {
        ((TextView)findViewById(R.id.text)).setText(asdf);
    }
}
