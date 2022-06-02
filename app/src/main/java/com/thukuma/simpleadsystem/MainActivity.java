package com.thukuma.simpleadsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.thukuma.online_ad_manager.Ads_Manager;
import com.thukuma.online_ad_manager.SharePreference;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Ads_Manager("https://2d-live.blogspot.com/2022/05/ads-manager.html", this, new Ads_Manager.onComplete() {
            @Override
            public void onComplete(SharePreference sharePreference) {

                Log.d("my-test", "Banner: "+sharePreference.load_banner());
                Log.d("my-test", "Inter: "+sharePreference.load_inter());
                Log.d("my-test", "App-ID: "+sharePreference.load_app_id());
                Log.d("my-test", "Status: "+sharePreference.load_status());
            }
        }, new Ads_Manager.onError() {
            @Override
            public void onError(String onError) {
                Log.d("my-test", "onError: "+onError);
            }
        });
    }
}