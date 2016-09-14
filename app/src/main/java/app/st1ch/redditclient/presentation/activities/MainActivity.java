package app.st1ch.redditclient.presentation.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import javax.inject.Inject;

import app.st1ch.redditclient.R;
import app.st1ch.redditclient.RedditApplication;
import app.st1ch.redditclient.presentation.presenters.MainActivityPresenter;
import app.st1ch.redditclient.presentation.views.IMainActivityView;

public class MainActivity extends AppCompatActivity implements IMainActivityView {

    @Inject
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RedditApplication.getComponent().inject(this);

        presenter.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void showProgress() {
        Log.wtf("MainActivity", "showProgress()");
    }

    @Override
    public void hideProgress() {
        Log.wtf("MainActivity", "hideProgress()");
    }

    @Override
    public void showToastMessage(String text) {
        Log.wtf("MainActivity", "showToastMessage()");
    }
}
