package com.example.uasakbif310119110;
//        NIM: 10119110
//        NAMA: BANI FAZA RASYADAN
//        KELAS: IF-3
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DB_SQL extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "catatan_harian.db";
    private static final int DATABASE_VERSION = 1;

    public DB_SQL(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table catatan_harian(judul_catatan text null, deskripsi_catatan text null, tgl_catatan text null);";
        Log.d("Data", "onCreate" + sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db0, int db1, int db2) {

    }
}
