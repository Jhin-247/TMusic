package com.example.th1.fragment.homefragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.th1.databinding.FragmentMyMusicBinding;

public class MyMusicFragment extends Fragment {
    FragmentMyMusicBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMyMusicBinding.inflate(inflater, container, false);

//        binding.notification.setOnClickListener(V -> {
//            Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.ic_new_notification);
//            NotificationCompat.Builder builder = new NotificationCompat.Builder(requireContext(), MyNotification.CHANNEL_ID)
//                    .setSmallIcon(R.drawable.ic_new_notification)
//                    .setLargeIcon(bm)
//                    .setContentTitle("textTitle")
//                    .setContentText("textContent")
//                    .setDefaults(NotificationCompat.DEFAULT_SOUND)
//                    .setCategory(CATEGORY_ALARM)
//                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);
//            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(requireActivity());
//            notificationManager.notify(1, builder.build());
//        });
        binding.userAvatar.setOnClickListener(v -> {
//            NotificationCompat.Builder builder = new NotificationCompat.Builder(requireContext(), MyNotification.CHANNEL_ID_2)
//                    .setSmallIcon(R.drawable.ic_close)
//                    .setContentTitle("textTitle")
//                    .setContentText("textContent")
//                    .setDefaults(NotificationCompat.DEFAULT_SOUND)
//                    .setCategory(CATEGORY_ALARM)
//                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);
//            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(requireActivity());
//            notificationManager.notify(2, builder.build());
        });

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
