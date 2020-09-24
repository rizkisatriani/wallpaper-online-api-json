package wallpaper.ux.com.wallpaperux.model;

import java.util.ArrayList;

import wallpaper.ux.com.wallpaperux.R;

public class singgle_pager_view {
    int gambar,icon;
    String nama_app,deskripsi,url;
    ArrayList<singgle_pager_view> data;

    public singgle_pager_view() {
    }

    public singgle_pager_view(int gambar, int icon, String nama_app, String deskripsi, String url) {
        this.gambar = gambar;
        this.icon = icon;
        this.nama_app = nama_app;
        this.deskripsi = deskripsi;
        this.url = url;
    }

    public singgle_pager_view(int gambar, int icon, String nama_app, String deskripsi, String url, ArrayList<singgle_pager_view> data) {
        this.gambar = gambar;
        this.icon = icon;
        this.nama_app = nama_app;
        this.deskripsi = deskripsi;
        this.url = url;
        this.data = data;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public String getNama_app() {
        return nama_app;
    }

    public void setNama_app(String nama_app) {
        this.nama_app = nama_app;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArrayList<singgle_pager_view> getData() {
        return data;
    }

    public void setData(ArrayList<singgle_pager_view> data) {
        this.data = data;
    }

    public   ArrayList<singgle_pager_view> getdata_app(){
        data=new ArrayList<>();
       /* data.add(new singgle_pager_view(R.drawable.thumb_1,R.drawable.app1
                ,"Ambyar Koplo Mp3 Player"
                ,"Pemutar Music Masa Kini"
                ,"lokal.property.coffe.id.kost.com.mp3_player"))*/
        return data;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
