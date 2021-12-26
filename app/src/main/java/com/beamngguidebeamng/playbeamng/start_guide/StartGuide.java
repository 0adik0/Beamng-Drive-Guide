package com.beamngguidebeamng.playbeamng.start_guide;

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
import com.beamngguidebeamng.playbeamng.settings.AdditionalFunctionality;
import com.beamngguidebeamng.playbeamng.settings.Banking;
import com.beamngguidebeamng.playbeamng.settings.Driving_and_Testing;
import com.beamngguidebeamng.playbeamng.settings.Height;
import com.beamngguidebeamng.playbeamng.settings.Width;

public class StartGuide extends AppCompatActivity {

    LinearLayout linearLayout11, linearLayout12, linearLayout13, linearLayout14, linearLayout15;
    ProgressBar progressBar;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_guide);

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

        linearLayout11 = findViewById(R.id.linearLayout11);
        linearLayout12 = findViewById(R.id.linearLayout12);
        linearLayout13 = findViewById(R.id.linearLayout13);
        linearLayout14 = findViewById(R.id.linearLayout14);
        linearLayout15 = findViewById(R.id.linearLayout15);

        linearLayout11.setOnClickListener(view -> {
            Intent intent = new Intent(this, Interpolations.class);
            startActivity(intent);
            Appodeal.show(this, Appodeal.INTERSTITIAL);
        });
        linearLayout11.setOnClickListener(view -> {
            Intent intent = new Intent(this, AdvancedPieces.class);
            startActivity(intent);
            Appodeal.show(this, Appodeal.INTERSTITIAL);
        });
        linearLayout12.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddingPieces.class);
            startActivity(intent);
            Appodeal.show(this, Appodeal.INTERSTITIAL);
        });
        linearLayout14.setOnClickListener(view -> {
            Intent intent = new Intent(this, Bezier.class);
            startActivity(intent);
            Appodeal.show(this, Appodeal.INTERSTITIAL);
        });
        linearLayout15.setOnClickListener(view -> {
            Intent intent = new Intent(this, TrackShape.class);
            startActivity(intent);
            Appodeal.show(this, Appodeal.INTERSTITIAL);
        });
    }
}