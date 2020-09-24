package wallpaper.ux.com.wallpaperux.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import wallpaper.ux.com.wallpaperux.R;
import wallpaper.ux.com.wallpaperux.model.SingleItemModel;

/**
 * Created by MyUnity on 16/07/2018.
 */

public class adaptergrid extends BaseAdapter
{
    Context ct;
    int Pos;
    private LayoutInflater inflater;
    private ArrayList<SingleItemModel> itemModels;

    public adaptergrid(Context context , ArrayList<SingleItemModel> itemModels)
    {
        this.itemModels = itemModels;
        ct=context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {

        return itemModels.size();
    }

    @Override
    public Object getItem(int i)
    {
        return null;
    }

    @Override
    public long getItemId(int i)
    {
        return itemModels.size();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        View v = view;
        TextView name;
        if(v == null)
        {
            v = inflater.inflate(R.layout.row_grid, viewGroup, false);
            v.setTag(R.id.text, v.findViewById(R.id.text));
        }
        String path=itemModels.get(i).getName();
        ImageView imageview;
        name=v.findViewById(R.id.text);
        name.setText(itemModels.get(i).getDescription().replace("_"," "));
        imageview=(ImageView)v.findViewById(R.id.imageView10);
        Glide.with(ct).load( path).thumbnail(0.5f).skipMemoryCache(true).into(imageview);
        return v;
    }


}

