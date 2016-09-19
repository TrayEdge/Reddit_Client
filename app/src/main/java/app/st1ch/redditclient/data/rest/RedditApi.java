package app.st1ch.redditclient.data.rest;

import app.st1ch.redditclient.data.entity.Parent;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by st1ch on 13.09.2016.
 */
public interface RedditApi {

    @GET(".json")
    Observable<Parent> fetchPosts(
            @Query("limit") int limit,
            @Query("after") String after,
            @Query("count") int count,
            @Query("q") String q
    );

    @GET(".json")
    Observable<Parent> fetchNewPosts(
            @Query("limit") int limit,
            @Query("before") String before,
            @Query("count") int count,
            @Query("q") String q
    );

}
