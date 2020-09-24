package wallpaper.ux.com.wallpaperux.model;

import android.os.Parcelable;

import java.io.Serializable;

public class file implements Serializable {
    String Path,Cat,Url;

    public file(String path, String cat) {
        Path = path;
        Cat = cat;
    }

    public file(String path, String cat, String url) {
        Path = path;
        Cat = cat;
        Url = url;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }

    public String getCat() {
        return Cat;
    }

    public void setCat(String cat) {
        Cat = cat;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
