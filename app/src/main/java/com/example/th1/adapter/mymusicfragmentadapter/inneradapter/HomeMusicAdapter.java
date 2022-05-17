package com.example.th1.adapter.mymusicfragmentadapter.inneradapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.th1.databinding.ItemMusicHomeBinding;
import com.example.th1.model.Music;

import java.util.List;

public class HomeMusicAdapter extends RecyclerView.Adapter<HomeMusicAdapter.HomeMusicHolder> {
    List<Music> musics;

    @NonNull
    @Override
    public HomeMusicHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeMusicHolder(ItemMusicHomeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeMusicHolder holder, int position) {
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return musics == null ? 0 : musics.size();
    }

    public static class HomeMusicHolder extends RecyclerView.ViewHolder {
        ItemMusicHomeBinding binding;

        public HomeMusicHolder(@NonNull ItemMusicHomeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
