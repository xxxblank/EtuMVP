package com.xpjun.mymvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xpjun.etumvp.TestUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TestUtil.showToast(this);
    }
}
