package wallpaper.ux.com.wallpaperux.view;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import wallpaper.ux.com.wallpaperux.fragment.Ads_inter;
import wallpaper.ux.com.wallpaperux.fragment.Main;
import wallpaper.ux.com.wallpaperux.fragment.Gridfrag;

import wallpaper.ux.com.wallpaperux.R;

public class menu_bawah extends AppCompatActivity {
    boolean doubleBackToExitPressedOnce = false;
    Fragment home;
    Fragment dasboard;
     static Ads_inter ads;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    if(home.isAdded()){
                        ft.replace(R.id.frame,home);
                        ft.addToBackStack(null);
                        ft.commit();
                    }else{
                        ft.add(R.id.frame,home);
                        ft.commit();
                    }

                    return true;
                case R.id.navigation_dashboard:
                    ft = getSupportFragmentManager().beginTransaction();
                    if(dasboard.isAdded()){
                        ft.replace(R.id.frame,dasboard);
                        ft.addToBackStack(null);
                        ft.commit();
                    }else{
                        ft.add(R.id.frame,dasboard);
                        ft.commit();
                    }
                    return true;

            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_bawah);
        home=new Main();
        dasboard=new Gridfrag();
         ads=new Ads_inter(menu_bawah.this);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if(home.isAdded()){
            ft.replace(R.id.frame,home);
            ft.addToBackStack(null);
            ft.commit();
        }else{
            ft.add(R.id.frame,home);
            ft.commit();
        }
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            finish();
            System.exit(0);
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Klik Sekali Lagi Untuk Keluar", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
    public static void showads(){
         ads.show_ads();
    }
}