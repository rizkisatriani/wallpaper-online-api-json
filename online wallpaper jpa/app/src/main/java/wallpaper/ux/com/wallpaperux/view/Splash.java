package wallpaper.ux.com.wallpaperux.view;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

import wallpaper.ux.com.wallpaperux.R;
import wallpaper.ux.com.wallpaperux.config.Connection;
import wallpaper.ux.com.wallpaperux.config.Globe_Function;
import wallpaper.ux.com.wallpaperux.config.datapreff;
import wallpaper.ux.com.wallpaperux.config.var_global;
import wallpaper.ux.com.wallpaperux.model.file;

public class Splash extends AppCompatActivity {
    public CheckBox cb;
    public boolean setuju;
    public TextView priv,progres;
    Globe_Function fg=new Globe_Function();
    datapreff db;
     Handler handler;
     Runnable update;
    ProgressBar progressBar;
    ArrayList<file> files;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        progressBar=findViewById(R.id.progressBar);
        progres=findViewById(R.id.progres);
        files=new ArrayList<>();
        cb=(CheckBox) findViewById(R.id.checkBox);
        setuju=cb.isChecked();
        db = new datapreff(this);
        db.setInterstitial(0);
        priv=(TextView) findViewById(R.id.textView12);
         handler = new Handler();
         update = new Runnable() {
            @Override
            public void run() { Intent intent = new Intent(Splash.this, MainActivity.class);
              // Intent intent = new Intent(Splash.this, menu_bawah.class);
                intent.putExtra("ads_view","0");
                intent.putExtra("data",files);
                startActivity(intent);
                //menutup layar activity
                finish();
            }
        };
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(cb.isChecked()){

                }
                else{
                }
            }
        });
        priv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        download_asset();
    }


    void download_asset() {
        class GetJSON extends AsyncTask<String, Integer, String> {
            String Url;

            @Override
            protected void onPreExecute() {
                if (android.os.Build.VERSION.SDK_INT <= android.os.Build.VERSION_CODES.KITKAT) {
                    Url=var_global.SET_API_KITKAT_APP;
                }else{
                    Url=var_global.SET_API_APP;
                }super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                progressBar.setProgress(98);
                progres.setText(""+98+"%");
                handler.postDelayed(update,500);
            }

            @Override
            protected String doInBackground(String... params) {
                HashMap<String, String> param = new HashMap<String, String>();
                Connection rh = new Connection();
                Log.e("URL :",Url );
                publishProgress((int) (30));
                String s = rh.sendPostRequest(Url, param);
                publishProgress((int) (50));
                Log.e("URL :",s );
               db.setJson(s);
                return null;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                progressBar.setIndeterminate(false);
                progressBar.setMax(100);
                progressBar.setProgress(values[0]);
                progres.setText(""+values[0]+"%");
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }


}
