package app.st1ch.redditclient.domain.subscribers;

import android.util.Log;

import rx.Subscriber;

/**
 * Created by st1ch on 14.09.2016.
 */
public abstract class BaseUseCaseSubscriber<T> extends Subscriber<T> {

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        Log.e("exception", String.valueOf(e));
    }

    @Override
    public void onNext(T t) {

    }
}
