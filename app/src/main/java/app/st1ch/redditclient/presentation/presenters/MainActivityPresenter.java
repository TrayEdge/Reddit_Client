package app.st1ch.redditclient.presentation.presenters;

import java.util.List;

import javax.inject.Inject;

import app.st1ch.redditclient.domain.ErrorHandler;
import app.st1ch.redditclient.domain.Post;
import app.st1ch.redditclient.domain.subscribers.BaseProgressSubscriber;
import app.st1ch.redditclient.domain.usecases.FetchPostsUseCase;
import app.st1ch.redditclient.presentation.views.IMainActivityView;

/**
 * Created by st1ch on 14.09.2016.
 */
public class MainActivityPresenter extends ProgressPresenter<IMainActivityView>
        implements IMainActivityPresenter, BaseProgressSubscriber.ProgressSubscriberListener {

    private FetchPostsUseCase useCase;

    @Inject
    public MainActivityPresenter(FetchPostsUseCase useCase, ErrorHandler errorHandler) {
        super(errorHandler);
        this.useCase = useCase;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onResume() {
        useCase.execute(getFetchPostsSubscriber());
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {
        useCase.unsubscribe();
    }

    @Override
    public void onLoadMore() {
        useCase.execute(getFetchPostsSubscriber());
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
//                for(Post post: posts){
//                    Log.wtf("onNext", String.valueOf(post));
//                }
//                if (getView() != null) {
//                    getView().showToastMessage(posts.toString());
//                }
            }
        };
    }

}
