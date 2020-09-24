package wallpaper.ux.com.wallpaperux.adapter;

import android.content.Context;
import android.content.Intent;

import androidx.recyclerview.widget.RecyclerView;
import wallpaper.ux.com.wallpaperux.R;
import wallpaper.ux.com.wallpaperux.config.datapreff;
import wallpaper.ux.com.wallpaperux.fragment.Ads_inter;
import wallpaper.ux.com.wallpaperux.model.SingleItemModel;
import wallpaper.ux.com.wallpaperux.view.detil_image;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder>{

    private ArrayList<SingleItemModel> itemModels;
    private Context mContext;
    Ads_inter ads;
    datapreff db;
    public SectionListDataAdapter(ArrayList<SingleItemModel> itemModels, Context mContext) {
        this.itemModels = itemModels;
        this.mContext = mContext;
        ads=new Ads_inter(mContext);
        db=new datapreff(mContext);
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_single_card, null);
        SingleItemRowHolder singleItemRowHolder = new SingleItemRowHolder(v);
        return singleItemRowHolder;
    }

    @Override
    public void onBindViewHolder(final SingleItemRowHolder holder, int position) {
     final  SingleItemModel itemModel = itemModels.get(position);
        String path=itemModels.get(position).getName();
        final String pathuri=path;
        holder.itemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent a = new Intent (mContext, detil_image.class);
                a.putExtra("path", itemModel.getNumber());
                a.putExtra("pathuri", pathuri);
                a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                mContext.startActivity(a);
                ads.show_ads();
            }
        });
        //Log.e("Url",path);
            Glide.with(this.mContext).load(path)
                    .skipMemoryCache(true)
                    .thumbnail(0.5f).override(200, 200).into(holder.itemImage);
    }
    @Override
    public int getItemCount() {
        return (null != itemModels ? 6 : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView tvTitle;
        protected ImageView itemImage;
        public SingleItemRowHolder(View itemView) {
            super(itemView);
            this.tvTitle = itemView.findViewById(R.id.itemTitle);
            this.itemImage = itemView.findViewById(R.id.itemImage);
        }
    }

}
