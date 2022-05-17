package com.example.th1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.th1.adapter.HomePagerAdapter;
import com.example.th1.customviews.TabLayoutCustomView;
import com.example.th1.databinding.ActivityMainBinding;
import com.example.th1.db.SQLiteHelper;
import com.example.th1.model.Student;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    SQLiteHelper sqLiteHelper;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initDB();
        initView();
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

    }

    private void initView() {
        initBottomNavigation();
    }

    @SuppressLint("NonConstantResourceId")
    private void initBottomNavigation() {
        handler = new Handler();

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home_tab_1:
                    handler.postDelayed(() -> binding.viewPager.setCurrentItem(0, true), 100);
                    break;
                case R.id.home_tab_2:
                    handler.postDelayed(() -> binding.viewPager.setCurrentItem(1, true), 100);
                    break;
                case R.id.home_tab_3:
                    handler.postDelayed(() -> binding.viewPager.setCurrentItem(2, true), 100);
                    break;
            }
            return true;
        });

        HomePagerAdapter adapter = new HomePagerAdapter(this);
        binding.viewPager.setAdapter(adapter);
        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                binding.bottomNavigation.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                binding.bottomNavigation.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(binding.tabLayout, binding.viewPager, true, (tab, position) -> {
        });
        tabLayoutMediator.attach();

        initCustomTabView();
    }

    @SuppressWarnings("ConstantConditions")
    private void initCustomTabView() {
        TabLayoutCustomView tab0, tab1, tab2;
        tab0 = new TabLayoutCustomView(this);
        tab0.setTitle("Home");
        tab0.setIcon(R.drawable.ic_baseline_account_balance_24);
        tab0.setActive(true);

        tab1 = new TabLayoutCustomView(this);
        tab1.setTitle("Home");
        tab1.setIcon(R.drawable.ic_baseline_account_balance_24);
        tab1.setActive(false);

        tab2 = new TabLayoutCustomView(this);
        tab2.setTitle("Home");
        tab2.setIcon(R.drawable.ic_baseline_account_balance_24);
        tab2.setActive(false);

        binding.tabLayout.getTabAt(0).setCustomView(tab0);
        binding.tabLayout.getTabAt(1).setCustomView(tab1);
        binding.tabLayout.getTabAt(2).setCustomView(tab2);

        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                ((TabLayoutCustomView) tab.getCustomView()).setActive(true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                ((TabLayoutCustomView) tab.getCustomView()).setActive(false);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                ((TabLayoutCustomView) tab.getCustomView()).setActive(true);
            }
        });
    }

    private void initDB() {
        sqLiteHelper = new SQLiteHelper(this);
        sqLiteHelper.addStudent(new Student("B18DCCN562", "Nguyen Anh Tuan", "D18CQCN01-B"));
    }


}