package com.doplesillo.bdlocal_sqliteopenhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {

    EditText idUpdate;
    EditText nameUpdate;
    EditText ageUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        //Ligando elementos Visuales con objetos
        idUpdate = findViewById(R.id.idUpdate);
        nameUpdate = findViewById(R.id.nameUpdate);
        ageUpdate = findViewById(R.id.ageUpdate);


    }
}
