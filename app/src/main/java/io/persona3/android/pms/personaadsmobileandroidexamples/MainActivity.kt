package io.persona3.android.pms.personaadsmobileandroidexamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import io.persona3.android.pms.ads.AdRequest
import io.persona3.android.pms.ads.AdView
import io.persona3.android.pms.ads.PersonaAdSDK

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        PersonaAdSDK.initialize(this)

        val mAdView = findViewById<AdView>(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
    }
}