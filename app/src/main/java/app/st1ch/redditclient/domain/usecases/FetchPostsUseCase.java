package app.st1ch.redditclient.domain.usecases;

import java.util.List;

import javax.inject.Inject;

import app.st1ch.redditclient.domain.Post;
import app.st1ch.redditclient.data.repository.SessionRepository;
import rx.Observable;

/**
 * Created by st1ch on 14.09.2016.
 */
public class FetchPostsUseCase extends UseCase<List<Post>> {
    private SessionRepository sessionRepository;
    private int limit;

    @Inject
    public FetchPostsUseCase(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    protected Observable<List<Post>> getUseCaseObservable() {
        return sessionRepository.getPosts(limit);
    }
}
