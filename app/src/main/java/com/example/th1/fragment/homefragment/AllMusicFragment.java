package com.example.th1.fragment.homefragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.th1.databinding.FragmentAllMusicBinding;

public class AllMusicFragment extends Fragment {
    FragmentAllMusicBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAllMusicBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}
