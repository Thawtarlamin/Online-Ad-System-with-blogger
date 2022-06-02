package com.thukuma.online_ad_manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;


public class SharePreference {
    private Context context;
    public SharePreference(Context context) {
        this.context = context;

    }

    public void save_id(String app_id,String banner,String  inter,String status) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("ADMOB",context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("app_id",app_id);
        editor.putString("banner",banner);
        editor.putString("inter",inter);
        editor.putString("status",status);
        editor.commit();
    }
    public String load_banner(){
        SharedPreferences sharedPreferences = context.getSharedPreferences("ADMOB",context.MODE_PRIVATE);
        return sharedPreferences.getString("banner", context.getString(R.string.banner_ads));
    }
    public String load_inter(){
        SharedPreferences sharedPreferences = context.getSharedPreferences("ADMOB",context.MODE_PRIVATE);
        return sharedPreferences.getString("inter", context.getString(R.string.intertitialAds));
    }
//    public String load_reward(){
//        SharedPreferences sharedPreferences = context.getSharedPreferences("ADMOB",context.MODE_PRIVATE);
//        return sharedPreferences.getString("rewards", context.getString(R.string.rewards_ads));
//    }
    @SuppressLint("CommitPrefEdits")
    public void removed(){
        SharedPreferences sharedPreferences = context.getSharedPreferences("ADMOB",context.MODE_PRIVATE);
        sharedPreferences.edit().remove("app_id");
        sharedPreferences.edit().remove("banner");
        sharedPreferences.edit().remove("inter");
        sharedPreferences.edit().remove("rewards");
        sharedPreferences.edit().remove("status");
    }
    public void app_id_set(){
        ApplicationInfo ai = null;
        try {
            ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            Bundle bundle = ai.metaData;
            String myApiKey = bundle.getString("com.google.android.gms.ads.APPLICATION_ID");

            ai.metaData.putString("com.google.android.gms.ads.APPLICATION_ID", SharePreference.this.load_app_id());//you can replace your key APPLICATION_ID here
            String ApiKey = bundle.getString("com.google.android.gms.ads.APPLICATION_ID");

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
    public String load_status(){
    SharedPreferences sharedPreferences = context.getSharedPreferences("ADMOB",context.MODE_PRIVATE);
    return sharedPreferences.getString("status", "off");
    }
    public String load_app_id(){
        SharedPreferences sharedPreferences = context.getSharedPreferences("ADMOB",context.MODE_PRIVATE);
        return sharedPreferences.getString("app_id", context.getString(R.string.app_id));
    }

}
