package app.st1ch.redditclient.presentation.presenters;

import app.st1ch.redditclient.presentation.views.IView;

/**
 * Created by st1ch on 14.09.2016.
 */
public interface IPresenter<V extends IView> {
    void bind(V view);
    void unbind();
}
