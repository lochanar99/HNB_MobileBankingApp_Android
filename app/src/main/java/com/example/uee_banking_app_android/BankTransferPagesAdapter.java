package com.example.uee_banking_app_android;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class BankTransferPagesAdapter extends FragmentPagerAdapter {
    private int num ;

    BankTransferPagesAdapter(FragmentManager fm, int numTabs){
        super(fm);
        this.num = numTabs ;
    }

    @Override
    public Fragment getItem(int position){
        switch(position){
            case 0:
                return new bank_transfer_own_acc();
            case 1:
                return new bank_transfer_hnb();
            case 2:
                return new bank_transfer_other_banks();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return num ;
    }
}