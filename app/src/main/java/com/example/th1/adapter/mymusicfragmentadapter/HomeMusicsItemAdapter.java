package com.example.th1.adapter.mymusicfragmentadapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.th1.databinding.ItemMusicHomeBinding;

public class HomeMusicsItemAdapter extends RecyclerView.Adapter<HomeMusicsItemAdapter.HomeMusicsItemHolder> {


    @NonNull
    @Override
    public HomeMusicsItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeMusicsItemHolder(ItemMusicHomeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeMusicsItemHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class HomeMusicsItemHolder extends RecyclerView.ViewHolder {
        ItemMusicHomeBinding binding;

        public HomeMusicsItemHolder(@NonNull ItemMusicHomeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
