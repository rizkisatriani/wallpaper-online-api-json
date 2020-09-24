package wallpaper.ux.com.wallpaperux.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import wallpaper.ux.com.wallpaperux.R;
import wallpaper.ux.com.wallpaperux.config.Globe_Function;
import wallpaper.ux.com.wallpaperux.config.datapreff;
import wallpaper.ux.com.wallpaperux.fragment.Ads_inter;

import android.Manifest;
import android.app.WallpaperManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class detil_image extends AppCompatActivity {
    ImageView  image_center;
    datapreff db;
    ScrollView sv;
    LinearLayout ly;
    Globe_Function gf;
    ImageView btn_back;
    String path;
    CardView btn_set, btn_download,btn_apps,btn_rate;
    WallpaperManager wallpaperManager;
    Ads_inter ads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detil_image);
        AdView adView = (AdView) findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        db = new datapreff(this);
        ads=new Ads_inter(this);
        image_center = findViewById(R.id.itemImage);
        Glide.with(this).load(getIntent().getStringExtra("pathuri")).into(image_center);
        sv = findViewById(R.id.scrolview);
        ly = findViewById(R.id.child);
        btn_back = findViewById(R.id.btn_back);
        gf = new Globe_Function();
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        wallpaperManager = WallpaperManager.getInstance(this);
        btn_set = findViewById(R.id.btn_set);
        btn_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ads.show_ads();
                Intent i=new Intent(detil_image.this,SetAs.class);
                i.putExtra("path",getIntent().getStringExtra("pathuri"));
                startActivity(i);
            }
        });
        btn_download = findViewById(R.id.btn_download);
        btn_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                path=getIntent().getStringExtra("pathuri");
                try {
                    getBitmapFromURL(path);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
        btn_apps=findViewById(R.id.btn_apps);
        btn_apps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://play.google.com/store/apps/developer?id=DEV+SUKA+MAJU"));
                startActivity(i);
            }
        });
        btn_rate=findViewById(R.id.btn_rate);
        btn_rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("market://details?id="
                                +  getPackageName())));
            }
        });
        permision();
    }

    void download(Bitmap bm){
                //  Bitmap bm = BitmapFactory.decodeResource(getResources(), item.getitem().get(posisi));
                String path1 = Environment.getExternalStorageDirectory().toString();
                File myDir = new File(path1 + "/DCIM/HD Wallpaper");
                myDir.mkdirs();
                File file = new File(myDir, myDir.list().length + ".jpg");
                try {
                    OutputStream stream = new FileOutputStream(file);
                    bm.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                    stream.flush();
                    stream.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                Intent a = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                Uri uri = Uri.fromFile(file);
                a.setData(uri);
                sendBroadcast(a);
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setType("image/*");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                ads.show_ads();
            }

    void permision(){
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED&&ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)||ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
                DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    onBackPressed();
                    }
                };
                DialogInterface.OnClickListener listener2=new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ActivityCompat.requestPermissions(detil_image.this,
                                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},
                                1);
                    }
                };
                gf.alert_dialog_tanya_jawab("<b>Request Permission (Permintaan Izin)</b>","</br></br><p  style='color:#7f8c8d; text-align:justify;'>" +
                        "We Ask For Permission To Read Your Hp Memory For,Write And Read Media Like Image, Media and Provide</p> " +
                        "</br></br> <p  style='color:#7f8c8d; text-align:justify;'>(Kami Meminta Izin Untuk Membaca Memori Hp Anda Untuk, Menulis dan Membaca Gambar Media Dan Provide)</p>",listener2,listener,detil_image.this);
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},
                        1);
            }
        } else {

        }
    }

    public  void getBitmapFromURL(String src) throws MalformedURLException {
        final Bitmap[] myBitmap = new Bitmap[1];
        final URL url = new URL(src);
        class GetJSON extends AsyncTask<String, Integer, String> {
            @Override
            protected void onPreExecute() {

            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                download(myBitmap[0]);
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
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    onBackPressed();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }
}
