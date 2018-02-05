package com.xpjun.etumvp;

import com.xpjun.etumvp.viewlayer.BasePresenter;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Rirsa on 2018/2/5.
 */

public class BaseDataActivityPresenter<ViewType extends BaseDataActivity,ModelType>
        extends BasePresenter<ViewType> {
    Observer<ModelType> dataSubscriber = new Observer<ModelType>() {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(ModelType modelType) {
            getView().dataCallback(modelType);
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    };

    protected Observer<ModelType> getDataSubscriber(){
        return dataSubscriber;
    }
}
