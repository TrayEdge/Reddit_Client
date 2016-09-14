package app.st1ch.redditclient.data.rest;

import java.util.ArrayList;
import java.util.List;

import app.st1ch.redditclient.data.entity.Child;
import app.st1ch.redditclient.data.entity.RedditPost;
import rx.Observable;

/**
 * Created by st1ch on 13.09.2016.
 */
public class RestApi {

    private final RedditApi api;

    public RestApi(RedditApi api) {
        this.api = api;
    }

    public Observable<List<RedditPost>> fetchPosts(int limit) {
        return api.fetchPosts(limit, "ios").map(parent -> {
            List<RedditPost> posts = new ArrayList<>();
            for (Child child : parent.getData().getChildren()) {
                posts.add(child.getData());
            }

            return posts;
        });
    }

}
