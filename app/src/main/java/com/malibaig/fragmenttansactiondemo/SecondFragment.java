package com.malibaig.fragmenttansactiondemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class SecondFragment extends Fragment {


    public SecondFragment() {
        // Required empty public constructor
    }

    public static SecondFragment newInstance() {
        SecondFragment fragment = new SecondFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_second, container, false);
        return rootView;
    }

    @Override
    public Animation onCreateAnimation(int transit, final boolean enter, int nextAnim) {
        Animation nextAnimation = AnimationUtils.loadAnimation(getContext(), nextAnim);
        nextAnimation.setAnimationListener(new Animation.AnimationListener() {

            private float mOldTranslationZ;

            @Override
            public void onAnimationStart(Animation animation) {
                if (getView() != null && enter) {
                    mOldTranslationZ = ViewCompat.getTranslationZ(getView());
                    ViewCompat.setTranslationZ(getView(), 100.f);
                }
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (getView() != null && enter) {
                    ViewCompat.setTranslationZ(getView(), mOldTranslationZ);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        return nextAnimation;
    }
}
