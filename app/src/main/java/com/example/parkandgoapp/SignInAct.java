package com.example.parkandgoapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.parkandgoapp.model.User;
import com.example.parkandgoapp.viewmodel.UserViewModel;

import java.util.List;

public class SignInAct extends AppCompatActivity implements View.OnClickListener {

    EditText username;
    EditText password;
    Button signin;

    public static final int SIGN_UP_REQUEST_CODE = 1;

    UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        signin= findViewById(R.id.btnSignIn);
        signin.setOnClickListener(this);

        userViewModel = new UserViewModel(getApplication());
        userViewModel.getAllUsers().observe(SignInAct.this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                //task when the data changes
                for (User user : users){
                    Log.e("SignInActivity", user.toString());
                }
            }
        });
        username = findViewById(R.id.edtusername);
        password = findViewById(R.id.edtpassword);
    }

    @Override
    public void onClick(View view) {



    }

    void SignIn(){

    }
    void signup(){
        Intent menuIntent = new Intent(SignInAct.this,MenuActivity.class);
        startActivityForResult(menuIntent,SIGN_UP_REQUEST_CODE);
    }

    void openMenuActivity(){
        Intent menuIntent = new Intent(SignInAct.this,MenuActivity.class);
        startActivity(menuIntent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == SIGN_UP_REQUEST_CODE){
            if(requestCode == RESULT_OK){
                User newUser = (User) data.getSerializableExtra("com.example.parkandgoapp.REPLY");
                Log.e("SIGN_IN_ACT",newUser.toString());
                userViewModel.insert(newUser);
            }
        }
    }
}
