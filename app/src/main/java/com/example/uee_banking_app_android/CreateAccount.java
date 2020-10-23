package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;


public class CreateAccount extends AppCompatActivity {

    public EditText nic;
    public EditText owner;
    public EditText branch;



    private String[] pageOneData;
    private String[] pageTwoData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        owner = findViewById(R.id.text_name);
        nic = findViewById(R.id.text_nic);
        branch = findViewById(R.id.text_branch);

        pageOneData = new String[3];
        Intent intent = getIntent();
        if (intent.hasExtra("pageTwoData"))
            pageTwoData = intent.getStringArrayExtra("pageTwoData");
        if (intent.hasExtra("pageOneData")){
            pageOneData = intent.getStringArrayExtra("pageOneData");
            owner.setText(pageOneData[0]);
            nic.setText(pageOneData[1]);
            branch.setText(pageOneData[2]);
         }


        branch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (event != null && ((event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    next();
                }
                return false;
            }
        });
    }


    private void next(){
        if(vaildate()) {
            pageOneData[0] = owner.getText().toString().trim();
            pageOneData[1] = nic.getText().toString().trim();
            pageOneData[2] = (pageOneData[2] == null || pageOneData[2].isEmpty() ? "Koswatta" : branch.getText().toString().trim());
            Intent intent = new Intent(this, Create_Account_page2.class);
            if (pageTwoData != null)
                intent.putExtra("pageTwoData", pageTwoData);
            intent.putExtra("pageOneData", pageOneData);
            startActivity(intent);

        }
    }


    public void openNext(View view){
        next();
    }


    public void openback(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this,AlertDialog.THEME_HOLO_LIGHT);
        builder.setTitle("Confirmation Message");
        builder.setMessage("are you sure you want to go back?\n all information will be lost");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                back();
            }
        });
        builder.setNegativeButton("Return", null);
        builder.show();
    }

    private void back(){
        Intent intent = new Intent(this, Select_Account.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
        builder.setTitle("Confromation Message");
        builder.setMessage("are you sure you want to go back?\n all information will be lost");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                back();
            }
        });
        builder.setNegativeButton("Return", null);
        builder.show();
    }

    private boolean vaildate(){

        if(owner.getText().toString() == null || owner.getText().toString().isEmpty()) {
            owner.setHint("Cant be empty.....");
            owner.setHintTextColor(getResources().getColor(R.color.error_text_red));
            return false;
        }
        else if(nic.getText().toString() == null || nic.getText().toString().isEmpty()) {
            nic.setHint("Cant be empty.....");
            nic.setHintTextColor(getResources().getColor(R.color.error_text_red));
            return false;
        }
        return true;
    }
}
