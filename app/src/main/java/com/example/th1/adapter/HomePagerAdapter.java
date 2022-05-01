package com.example.th1.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.th1.fragment.CRUDFragment;
import com.example.th1.fragment.SearchFragment;
import com.example.th1.fragment.homefragment.ShowDataFragment;

public class HomePagerAdapter extends FragmentStateAdapter {
    public HomePagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public HomePagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public HomePagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new ShowDataFragment();
            case 1:
                return new SearchFragment();
        }
        return new CRUDFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
