package com.example.parkandgoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.parkandgoapp.model.User;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SignUpAct extends AppCompatActivity implements View.OnClickListener {


    String username;
    String password;
    String phonenumber;
    String email;
    String numberplate;


    String cardnumber;


    EditText edtusername1;
    EditText edtpassword1;
    EditText edtemail1;
    EditText edtphone1;
    EditText edtnumberplate1;

    Button btnlogin;

    EditText edtcardnumber1;
    Button btnlogin1;


    public static final String EXTRA_REPLY = "com.example.parkandgoapp";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.referWidgets();
    }

    private void referWidgets(){
        edtusername1= findViewById(R.id.edtusername);
        edtpassword1 = findViewById(R.id.edtpassword);
        edtemail1 = findViewById(R.id.edtemail);
        edtphone1 = findViewById(R.id.edtphone);

        edtnumberplate1 = findViewById(R.id.edtnumberplate);
        btnlogin = findViewById(R.id.btnSignIn);
        btnlogin.setOnClickListener(this);

        edtcardnumber1 = findViewById(R.id.edtCardNumber);
        edtnumberplate1 = findViewById(R.id.edtnumberplate);
        btnlogin1 = findViewById(R.id.btnlogin);
        btnlogin1.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnlogin:
               if(this.validateData()){
                   this.createUserAndReply();
                   openMenuActivity();

               }
               break;

        }

    }


    private void createUserAndReply(){

        username = edtusername1.getText().toString();
        password = edtpassword1.getText().toString();
        phonenumber = edtphone1.getText().toString();
        numberplate = edtnumberplate1.getText().toString();
        email = edtemail1.getText().toString();


        User newUser = new User(username,password,phonenumber,numberplate,email);

        cardnumber = edtcardnumber1.getText().toString();


        User newUser = new User(username,password,phonenumber,numberplate,email,cardnumber);

        Log.d("SignUpAct",newUser.toString());

        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY,newUser);
        setResult(RESULT_OK,replyIntent);

        //save to DB

        finish();


    }


    void openMenuActivity(){
        Intent menuIntent = new Intent(SignUpAct.this,MenuActivity.class);
        startActivity(menuIntent);
    }


    private boolean validateData(){
        boolean allvalidations = true;

        if(edtusername1.getText().toString().isEmpty()){
            edtusername1.setError("You must enter the first name");
            allvalidations = false;
        }
        if(edtpassword1.getText().toString().isEmpty()){
            edtpassword1.setError("Enter the password");
            allvalidations = false;
        }
        if(edtphone1.getText().toString().isEmpty()){
            edtphone1.setError("Enter the phone number");
            allvalidations = false;
        }
        if(edtnumberplate1.getText().toString().isEmpty()){
            edtnumberplate1.setError("Enter the number plate");
            allvalidations = false;
        }
        if(edtemail1.getText().toString().isEmpty()){
            edtemail1.setError("Email cannot be empty");
            allvalidations = false;
        }else if (!Utils.isValidEmail(edtemail1.getText().toString())){
            edtemail1.setError("Please provide valid email address");
            allvalidations = false;
        }

        return allvalidations;
    }
}
