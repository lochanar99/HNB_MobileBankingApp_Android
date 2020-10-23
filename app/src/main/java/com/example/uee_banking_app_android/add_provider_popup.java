package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class add_provider_popup extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_provider_popup);

        button = (Button) findViewById(R.id.button24);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(add_provider_popup.this, BillPaymentsMain.class);
                startActivity(intent);
            }
        });
    }

    public void addprovider(View view){
        Intent intent = new Intent(this, BillPaymentsMain.class);
        startActivity(intent);
    }
}
