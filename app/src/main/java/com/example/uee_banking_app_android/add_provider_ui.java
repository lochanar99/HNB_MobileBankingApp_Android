package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class add_provider_ui extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_provider_ui);
    }

    public void addProviderButton(View view){
        Toast.makeText(getApplicationContext(), "Provider Added!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, BillPaymentsMain.class);
        startActivity(intent);
    }
}
