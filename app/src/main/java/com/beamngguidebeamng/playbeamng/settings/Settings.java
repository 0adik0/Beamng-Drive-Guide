package com.beamngguidebeamng.playbeamng.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import com.appodeal.ads.Appodeal;
import com.appodeal.ads.BannerCallbacks;
import com.appodeal.ads.InterstitialCallbacks;
import com.beamngguidebeamng.playbeamng.R;
import com.beamngguidebeamng.playbeamng.main.Basic_Concepts;
import com.beamngguidebeamng.playbeamng.main.GettingStarted;
import com.beamngguidebeamng.playbeamng.main.Overview;
import com.beamngguidebeamng.playbeamng.main.Selecing_Pieces;
import com.beamngguidebeamng.playbeamng.main.TrackBuilder;

public class Settings extends AppCompatActivity {

    LinearLayout linearLayout6, linearLayout7, linearLayout8, linearLayout9, linearLayout10;
    ProgressBar progressBar;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        progressBar = findViewById(R.id.progressBar);
        scrollView = findViewById(R.id.scrollView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        scrollView.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.GONE);
                    }
                }, 0);
            }

        }, 5000);

        String appKey = "94ccdf6c7a83d7d90bdcb8adad8de68f5d813c07d0bc1e67";
        Appodeal.setTesting(true);
        Appodeal.initialize(this, appKey, Appodeal.INTERSTITIAL | Appodeal.BANNER );

        Appodeal.setBannerViewId(R.id.appodealBannerView);
        Appodeal.getBannerView(this);
        Appodeal.show(this, Appodeal.BANNER_BOTTOM);
        Appodeal.setBannerCallbacks(new BannerCallbacks() {
            @Override
            public void onBannerLoaded(int height, boolean isPrecache) {
                // Called when banner is loaded
            }

            @Override
            public void onBannerFailedToLoad() {
                // Called when banner failed to load
            }

            @Override
            public void onBannerShown() {
                // Called when banner is shown
            }

            @Override
            public void onBannerShowFailed() {
                // Called when banner show failed
            }

            @Override
            public void onBannerClicked() {
                // Called when banner is clicked
            }

            @Override
            public void onBannerExpired() {
                // Called when banner is expired
            }
        });

        linearLayout6 = findViewById(R.id.linearLayout6);
        linearLayout7 = findViewById(R.id.linearLayout7);
        linearLayout8 = findViewById(R.id.linearLayout8);
        linearLayout9 = findViewById(R.id.linearLayout9);
        linearLayout10 = findViewById(R.id.linearLayout10);

        linearLayout6.setOnClickListener(view -> {
            Intent intent = new Intent(this, Driving_and_Testing.class);
            startActivity(intent);
            Appodeal.show(this, Appodeal.INTERSTITIAL);
        });
        linearLayout7.setOnClickListener(view -> {
            Intent intent = new Intent(this, AdditionalFunctionality.class);
            startActivity(intent);
            Appodeal.show(this, Appodeal.INTERSTITIAL);
        });
        linearLayout8.setOnClickListener(view -> {
            Intent intent = new Intent(this, Banking.class);
            startActivity(intent);
            Appodeal.show(this, Appodeal.INTERSTITIAL);
        });
        linearLayout9.setOnClickListener(view -> {
            Intent intent = new Intent(this, Height.class);
            startActivity(intent);
            Appodeal.show(this, Appodeal.INTERSTITIAL);
        });
        linearLayout10.setOnClickListener(view -> {
            Intent intent = new Intent(this, Width.class);
            startActivity(intent);
            Appodeal.show(this, Appodeal.INTERSTITIAL);
        });
    }
}