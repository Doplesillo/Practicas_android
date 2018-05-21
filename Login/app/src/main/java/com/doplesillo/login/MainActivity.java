package com.doplesillo.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;
import android.app.Activity;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    //REferencia para los campos de texto
    EditText txtName;
    EditText txtPassword;

    String nombre = "gato";
    String contra = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Conectar los input con sus variables
        txtName = findViewById(R.id.txtName);
        txtPassword = findViewById(R.id.txtpass);

        //Conectar el boton del xml con el boton de la clase actual
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = txtName.getText().toString();
                String password = txtPassword.getText().toString();

                if (nombre.equals(name) && contra.equals(password) ){
                    Toast.makeText(MainActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();

                    //crear objeto intent para pasar a pantalla
                    Intent intent = new Intent(MainActivity.this,WelcomeActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(MainActivity.this, "Credencials incorectas", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
