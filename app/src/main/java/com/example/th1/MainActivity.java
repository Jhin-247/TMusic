package com.example.th1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager2.widget.ViewPager2;

import com.example.th1.adapter.HomePagerAdapter;
import com.example.th1.db.SQLiteHelper;
import com.example.th1.model.Student;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    SQLiteHelper sqLiteHelper;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        DataBindingUtil.setContentView(this,R.layout.activity_main);
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).hide();
        initDB();
        initView();

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


    }

    private void initDB() {
        sqLiteHelper = new SQLiteHelper(this);
        sqLiteHelper.addStudent(new Student("B18DCCN562", "Nguyen Anh Tuan", "D18CQCN01-B"));
    }


}