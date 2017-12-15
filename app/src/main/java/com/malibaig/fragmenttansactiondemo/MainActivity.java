package com.malibaig.fragmenttansactiondemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements FirstFragment.ShowSecondFragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showFirstFragment();
    }

    private void showFirstFragment() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, FirstFragment.newInstance())
                .commit();
    }

    @Override
    public void showSecondFragment() {
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slide_in_from_bottom_bounce, R.anim.zoom_out_slow, R.anim.zoom_in_slow, R.anim.slide_out_to_bottom)
                .replace(R.id.fragment_container, SecondFragment.newInstance())
                .addToBackStack("Replace FirstFragment with Second")
                .commit();
    }
}
