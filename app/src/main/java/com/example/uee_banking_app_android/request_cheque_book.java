package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class request_cheque_book extends AppCompatActivity {
    Dialog myDialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_cheque_book);

        myDialog = new Dialog(this);
    }

    public void mainMenu(View view){
        Intent intent = new Intent(this,dashboard.class);
        startActivity(intent);
    }

    public void refreshPage(View view){
        Intent intent = new Intent(this,request_cheque_book.class);
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
                nextPopUp();
                //Toast.makeText(getApplicationContext(), "Successfully sent, you will receive an email shortly", Toast.LENGTH_LONG).show();
            }
        });
        myDialog.show();
    }

    public void nextPopUp()  {

        try {
            myDialog.setContentView(R.layout.messagesent_check_book);
            myDialog.show();
            wait(1000);
            refreshPage(null);
        }catch (Exception e){

        }


    }



}
