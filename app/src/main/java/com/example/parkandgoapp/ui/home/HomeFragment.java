package com.example.parkandgoapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.example.parkandgoapp.R;
import com.example.parkandgoapp.SignInAct;
import com.example.parkandgoapp.SignUpAct;
import com.example.parkandgoapp.model.User;
import com.example.parkandgoapp.viewmodel.UserViewModel;

import java.util.List;

import static android.app.Activity.RESULT_OK;

/** Created by Nisarg */

public class HomeFragment extends Fragment implements View.OnClickListener   {

    Button signin;
    Button signup;

    public static final int SIGN_UP_REQUEST_CODE = 1;

    UserViewModel userViewModel;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);


        signin = root.findViewById(R.id.btnSignIn);
        signin.setOnClickListener(this);

        signup = root.findViewById(R.id.btnSignUp);
        signup.setOnClickListener(this);

        userViewModel = new UserViewModel(getActivity().getApplication());

        userViewModel.getAllUsers().observe(HomeFragment.this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                //task when the data changes
                for (User user : users){
                    Log.e("HomeFragment", user.toString());
                }
            }
        });

        return root;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSignIn:
                this.SignIn();
                break;
            case R.id.btnSignUp:
                this.SignUp();
                break;
        }
    }

     void SignIn(){
        Intent newpage2 = new Intent(getActivity(), SignInAct.class);
        startActivity(newpage2);

    }
     void SignUp(){
         Intent newpage1 = new Intent(getActivity(),SignUpAct.class);
         startActivityForResult(newpage1,SIGN_UP_REQUEST_CODE);
     }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SIGN_UP_REQUEST_CODE){
            if(resultCode == RESULT_OK){

                User newUser = (User) data.getSerializableExtra("com.example.parkandgoapp.ui.home.REPLY");
                Log.e("HOME_FRAGMENT_ACTIVITY", newUser.toString());

                //insert new user account detail into database
                userViewModel.insert(newUser);
            }
        }
    }
}