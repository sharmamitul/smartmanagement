package com.example.login.home;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.login.MainActivity;
import com.example.login.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class infoFragment extends Fragment {

    private EditText txt_name;
    private Button BnLogout;
    OnLogoutListerner logoutListerner;

    public interface OnLogoutListerner
    {
        public void logoutPerformed();
    }

    public infoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        BnLogout = view.findViewById(R.id.bn_logout);
        txt_name = view.findViewById(R.id.info_name);

        txtDisplay();

        BnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logoutListerner.logoutPerformed();
            }
        });
        return view;
    }

    public void txtDisplay(){


        txt_name.setText(MainActivity.prefConfig.readName());

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        logoutListerner = (OnLogoutListerner) activity;


    }

}
