package com.muslimadel2018.bit69_task.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;
import com.muslimadel2018.bit69_task.R;
import com.muslimadel2018.bit69_task.ui.introSlider.IntroSlider;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        boolean connected = false;

        if (!haveNetwork()) {
            Toast.makeText(SplashScreen.this, "no internet connection", Toast.LENGTH_LONG).show();
        }

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                    boolean x = true;
                    while (x) {
                        if (haveNetwork() & isInternetAvailable()) {
                            Intent intent = new Intent(SplashScreen.this, IntroSlider.class);
                            startActivity(intent);
                            x = false;
                            finish();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();
    }

    public boolean isInternetAvailable() {
        try {
            InetAddress address = InetAddress.getByName("www.google.com");
            return !address.equals("");
        } catch (UnknownHostException e) {
        }
        return false;
    }

    private boolean haveNetwork() {
        boolean have_WIFI = false;
        boolean have_MobileData = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInfos = connectivityManager.getAllNetworkInfo();
        for (NetworkInfo info : networkInfos) {
            if (info.getTypeName().equalsIgnoreCase("WIFI"))
                if (info.isConnected()) have_WIFI = true;
            if (info.getTypeName().equalsIgnoreCase("MOBILE DATA"))
                if (info.isConnected()) have_MobileData = true;
        }
        return have_WIFI || have_MobileData;
    }
}
