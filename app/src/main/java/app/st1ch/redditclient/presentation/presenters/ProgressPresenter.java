package app.st1ch.redditclient.presentation.presenters;

import app.st1ch.redditclient.domain.ErrorHandler;
import app.st1ch.redditclient.domain.subscribers.BaseProgressSubscriber;
import app.st1ch.redditclient.presentation.views.IProgressView;

/**
 * Created by st1ch on 14.09.2016.
 */
public class ProgressPresenter<V extends IProgressView> extends BasePresenter<V>
        implements BaseProgressSubscriber.ProgressSubscriberListener {

    private ErrorHandler errorHandler;

    public ProgressPresenter(ErrorHandler errorHandler){
        this.errorHandler = errorHandler;
    }

    @Override
    public void onError(Throwable t) {
        V view = getView();
        if (view != null) {
            view.hideProgress();
            view.showToastMessage(errorHandler.handleError(t));
        }
    }

    @Override
    public void onCompleted() {
        V view = getView();
        if (view != null) {
            view.hideProgress();
        }
    }

    @Override
    public void onStartLoading() {
        V view = getView();
        if (view != null) {
            view.showProgress();
        }
    }
}
