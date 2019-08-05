package com.example.login.home;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.login.R;
import com.example.login.login.LoginFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeFragment extends Fragment {

    private TextView welcomeMsg;
    //private Button BnLogout;
    private BottomNavigationView bottonNav;

    public interface OnLogoutListerner
    {
        public void logoutPerformed();
    }

    /* public interface OnNavigationItemReselectedLister
    {
        public void selectedNavigation();
    } */

    public WelcomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);

        bottonNav = view.findViewById(R.id.navigation);
        bottonNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {Fragment selectedFragment = null;
                switch (menuItem.getItemId()) {
                    case R.id.nav_event:
                        selectedFragment = new EventFragment();
                        Log.d("welcome","Event Fragment");
                        break;
                    case R.id.nav_contact:
                        selectedFragment = new ContactFragment();
                        Log.d("welcome","Contact Fragment");
                        break;
                    case R.id.nav_info:
                        selectedFragment = new infoFragment();
                        Log.d("welcome","Info Fragment");
                        break;
                }

                getChildFragmentManager().beginTransaction().replace(R.id.nav_layout, selectedFragment).commit();
                return true;
            }

        });

        return view;
    }

}