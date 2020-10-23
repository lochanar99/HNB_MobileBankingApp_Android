package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class credit_card_save_popup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_card_save_popup);
    }

    public void backToDashboard(View view){
        Intent intent = new Intent(this, dashboard.class);
        startActivity(intent);
    }
}
