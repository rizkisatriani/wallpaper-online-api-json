package wallpaper.ux.com.wallpaperux.fragment;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import wallpaper.ux.com.wallpaperux.R;
import wallpaper.ux.com.wallpaperux.adapter.RecyclerViewDataAdapter;
import wallpaper.ux.com.wallpaperux.adapter.ViewPagerAdapter;
import wallpaper.ux.com.wallpaperux.config.Globe_Function;
import wallpaper.ux.com.wallpaperux.config.datapreff;
import wallpaper.ux.com.wallpaperux.config.var_global;
import wallpaper.ux.com.wallpaperux.model.SectionDataModel;
import wallpaper.ux.com.wallpaperux.model.SingleItemModel;
import wallpaper.ux.com.wallpaperux.model.file;
import wallpaper.ux.com.wallpaperux.model.singgle_pager_view;
import wallpaper.ux.com.wallpaperux.view.MainActivity;
import wallpaper.ux.com.wallpaperux.view.menu_bawah;

/**
 * A simple {@link Fragment} subclass.
 */
public class Main extends Fragment {
    private ArrayList<SectionDataModel> allSampleData;
    private RecyclerView recyclerView;
    private RecyclerViewDataAdapter adapter_recycler;
    SwipeRefreshLayout refresh;
    Globe_Function gf;
    ArrayList<SingleItemModel> singleItemModels;
    public AssetManager as;
    // The AdLoader used to load ads.
    private List<UnifiedNativeAd> mNativeAds;
    private AdLoader adLoader;
    ProgressDialog loading;
    private static final int NUMBER_OF_ADS = 2;
    datapreff db;
    ArrayList<file> data_file;
    SectionDataModel dm;
    public Main() {
        // Required empty public constructor
    }
    @SuppressLint("WrongConstant")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View returnv = inflater.inflate(R.layout.fragment_main, container, false);
        db=new datapreff(getActivity());
        allSampleData = new ArrayList<>();
        loading=new ProgressDialog(getActivity());
        loading.setCancelable(false);
        loading.setTitle("Loading Wallpaper");
        loading.setMessage("Wait...");
        as = returnv.getResources().getAssets();
        gf = new Globe_Function();
        refresh = returnv.findViewById(R.id.swipe);
        recyclerView = (RecyclerView) returnv.findViewById(R.id.my_recycler_view);

