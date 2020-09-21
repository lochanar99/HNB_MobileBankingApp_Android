package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.uee_banking_app_android.util.RecycerViewAdapterTHistory;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransactionHistory extends AppCompatActivity {


    ArrayList<String> type ;
    ArrayList<String>  payment;
    ArrayList<String>  amount ;
    ArrayList<String>  balance;
    ArrayList<String>  date;
    ArrayList<Number>  positions;
    EditText search;
    Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);
        search = findViewById(R.id.text_search);
        searchButton = findViewById(R.id.search_button);

        init();
        initValues();
        initRecyclerView();

        search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (event != null && ((event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    String key = search.getText().toString().trim();
                    filterRecyclerView(key);
                    InputMethodManager imm = (InputMethodManager)v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                }
                return false;
            }
        });
    }

    private void init(){
        type = new ArrayList<>();
        payment = new ArrayList<>();
        amount = new ArrayList<>();
        balance = new ArrayList<>();
        date = new ArrayList<>();
        positions = new ArrayList<>();
    }




    private void setFilterPosition(String key){
        ArrayList positions = new ArrayList<Number>();
        key = key.trim();
        for(int i = 0; i < type.size(); i++){
            if(type.get(i).matches("(?i:.*"+ key +"*)") ||
            payment.get(i).matches("(?i:.*"+ key +"*)") ||
            balance.get(i).equals(key) ||
            amount.get(i).equals(key) ){
                positions.add(i);
            }
        }
        this.positions = positions;
    }

    private ArrayList alterArray(ArrayList arr){

        ArrayList arrayList = new ArrayList();
        for(int i = 0; i < arr.size(); i++){
            if(positions.contains(i)){
                arrayList.add(arr.get(i));
            }
        }

        return arrayList;
    }

    public void openTrans(View view){
        String key = search.getText().toString().trim();
        filterRecyclerView(key);
    }

    private void initValues(){
        //
        type.add("ATM");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("ATM");
        payment.add("Deposited");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Credit");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Transfer");
        payment.add("Deposited");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("ATM");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Debit");
        payment.add("Deposited");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("ATM");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Payment");
        payment.add("Deposited");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("ATM");
        payment.add("Deposited");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Transfer");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("ATM");
        payment.add("Deposited");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Credit");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Transfer");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Credit");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Credit");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Payment");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("ATM");
        payment.add("Deposited");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Transfer");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Payment");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Debit");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Payment");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("ATM");
        payment.add("Deposited");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Debit");
        payment.add("Deposited");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("ATM");
        payment.add("Deposited");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Credit");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Transfer");
        payment.add("Deposited");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("ATM");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Debit");
        payment.add("Deposited");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("ATM");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Payment");
        payment.add("Deposited");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("ATM");
        payment.add("Deposited");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Transfer");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("ATM");
        payment.add("Deposited");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Credit");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Transfer");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Credit");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Credit");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Payment");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("ATM");
        payment.add("Deposited");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Transfer");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("ATM");
        payment.add("Deposited");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Credit");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Transfer");
        payment.add("Deposited");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("ATM");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Debit");
        payment.add("Deposited");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("ATM");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Payment");
        payment.add("Deposited");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("ATM");
        payment.add("Deposited");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Transfer");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("ATM");
        payment.add("Deposited");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Credit");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Transfer");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Credit");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Credit");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Payment");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("ATM");
        payment.add("Deposited");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Transfer");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("ATM");
        payment.add("Deposited");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Credit");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Transfer");
        payment.add("Deposited");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("ATM");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Debit");
        payment.add("Deposited");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("ATM");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Payment");
        payment.add("Deposited");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("ATM");
        payment.add("Deposited");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Transfer");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("ATM");
        payment.add("Deposited");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Credit");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Transfer");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Credit");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Credit");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Payment");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("ATM");
        payment.add("Deposited");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");
        type.add("Transfer");
        payment.add("Withdrawal");
        amount.add("20,000");
        balance.add("234,678");
        date.add("12/12/19");








    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecycerViewAdapterTHistory adapter = new RecycerViewAdapterTHistory(this, type,
                payment, amount, balance, date);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void filterRecyclerView(String key) {
        setFilterPosition(key);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecycerViewAdapterTHistory adapter = new RecycerViewAdapterTHistory(this, alterArray(type),
                alterArray(payment), alterArray(amount), alterArray(balance), alterArray(date));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void menu(View view){
        Intent intent = new Intent(this, menu_screen.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, Select_Account.class);
        startActivity(intent);
    }

    public void back(View view){
        Intent intent = new Intent(this, AccountDetails.class);
        intent.putExtra("Name",getIntent().getExtras().getString("Name"));
        startActivity(intent);
    }




}
