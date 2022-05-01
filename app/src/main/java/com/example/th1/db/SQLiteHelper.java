package com.example.th1.db;

import static com.example.th1.Constants.DB_CONSTANTS.KEY_CLASS;
import static com.example.th1.Constants.DB_CONSTANTS.KEY_ID;
import static com.example.th1.Constants.DB_CONSTANTS.KEY_NAME;
import static com.example.th1.Constants.DB_CONSTANTS.TABLE_NAME;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.th1.Constants;
import com.example.th1.model.Student;

public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(@Nullable Context context) {
        super(context, Constants.DB_CONSTANTS.DATABASE_NAME, null, Constants.DB_CONSTANTS.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createStudentsTable = String.format("CREATE TABLE %s(%s TEXT PRIMARY KEY, %s TEXT, %s TEXT)", TABLE_NAME, KEY_ID, KEY_NAME, KEY_CLASS);
        sqLiteDatabase.execSQL(createStudentsTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String dropStudentsTable = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        sqLiteDatabase.execSQL(dropStudentsTable);
        onCreate(sqLiteDatabase);
    }

    public void addStudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_ID,student.getId());
        contentValues.put(KEY_NAME, student.getName());
        contentValues.put(KEY_CLASS, student.getClassName());

        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }
}
