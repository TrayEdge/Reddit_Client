package app.st1ch.redditclient;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import app.st1ch.redditclient.di.ApplicationComponent;
import app.st1ch.redditclient.di.ApplicationModule;
import app.st1ch.redditclient.di.DaggerApplicationComponent;
import app.st1ch.redditclient.domain.Post;

/**
 * Created by st1ch on 13.09.2016.
 */
public class RedditApplication extends Application {
    private static ApplicationComponent component;
    private static RedditApplication instance;

    private List<Post> postsList;

    @Override
    public void onCreate() {
        super.onCreate();
        component = buildComponent();
        instance = this;

        postsList = new ArrayList<>();
    }

    protected ApplicationComponent buildComponent(){
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static RedditApplication getInstance() {
        return instance;
    }

    public List<Post> getPostsList() {
        return postsList;
    }

    public static ApplicationComponent getComponent(){
        return component;
    }
}
