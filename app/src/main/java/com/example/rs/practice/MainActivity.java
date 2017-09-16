package com.example.rs.practice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

public class MainActivity extends FragmentActivity //step1 = extends to fragment activity
 {
    ViewPager viewpager = null; //step2 = Create new viewpager & intialize viewpager to null

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewpager = (ViewPager)findViewById(R.id.pager); //step3 = link the viewpager layout id to created viewpager

        FragmentManager fragmentManager = getSupportFragmentManager();//step10 = create a fragment manager to give its support to the view pager adapter
        viewpager.setAdapter(new CreatedAdapter(fragmentManager)); //step9 = we have to intialize the created adapter to our view pager & parameter as fragment manager support which is intialized in step10


    }
}






class CreatedAdapter extends FragmentPagerAdapter{ //step4 = create an adapter class which is used to switch between between fragments or pages

    public CreatedAdapter(FragmentManager fm) { //step6 = create a constructor with fragmentmanager fm as a parameter
        super(fm);
    }

    @Override
    public Fragment getItem(int position) { //step5 = takes the postion from the user and returns fragments to be at that postion
        Fragment fragment = null; //step7 = create a dummy fragment for returning current fragment
        switch (position){ //step8 = implement switch case to perform particular fragment task
            case 0:
                fragment = new Fragment1();
                break;
            case 1:
                fragment = new Fragment2();
                break;
            case 2:
                fragment = new Fragment3();
                break;

        }
        return fragment;
    }

    @Override
    public int getCount() { //step5 =  getcount returns number of fragments to be deal with
        return 3;
    }
}