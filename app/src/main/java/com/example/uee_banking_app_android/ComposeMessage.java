package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.SubMenu;
import android.view.View;
import android.widget.Toast;

public class ComposeMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose_message);
    }

    public void submit(View view)
    {
        Intent intent = new Intent(this, MessageSent.class);
        startActivity(intent);
        this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out); //fade animations
    }



    /**
     * Disabling back button
     */
    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Back button is disabled in this Screen", Toast.LENGTH_LONG).show();
    }
}
