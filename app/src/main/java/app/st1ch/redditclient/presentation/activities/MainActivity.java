package app.st1ch.redditclient.presentation.activities;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import app.st1ch.redditclient.R;
import app.st1ch.redditclient.RedditApplication;
import app.st1ch.redditclient.domain.Post;
import app.st1ch.redditclient.presentation.adapters.PostsAdapter;
import app.st1ch.redditclient.presentation.listeners.EndlessRecyclerViewScrollListener;
import app.st1ch.redditclient.presentation.presenters.MainActivityPresenter;
import app.st1ch.redditclient.presentation.views.IMainActivityView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IMainActivityView,
        SwipeRefreshLayout.OnRefreshListener{

    @Inject
    MainActivityPresenter presenter;
    @BindView(R.id.posts_recycler_view)
    RecyclerView rvPosts;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;

    private List<Post> postsList;
    private PostsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        RedditApplication.getComponent().inject(this);

        refreshLayout.setOnRefreshListener(this);
        postsList = new ArrayList<>();
        adapter = new PostsAdapter(postsList);
        setUpRecyclerView();

        presenter.bind(this);
        presenter.onCreate();
    }

    private void setUpRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvPosts.setLayoutManager(layoutManager);
        rvPosts.setItemAnimator(new DefaultItemAnimator());
        rvPosts.setAdapter(adapter);
        rvPosts.setOnScrollListener(new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                presenter.onLoadMore();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void showProgress() {
        refreshLayout.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void showToastMessage(String text) {
        Log.wtf("MainActivity", "showToastMessage()");
    }

    @Override
    public void onListLoad(List<Post> posts) {
        int curSize = adapter.getItemCount();
        postsList.addAll(posts);
        adapter.notifyItemRangeChanged(curSize, postsList.size() - 1);
    }

    @Override
    public void onNewPostsListLoad(List<Post> posts) {
        postsList.addAll(0, posts);
        adapter.notifyItemRangeChanged(0, posts.size() - 1);
    }

    @Override
    public void onRefresh() {
        presenter.onLoadNewPosts();
    }
}
