package com.example.uee_banking_app_android.util;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.uee_banking_app_android.AccountDetails;
import com.example.uee_banking_app_android.R;


import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapterAccountCard extends RecyclerView.Adapter<RecyclerViewAdapterAccountCard.ViewHolder>{

    Context context;
    
    ArrayList<String> accountName = new ArrayList<>();
    ArrayList<String>  ownerName = new ArrayList<>();
    ArrayList<String>  balance = new ArrayList<>();
    ArrayList<String>  avaBalance = new ArrayList<>();
    ArrayList<String>  accRef = new ArrayList<>();

    public RecyclerViewAdapterAccountCard(Context context, ArrayList<String> accountName,
                                          ArrayList<String> ownerName,
                                          ArrayList<String> balance,
                                          ArrayList<String> avaBalance,
                                           ArrayList<String> accRef) {
        this.context = context;
        this.accountName = accountName;
        this.ownerName = ownerName;
        this.balance = balance;
        this.avaBalance = avaBalance;
        this.accRef = accRef;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.select_account_cards,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.accountName.setText(accountName.get(position));
        holder.ownerName.setText(ownerName.get(position));
        holder.balance.setText(balance.get(position));
        holder.avaBalance.setText(avaBalance.get(position));
        holder.accRef.setText(accRef.get(position));
        final int num = position;
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AccountDetails.class);
                intent.putExtra("Name",accountName.get(num));
                context.startActivity(intent);
           }
        });
    }



    @Override
    public int getItemCount() {
        return accountName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        RelativeLayout parent;
        TextView accountName;
        TextView ownerName;
        TextView balance;
        TextView avaBalance;
        TextView accRef;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent_layout);
            accountName = itemView.findViewById(R.id.account_name);
            ownerName = itemView.findViewById(R.id.owner_name);
            balance = itemView.findViewById(R.id.balance);
            avaBalance = itemView.findViewById(R.id.available_balance);
            accRef = itemView.findViewById(R.id.account_ref);
        }
    }
}
