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
public class infoFragment extends Fragment {

    public static infoFragment newInstance() {
        infoFragment fragment = new infoFragment();
        return fragment;
    }
    public infoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

}
