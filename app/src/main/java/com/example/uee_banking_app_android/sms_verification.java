package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class sms_verification extends AppCompatActivity {

    private EditText code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_verification);

        code = findViewById(R.id.smsCode);

        if(MainActivity.autoFill)
        {
            code.setText("623492");
        }
    }

    public void submitBttn(View view) {

        if(code.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Please Enter SMS code", Toast.LENGTH_LONG).show();
        }
        else {
            Intent intent = new Intent(this, menu_screen.class);
            startActivity(intent);
        }
    }



    /**
     * Disabling back button
     */
//    @Override
//    public void onBackPressed() {
//        Toast.makeText(getApplicationContext(), "Back button is disabled in this Screen", Toast.LENGTH_LONG).show();
//    }
}
