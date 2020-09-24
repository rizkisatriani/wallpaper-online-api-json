package wallpaper.ux.com.wallpaperux.view;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import lib.cropper.wallpaper.CropImageView;
import wallpaper.ux.com.wallpaperux.R;
import wallpaper.ux.com.wallpaperux.config.BlurTransformation;
import wallpaper.ux.com.wallpaperux.config.Connection;
import wallpaper.ux.com.wallpaperux.config.datapreff;
import wallpaper.ux.com.wallpaperux.config.var_global;

public class SetAs extends AppCompatActivity {
    CropImageView mCropImageView;
    private ProgressDialog pDialog;
    String path;
    ImageView background;
    private InterstitialAd interstitial;

    datapreff db;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_as);
        // Load ads into Interstitial Ads

        db = new datapreff(this);
        background = findViewById(R.id.img_back);
        path = getIntent().getStringExtra("path");
        Glide.with(this).load(path).bitmapTransform(new BlurTransformation(this)).into(background);
        AdView adView = (AdView) findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        mCropImageView = (CropImageView) findViewById(R.id.CropImageView);
        Bitmap bm = null;
        try {
            bm =getBitmapFromURL(path);
        } catch (MalformedURLException e) {e.printStackTrace();

        }
        interstitial = new InterstitialAd(SetAs.this);
        interstitial.setAdUnitId(getResources().getString(R.string.inter));
        interstitial.loadAd(new AdRequest.Builder().build());
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
                // Call displayInterstitial() function
                // If Ads are loaded, show Interstitial else show nothing.
                //pDialog.dismiss();
            }

            @Override
            public void onAdClosed() {
                Intent intent = new Intent(SetAs.this, MainActivity.class);
                intent.putExtra("ads_view","1");
                startActivity(intent);

                //menutup layar activity
                finish();
                super.onAdClosed();
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
            }
        });

        pDialog = new ProgressDialog(SetAs.this,R.style.AppCompatAlertDialogStyle);
        pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pDialog.setMessage("Wallpaer set ...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
    }

    public void setAsWallpaper(View view) throws IOException {
        pDialog.show();
         new SetWallpaperTask().execute("");
    }

    public class SetWallpaperTask extends AsyncTask<String, String, String> {
        Bitmap bmImg = null;


        public SetWallpaperTask( ) {
        }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(String... args) {
            // TODO Auto-generated method stub
            bmImg = mCropImageView.getCroppedImage();
            WallpaperManager wpm = WallpaperManager.getInstance(getApplicationContext()); // --The method context() is undefined for the type SetWallpaperTask
            try {
                wpm.setBitmap(bmImg);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }


        @Override
        protected void onPostExecute(String args) {
            // TODO Auto-generated method stub
            int click =db.getInterstitial();
            if (interstitial.isLoaded() &&click!=0) {
                interstitial.show();
            }else{
                Intent intent = new Intent(SetAs.this, MainActivity.class);

                intent.putExtra("ads_view","1");
                startActivity(intent);

                //menutup layar activity
                finish();
            }
           final Handler handler= new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    pDialog.dismiss();
                    handler.removeCallbacks(this);
                }
            },300);

        }
    }
void set_image(Bitmap bm){
    mCropImageView.setImageBitmap( bm);

}

    public  Bitmap getBitmapFromURL(String src) throws MalformedURLException {
        final Bitmap[] myBitmap = new Bitmap[1];
        final URL url = new URL(src);
        class GetJSON extends AsyncTask<String, Integer, String> {
            @Override
            protected void onPreExecute() {

            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                set_image(myBitmap[0]);
            }

            @Override
            protected String doInBackground(String... params) {
                try {
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setDoInput(true);
                    connection.connect();
                    InputStream input = connection.getInputStream();
                    myBitmap[0] = BitmapFactory.decodeStream(input);

                } catch (IOException e) {
                    // Log exception
                    return null;
                }
                return null;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
        return myBitmap[0];
    }

}
