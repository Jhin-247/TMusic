package com.example.th1.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.example.th1.Constants;
import com.example.th1.R;
import com.example.th1.databinding.LayoutTablayoutBinding;

public class TabLayoutCustomView extends ConstraintLayout {
    private LayoutTablayoutBinding binding;

    public TabLayoutCustomView(@NonNull Context context) {
        super(context);
        initView(context);
    }

    public TabLayoutCustomView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        initAttribute(context, attrs);
    }

    public TabLayoutCustomView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        initAttribute(context, attrs);
    }

    public TabLayoutCustomView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
        initAttribute(context, attrs);
    }

    public TabLayoutCustomView create(Context context, String title, int resourceId, Boolean defaultState) {
        TabLayoutCustomView tabLayoutCustomView = new TabLayoutCustomView(context);
        tabLayoutCustomView.setTitle(title);
        tabLayoutCustomView.setIcon(resourceId);
        tabLayoutCustomView.setActive(defaultState);
        return tabLayoutCustomView;
    }

    private void initView(Context context) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        binding = LayoutTablayoutBinding.inflate(layoutInflater, this, true);
    }

    private void initAttribute(Context context, AttributeSet attributeSet) {
        int[] ints = {R.attr.pin_input_button_text};
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, ints);
        typedArray.recycle();
    }

    public void setActive(Boolean active) {
        if (active) {
            binding.loutMainWrapper.setBackgroundColor(
                    ContextCompat.getColor(getContext(), R.color.home_tab_bar_wrapper_active)
            );
            binding.tvTitle.setVisibility(View.VISIBLE);
            binding.imvTabIcon.setColorFilter(
                    new PorterDuffColorFilter(
                            ContextCompat.getColor(getContext(), R.color.home_tab_bar_icon_active),
                            PorterDuff.Mode.SRC_IN
                    )
            );
        } else {
            binding.loutMainWrapper.setBackgroundColor(
                    ContextCompat.getColor(getContext(), R.color.transparent)
            );
            binding.tvTitle.setVisibility(View.GONE);
            binding.imvTabIcon.setColorFilter(
                    new PorterDuffColorFilter(
                            ContextCompat.getColor(getContext(), R.color.home_tab_bar_icon_inactive),
                            PorterDuff.Mode.SRC_IN
                    )
            );
        }
    }

    public void setTitle(String title) {
        binding.tvTitle.setText(title);
        Log.d(Constants.LOG_CONSTANTS.DEBUG_LOG, title);
    }

    public void setIcon(int icon) {
        Glide.with(getContext())
                .load(icon)
                .centerInside()
                .into(binding.imvTabIcon);
        Log.d(Constants.LOG_CONSTANTS.DEBUG_LOG, "icon" + icon);
    }
}
