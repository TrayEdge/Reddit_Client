package app.st1ch.redditclient.domain.usecases;

import android.util.Log;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by st1ch on 14.09.2016.
 */
public abstract class UseCase<T> {

    private Subscription subscription = Subscriptions.empty();
    private Observable<T> observable;

    public UseCase(){}

    public void execute(Subscriber<T> subscriber){
        Log.wtf("subscription", "execute");
        if(observable == null){
            observable = getUseCaseObservable()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .cache()
                    .doOnError(throwable -> observable = null)
                    .doOnCompleted(() -> observable = null);
            subscription = observable.subscribe(subscriber);
        }
    }

    protected abstract Observable<T> getUseCaseObservable();

    public boolean isWorking(){
        return observable != null;
    }

    public void unsubscribe(){
        Log.wtf("subscription", "unsubscribe");
        if(!subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }
    }

}
