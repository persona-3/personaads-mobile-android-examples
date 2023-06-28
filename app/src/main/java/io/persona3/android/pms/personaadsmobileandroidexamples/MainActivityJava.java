package io.persona3.android.pms.personaadsmobileandroidexamples;

import androidx.activity.ComponentActivity;

import android.os.Bundle;

import io.persona3.android.pms.ads.AdRequest;
import io.persona3.android.pms.ads.AdView;
import io.persona3.android.pms.ads.PersonaAdSDK;

public class MainActivityJava extends ComponentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PersonaAdSDK.Companion.initialize(this);

        AdView adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }
}