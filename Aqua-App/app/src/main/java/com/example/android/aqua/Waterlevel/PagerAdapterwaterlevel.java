package com.example.android.aqua.Waterlevel;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.android.aqua.R;

public class PagerAdapterwaterlevel extends FragmentStatePagerAdapter {

    private Context mContext;

    public PagerAdapterwaterlevel(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new WaterlevelFragment();
        } else
            return new waterlevelgraphFragment();

    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_Stats);
        } else
            return mContext.getString(R.string.category_graph);
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 2;
    }
}
