package app.st1ch.redditclient.data.rest;

import java.util.ArrayList;
import java.util.List;

import app.st1ch.redditclient.data.entity.Child;
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

    public RestApi(RedditApi api) {
        this.api = api;
    }

    public Observable<List<RedditPost>> fetchPosts() {
        return api.fetchPosts(limit, after, count, "ios")
                .map(parent -> {
                    List<RedditPost> posts = new ArrayList<>();
                    Data data = parent.getData();
                    for (Child child : data.getChildren()) {
                        posts.add(child.getData());
                    }

                    after = data.getAfter();
                    before = data.getBefore();

                    return posts;
                });
    }

    public Observable<List<RedditPost>> fetchNewPosts() {
        return api.fetchNewPosts(limit, before, count, "ios")
                .map(parent -> {
                    List<RedditPost> posts = new ArrayList<>();
                    Data data = parent.getData();
                    for (Child child : data.getChildren()) {
                        posts.add(child.getData());
                    }

                    after = data.getAfter();
                    before = data.getBefore();

                    return posts;
                });
    }

}
