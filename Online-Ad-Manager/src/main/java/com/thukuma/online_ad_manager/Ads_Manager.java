package com.thukuma.online_ad_manager;

import android.content.Context;

public class Ads_Manager {
    private Context context;
    private GetOnlineData data;
    private SharePreference sharePreference;
    public Ads_Manager(String url,Context context,onComplete complete,onError error) {
        this.context = context;
        data = new GetOnlineData(context, complete, error, url);
        data.getAds();
        sharePreference = new SharePreference(context);
    }
    public interface onComplete{
        void onComplete(SharePreference sharePreference);
    }
    public interface onError{
        void onError(String onError);
    }


}
