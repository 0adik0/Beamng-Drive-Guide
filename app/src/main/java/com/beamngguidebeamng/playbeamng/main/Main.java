package com.beamngguidebeamng.playbeamng.main;

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
import com.beamngguidebeamng.playbeamng.activity.Subcategories;

public class Main extends AppCompatActivity {

    LinearLayout linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5;
    ProgressBar progressBar;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

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

        linearLayout = findViewById(R.id.linearLayout);
        linearLayout2 = findViewById(R.id.linearLayout2);
        linearLayout3 = findViewById(R.id.linearLayout3);
        linearLayout4 = findViewById(R.id.linearLayout4);
        linearLayout5 = findViewById(R.id.linearLayout5);

        linearLayout.setOnClickListener(view -> {
            Intent intent = new Intent(this, TrackBuilder.class);
            startActivity(intent);
            Appodeal.show(this, Appodeal.INTERSTITIAL);
        });
        linearLayout2.setOnClickListener(view -> {
            Intent intent = new Intent(this, GettingStarted.class);
            startActivity(intent);
            Appodeal.show(this, Appodeal.INTERSTITIAL);
        });
        linearLayout3.setOnClickListener(view -> {
            Intent intent = new Intent(this, Overview.class);
            startActivity(intent);
            Appodeal.show(this, Appodeal.INTERSTITIAL);
        });
        linearLayout4.setOnClickListener(view -> {
            Intent intent = new Intent(this, Basic_Concepts.class);
            startActivity(intent);
            Appodeal.show(this, Appodeal.INTERSTITIAL);
        });
        linearLayout5.setOnClickListener(view -> {
            Intent intent = new Intent(this, Selecing_Pieces.class);
            startActivity(intent);
            Appodeal.show(this, Appodeal.INTERSTITIAL);
        });
    }
}