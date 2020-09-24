package wallpaper.ux.com.wallpaperux.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.core.widget.ImageViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import wallpaper.ux.com.wallpaperux.R;
import wallpaper.ux.com.wallpaperux.model.singgle_pager_view;

public class ViewPagerAdapter extends PagerAdapter {
    ArrayList<singgle_pager_view>  data;
    singgle_pager_view v;
    LayoutInflater inflater;
    Context context;

    public ViewPagerAdapter(Context mainActivity,ArrayList<singgle_pager_view>  data ) {
        this.context = mainActivity;
        v=new singgle_pager_view();
        this.data=data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        ImageView img;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemview = inflater.inflate(R.layout.item_view_pager, container, false);
        img = (ImageView) itemview.findViewById(R.id.ima1);
        img.setImageResource(data.get(position).getGambar());
        TextView nama,des;
        nama =   itemview.findViewById(R.id.judul);
        des =   itemview.findViewById(R.id.desc);
        nama.setText(data.get(position).getNama_app());
        des.setText(data.get(position).getDeskripsi());
        ((ViewPager) container).addView(itemview);
//        itemview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                context.startActivity(new Intent(Intent.ACTION_VIEW,
//                        Uri.parse("market://details?id="
//                                + data.get(position).getUrl())));
//            }
//        });
        return itemview;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((RelativeLayout) object);
    }

    @Override
    public float getPageWidth(int position) {
        return 1f;   //it is used for set page widht of view pager
    }
}
