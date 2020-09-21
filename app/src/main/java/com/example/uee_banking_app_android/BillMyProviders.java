package com.example.uee_banking_app_android;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class BillMyProviders extends Fragment {

    Context mContext;

    public BillMyProviders() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bill_my_providers, container, false);
    }

    public void myProviderButton(View view){
        Intent intent = new Intent(mContext, my_provider_payment.class);
        startActivity(intent);
    }

}