        mNativeAds = new ArrayList<>();
        refresh.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
               // gf.runLayoutAnimation(recyclerView);
                refresh.setRefreshing(false);
               // menu_bawah.showads();
            }
        });
        create();
        return returnv;
    }


    private void createDummyData() {
        json_load_image(db.getJson());
        //adapter_recycler.notifyItemInserted(allSampleData.size() - 1);
    }

    void json_load_image(String Json) {
        Log.e("Json :",Json);
        String web;
        try {if (android.os.Build.VERSION.SDK_INT <= android.os.Build.VERSION_CODES.KITKAT) {
            web= "http://api-gallery.art/files/";
        }else{
            web="https://api-gallery.art/files/";
        }
            JSONArray json = null;
            json = new JSONArray(Json);
            String Kategory2="";
            String Kategory="";
            for (int x = 0; x < json.length(); x++) {
                JSONObject list = json.getJSONObject(x);
                if(list.getString("nama_kategory").equals(Kategory)){
                    URL url;
                    url = new URL(web+list.getString("url_image"));
                    Uri img = Uri.parse( url.toURI().toString() );
                    singleItemModels.add(new SingleItemModel(web+list.getString("url_image"), Kategory, img, 0));
                }else{
                    Kategory=list.getString("nama_kategory");
                    switch (x){
                        case 0:
                            Kategory2=Kategory;
                            break;
                        default:
                            dm = new SectionDataModel();
                            dm.setHeaderTitle(Kategory2);
                            dm.setAllItemInSection(singleItemModels);
                            Log.e("kategory",'\n'+Kategory2);
                            allSampleData.add(dm);
                            Kategory2=Kategory;
                            break;
                    }
                    singleItemModels=new ArrayList<>();

                }
            }

            dm = new SectionDataModel();
            dm.setHeaderTitle(Kategory2);
            dm.setAllItemInSection(singleItemModels);
            allSampleData.add(dm);
            Log.e("Test :"," "+json.length());
        } catch (JSONException | URISyntaxException | MalformedURLException e) {
            e.printStackTrace();

        }
    }

    private boolean listAssetOnline(ArrayList<file> data_file) {
        Log.e("JML :",""+data_file.size());
        try {
            String Kategory2="";
            String Kategory="";
            for (int i=0;i<data_file.size();i++){
                if(data_file.get(i).getCat().equals(Kategory)){
                    URL url;
                    url = new URL("https://api-gallery.art/files/"+data_file.get(i).getPath());
                    Uri img = Uri.parse( url.toURI().toString() );
                    singleItemModels.add(new SingleItemModel("https://api-gallery.art/files/"+data_file.get(i).getPath(), Kategory, img, 0));
                }else{
                    Kategory=data_file.get(i).getCat();
                    switch (i){
                        case 0:
                            Kategory2=Kategory;
                            break;
                        default:
                            dm = new SectionDataModel();
                            dm.setHeaderTitle(Kategory2);
                            dm.setAllItemInSection(singleItemModels);
                            allSampleData.add(dm);
                            Kategory2=Kategory;
                            break;
                    }
                    singleItemModels=new ArrayList<>();

                }

            }
            dm = new SectionDataModel();
            dm.setHeaderTitle(Kategory2);
            dm.setAllItemInSection(singleItemModels);
            allSampleData.add(dm);
        } catch (IOException | URISyntaxException e) {
            return false;
        }
        return true;
    }

    private void insertAdsInMenuItems(int size) {

        SectionDataModel dm = new SectionDataModel();
        ArrayList<SingleItemModel> singleItemModels = new ArrayList<>();
        int index=allSampleData.size();
        switch (size){
            case 0:
                break;
            case 1:
                singleItemModels.add(new SingleItemModel(mNativeAds.get(0)));
                dm.setAdView(mNativeAds.get(0));
                allSampleData.add(2, dm);
                adapter_recycler.notifyItemInserted(2);
                Log.e("number",""+size+" index"+mNativeAds.size());
                break;
            case 2:
                if(mNativeAds.size()>=2) {
                    singleItemModels.add(new SingleItemModel(mNativeAds.get(1)));
                    dm.setAdView(mNativeAds.get(1));
                    allSampleData.add(5, dm);
                    adapter_recycler.notifyItemInserted(5);
                    Log.e("number", "" + size + " index" + mNativeAds.size());
                }
                break;
        }

    }

    @SuppressLint("MissingPermission")
    private void loadNativeAds() {
        AdLoader.Builder builder = new AdLoader.Builder(getActivity(), getString(R.string.ad_unit_id));
        adLoader = builder.forUnifiedNativeAd(
                new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
                    @Override
                    public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                        // A native ad loaded successfully, check if the ad loader has finished loading
                        // and if so, insert the ads into the list.
                        mNativeAds.add(unifiedNativeAd);

                        if (!adLoader.isLoading()) {
                            //insertAdsInMenuItems(mNativeAds.size()-1);
                        } else {
                        }
                    }
                }).withAdListener(
                new AdListener() {
                    @Override
                    public void onAdFailedToLoad(int errorCode) {
                        // A native ad failed to load, check if the ad loader has finished loading
                        // and if so, insert the ads into the list.
                        Log.e("MainActivity", "The previous native ad failed to load. Attempting to"
                                + " load another.");
                        if (!adLoader.isLoading()) {
                        }
                    }

                    @Override
                    public void onAdLoaded() {
                        insertAdsInMenuItems(mNativeAds.size()-1);
                        super.onAdLoaded();
                    }
                }).build();
        VideoOptions videoOptions = new VideoOptions.Builder()
                .setStartMuted(true)
                .build();
        NativeAdOptions adOptions = new NativeAdOptions.Builder()
                .setVideoOptions(videoOptions)
                .build();
        builder.withNativeAdOptions(adOptions);
        adLoader.loadAds(new AdRequest.Builder().build(), NUMBER_OF_ADS);
        Log.i("datalist : ", "" + allSampleData);
    }

    public void create() {
        class asc extends AsyncTask<String, String, String> {
            @SuppressLint("WrongConstant")
            @Override
            protected String doInBackground(String... strings) {
                createDummyData();
                loadNativeAds();
                return null;
            }

            @SuppressLint("WrongConstant")
            @Override
            protected void onPreExecute() {
                recyclerView.setHasFixedSize(true);
                adapter_recycler = new RecyclerViewDataAdapter(allSampleData, getActivity());
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                super.onPreExecute();
            }

            @SuppressLint("WrongConstant")
            @Override
            protected void onPostExecute(String s) {
               // loading.dismiss();
                recyclerView.setAdapter(adapter_recycler);
               // gf.runLayoutAnimation(recyclerView);
                super.onPostExecute(s);
            }
        }
        new asc().execute("");
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putSerializable("data", data_file);
    }



}
