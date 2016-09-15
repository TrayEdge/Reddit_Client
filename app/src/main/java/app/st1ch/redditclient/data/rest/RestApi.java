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
    private String after;
    private final int limit = 25;

    public RestApi(RedditApi api) {
        this.api = api;
    }

    public Observable<List<RedditPost>> fetchPosts() {
        return api.fetchPosts(limit, after, "ios")
                .map(parent -> {
                    List<RedditPost> posts = new ArrayList<>();
                    for (Child child : parent.getData().getChildren()) {
                        posts.add(child.getData());
                    }

                    after = parent.getData().getAfter();

                    return posts;
                });
    }

}
