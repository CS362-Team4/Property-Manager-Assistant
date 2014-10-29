package com.project.group4.propertymanagerassistant;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


class TabAdapter extends FragmentStatePagerAdapter {//to save state, use statepageradptapter
                                                //will call savestate when scroll two fragments away, and it will detach, which destroys
                                                //usefull when you wan to save state

//base constructor
    public TabAdapter(FragmentManager fm) {
        super(fm);
    }


    //return current fragment
    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;

        if(i==0){
            fragment = new FragmentTransactionTab();
        }
        if(i==1){
            fragment = new FragmentTenantTab();

        }
        if(i==2){
            fragment = new FragmentOwnerTab();
        }
        if(i==3){
            fragment = new FragmentReportTab();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;//static assignment
    }
//return active frag for title
    @Override
    public CharSequence getPageTitle(int position) {

        String returnString=null;
        if(position==0){
            returnString = "Transaction";
        }
        if(position==1){
            returnString = "Tenant";
        }
        if(position==2){
            returnString = "Owner";
        }
        if(position==3){
            returnString = "Report";
        }
        return returnString;
    }
}