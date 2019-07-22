package com.example.login;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeFragment extends Fragment {

    private TextView welcomeMsg;
    private Button BnLogout;

    OnLogoutListerner logoutListerner;

    public interface OnLogoutListerner
    {
        public void logoutPerformed();
    }

    public WelcomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);

        welcomeMsg = view.findViewById(R.id.txt_name_info);
        welcomeMsg.setText("Welcome "+MainActivity.prefConfig.readName());
        BnLogout = view.findViewById(R.id.bn_logout);

        BnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logoutListerner.logoutPerformed();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        logoutListerner = (OnLogoutListerner) activity;

    }
}
