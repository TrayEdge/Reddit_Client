package app.st1ch.redditclient;

import android.app.Application;

import app.st1ch.redditclient.di.ApplicationComponent;
import app.st1ch.redditclient.di.ApplicationModule;
import app.st1ch.redditclient.di.DaggerApplicationComponent;

/**
 * Created by st1ch on 13.09.2016.
 */
public class RedditApplication extends Application {
    private static ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = buildComponent();
    }

    protected ApplicationComponent buildComponent(){
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static ApplicationComponent getComponent(){
        return component;
    }
}
