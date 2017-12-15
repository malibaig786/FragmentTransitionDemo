package com.malibaig.fragmenttansactiondemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        showSecondFragment();
    }

    public void showSecondFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_second_activity, SecondFragment.newInstance())
                .commit();
    }
}
