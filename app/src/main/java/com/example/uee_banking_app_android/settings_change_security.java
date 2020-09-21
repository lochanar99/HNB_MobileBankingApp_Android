package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class settings_change_security extends AppCompatActivity {

    private Switch email;
    private Switch sms;

    Dialog myDialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_change_security);

        email = findViewById(R.id.emailSwitch);
        sms = findViewById(R.id.smsSwitch);

        myDialog = new Dialog(this);

        SharedPreferences prefs = getSharedPreferences("Settings", MODE_PRIVATE);
        if (prefs.getInt("emailVerification",0) == 1)
        {
            email.setChecked(true);
        }
        if (prefs.getInt("smsVerification",0) == 1)
        {
            sms.setChecked(true);
        }

    }

    public void mainMenu(View view){
        Intent intent = new Intent(this,menu_screen.class);
        startActivity(intent);
    }


    public void update(View virw)
    {
        Button closeBttn ;
        Button yesBttn;

        myDialog.setContentView(R.layout.activity_popup_message_request_book);
        closeBttn = (Button) myDialog.findViewById(R.id.msg_close_bttn);
        yesBttn = (Button) myDialog.findViewById(R.id.msg_yes_bttn);

        closeBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });

        yesBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
                if(email.isChecked())
                {
                    editor.putInt("emailVerification", 1);
                }
                else
                {
                    editor.putInt("emailVerification", 0);
                }

                if(sms.isChecked())
                {
                    editor.putInt("smsVerification", 1);
                }
                else
                {
                    editor.putInt("smsVerification", 0);
                }
                editor.apply();
                myDialog.dismiss();
                Toast.makeText(getApplicationContext(), "Settings Updated", Toast.LENGTH_LONG).show();
            }
        });
        myDialog.show();

    }


    public void onEmailVerify(View V)
    {
        sms.setChecked(false);
    }

    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Back button is disabled in this Screen", Toast.LENGTH_LONG).show();
    }

    public void onSmsVerify(View V)
    {
        email.setChecked(false);
    }


}
