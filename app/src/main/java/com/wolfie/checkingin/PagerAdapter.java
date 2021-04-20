package com.wolfie.checkingin;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                breakfast breakfast = new breakfast();
                return breakfast;
            case 1:
                lunch lunch = new lunch();
                return lunch;
            case 2:
                dinner dinner = new dinner();
                return dinner;
            case 3:
                snacks snacks = new snacks();
                return snacks;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 4;
    }

    public CharSequence getPageTitle(int position){
        switch (position) {
            case 0:
                return "Breakfast";
            case 1:
                return "Lunch";
            case 2:
                return "Dinner";
            case 3:
                return "Snacks";
            default:
                return null;
        }
    }
}
