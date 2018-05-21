package com.doplesillo.practica_6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class AdActivity extends AppCompatActivity {
    Button btnInter;
    AdView adView1;
    AdView adView2;

    private InterstitialAd mInterstitialAd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);
        //Baners
        adView1 = findViewById(R.id.adView1);
        adView2 = findViewById(R.id.adView2);

        AdRequest adRequest1 = new AdRequest.Builder().build();
        AdRequest adRequest2 = new AdRequest.Builder().build();

        adView1.loadAd(adRequest1);
        adView2.loadAd(adRequest2);
         //Intertitial
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        btnInter = findViewById(R.id.btnInter);
        btnInter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Toast.makeText(AdActivity.this, "The interstitial wasn't loaded yet.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
