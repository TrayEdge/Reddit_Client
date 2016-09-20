package app.st1ch.redditclient.data.repository;

import java.io.IOException;
import java.util.List;

import app.st1ch.redditclient.data.mappers.AbstractMapperFactory;
import app.st1ch.redditclient.data.rest.RestApi;
import app.st1ch.redditclient.domain.Post;
import rx.Observable;

/**
 * Created by st1ch on 13.09.2016.
 */
public class SessionDataRepository implements SessionRepository {

    private final AbstractMapperFactory abstractMapperFactory;
    private RestApi restApi;

    public SessionDataRepository(RestApi restApi, AbstractMapperFactory abstractMapperFactory) {
        this.restApi = restApi;
        this.abstractMapperFactory = abstractMapperFactory;
    }

    @Override
    public Observable<List<Post>> getPosts() {
        return Observable.defer(() -> restApi.fetchPosts()
                .concatMap(Observable::from)
                .map(redditPost -> abstractMapperFactory.getPostMapper()
                        .transform(redditPost)).toList())
                .retryWhen(errors -> errors
                        .flatMap(error -> {
                            if (error instanceof IOException) {
                                return Observable.just(null);
                            }
                            return Observable.error(error);
                        }));
    }

    @Override
    public Observable<List<Post>> getNewPosts() {
        return Observable.defer(() -> restApi.fetchNewPosts()
                .concatMap(Observable::from)
                .map(redditPost -> abstractMapperFactory.getPostMapper()
                        .transform(redditPost)).toList())
                .retryWhen(errors -> errors
                        .flatMap(error -> {
                            if (error instanceof IOException) {
                                return Observable.just(null);
                            }
                            return Observable.error(error);
                        }))
                ;
    }


}
