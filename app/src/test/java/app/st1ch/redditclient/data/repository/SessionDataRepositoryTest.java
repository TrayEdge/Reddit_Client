package app.st1ch.redditclient.data.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import app.st1ch.redditclient.data.entity.RedditPost;
import app.st1ch.redditclient.data.mappers.MapperFactory;
import app.st1ch.redditclient.data.rest.RestApi;
import app.st1ch.redditclient.domain.Post;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.observers.TestSubscriber;

/**
 * Created by st1ch on 17.09.2016.
 */
public class SessionDataRepositoryTest {

    @Mock
    RestApi restApi;

    private SessionRepository sessionRepository;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        sessionRepository = new SessionDataRepository(restApi, new MapperFactory());
    }

    @Test
    public void getPosts_Response_InvokesCorrectApiCalls(){
        //Given
        Mockito.when(restApi.fetchPosts()).thenReturn(Observable.just(postsList()));

        //When
        TestSubscriber<List<Post>> subscriber = new TestSubscriber<>();
        sessionRepository.getPosts().subscribe(subscriber);

        //Then
        subscriber.awaitTerminalEvent();
        subscriber.assertNoErrors();

        List<List<Post>> onNextEvent = subscriber.getOnNextEvents();
        List<Post> posts = onNextEvent.get(0);
        Assert.assertEquals("Title 1", posts.get(0).getTitle());
        Assert.assertEquals("Title 2", posts.get(1).getTitle());
        Mockito.verify(restApi).fetchPosts();

    }

    @Test
    public void getNewPosts_Response_InvokesCorrectApiCalls(){
        //Given
        Mockito.when(restApi.fetchNewPosts()).thenReturn(Observable.just(postsList()));

        //When
        TestSubscriber<List<Post>> subscriber = new TestSubscriber<>();
        sessionRepository.getNewPosts().subscribe(subscriber);

        //Then
        subscriber.awaitTerminalEvent();
        subscriber.assertNoErrors();

        List<List<Post>> onNextEvent = subscriber.getOnNextEvents();
        List<Post> posts = onNextEvent.get(0);
        Assert.assertEquals("Title 1", posts.get(0).getTitle());
        Assert.assertEquals("Title 2", posts.get(1).getTitle());
        Mockito.verify(restApi).fetchNewPosts();

    }

    private List<RedditPost> postsList() {
        List<RedditPost> posts = new ArrayList<>();
        int size = 10;
        for(int i = 0; i < size; i++){
            RedditPost post = new RedditPost();
            post.setId(String.valueOf((int) (Math.random() * 1000)));
            int position = i + 1;
            post.setId(String.valueOf(position));
            post.setTitle("Title " + position);
            post.setAuthor("Author " + position);
            post.setThumbnail("Thumbnail " + position);
            post.setCreated("147147147.0");
            posts.add(post);
        }

        return posts;
    }

    @Test
    public void getPosts_IOExceptionThenSuccess_getPostsRetried(){
        //Given
        Mockito.when(restApi.fetchPosts())
                .thenReturn(getIOExceptionError(), Observable.just(postsList()));

        //When
        TestSubscriber<List<Post>> subscriber = new TestSubscriber<>();
        sessionRepository.getPosts().subscribe(subscriber);

        //Then
        subscriber.awaitTerminalEvent();
        subscriber.assertNoErrors();

        Mockito.verify(restApi, Mockito.times(2)).fetchPosts();
    }

    @Test
    public void getNewPosts_IOExceptionThenSuccess_getPostsRetried(){
        //Given
        Mockito.when(restApi.fetchNewPosts())
                .thenReturn(getIOExceptionError(), Observable.just(postsList()));

        //When
        TestSubscriber<List<Post>> subscriber = new TestSubscriber<>();
        sessionRepository.getNewPosts().subscribe(subscriber);

        //Then
        subscriber.awaitTerminalEvent();
        subscriber.assertNoErrors();

        Mockito.verify(restApi, Mockito.times(2)).fetchNewPosts();
    }

    @Test
    public void getPosts_OtherHttpError_SearchTerminatedWithError(){
        //Given
        Mockito.when(restApi.fetchPosts()).thenReturn(get403ForbiddenError());

        //When
        TestSubscriber<List<Post>> subscriber = new TestSubscriber<>();
        sessionRepository.getPosts().subscribe(subscriber);

        //Then
        subscriber.awaitTerminalEvent();
        subscriber.assertError(HttpException.class);

        Mockito.verify(restApi).fetchPosts();
    }

    private Observable getIOExceptionError(){
        return Observable.error(new IOException());
    }

    private Observable<List<RedditPost>> get403ForbiddenError(){
        return Observable.error(new HttpException(
                Response.error(403, ResponseBody.create(MediaType.parse("appliceion/json"), "Forbidden"))
        ));
    }

}