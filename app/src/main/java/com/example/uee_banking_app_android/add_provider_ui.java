package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class add_provider_ui extends AppCompatActivity {


    Button button;
    Dialog myDialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_provider_ui);

        button = (Button) findViewById(R.id.button3);

        myDialog = new Dialog(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    addCardPop();
            }
        });
    }

    public void addCardPop(){
        Button closeBttn ;
        Button yesBttn;
        TextView textMsg ;

        myDialog.setContentView(R.layout.activity_popup_message_request_book);
        closeBttn = (Button) myDialog.findViewById(R.id.msg_close_bttn);
        yesBttn = (Button) myDialog.findViewById(R.id.msg_yes_bttn);
        textMsg = (TextView) myDialog.findViewById(R.id.textView19);

        textMsg.setText("Please Confirm the task");

        closeBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });

        yesBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();

                nextPopUp();

            }
        });
        myDialog.show();
    }

    public void nextPopUp()  {

        try {
            myDialog.setContentView(R.layout.activity_add_provider_popup);
            myDialog.show();
        }catch (Exception e){

        }


    }



//    public void addprovider(View view){
//        Intent intent = new Intent(this, BillPaymentsMain.class);
//        startActivity(intent);
//    }
}
