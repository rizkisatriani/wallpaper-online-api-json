package wallpaper.ux.com.wallpaperux.model;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

import java.util.ArrayList;

public class SectionDataModel {
    private String headerTitle;
    private UnifiedNativeAd adView;
    private ArrayList<SingleItemModel> allItemInSection;
    private ArrayList<singgle_pager_view> pager_view_Section;

    public SectionDataModel() {
    }

    public SectionDataModel(String headerTitle, ArrayList<SingleItemModel> allItemInSection) {
        this.headerTitle = headerTitle;
        this.allItemInSection = allItemInSection;
    }

    public void setPagerView(ArrayList<singgle_pager_view> pager_view_Section) {
        this.pager_view_Section = pager_view_Section;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public ArrayList<SingleItemModel> getAllItemInSection() {
        return allItemInSection;
    }

    public void setAllItemInSection(ArrayList<SingleItemModel> allItemInSection) {
        this.allItemInSection = allItemInSection;
    }

    public ArrayList<singgle_pager_view> getPager_view_Section() {
        return pager_view_Section;
    }

    public void setPager_view_Section(ArrayList<singgle_pager_view> pager_view_Section) {
        this.pager_view_Section = pager_view_Section;
    }

    public Integer getsize () {
        return allItemInSection.size();
    }

    public UnifiedNativeAd getAdView() {
        return adView;
    }

    public void setAdView(UnifiedNativeAd adView) {
        this.adView = adView;
    }
}
