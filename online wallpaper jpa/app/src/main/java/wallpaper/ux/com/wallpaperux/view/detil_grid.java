package wallpaper.ux.com.wallpaperux.view;

import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
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
import java.util.HashMap;

import wallpaper.ux.com.wallpaperux.R;
import wallpaper.ux.com.wallpaperux.adapter.adaptergrid;
import wallpaper.ux.com.wallpaperux.config.Connection;
import wallpaper.ux.com.wallpaperux.config.Globe_Function;
import wallpaper.ux.com.wallpaperux.config.datapreff;
import wallpaper.ux.com.wallpaperux.config.var_global;
import wallpaper.ux.com.wallpaperux.fragment.Ads_inter;
import wallpaper.ux.com.wallpaperux.model.SingleItemModel;

public class detil_grid extends AppCompatActivity {

    Globe_Function gf;
    ArrayList<SingleItemModel> singleItemModels;
    public AssetManager as;
    String folder;
    Ads_inter ads;
    GridView gridb;
    datapreff db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detil_grid);
        folder=getIntent().getStringExtra("folder");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(folder.replace("_"," "));
        setSupportActionBar(toolbar);
        as = getResources().getAssets();
        gf=new Globe_Function();
        db=new datapreff( this);
        ads=new Ads_inter(this);
        singleItemModels=new ArrayList<>();
        json_load_image(db.getJson());
        gridb=(GridView) findViewById(R.id.grid2);
        gridb.setAdapter(new adaptergrid(this, singleItemModels));
        gridb.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final  SingleItemModel itemModel = singleItemModels.get(i);
                Intent a = new Intent (detil_grid.this, detil_image.class);
                a.putExtra("path", itemModel.getNumber());
                a.putExtra("pathuri", singleItemModels.get(i).getName());
                a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(a);
                 ads.show_ads();
            }
        });
    }

    private void listAssetFiles(String path, String Cat) {
        String[] list;
        try {
            list = as.list(path);
            if (list.length > 0) {
                for (String file : list) {
                        Uri img = Uri.fromFile(new File(path + "/" + file));
                        singleItemModels.add(new SingleItemModel(file,Cat,img, 0));
                }
            }
        } catch (IOException e) {
            gf.alert_dialog("Konfirmasi","Telah Terjadi Kesalahan dan tim sedang berusaha memperbaiki, mohon bersabar.",detil_grid.this);
        }
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
            for (int x = 0; x < json.length(); x++) {
                JSONObject list = json.getJSONObject(x);
                Log.e("JSON :",folder+"|"+list.getString("nama_kategory"));
                if(list.getString("nama_kategory").equals(folder)) {
                    URL url;
                    url = new URL(web+list.getString("url_image"));
                    Uri img = Uri.parse( url.toURI().toString() );
                    singleItemModels.add(new SingleItemModel(web+list.getString("url_image"), Kategory, img, 0));
                }
            }
        } catch (JSONException | URISyntaxException | MalformedURLException e) {
            e.printStackTrace();

        }
    }

}
