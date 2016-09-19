package app.st1ch.redditclient.data.repository;

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
    public Observable<List<Post>> getPosts() {
        return restApi.fetchPosts().map(redditPosts -> {
            List<Post> posts = new ArrayList<>();
            for(RedditPost redditPost: redditPosts){
                Post post = abstractMapperFactory.getPostMapper().transform(redditPost);
                posts.add(post);
            }
            return posts;
        });
    }

    @Override
    public Observable<List<Post>> getNewPosts() {
        return restApi.fetchNewPosts().map(redditPosts -> {
            List<Post> posts = new ArrayList<>();
            for(RedditPost redditPost: redditPosts){
                Post post = abstractMapperFactory.getPostMapper().transform(redditPost);
                posts.add(post);
            }
            return posts;
        });
    }


}
