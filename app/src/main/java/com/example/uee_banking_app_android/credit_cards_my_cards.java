package com.example.uee_banking_app_android;




import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class credit_cards_my_cards extends Fragment {

    Dialog myDialog ;

    public credit_cards_my_cards() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_credit_cards_my_cards, container, false);

        myDialog = new Dialog(getActivity());

        ToggleButton b = (ToggleButton) v.findViewById(R.id.toggleButton) ;

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                removeCardPop();
            }
        });

        return v;
    }

    public void removeCardPop(){
        Button closeBttn ;
        Button yesBttn;
        TextView textMsg ;

        myDialog.setContentView(R.layout.activity_popup_message_request_book);
        closeBttn = (Button) myDialog.findViewById(R.id.msg_close_bttn);
        yesBttn = (Button) myDialog.findViewById(R.id.msg_yes_bttn);
        textMsg = (TextView) myDialog.findViewById(R.id.textView19);

        textMsg.setText("Are you sure u want to remove card?");

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

                //Toast.makeText(getContext(), "Successfully added", Toast.LENGTH_LONG).show();

                nextPopUp();


            }
        });
        myDialog.show();
    }

    public void nextPopUp()  {

        try {
            myDialog.setContentView(R.layout.activity_card_delink_popup);
            myDialog.show();
        }catch (Exception e){

        }


    }


    public void delinkCard(View view){
        //Method is already implemented in parent class
    }

}
