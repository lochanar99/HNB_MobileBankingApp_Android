package com.example.uee_banking_app_android;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class credit_cards_add_card extends Fragment {

    EditText creditCardNo,name,date,cvv;
    Button submit;


    public credit_cards_add_card() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_credit_cards_add_card, container, false);

        // access to elements

        creditCardNo = (EditText) v.findViewById(R.id.creditCardNo);
        name = (EditText) v.findViewById(R.id.emailSwitch);
        date = (EditText) v.findViewById(R.id.expDate);
        cvv = (EditText) v.findViewById(R.id.forgotPWusername);
        submit = (Button) v.findViewById(R.id.button5);


        creditCardNo.addTextChangedListener(creditTextWatcher);
        name.addTextChangedListener(creditTextWatcher);
        date.addTextChangedListener(creditTextWatcher);
        cvv.addTextChangedListener(creditTextWatcher);
        //creditCardNo.setText(""+"dd");

        return v;
    }

    private TextWatcher creditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            String No = creditCardNo.getText().toString().trim();
            String Name = name.getText().toString().trim();
            String Cvv = cvv.getText().toString().trim();
            String ex = date.getText().toString().trim();

            submit.setEnabled(!No.isEmpty() &&  !Name.isEmpty() && !Cvv.isEmpty() && !ex.isEmpty());


        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public void addCardPopup(View view){
        //Method is already implemented in parent class
    }

}
