package app.st1ch.redditclient.presentation.views;

import java.util.List;

import app.st1ch.redditclient.domain.Post;

/**
 * Created by st1ch on 14.09.2016.
 */
public interface IMainActivityView extends IProgressView {

    void onListLoad(List<Post> posts);
    void onNewPostsListLoad(List<Post> posts);

}
