package com.example.uasakbif310119110;
//        NIM: 10119110
//        NAMA: BANI FAZA RASYADAN
//        KELAS: IF-3
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.uasakbif310119110.BotNav.CatatanFragment;
import com.example.uasakbif310119110.BotNav.ProfilFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        auth = FirebaseAuth.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.botnav);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                new CatatanFragment()).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.catatan:
                        selectedFragment = new CatatanFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                                selectedFragment).commit();

                        break;
                    case R.id.profil:
                        selectedFragment = new ProfilFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                                selectedFragment).commit();

                        break;

                    case R.id.logout:
                        auth.signOut();
                        startActivity(new Intent(MainActivity.this, SignInActivity.class));
                        break;


                }
                return true;


            }

        });


    }
}