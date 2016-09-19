package app.st1ch.redditclient.presentation.presenters;

import app.st1ch.redditclient.presentation.views.IMainActivityView;

/**
 * Created by st1ch on 14.09.2016.
 */
public interface IMainActivityPresenter extends IPresenter<IMainActivityView> {

    void onCreate();
    void onResume();
    void onPause();
    void onDestroy();
    void onLoadMore();
    void onLoadNewPosts();

}
