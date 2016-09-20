package app.st1ch.redditclient.presentation.presenters;

import java.util.List;

import javax.inject.Inject;

import app.st1ch.redditclient.domain.ErrorHandler;
import app.st1ch.redditclient.domain.Post;
import app.st1ch.redditclient.domain.subscribers.BaseProgressSubscriber;
import app.st1ch.redditclient.domain.usecases.FetchNewPostsUseCase;
import app.st1ch.redditclient.domain.usecases.FetchPostsUseCase;
import app.st1ch.redditclient.presentation.views.IMainActivityView;

/**
 * Created by st1ch on 14.09.2016.
 */
public class MainActivityPresenter extends ProgressPresenter<IMainActivityView>
        implements IMainActivityPresenter, BaseProgressSubscriber.ProgressSubscriberListener {

    private FetchPostsUseCase useCase;
    private FetchNewPostsUseCase newPostsUseCase;

    @Inject
    public MainActivityPresenter(FetchPostsUseCase useCase, FetchNewPostsUseCase newPostsUseCase,
                                 ErrorHandler errorHandler) {
        super(errorHandler);
        this.useCase = useCase;
        this.newPostsUseCase = newPostsUseCase;
    }

    @Override
    public void onCreate() {
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onPause() {
    }

    @Override
    public void onDestroy() {
        useCase.unsubscribe();
        unbind();
    }

    @Override
    public void onLoadMore() {
        useCase.execute(getFetchPostsSubscriber());
    }

    @Override
    public void onLoadNewPosts() {
        newPostsUseCase.execute(getFetchNewPostsSubscriber());
    }

    private BaseProgressSubscriber<List<Post>> getFetchPostsSubscriber(){
        return new BaseProgressSubscriber<List<Post>>(this){
            @Override
            public void onNext(List<Post> posts) {
                super.onNext(posts);
                IMainActivityView view = getView();
                if (view != null) {
                    view.onListLoad(posts);
                }
            }
        };
    }

    private BaseProgressSubscriber<List<Post>> getFetchNewPostsSubscriber(){
        return new BaseProgressSubscriber<List<Post>>(this){
            @Override
            public void onNext(List<Post> posts) {
                super.onNext(posts);
                IMainActivityView view = getView();
                if (view != null) {
                    view.onNewPostsListLoad(posts);
                }
            }
        };
    }

}
