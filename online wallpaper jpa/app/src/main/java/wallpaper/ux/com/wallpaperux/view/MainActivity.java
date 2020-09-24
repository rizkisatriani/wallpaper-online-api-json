package wallpaper.ux.com.wallpaperux.view;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.os.Handler;
import android.view.View;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import wallpaper.ux.com.wallpaperux.R;
import wallpaper.ux.com.wallpaperux.adapter.Adapter_Pager_Slide_Menu;
import wallpaper.ux.com.wallpaperux.config.Globe_Function;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    ViewPager viewpager_main;
    FrameLayout btn_ads;
    Globe_Function gf;
    FragmentManager fm = getSupportFragmentManager();
    boolean doubleBackToExitPressedOnce = false;
    String ads_view="0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btn_ads=findViewById(R.id.btn_ads);
        ads_view = getIntent().getStringExtra("ads_view");
        gf=new Globe_Function();
        viewpager_main = (ViewPager) findViewById(R.id.viewpager_main);
        viewpager_main.setAdapter(new Adapter_Pager_Slide_Menu(fm));
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewpager_main);
        if(ads_view.equals("1")){
            gf.alert_dialog("Selamat","Wallpaper Telah Terpasang",MainActivity.this);
        }
        btn_ads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://play.google.com/store/apps/developer?id=DEV+SUKA+MAJU"));
                startActivity(i);
            }
        });

    }



    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }




}
