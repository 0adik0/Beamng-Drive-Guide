package com.beamngguidebeamng.playbeamng.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.appodeal.ads.Appodeal;
import com.appodeal.ads.BannerCallbacks;
import com.beamngguidebeamng.playbeamng.R;
import com.beamngguidebeamng.playbeamng.main.Main;
import com.beamngguidebeamng.playbeamng.settings.Settings;
import com.beamngguidebeamng.playbeamng.start_guide.StartGuide;

public class Subcategories extends AppCompatActivity {

    Button button1, button2, button3;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcategories);
        progressBar = findViewById(R.id.progressBar);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        button1.setVisibility(View.VISIBLE);
                        button2.setVisibility(View.VISIBLE);
                        button3.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.GONE);
                    }
                }, 0);
            }

        }, 5000);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

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

        button1.setOnClickListener(view -> {
            Intent intent = new Intent(this, Main.class);
            startActivity(intent);
        });
        button2.setOnClickListener(view -> {
            Intent intent = new Intent(this, Settings.class);
            startActivity(intent);
        });
        button3.setOnClickListener(view -> {
            Intent intent = new Intent(this, StartGuide.class);
            startActivity(intent);
        });
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}