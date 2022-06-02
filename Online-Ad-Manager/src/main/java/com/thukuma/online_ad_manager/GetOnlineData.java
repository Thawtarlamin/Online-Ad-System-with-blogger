package com.thukuma.online_ad_manager;


import android.content.Context;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GetOnlineData {
    private String TAG = "my-test";
    private Context context;
    private Ads_Manager.onComplete complete;
    private Ads_Manager.onError error;
    private String url;

    public GetOnlineData(Context context, Ads_Manager.onComplete complete, Ads_Manager.onError error, String url) {
        this.context = context;
        this.complete = complete;
        this.error = error;
        this.url = url;
    }

    public  void getAds(){
        SharePreference sharePreference = new SharePreference(context);
        AndroidNetworking.get(url)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Document doc = Jsoup.parse(response);
                        String banner =doc.select("a[id=admob]").attr("banner");
                        String inter = doc.select("a[id=admob]").attr("inter");
                        String status = doc.select("a[id=admob]").attr("status");
                        String app_id = doc.select("a[id=admob]").attr("appid");
                        if (!banner.isEmpty()&&!inter.isEmpty()&&!app_id.isEmpty()&&!status.isEmpty()) {
                            sharePreference.save_id(app_id, banner, inter,status);
                            complete.onComplete(sharePreference);

                        }
                    }
                    @Override
                    public void onError(ANError anError) {
                        error.onError(anError.toString());
                    }
                });
    }
}
