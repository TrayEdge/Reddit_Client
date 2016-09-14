package app.st1ch.redditclient.di;

import javax.inject.Singleton;

import app.st1ch.redditclient.presentation.activities.MainActivity;
import dagger.Component;

/**
 * Created by st1ch on 13.09.2016.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    // Inject of Activities
    void inject(MainActivity mainActivity);

}
