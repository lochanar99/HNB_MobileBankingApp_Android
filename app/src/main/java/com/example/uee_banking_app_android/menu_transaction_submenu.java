package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class menu_transaction_submenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_transaction_submenu);
    }

    public void logoutBttn(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void backBttn(View view){
        Intent intent = new Intent(this,menu_screen.class);
        startActivity(intent);
    }

    public void bktransferButton(View view){
        Intent intent = new Intent(this, bank_transfer.class);
        startActivity(intent);
    }

    public void billpButton(View view){
        Intent intent = new Intent(this, BillPaymentsMain.class);
        startActivity(intent);
    }
}
