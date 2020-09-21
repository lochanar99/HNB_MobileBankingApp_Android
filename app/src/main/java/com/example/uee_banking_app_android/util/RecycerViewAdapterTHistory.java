package com.example.uee_banking_app_android.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.uee_banking_app_android.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class  RecycerViewAdapterTHistory extends RecyclerView.Adapter<RecycerViewAdapterTHistory.ViewHolder>{

    Context context;

    ArrayList<String> type = new ArrayList<>();
    ArrayList<String>  payment = new ArrayList<>();
    ArrayList<String>  amount = new ArrayList<>();
    ArrayList<String>  balance = new ArrayList<>();
    ArrayList<String>  date = new ArrayList<>();

    public RecycerViewAdapterTHistory(Context context, ArrayList<String> type, ArrayList<String> payment, ArrayList<String> amount, ArrayList<String> balance, ArrayList<String> date) {
        this.context = context;
        this.type = type;
        this.payment = payment;
        this.amount = amount;
        this.balance = balance;
        this.date = date;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_history_cards,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        switch (type.get(position)) {
            case "ATM":
                holder.tag.setBackgroundResource(R.drawable.atm_tag);
                break;
            case "Credit":
                holder.tag.setBackgroundResource(R.drawable.credit_tag);
                break;
            case "Debit":
                holder.tag.setBackgroundResource(R.drawable.debit_tag);
                break;
            case "Interest":
                holder.tag.setBackgroundResource(R.drawable.interest_tag);
                break;
            case "Payment":
                holder.tag.setBackgroundResource(R.drawable.payment_tag);
                break;
            case "Transfer":
                holder.tag.setBackgroundResource(R.drawable.transfer_tag);
                break;
        }

        holder.type.setText(type.get(position));
        holder.payment.setText(payment.get(position));
        holder.amount.setText(amount.get(position));
        holder.balance.setText(balance.get(position));
        holder.date.setText(date.get(position));

    }

    @Override
    public int getItemCount() {
        return type.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        RelativeLayout parent;
        ImageView tag;
        TextView type;
        TextView payment;
        TextView amount;
        TextView balance;
        TextView date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent_layout);
            tag = itemView.findViewById(R.id.tag);
            type = itemView.findViewById(R.id.text_type);
            payment = itemView.findViewById(R.id.label_amount);
            amount = itemView.findViewById(R.id.text_amount);
            balance = itemView.findViewById(R.id.text_balance);
            date = itemView.findViewById(R.id.text_date);
        }
    }
}




