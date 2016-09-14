package app.st1ch.redditclient.data.di;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import app.st1ch.redditclient.data.ResponseErrorHandler;
import app.st1ch.redditclient.data.mappers.AbstractMapperFactory;
import app.st1ch.redditclient.data.mappers.MapperFactory;
import app.st1ch.redditclient.data.repository.SessionDataRepository;
import app.st1ch.redditclient.data.repository.SessionRepository;
import app.st1ch.redditclient.data.rest.RedditApi;
import app.st1ch.redditclient.data.rest.RestApi;
import app.st1ch.redditclient.domain.ErrorHandler;
import app.st1ch.redditclient.utils.Constants;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by st1ch on 13.09.2016.
 */
@Module
public class DataModule {

    @Provides
    @Singleton
    public OkHttpClient provideOkClient(){
        return new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(Constants.URLS.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public RedditApi provideRedditApi(Retrofit retrofit){
        return retrofit.create(RedditApi.class);
    }

    @Provides
    @Singleton
    public RestApi provideRestApi(RedditApi api){
        return new RestApi(api);
    }

    @Provides
    public AbstractMapperFactory provideMapperFactory(){
        return new MapperFactory();
    }

    @Provides
    @Singleton
    public SessionRepository provideSessionRepository(RestApi restApi){
        return new SessionDataRepository(restApi, new MapperFactory());
    }

    @Provides
    @Singleton
    public ErrorHandler provideErrorHandler(){
        return new ResponseErrorHandler();
    }


}
