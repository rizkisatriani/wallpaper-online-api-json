package wallpaper.ux.com.wallpaperux.adapter;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import wallpaper.ux.com.wallpaperux.fragment.Gridfrag;
import wallpaper.ux.com.wallpaperux.fragment.Main;


import java.util.ArrayList;
import java.util.List;

public class Adapter_Pager_Slide_Menu extends FragmentPagerAdapter {
    Main bf1 ;
    Gridfrag bf3;

    public  List<Fragment> pages = new ArrayList<Fragment>();
    public Adapter_Pager_Slide_Menu(FragmentManager fm) {

        super(fm);
        bf1=new Main();
        bf3 = new Gridfrag();
        pages.add(bf1);
        pages.add(bf3);
    }

    @Override
    public Fragment getItem(int position) {

        return pages.get(position);
    }



    @Override
    public int getCount() {
        return pages.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String a="Galery";
        if(position==0){
            a= "TOP WALLPAPER";
        }   if(position==1){
            a= "GALERY";
        }  if(position==2){
            a= "BEST APPS";
        }  if(position==3){
            a= "Example";
        }
        return a;
    }
}
