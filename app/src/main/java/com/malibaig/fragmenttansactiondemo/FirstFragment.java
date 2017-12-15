package com.malibaig.fragmenttansactiondemo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FirstFragment extends Fragment {

    private ShowSecondFragment listener;

    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment newInstance() {
        FirstFragment fragment = new FirstFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_first, container, false);
        initializeViews(rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listener = (ShowSecondFragment) getActivity();
    }

    private void initializeViews(View rootView) {
        Button button = (Button) rootView.findViewById(R.id.btn_show_second_fragment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.showSecondFragment();
            }
        });
    }

    public interface ShowSecondFragment {
        void showSecondFragment();
    }

}
