package app.st1ch.redditclient.presentation.activities;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

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

    private PostsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        RedditApplication.getComponent().inject(this);

        refreshLayout.setOnRefreshListener(this);
        List<Post> postsList = RedditApplication.getInstance().getPostsList();
        adapter = new PostsAdapter(postsList);
        setUpRecyclerView();

        presenter.bind(this);

        if(postsList.isEmpty()){
            presenter.onLoadMore();
        }
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
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onListLoad(List<Post> posts) {
        int curSize = adapter.getItemCount();
        RedditApplication.getInstance().getPostsList().addAll(posts);
        adapter.notifyItemRangeChanged(curSize, RedditApplication.getInstance().getPostsList().size() - 1);
    }

    @Override
    public void onNewPostsListLoad(List<Post> posts) {
        RedditApplication.getInstance().getPostsList().addAll(0, posts);
        adapter.notifyItemRangeChanged(0, posts.size() - 1);
    }

    @Override
    public void onRefresh() {
        presenter.onLoadNewPosts();
    }
}
