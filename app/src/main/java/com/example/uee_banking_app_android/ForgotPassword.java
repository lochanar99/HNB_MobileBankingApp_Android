package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
    }

    public void Submit(View view)
    {
        Intent intent = new Intent(this,ResetInstructions.class);
        startActivity(intent);
        this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out); //fade animations
    }


    /**
     * Disabling back button
     */
//    @Override
//    public void onBackPressed() {
//        Toast.makeText(getApplicationContext(), "Back button is disabled in this Screen", Toast.LENGTH_LONG).show();
//    }

}
