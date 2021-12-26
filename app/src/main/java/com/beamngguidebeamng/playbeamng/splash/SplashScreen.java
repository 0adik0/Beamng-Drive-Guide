package com.beamngguidebeamng.playbeamng.splash;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.appodeal.ads.Appodeal;
import com.beamngguidebeamng.playbeamng.R;
import com.beamngguidebeamng.playbeamng.activity.MainActivity;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends Activity {
    private ProgressBar mProgress;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        mProgress = findViewById(R.id.splash_screen_progress_bar);
        mProgress.getProgressDrawable().setColorFilter(
                Color.GRAY, android.graphics.PorterDuff.Mode.SRC_IN);

        new Thread(() -> {
            doWork();
            startApp();
            finish();
        }).start();
    }

    private void doWork() {
        for (int progress=0; progress<100; progress+=1) {
            try {
                Thread.sleep(100);
                mProgress.setProgress(progress);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void startApp() {
        Intent intent = new Intent(SplashScreen.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}