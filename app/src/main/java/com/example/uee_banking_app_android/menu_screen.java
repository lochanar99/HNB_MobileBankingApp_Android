package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class menu_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);
    }

    public void closeMenu(View view) {
//        Intent intent = new Intent(this,sms_verification.class);
//        startActivity(intent);
        finish();
    }

    public void logoutBttn(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void creditCardBttn(View view) {
        Intent intent = new Intent(this,credit_cards.class);
        startActivity(intent);
    }

    public void mailsBttn(View view)
    {
        Intent intent = new Intent(this,ViewMessages.class);
        startActivity(intent);

    }

    public void transactionsButton(View view){
        Intent intent = new Intent(this, menu_transaction_submenu.class);
        startActivity(intent);
    }

    public void settingsBttn(View view){
        Intent intent = new Intent(this,menu_settings_screen.class);
        startActivity(intent);
    }

    public void otherServices(View view){
        Intent intent = new Intent(this,request_cheque_book.class);
        startActivity(intent);
    }

    public void openNext(View view){
        Intent intent = new Intent(this, Select_Account.class);
        startActivity(intent);
    }


    /**
     * Disabling back button
     */
    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Back button is disabled in this Screen", Toast.LENGTH_LONG).show();
    }

}
