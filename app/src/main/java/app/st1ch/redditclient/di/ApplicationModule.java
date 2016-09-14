package app.st1ch.redditclient.di;

import android.content.Context;

import javax.inject.Singleton;

import app.st1ch.redditclient.data.di.DataModule;
import app.st1ch.redditclient.domain.di.DomainModule;
import dagger.Module;
import dagger.Provides;

/**
 * Created by st1ch on 13.09.2016.
 */
@Module(includes = {DataModule.class, DomainModule.class})
public class ApplicationModule {
    private final Context application;

    public ApplicationModule(Context application){
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext(){
        return application;
    }
}
