package com.guide.gameguide;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.guide.gameguide.ui.attachments.AttachmentsList;
import com.guide.gameguide.ui.comparison.ComparisonWeapon;
import com.guide.gameguide.ui.consumables.ConsumablesItems;
import com.guide.gameguide.ui.gundetail.GunType;

public class TabbedPageAdapter extends FragmentPagerAdapter
{

    int tabcount;

    public TabbedPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0 : return new AttachmentsList();
            case 1 : return new GunType();
            case 2 : return new ComparisonWeapon();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
