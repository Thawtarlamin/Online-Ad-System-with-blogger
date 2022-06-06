# Online-Ad-System-with-blogger

# Usage Library
>settings.gradle ထည့်‌ပေးပါ

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
>build.gradle ထည့်‌ပေးပါ
```
dependencies {
	        implementation 'com.github.Thawtarlamin:Online-Ad-System-with-blogger:1.0.0'
	}
```

>MainActivity.java
```
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
```

# Blogger Html
```
<a id="admob" banner = "ca-app-pub-8474060183299772/6116071731"/>
<a id="admob" inter = "ca-app-pub-8474060183299772/5924500040"/>
<a id="admob" status = "On"/>
<a id="admob" appid = "ca-app-pub-3940256099942544~3347511713"/>

```

> အသုံးပြုသူများအဆ‌င်ပြေစေရန်ရည်ရွယ်၍ ထုတ်ပေးထားခြင်းဖြစ်ပါသည်။

# Creator By Thaw Tar La Minn


# 😘😘😘😘
# Donate Paypal
```
nyeineikhin.nek@gmail.com
```

>Thank you for  All User
