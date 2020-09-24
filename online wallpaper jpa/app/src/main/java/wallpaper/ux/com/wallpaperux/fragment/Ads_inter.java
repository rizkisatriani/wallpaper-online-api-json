package wallpaper.ux.com.wallpaperux.fragment;

import android.content.Context;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import wallpaper.ux.com.wallpaperux.R;
import wallpaper.ux.com.wallpaperux.config.datapreff;

public class Ads_inter {
    datapreff db;
    InterstitialAd interstitial;
    Context context;

    public Ads_inter(Context context) {
        this.context = context;
        db=new datapreff(context);
        interstitial = new InterstitialAd(context);
        interstitial.setAdUnitId(context.getResources().getString(R.string.inter));
        interstitial.loadAd(new AdRequest.Builder().build());
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
                // Call displayInterstitial() function
                // If Ads are loaded, show Interstitial else show nothing.
                //pDialog.dismiss();
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
            }
        });
    }

    public void show_ads(){
        int click =db.getInterstitial();
        Log.e("ADS CLICK :",""+click);
        if ( click>=3) {
            if (interstitial.isLoaded()&&click==3) {
                Log.e("ADS Crash :","YES");
                interstitial.show();
            }else{
                Log.e("ADS Crash :","NO");
                interstitial.loadAd(new AdRequest.Builder().build());
                interstitial.setAdListener(new AdListener() {
                    public void onAdLoaded() {
                    }
                    @Override
                    public void onAdFailedToLoad(int i) {
                        super.onAdFailedToLoad(i);
                    }
                });
            }
            db.setInterstitial(0);
        }else{
            db.setInterstitial(click+1);
        }
    }
}
