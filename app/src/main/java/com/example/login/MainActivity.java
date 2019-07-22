package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements LoginFragment.OnLoginFormActivityListner, WelcomeFragment.OnLogoutListerner {

    public static PrefConfig prefConfig;
    public static ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefConfig = new PrefConfig(this);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Log.d("login","Invoke on create main method");


        if (findViewById(R.id.fragment_container)!= null)
        {
            if (savedInstanceState!=null)
            {
                return;
            }
        }

        if (prefConfig.readLoginstatus())
        {
            Log.d("welcome","Loading Welcome Fragment");
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new WelcomeFragment()).commit();
        }
        else
        {
            Log.d("login","Loading Login Fragment");
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new LoginFragment()).commit();
        }
    }


    @Override
    public void performRegister() {
        Log.d("register","Invoke perform register");
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new RegistrationFragment()).addToBackStack(null).commit();
    }

    @Override
    public void performLogin(String name) {

        Log.d("login","Invoke perform login fragment method");
        prefConfig.writeName(name);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new WelcomeFragment()).commit();

    }

    @Override
    public void logoutPerformed() {

        Log.d("logout","Invoke logout method");
        prefConfig.writeLoginStatus(false);
        prefConfig.writeName("User");
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoginFragment()).commit();
    }
}
