package com.example.login.login;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.login.MainActivity;
import com.example.login.R;
import com.example.login.apiclient.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {


    private TextView RegText;
    private EditText UserName, UserPassword;
    private Button LoginBn;

    OnLoginFormActivityListner loginFormActivityListner;

    public interface OnLoginFormActivityListner{

        public void performRegister();
        public void performLogin(String name);
    }

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        RegText = view.findViewById(R.id.register_txt);

        Log.d("login","Invoke test method");

        UserName = view.findViewById(R.id.user_name);
        UserPassword = view.findViewById(R.id.user_pass);
        LoginBn = view.findViewById(R.id.login_bn);

        LoginBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performLogin();

            }
        });


        RegText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginFormActivityListner.performRegister();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        Activity activity = (Activity) context;
        loginFormActivityListner = (OnLoginFormActivityListner) context;
    }

    private void performLogin()
    {
        String username = UserName.getText().toString();
        String password = UserPassword.getText().toString();
        Log.d("login","Invoke Perform Login method");


        /* OkHttpClient.Builder okhttpClientBuilder= new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        okhttpClientBuilder.addInterceptor(logging);

        Retrofit.Builder retrofit = new Retrofit.Builder().baseUrl(ApiClient.BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(okhttpClientBuilder.build());

        Retrofit retro = retrofit.build();

        ApiInterface service = retro.create(ApiInterface.class);

        Call<User> call = service.performUserLogin(username,password); */

       Call<User> call = MainActivity.apiInterface.performUserLogin(username, password);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.body().getResponse().equals("ok"))
                {
                    Log.d("login","invoke on Response");
                    MainActivity.prefConfig.writeLoginStatus(true);
                    loginFormActivityListner.performLogin(response.body().getName());
                }
                else if (response.body().getResponse().equals("failed"))
                {
                    Log.d("login","Login Failed");
                    MainActivity.prefConfig.displayToast("Login Failed ... Please try again...");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

        UserName.setText("");
        UserPassword.setText("");

    }
}
