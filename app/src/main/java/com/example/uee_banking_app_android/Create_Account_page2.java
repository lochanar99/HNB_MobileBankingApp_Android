package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Create_Account_page2 extends AppCompatActivity {

    public EditText name;
    public Spinner type;
    public EditText cLimit;
    public EditText dLimit;
    public Spinner currency;

    private String[] pageOneData;
    private String[] pageTwoData;

    private String name_unavailable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__account_page2);
        name_unavailable = null;
        name = findViewById(R.id.text_account_name);
        type = findViewById(R.id.text_account_type);
        cLimit = findViewById(R.id.text_credit_limit);
        dLimit = findViewById(R.id.text_debit_limit);
        currency = findViewById(R.id.text_currency);

        cLimit.setText("100,000");
        dLimit.setText("100,000");

        type.setSelection(0);
        currency.setSelection(0);
        Intent intent = getIntent();
        if (intent.hasExtra("pageTwoData")) {
            pageTwoData = intent.getStringArrayExtra("pageTwoData");
            name.setText(pageTwoData[0]);
            type.setSelection(Integer.parseInt(pageTwoData[1]));
            cLimit.setText(pageTwoData[4]);
            dLimit.setText(pageTwoData[3]);
            currency.setSelection(Integer.parseInt(pageTwoData[2]));
        }

        pageTwoData = new String[8];
        pageOneData = intent.getStringArrayExtra("pageOneData");
        dLimit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (event != null && ((event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    next();
                }
                return false;
            }
        });


    }


    public void openNext(View view) {
        if(name_unavailable != null)
            name.setText(name_unavailable);
        next();
    }

    private void next() {
        if (vaildate()) {
            pageTwoData[0] = name.getText().toString().trim();
            pageTwoData[1] = new Integer(type.getSelectedItemPosition()).toString();
            pageTwoData[2] = new Integer(currency.getSelectedItemPosition()).toString();
            pageTwoData[3] = dLimit.getText().toString().trim();
            pageTwoData[4] = cLimit.getText().toString().trim();
            pageTwoData[5] = getInterest(Integer.parseInt(pageTwoData[1]));
            pageTwoData[6] = getDebitInterest();
            pageTwoData[7] = getCreditInterest(Double.parseDouble(cLimit.getText().toString().replace(",", "")));

            Intent intent = new Intent(this, Confirm_New_Account.class);
            intent.putExtra("pageOneData", pageOneData);
            intent.putExtra("pageTwoData", pageTwoData);
            startActivity(intent);
        }
    }

    public void back(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
        builder.setTitle("Confromation Message");
        builder.setMessage("are you sure you want to go back?\n all information will be lost");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                back();
            }
        });
        builder.setNegativeButton("Return", null);
        builder.show();
    }

    public String getCreditInterest(double creditLimit) {
        if (creditLimit < 10000)
            return "34.0%";
        else if (creditLimit < 50000)
            return "32.5%";
        else if (creditLimit < 100000)
            return "30.9%";
        else if (creditLimit < 250000)
            return "30.0%";
        else if (creditLimit < 750000)
            return "29.3%";
        else if (creditLimit < 1000000)
            return "28.5%";
        else if (creditLimit < 1500000)
            return "29.4%";
        else if (creditLimit < 5000000)
            return "25.9%";

        return "34.0%";
    }

    public String getInterest(int index) {
        switch (index) {
            case 0:
                return "4.9%";
            case 1:
                return "10.0%";
            case 2:
                return "6.7%";
            case 3:
                return "0%";
            case 4:
                return "13.5%";
        }

        return "0.0%";
    }


    public String getDebitInterest() {
        return "0.9%";
    }


    private boolean vaildate() {

        if (name.getText().toString() == null || name.getText().toString().isEmpty()) {
            name.setHint("Cant be empty.....");
            name.setHintTextColor(getResources().getColor(R.color.error_text_red));
            return false;
        }
        if (name.getText().toString().toLowerCase().trim().equals("my savings") ||
                name.getText().toString().toLowerCase().trim().equals("my account")) {
            name_unavailable = name.getText().toString();
            name.setText("");
            name.setHint("Name unavailable" );
            name.setHintTextColor(getResources().getColor(R.color.error_text_red));
            return false;
        }


        if (dLimit.getText().toString() == null || dLimit.getText().toString().isEmpty()) {
            name.setText("0.00");
        }
        if (cLimit.getText().toString() == null || cLimit.getText().toString().isEmpty()) {
            name.setText("0.00");
        }
        return true;
    }


    public void clickName(View view){
        if(name_unavailable != null)
            name.setText(name_unavailable);
    }

    private void back(){
        Intent intent = new Intent(this, Select_Account.class);
        startActivity(intent);
    }
}
