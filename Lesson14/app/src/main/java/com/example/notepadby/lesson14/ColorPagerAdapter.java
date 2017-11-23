package com.example.notepadby.lesson14;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.Random;

/**
 * Created by NotePad.by on 22.11.2017.
 */

public class ColorPagerAdapter extends FragmentStatePagerAdapter {

    public ColorPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new ColorFragment();
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public String getPageTitle(int position){
        return "Color #" + position;
    }
}
