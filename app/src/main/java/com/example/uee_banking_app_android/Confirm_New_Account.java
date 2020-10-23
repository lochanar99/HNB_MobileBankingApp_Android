package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class Confirm_New_Account extends AppCompatActivity {

    public TextView name;
    public TextView owner;
    public TextView branch;
    public TextView currency;
    public TextView interest;
    public TextView type;
    public TextView CLimit;
    public TextView dLimit;
    public TextView cInterest;
    public TextView dInterest;

    private String[] pageOneData;
    private String[]  pageTwoData;
    Dialog myDialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm__new__account);
        myDialog = new Dialog(this);

        Bundle bundle = getIntent().getExtras();
        pageOneData = bundle.getStringArray("pageOneData");
        pageTwoData = bundle.getStringArray("pageTwoData");

        name = findViewById(R.id.header1);
        owner = findViewById(R.id.text_owner);
        branch = findViewById(R.id.text_branch);
        currency = findViewById(R.id.text_currency);
        interest = findViewById(R.id.text_interest);
        type = findViewById(R.id.text_account_type);
        CLimit = findViewById(R.id.text_credit_limit);
        dLimit = findViewById(R.id.text_debit_limit);
        cInterest = findViewById(R.id.text_credit_interest);
        dInterest = findViewById(R.id.text_debit_interest);

        init();


    }


    private void init(){
        name.setText("Hey " +pageTwoData[0]);
        owner.setText(pageOneData[1]);
        branch.setText(pageOneData[2]);
        currency.setText(getCurrencyByIndex(Integer.parseInt(pageTwoData[2])));
        interest.setText(pageTwoData[5]);
        type.setText(getTypeByIndex(Integer.parseInt(pageTwoData[1])));
        CLimit.setText(pageTwoData[3]);
        dLimit.setText(pageTwoData[4]);
        cInterest.setText(pageTwoData[7]);
        dInterest.setText(pageTwoData[6]);
    }



    public void openPage1(View view){
        Intent intent = new Intent(this, CreateAccount.class);
        intent.putExtra("pageOneData",pageOneData);
        intent.putExtra("pageTwoData", pageTwoData);
        startActivity(intent);
    }
    public void openPage2(View view){
        Intent intent = new Intent(this, Create_Account_page2.class);
        intent.putExtra("pageOneData",pageOneData);
        intent.putExtra("pageTwoData", pageTwoData);
        startActivity(intent);
    }

    public void confirm(View view){
        Button closeBttn ;
        Button yesBttn;

        myDialog.setContentView(R.layout.addaccountfinalconfirmation);
        closeBttn = (Button) myDialog.findViewById(R.id.msg_close_bttn);
        yesBttn = (Button) myDialog.findViewById(R.id.msg_yes_bttn);

        closeBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });

        yesBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextPopUp();
            }
        });
        myDialog.show();

    }
    public void nextPopUp() {

        try {
            Handler handler = new Handler();
            myDialog.setContentView(R.layout.accountreqsent);
            myDialog.show();
            final Intent intent = new Intent(this, Select_Account.class);
            handler.postDelayed(new Runnable() {
                public void run() {

                    startActivity(intent);

                }
            }, 8000);


        } catch (Exception e) {

        }
    }
    public void cancel(View view){

  /*      AlertDialog.Builder builder = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
        builder.setTitle("Confromation Message");
        builder.setMessage("are you sure you want to cancel\n all entered information will be lost");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                back();
            }
        });
        builder.setNegativeButton("Return", null);
        builder.show();*/

        //new

        Button closeBttn ;
        Button yesBttn;

        myDialog.setContentView(R.layout.accountconfirm);
        closeBttn = (Button) myDialog.findViewById(R.id.msg_close_bttn);
        yesBttn = (Button) myDialog.findViewById(R.id.msg_yes_bttn);

        closeBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });

        yesBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });
        myDialog.show();
    }

    private String getTypeByIndex(int index){
        switch(index){
            case 0: return"Personal";
            case 1: return" Savings";
            case 2: return" Fixed Deposit";
            case 3: return" Money Marketing";
            case 4: return"Retirement Accounts";

        }
             return "Personal";
    }



    private String getCurrencyByIndex(int index){
        switch(index){
            case 0: return"LRK";
            case 1: return"USD";
            case 2: return"EUR";
            case 3: return"JPY";
            case 4: return"GBP";
            case 5: return"AUD";
            case 6: return"CAD";
            case 7: return"CNH";
            case 8: return"NZD";
        }
        return "LRK";
    }


    private void back() {
        Intent intent = new Intent(this, Select_Account.class);
        startActivity(intent);
    }


    private void next(){
        Intent intent = new Intent(this, Select_Account.class);
        startActivity(intent);
    }
}








