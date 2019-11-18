package com.example.parkandgoapp.ui.Settings;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.parkandgoapp.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment implements View.OnClickListener {


    Button btnUpdate;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_settings, container, false);
        btnUpdate=root.findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(this);
        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onClick(View view) {
        LayoutInflater inflater=getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.fragment_settings,null);
        AlertDialog alertDialog=new AlertDialog.Builder(getActivity())
                .setTitle("Edit User Name")
                .setMessage("Please edit User password")
                .setView(dialogView)
                .setPositiveButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       // EditText edt_fruit_name=getActivity().findViewById(R.id.edtTitle);
                       // EditText edt_fruit_details=getActivity().findViewById(R.id.edtDetails);
                       // String newName=edt_fruit_name.getText().toString();
                        //String newDetails=edt_fruit_details.getText().toString();
                        //fruitViewModel.update(new Fruit(newName,newDetails,R.drawable.fruits));
                        //fruitViewModel.update();
                       // TextView tvTitle=findViewById(R.id.tvTitle);
                        //TextView tvDetail=findViewById(R.id.tvDetail);
                        //fruitViewModel.deleteAll();
                        //Fruit fruit = fruitArraylist.get(position);
                        //tvTitle.setText(newName);
                        //tvDetail.setText(newDetails);
                        //fruit.setFruitName(newName);
                        //fruit.setFruitDetails(newDetails);
                        //fruitViewModel.update(fruit);
                        // addFruit();
                        //fruitAdapter.notifyDataSetChanged();
                    }
                })
                .setNegativeButton("Cancel", null)
                .create();
        alertDialog.show();
    }
}