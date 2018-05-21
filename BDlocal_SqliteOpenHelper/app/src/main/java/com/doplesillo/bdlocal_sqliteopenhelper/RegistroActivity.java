package com.doplesillo.bdlocal_sqliteopenhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    EditText txtitem;
    TextView txtEdad;
    SeekBar seekBarEdad;
    Button btnAddRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        //Ligar interfaz grafica
        txtitem = findViewById(R.id.txtitem);
        txtEdad = findViewById(R.id.txtEdad);
        seekBarEdad = findViewById(R.id.seekBarEdad);
        btnAddRecord = findViewById(R.id.btnAddRecord);

        //implememtar evento de Seekbar
        seekBarEdad.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                txtEdad.setText("Edad: " + i + " años");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Listener del boton agregar Registros Nuevos
        btnAddRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txtitem.getText().toString();
                int edad = seekBarEdad.getProgress();
                if (name.isEmpty()){
                    Toast.makeText(RegistroActivity.this, "Por favor introduce un nombre", Toast.LENGTH_LONG).show();
                    return;
                }
                if (edad <= 3){
                    Toast.makeText(RegistroActivity.this, "Tienes que tener mas de 3 años", Toast.LENGTH_LONG).show();
                    return;
                }

                //Base de Datos
                Usuario usuarioDB = new Usuario(RegistroActivity.this,"usuarios",null,1);
                usuarioDB.agregar(name,edad);

                txtitem.setText("");
                Toast.makeText(RegistroActivity.this, "Usuario Registrado", Toast.LENGTH_LONG).show();
            }
        });

    }
}
