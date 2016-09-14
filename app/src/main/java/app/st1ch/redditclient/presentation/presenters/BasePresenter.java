package app.st1ch.redditclient.presentation.presenters;

import android.support.annotation.Nullable;

import app.st1ch.redditclient.presentation.views.IView;

/**
 * Created by st1ch on 14.09.2016.
 */
public class BasePresenter<V extends IView> implements IPresenter<V> {

    @Nullable
    private V view;

    @Override
    public void bind(V view) {
        this.view = view;
    }

    @Override
    public void unbind() {
        this.view = null;
    }

    @Nullable
    public V getView(){
        return view;
    }
}
