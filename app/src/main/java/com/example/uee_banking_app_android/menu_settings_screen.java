package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class menu_settings_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_settings_screen);
    }

    public void logoutBttn(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void backBttn(View view){
        Intent intent = new Intent(this,menu_screen.class);
        startActivity(intent);
    }

    public void changePwBttn(View view){
        Intent intent = new Intent(this,settings_change_password.class);
        startActivity(intent);
    }

    public void changeSecurityBttn(View view){
        Intent intent = new Intent(this,settings_change_security.class);
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
