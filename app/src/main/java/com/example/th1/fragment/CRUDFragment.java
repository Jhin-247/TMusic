package com.example.th1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.th1.databinding.FragmentCrudBinding;

public class CRUDFragment extends Fragment {
    FragmentCrudBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCrudBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}
