package com.xpjun.mymvp;


import io.reactivex.Observable;

/**
 * Created by Rirsa on 2018/2/5.
 */

public class MainModel {
    public static Observable<String> getData(String data){
        return Observable.just(data);
    }
}
