package com.example.th1.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.th1.fragment.homefragment.UserInfoFragment;
import com.example.th1.fragment.homefragment.AllMusicFragment;
import com.example.th1.fragment.homefragment.MyMusicFragment;

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
                return new MyMusicFragment();
            case 1:
                return new AllMusicFragment();
        }
        return new UserInfoFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
