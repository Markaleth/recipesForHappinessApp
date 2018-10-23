package com.vladgeorgescu.recipesforhappiness.Adapters.TabPageAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.vladgeorgescu.recipesforhappiness.TabFragments.IngredientsTabFragment;
import com.vladgeorgescu.recipesforhappiness.TabFragments.StepsTabFragment;


public class TabPageAdapter extends FragmentPagerAdapter {

    private String tabNames[] = {"Ingredients", "Steps"};

    public TabPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new IngredientsTabFragment();
        }
        if (position == 1) {
            return new StepsTabFragment();
        }

        return null;

    }

    @Override
    public int getCount() {
        return tabNames.length;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return tabNames[position];
    }
}

