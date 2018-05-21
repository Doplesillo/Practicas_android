package com.doplesillo.listviews;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager FragmentManager = getSupportFragmentManager();
            FragmentTransaction FragmentTransaction = FragmentManager.beginTransaction();

            switch (item.getItemId()) {
                case R.id.navigation_image:
                    FragmentTransaction.replace(R.id.content, new ImageFragment()).commit();
                    Toast.makeText(MainActivity.this, "Aun no esta implememtado", Toast.LENGTH_LONG).show();
                    return true;
                case R.id.navigation_list:
                    FragmentTransaction.replace(R.id.content, new ListFragment()).commit();
                    return true;
                case R.id.navigation_custom_list:
                    FragmentTransaction.replace(R.id.content, new ListFragment()).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager FragmentManager = getSupportFragmentManager();
        FragmentTransaction FragmentTransaction = FragmentManager.beginTransaction();
        FragmentTransaction.replace(R.id.content, new ImageFragment()).commit();



        BottomNavigationView navigation =  findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
