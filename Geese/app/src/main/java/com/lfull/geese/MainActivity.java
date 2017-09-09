package com.lfull.geese;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.lfull.geese.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements NewsFragment.OnListFragmentInteractionListener,
        DiscoveryFragment.OnFragmentInteractionListener {
    private TextView subscriptionTxt;
    private TextView discoveryTxt;

    private NewsFragment newsFragment;
    private DiscoveryFragment discoveryFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        showFragment(R.string.title_news);
    }

    private void initView() {
        subscriptionTxt = findViewById(R.id.txt_subscription);
        discoveryTxt = findViewById(R.id.txt_discovery);

        newsFragment = NewsFragment.newInstance(1);
        discoveryFragment = DiscoveryFragment.newInstance("1", "2");

        subscriptionTxt.setOnClickListener(v -> showFragment(R.string.title_news));
        discoveryTxt.setOnClickListener(v -> showFragment(R.string.title_discovery));
    }

    private void showFragment(@StringRes int title) {
        if (title == R.string.title_news) {
            getSupportFragmentManager().beginTransaction().replace(R.id.page_container, newsFragment).commit();
            setTitle(R.string.title_news);
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.page_container, discoveryFragment).commit();
            setTitle(R.string.title_discovery);
        }
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
