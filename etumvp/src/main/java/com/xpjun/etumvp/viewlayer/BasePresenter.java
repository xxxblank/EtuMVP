package com.xpjun.etumvp.viewlayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.xpjun.etumvp.toplayer.Presenter;

/**
 * Created by Rirsa on 2018/2/4.
 */

public class BasePresenter<ViewType> extends Presenter<ViewType> {

    public static final String DATA_KEY = "data";

    private Activity getActivity(){
        Activity activity = null;
        if (getView() instanceof Activity) activity = (Activity)getView();
        if (getView() instanceof Fragment) activity = ((Fragment) getView()).getActivity();
        if (activity==null) Log.e("","");
        return activity;
    }

    public void startActivity(Intent intent){
        getActivity().startActivity(intent);
    }

    public void startActivity(Class<? extends Activity> clazz){
        Activity activity = getActivity();
        Intent intent = new Intent(activity,clazz);
        activity.startActivity(intent);
    }

    public void startActivityWithData(Parcelable data,Class<? extends Activity> clazz){
        Activity activity = getActivity();
        Intent intent = new Intent(activity,clazz);
        intent.putExtra(DATA_KEY,data);
        activity.startActivity(intent);
    }
}
