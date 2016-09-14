package app.st1ch.redditclient.data.repository;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import app.st1ch.redditclient.data.entity.RedditPost;
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

    public SessionDataRepository(RestApi restApi, AbstractMapperFactory abstractMapperFactory){
        this.restApi = restApi;
        this.abstractMapperFactory = abstractMapperFactory;
    }

    @Override
    public Observable<List<Post>> getPosts(int limit) {
        return restApi.fetchPosts(limit).map(redditPosts -> {
            List<Post> posts = new ArrayList<>();
            for(RedditPost redditPost: redditPosts){
                Log.wtf("SDR", "redditPost: " + redditPost.toString());
                posts.add(abstractMapperFactory.getPostMapper().transform(redditPost));
            }
            return posts;
        });
    }
}