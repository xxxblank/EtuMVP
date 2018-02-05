package com.xpjun.etumvp;

import com.xpjun.etumvp.viewlayer.BasePresenter;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Rirsa on 2018/2/5.
 */

public class BaseDataFragmentPresenter<ViewType extends BaseDataFragment,ModelType>
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
            getView().errorCallback(e);
        }

        @Override
        public void onComplete() {
            getView().completeCallback();
        }
    };

    protected Observer<ModelType> getDataSubscriber(){
        return dataSubscriber;
    }
}
