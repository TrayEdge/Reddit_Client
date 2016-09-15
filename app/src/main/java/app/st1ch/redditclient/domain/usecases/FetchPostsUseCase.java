package app.st1ch.redditclient.domain.usecases;

import java.util.List;

import javax.inject.Inject;

import app.st1ch.redditclient.data.repository.SessionRepository;
import app.st1ch.redditclient.domain.Post;
import rx.Observable;

/**
 * Created by st1ch on 14.09.2016.
 */
public class FetchPostsUseCase extends UseCase<List<Post>> {
    private SessionRepository sessionRepository;

    @Inject
    public FetchPostsUseCase(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    protected Observable<List<Post>> getUseCaseObservable() {
        return sessionRepository.getPosts();
    }
}
