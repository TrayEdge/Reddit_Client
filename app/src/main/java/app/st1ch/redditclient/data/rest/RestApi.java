package app.st1ch.redditclient.data.rest;

import java.util.List;

import app.st1ch.redditclient.data.entity.Data;
import app.st1ch.redditclient.data.entity.RedditPost;
import rx.Observable;

/**
 * Created by st1ch on 13.09.2016.
 */
public class RestApi {

    private final RedditApi api;
    private String after;
    private String before;
    private final int limit = 25;
    private final int count = 25;
    private final String q = "ios";

    private boolean isFirstFetch = true;

    public RestApi(RedditApi api) {
        this.api = api;
    }

    public Observable<List<RedditPost>> fetchPosts() {
        return api.fetchPosts(limit, after, count, q)
                .concatMap(parent -> {
                            Data data = parent.getData();
                            after = data.getAfter();
                            if (isFirstFetch) {
                                before = data.getBefore();
                                isFirstFetch = false;
                            }
                            return Observable.from(data.getChildren())
                                    .concatMap(child1 -> Observable.just(child1.getData()).toList());

                        }
                );
    }

    public Observable<List<RedditPost>> fetchNewPosts() {
        return api.fetchNewPosts(limit, before, count, q)
                .concatMap(parent -> {
                            Data data = parent.getData();
                            after = data.getAfter();
                            if (isFirstFetch) {
                                before = data.getBefore();
                                isFirstFetch = false;
                            }
                            return Observable.from(data.getChildren());
                        }
                )
                .concatMap(child1 -> Observable.just(child1.getData()).toList());
    }

}
