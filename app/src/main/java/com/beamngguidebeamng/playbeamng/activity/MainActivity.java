package com.beamngguidebeamng.playbeamng.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.appodeal.ads.Appodeal;
import com.appodeal.ads.BannerCallbacks;
import com.beamngguidebeamng.playbeamng.R;
import com.beamngguidebeamng.playbeamng.splash.SplashScreen;

public class MainActivity extends AppCompatActivity {

    private long backPressedTime;
    Button nextBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


        nextBtn = findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, Subcategories.class);
            startActivity(intent);
        });
    }

    @Override
    public void onBackPressed() {

        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        }
        backPressedTime = System.currentTimeMillis();
    }

}