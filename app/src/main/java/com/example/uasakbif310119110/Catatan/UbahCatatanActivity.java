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

public class UbahCatatanActivity extends AppCompatActivity {
    protected Cursor cursor;
    DB_SQL database;
    Button btn_simpan;
    EditText judul, deskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_catatan);
        database = new DB_SQL(this);
        judul = findViewById(R.id.judul);
        deskripsi = findViewById(R.id.deskripsi);
        btn_simpan = findViewById(R.id.btn_simpan);
        SQLiteDatabase db = database.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM catatan_harian WHERE judul_catatan = '" +
                getIntent().getStringExtra("judul_catatan") + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            judul.setText(cursor.getString(0).toString());
            deskripsi.setText(cursor.getString(1).toString());
        }
        btn_simpan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SQLiteDatabase db = database.getWritableDatabase();
                db.execSQL("UPDATE catatan_harian SET  judul_catatan= '" + judul.getText().toString() + "', deskripsi_catatan= '" +
                        deskripsi.getText().toString() + "' where judul_catatan = '" +
                        getIntent().getStringExtra("judul_catatan") + "'");
                Toast.makeText(UbahCatatanActivity.this, "Data Berhasil di Update", Toast.LENGTH_SHORT).show();
                CatatanFragment.catatan.RefreshList();
                finish();
            }
        });
    }
}