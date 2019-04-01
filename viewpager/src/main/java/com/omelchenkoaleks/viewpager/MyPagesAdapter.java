package com.omelchenkoaleks.viewpager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class MyPagesAdapter extends FragmentStatePagerAdapter {
    public MyPagesAdapter(FragmentManager fm) {
        super(fm);
    }

    // возвращает сам элемент
    @Override
    public Fragment getItem(int position) {
        return MyFragment.getInstance("page " + position);
    }

    // возвращает количество элементов
    @Override
    public int getCount() {
        return 5;
    }
}
