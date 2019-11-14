package com.example.parkandgoapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.parkandgoapp.R;
import com.example.parkandgoapp.SignUpAct;

public class HomeFragment extends Fragment implements View.OnClickListener   {

    TextView signin;
    TextView signup;
    Button txtbtn;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);


        txtbtn = root.findViewById(R.id.btnSignUp);
        txtbtn.setOnClickListener(this);

        signin = root.findViewById(R.id.txtsignin);
        signin.setOnClickListener(this);

        signup = root.findViewById(R.id.txtsignup);
        signup.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.txtsignin:
                this.SignIn();
                break;
            case R.id.btnSignUp:
                this.SignUp();
                break;
        }
    }

     void SignIn(){

    }
     void SignUp(){
         Intent newpage1 = new Intent(getActivity(),SignUpAct.class);
         startActivity(newpage1);
     }
}