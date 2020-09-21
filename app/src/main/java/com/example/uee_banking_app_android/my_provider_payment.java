package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class my_provider_payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_provider_payment);
    }

    public void myProviderPaymentButton(View view){
        Toast.makeText(getApplicationContext(), "Payment Made Successfully!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, BillPaymentsMain.class);
        startActivity(intent);
    }
}
