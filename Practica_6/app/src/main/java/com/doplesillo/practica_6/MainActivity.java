package com.doplesillo.practica_6;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.MobileAds;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button btnCamara;
    Button btnGaleria , btnQr, btnAd;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
        imageView = findViewById(R.id.imageView);
        btnCamara = findViewById(R.id.btnCamara);
        btnGaleria = findViewById(R.id.btnGaleria);
        btnQr = findViewById(R.id.btnQr);
        textView = findViewById(R.id.textView);
        btnAd = findViewById(R.id.btnAd);


        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent camara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camara,1); //el codigo 1 es para la camara
            }
        });

        btnGaleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galeria = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galeria,2);// codigo galeria
            }
        });

        btnQr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //lectura QR
                IntentIntegrator integrator = new IntentIntegrator(MainActivity.this);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrator.setPrompt("Seek & Destroy");
                integrator.setBeepEnabled(true);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });
        btnAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AdActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null){
            //logica QR
            if (result.getContents() == null){
                Toast.makeText(this, "Escaneo cancelado por el usuario", Toast.LENGTH_LONG).show();
            } else {
                textView.setText(result.getContents());
                Toast.makeText(this,result.getContents(), Toast.LENGTH_LONG).show();
            }
        } else if (requestCode == 1 && resultCode == Activity.RESULT_OK){
            Bitmap foto = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(foto);
        } else if (requestCode == 2 && resultCode == Activity.RESULT_OK){
            Uri gal = data.getData();
            imageView.setImageURI(gal);
        }

    }


}
