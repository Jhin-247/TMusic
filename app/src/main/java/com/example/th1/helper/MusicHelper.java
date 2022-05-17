package com.example.th1.helper;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.example.th1.model.Music;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MusicHelper {

    public static List<Music> getAllMusicFromDevice(Context context){
        List<Music> songs = new ArrayList<>();
        String[] projection = {
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.DURATION,
                MediaStore.Audio.Media.ARTIST
        };

        String selection = MediaStore.Audio.Media.IS_MUSIC + " !=0";

        Cursor cursor = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,projection,selection,null,null);
        while(cursor.moveToNext()){
            Music song = new Music(cursor.getString(1), cursor.getString(0), cursor.getString(2));
            if(new File(song.getPath()).exists()) {
                songs.add(song);
            }
        }
        cursor.close();
        return songs;
    }

}
