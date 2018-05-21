package com.doplesillo.listviews;

import android.app.LauncherActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {

    TextView txtSaludo;
    ListView lstItems;

    String[] items = {"0","1","2","3","4","5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        txtSaludo = (TextView) findViewById(R.id.txtSaludo);
        String saludo = getIntent().getExtras().getString("saludo");
        txtSaludo.setText(saludo);

        //List Area
        lstItems = (ListView) findViewById(R.id.lstItems);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, items
        );
        lstItems.setAdapter(adapter);
    }
}
