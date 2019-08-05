package com.example.login.register;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.login.R;
import com.example.login.apiclient.User;
import com.example.login.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationFragment extends Fragment {

    private EditText Userid, FName, LName, Email, Contact, CAddress, Designation, Role, Password;
    private Button BnRegister;

    public RegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registration, container, false);
        //Name = view.findViewById(R.id.txt_name);
        //UserName = view.findViewById(R.id.txt_user_name);
        Userid = view.findViewById(R.id.txt_userid);
        FName = view.findViewById(R.id.txt_fname);
        LName = view.findViewById(R.id.txt_lname);
        Email = view.findViewById(R.id.txt_email);
        Contact = view.findViewById(R.id.txt_number);
        CAddress = view.findViewById(R.id.txt_caddress);
        Designation = view.findViewById(R.id.txt_designation);
        Role = view.findViewById(R.id.txt_role);
        Password = view.findViewById(R.id.txt_password);
        BnRegister = view.findViewById(R.id.bn_register);

        BnRegister.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                performRegisteration();
            }
        });

        return view;
    }

    public void performRegisteration() {

        String userid = Userid.getText().toString();
        String firstname = FName.getText().toString();
        String lastname = LName.getText().toString();
        String email = Email.getText().toString();
        String contact = Contact.getText().toString();
        String company = CAddress.getText().toString();
        String designation = Designation.getText().toString();
        String role = Role.getText().toString();
        String password = Password.getText().toString();

        Call<User> call = MainActivity.apiInterface.performRegistration(userid, firstname, lastname, email, contact, company, designation, role, password);
        Log.d("register","Invoke Perform Registration");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (response.body().getResponse().equals("ok"))
                {
                    Log.d("register","Success");
                    MainActivity.prefConfig.displayToast("Registration Success...");
                }
                else if(response.body().getResponse().equals("exist"))
                {
                    Log.d("register","exist");
                    MainActivity.prefConfig.displayToast("User already exist...");
                }
                else if(response.body().getResponse().equals("error"))
                {

                    Log.d("register","error");
                    MainActivity.prefConfig.displayToast("Something went wrong...");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
        Userid.setText("");
        FName.setText("");
        LName.setText("");
        Email.setText("");
        Contact.setText("");
        CAddress.setText("");
        Designation.setText("");
        Role.setText("");
        Password.setText("");

    }

}
