/*
*OthersHabitFragment
*
* version 1.0
*
* Dec 3, 2017
*
*Copyright (c) 2017 Team 16 (Jonah Cowan, Alexander Mackenzie, Hao Yuan, Jacy Mark, Shu-Ting Lin), CMPUT301, University of Alberta - All Rights Reserved.
*You may use, distribute, or modify this code under terms and conditions of the Code of Student Behavior at University of Alberta.
*You can find a copy of the license in this project. Otherwise please contact contact@abc.ca.
*
*/

package com.example.habittracker2017;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 *Setup sub tabs for Other's Habit, includes Other's Activity and Manage Sharing tabs
 *
 * @author team 16
 * @version 1.0
 * @see Fragment
 * @since 1.0
 */

public class OthersHabitFragment extends Fragment {
    /**
     * Setup sub tab container
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.myhabitfragment, container, false);
        ViewPager mViewPager = (ViewPager) view.findViewById(R.id.container_main);
        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mSectionsPagerAdapter);

        return view;

    }



    /**
     * Adapter for sub tabs
     */
    private class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return Fragment tabs
         * @param position
         * @return
         */
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return OthersFragment.newInstance(1);
                default:
                    return manageSharing.newInstance(2);
            }

        }

        /**
         *
         * @return the number of sub tabs
         */
        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }

        /**
         * Return tab's title
         * @param position
         * @return tab's title
         */
        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return "Other's Activities";
                default:
                    return "Manage Sharing";
            }


        }
    }

}
