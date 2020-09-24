package wallpaper.ux.com.wallpaperux.model;


import android.net.Uri;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

public class SingleItemModel {
    private String name, url, description;
    private UnifiedNativeAd adView;
    Uri uri;
    int number;


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public SingleItemModel() {

    }

    public SingleItemModel(String name, String description, Uri url, int number) {
        this.name = name;
        this.description = description;
        this.uri = url;
        this.number = number;
    }

    public SingleItemModel(UnifiedNativeAd adView) {
        this.adView = adView;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public UnifiedNativeAd getAdView() {
        return adView;
    }

    public void setAdView(UnifiedNativeAd adView) {
        this.adView = adView;
    }
}
