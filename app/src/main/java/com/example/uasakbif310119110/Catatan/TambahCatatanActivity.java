package com.example.uasakbif310119110.Catatan;
//        NIM: 10119110
//        NAMA: BANI FAZA RASYADAN
//        KELAS: IF-3
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.uasakbif310119110.BotNav.CatatanFragment;
import com.example.uasakbif310119110.DB_SQL;
import com.example.uasakbif310119110.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TambahCatatanActivity extends AppCompatActivity {
    protected Cursor cursor;
    DB_SQL database;
    Button btn_simpan;
    EditText judul,deskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_catatan);

        database = new DB_SQL(this);
        judul = findViewById(R.id.judul);
        deskripsi = findViewById(R.id.deskripsi);
        btn_simpan = findViewById(R.id.btn_simpan);
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pattern = "dd-MM-yyyy";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String date = simpleDateFormat.format(new Date());
                SQLiteDatabase db = database.getWritableDatabase();
                db.execSQL("INSERT INTO catatan_harian(judul_catatan, deskripsi_catatan, tgl_catatan) values('" +
                        judul.getText().toString()+ "','" +
                        deskripsi.getText().toString() + "','" + date + "')");
                Toast.makeText(TambahCatatanActivity.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                CatatanFragment.catatan.RefreshList();
                finish();
            }
        });
    }
}