package com.example.uee_banking_app_android;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CreditCardsPageAdapter extends FragmentPagerAdapter {
    private int num ;

    CreditCardsPageAdapter(FragmentManager fm, int numTabs){
        super(fm);
        this.num = numTabs ;
    }

    @Override
    public Fragment getItem(int position){
        switch(position){
            case 0:
                return new credit_cards_my_cards();
            case 1:
                return new credit_cards_add_card();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return num ;
    }
}
