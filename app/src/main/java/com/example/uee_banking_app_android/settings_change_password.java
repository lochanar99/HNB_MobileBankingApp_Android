package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class settings_change_password extends AppCompatActivity {
    Dialog myDialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_change_password);

        myDialog = new Dialog(this);
    }

    public void mainMenu(View view){
        Intent intent = new Intent(this,menu_screen.class);
        startActivity(intent);
    }

    public void refreshPage(View view){
        Intent intent = new Intent(this,settings_change_password.class);
        startActivity(intent);
    }

    public void showPopupMsg(View view){
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
                refreshPage(null);
                Toast.makeText(getApplicationContext(), "Successfully updated", Toast.LENGTH_LONG).show();
            }
        });
        myDialog.show();
    }

    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Back button is disabled in this Screen", Toast.LENGTH_LONG).show();
    }

}
