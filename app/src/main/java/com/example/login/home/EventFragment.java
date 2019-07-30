package com.example.login.home;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.login.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment {

    public static EventFragment newInstance() {
        EventFragment fragment = new EventFragment();
        return fragment;
    }
    public EventFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event, container, false);
    }

}
