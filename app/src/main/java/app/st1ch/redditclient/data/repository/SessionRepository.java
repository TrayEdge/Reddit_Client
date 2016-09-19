package app.st1ch.redditclient.data.repository;

import java.util.List;

import app.st1ch.redditclient.domain.Post;
import rx.Observable;

/**
 * Created by st1ch on 13.09.2016.
 */
public interface SessionRepository {

    Observable<List<Post>> getPosts();
    Observable<List<Post>> getNewPosts();

}
