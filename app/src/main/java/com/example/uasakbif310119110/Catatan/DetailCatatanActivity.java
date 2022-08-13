package com.example.uasakbif310119110.Catatan;
//        NIM: 10119110
//        NAMA: BANI FAZA RASYADAN
//        KELAS: IF-3
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.uasakbif310119110.DB_SQL;
import com.example.uasakbif310119110.R;

public class DetailCatatanActivity extends AppCompatActivity {
    protected Cursor cursor;
    DB_SQL database;
    Button btn_simpan;
    TextView judul,deskripsi, tgl_dibuat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_catatan);
        database = new DB_SQL(this);
        judul = findViewById(R.id.judul);
        deskripsi = findViewById(R.id.deskripsi);
        tgl_dibuat = findViewById(R.id.tgl_dibuat);
        btn_simpan = findViewById(R.id.btn_simpan);
        SQLiteDatabase db = database.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM catatan_harian WHERE judul_catatan = '" +
                getIntent().getStringExtra("judul_catatan") + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            judul.setText(cursor.getString(0).toString());
            deskripsi.setText(cursor.getString(1).toString());
            tgl_dibuat.setText(cursor.getString(2).toString());

        }
    }
}