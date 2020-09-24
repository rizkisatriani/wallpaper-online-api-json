package wallpaper.ux.com.wallpaperux.fragment;


import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import wallpaper.ux.com.wallpaperux.R;
import wallpaper.ux.com.wallpaperux.adapter.adaptergrid;
import wallpaper.ux.com.wallpaperux.config.Globe_Function;
import wallpaper.ux.com.wallpaperux.config.datapreff;
import wallpaper.ux.com.wallpaperux.model.SectionDataModel;
import wallpaper.ux.com.wallpaperux.model.SingleItemModel;
import wallpaper.ux.com.wallpaperux.model.file;
import wallpaper.ux.com.wallpaperux.view.detil_image;
import wallpaper.ux.com.wallpaperux.view.menu_bawah;

/**
 * A simple {@link Fragment} subclass.
 */
public class Gridfrag extends Fragment {


    public Gridfrag() {
        // Required empty public constructor
    }

    Globe_Function gf;
    ArrayList<SingleItemModel> singleItemModels;
    public AssetManager as;

    datapreff db;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View returnv= inflater.inflate(R.layout.fragment_gridfrag, container, false);
        as = returnv.getResources().getAssets();
        gf=new Globe_Function();
        db=new datapreff(getActivity());
        singleItemModels=new ArrayList<>();
        json_load_image(db.getJson());
        GridView gridb=(GridView) returnv.findViewById(R.id.grid2);
        gridb.setAdapter(new adaptergrid(getActivity(), singleItemModels));
        gridb.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final  SingleItemModel itemModel = singleItemModels.get(i);
                Intent a = new Intent (getActivity(), detil_image.class);
                a.putExtra("path", itemModel.getNumber());
                a.putExtra("pathuri", singleItemModels.get(i).getName());
                a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(a);
                 menu_bawah.showads();
            }
        });
        return returnv;
    }

    void json_load_image(String Json) {
        String web; if (android.os.Build.VERSION.SDK_INT <= android.os.Build.VERSION_CODES.KITKAT) {
            web= "http://api-gallery.art/files/";
        }else{
            web="https://api-gallery.art/files/";
        }
        try {
            JSONArray json = null;
            json = new JSONArray(Json);
            String Kategory="";
            singleItemModels=new ArrayList<>();
            for (int x = 0; x < json.length(); x++) {
                JSONObject list = json.getJSONObject(x);
                    URL url;
                    url = new URL(web+list.getString("url_image"));
                    Uri img = Uri.parse(url.toURI().toString());
                    singleItemModels.add(new SingleItemModel(web+list.getString("url_image"), Kategory, img, 0));
            }

        } catch (JSONException | URISyntaxException | MalformedURLException e) {
            e.printStackTrace();

        }
    }
}


