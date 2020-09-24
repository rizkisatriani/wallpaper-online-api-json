package wallpaper.ux.com.wallpaperux.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcelable;

import java.util.ArrayList;

import wallpaper.ux.com.wallpaperux.model.SingleItemModel;

public class datapreff {

    public static SharedPreferences data;
    public static SharedPreferences.Editor editor;
public datapreff(Context context){
    data=context.getSharedPreferences("PREFS", Context.MODE_PRIVATE);
    editor=data.edit();
}
public Parcelable singleItemModels;
    public int img,interstitial;
    public String json;
 // public ArrayList<SingleItemModel> singleItemModels;
    public static SharedPreferences getData() {
        return data;
    }

    public static void setData(SharedPreferences data) {
        datapreff.data = data;
    }


    public static SharedPreferences.Editor getEditor() {
        return editor;
    }

    public static void setEditor(SharedPreferences.Editor editor) {
        datapreff.editor = editor;
    }

    public int getImg() {
        img = data.getInt("img", 0);
        return img;
    }

    public void setImg(int img) {
        editor.putInt("img", img);
        editor.apply();
        this.img = img;
    }

    public int getInterstitial() {
        interstitial = data.getInt("interstitial", 0);
        return interstitial;
    }

    public void setInterstitial(int interstitial) {
        editor.putInt("interstitial", interstitial);
        editor.apply();
        this.interstitial = interstitial;
    }

    public String getJson() {
        json = data.getString("json", "");
        return json;
    }

    public void setJson(String json) {
        editor.putString("json", json);
        editor.apply();
        this.json = json;
    }
}
