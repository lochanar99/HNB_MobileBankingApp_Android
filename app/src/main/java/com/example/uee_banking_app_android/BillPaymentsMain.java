package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class BillPaymentsMain extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager ;
    BillPaymentsPagesAdapter pageAdapter ;
    TabItem myTab ;
    TabItem addTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_payments_main);

        tabLayout = findViewById(R.id.tabLayoutbill) ;
        myTab = findViewById(R.id.myPaymentsTab);
        addTab = findViewById(R.id.addProviderTab);
        viewPager = findViewById(R.id.billpViewPager);

        pageAdapter = new BillPaymentsPagesAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    public void addProviderButton(View view){
        Intent intent = new Intent(this, add_provider_ui.class);
        startActivity(intent);
    }

    public void myProviderButton(View view){
        Intent intent = new Intent(this, my_provider_payment.class);
        startActivity(intent);
    }


}
