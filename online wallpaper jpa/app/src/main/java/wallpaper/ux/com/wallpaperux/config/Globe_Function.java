package wallpaper.ux.com.wallpaperux.config;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.Html;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import androidx.recyclerview.widget.RecyclerView;
import wallpaper.ux.com.wallpaperux.R;

public class Globe_Function {
    Context context;
    private SimpleDateFormat dateFormatter;
    private SimpleDateFormat postFormatter;
    DecimalFormatSymbols symbols;
    DecimalFormat decimalFormat;
    ProgressDialog loading;
    public Globe_Function(Context context) {
        this.context = context;
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        postFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

        symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(',');
        symbols.setDecimalSeparator('.');
        decimalFormat = new DecimalFormat("#,###.##", symbols);
    }

    public Globe_Function() {
    }
    public void runLayoutAnimation(final RecyclerView recyclerView) {
        final Context context = recyclerView.getContext();
        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down);

        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }
    public int getsize_screen() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        display.getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        return width;
    }

    public boolean HorizontalScrollViewIsScrolble(HorizontalScrollView view, LinearLayout layoutchild) {
        HorizontalScrollView scrollView = view;
        int childHeight = layoutchild.getWidth();
        boolean isScrollable = scrollView.getWidth() < childHeight + scrollView.getPaddingLeft() + scrollView.getPaddingRight();
        return isScrollable;
    }

    public int StringToColor(String color) {
        int myColor = Color.parseColor(color);
        return myColor;
    }

    public int getPixel(float dp) {
        float dpValue = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                context.getResources().getDisplayMetrics());
        /*  reference dpi other

    DisplayMetrics metrics = getResources().getDisplayMetrics();
    float witdh = 150f;
    float wpixels = metrics.density * witdh;
    int w_pixels = (int) (wpixels + 0.5f);
    float height = 30f;
    float hpixels = metrics.density * height;
    int h_pixels = (int) (hpixels + 0.5f);*/
        return (int) dpValue;
    }

    public String DateSqltoDisplay(String date) {
        Date tgl = null;
        try {
            tgl = new SimpleDateFormat("yyyy-MM-dd").parse(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        String result=""+dateFormatter.format(tgl);
        return result;
    }

    public String DateDisplayToSql(String date) {
        Date tgl = null;
        try {
            tgl = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String result=""+postFormatter.format(tgl);
        return result;
    }

    public SimpleDateFormat getDateFormatter() {
        return dateFormatter;
    }

    public SimpleDateFormat getPostFormatter() {
        return postFormatter;
    }

    public void alert_dialog(String Judul, String Pesan,Context context) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle(Judul);
        alertDialogBuilder
                .setMessage(Html.fromHtml(Pesan))
                .setCancelable(false)
                .setNegativeButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void alert_dialog_tanya(String Judul, String Pesan,DialogInterface.OnClickListener listener) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle(Html.fromHtml("<b>"+Judul+"</b>"));
        alertDialogBuilder
                .setMessage(Html.fromHtml(Pesan))
                .setCancelable(false)
                .setPositiveButton("Ya",
                        listener).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    public void alert_dialog_tanya_jawab(String Judul, String Pesan, DialogInterface.OnClickListener listener,
                                         DialogInterface.OnClickListener listener2, final Context context) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle(Html.fromHtml(Judul));
        alertDialogBuilder
                .setMessage(Html.fromHtml(Pesan))
                .setCancelable(false)
                .setPositiveButton("Oke",
                        listener).setNegativeButton("Cancel",listener2) ;
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                Button negativeButton = ((AlertDialog)dialog).getButton(DialogInterface.BUTTON_NEGATIVE);
                negativeButton.setTextColor(context.getResources().getColor(R.color.colorPrimary));
                Button positiveButton = ((AlertDialog)dialog).getButton(DialogInterface.BUTTON_POSITIVE);
                positiveButton.setTextColor(context.getResources().getColor(R.color.colorPrimary));

            }
        });
        alertDialog.show();
    }
    public void alert_dialog_tanya_paksa(String Judul, String Pesan,DialogInterface.OnClickListener listener) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle(Html.fromHtml("<b>"+Judul+"</b>"));
        alertDialogBuilder
                .setMessage(Html.fromHtml(Pesan))
                .setCancelable(false)
                .setPositiveButton("Ya",
                        listener) ;
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    public void alert_dialog_2_listerner(String Judul, String Pesan,DialogInterface.OnClickListener listenerYA,DialogInterface.OnClickListener listenerTIDAK) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle(Html.fromHtml("<b>"+Judul+"</b>"));
        alertDialogBuilder
                .setMessage(Html.fromHtml(Pesan))
                .setCancelable(false)
                .setPositiveButton("Ya",
                        listenerYA)
                .setNegativeButton("Tidak",
                        listenerTIDAK) ;
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    public  String Curency(String value){

        String result=""+decimalFormat.format(Double.valueOf(value));
        return result;
    }

    /*deki*/
    public void alert_notif(String Judul, String Pesan,DialogInterface.OnClickListener listener) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle(Html.fromHtml("<b>"+Judul+"</b>"));
        alertDialogBuilder
                .setMessage(Html.fromHtml(Pesan))
                .setCancelable(false)
                .setPositiveButton("Ok",listener);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    /*deki*/

    /*toni*/
    public void loading_show(){
        if(loading==null)loading = new ProgressDialog(context);
        if(loading.isShowing()) loading.dismiss();
        loading.setMessage("Silahkan tunggu...");
        loading.setCancelable(false);
        loading.setCanceledOnTouchOutside(false);
        loading.show();

    }
    public void loading_dismiss(){
        if(loading!=null)if(loading.isShowing()) loading.dismiss();
    }
    /*toni*/

    //Pembulatan Ikwan
    public float pembulatan(String angka){
        if(angka.equals("null")){
            angka = "0";
        }
        float doubleNumber = Float.parseFloat(angka);
        int intPart = (int) doubleNumber;
        String strintpart = String.valueOf(intPart);
        float total_harga=0;
        float replace_angka = Float.parseFloat(strintpart);
        if(strintpart.length() == 4){
            float pengurang = Float.parseFloat(strintpart.substring(strintpart.length()-2));
            total_harga = (replace_angka - pengurang);
        }else if(strintpart.length() == 5){
            float pengurang = Float.parseFloat(strintpart.substring(strintpart.length()-3));
            total_harga = (replace_angka - pengurang);
        }else if(strintpart.length() == 6){
            float pengurang = Float.parseFloat(strintpart.substring(strintpart.length()-3));
            total_harga = (replace_angka - pengurang);
        }else if(strintpart.length() == 7){
            float pengurang = Float.parseFloat(strintpart.substring(strintpart.length()-4));
            total_harga = (replace_angka - pengurang);
        }else if(strintpart.length() == 8){
            float pengurang = Float.parseFloat(strintpart.substring(strintpart.length()-5));
            total_harga = (replace_angka - pengurang);
        }else if(strintpart.length() == 9){
            float pengurang = Float.parseFloat(strintpart.substring(strintpart.length()-5));
            total_harga = (replace_angka - pengurang);
        }else if(strintpart.length() == 10){
            float pengurang = Float.parseFloat(strintpart.substring(strintpart.length()-5));
            total_harga = (replace_angka - pengurang);
        }else if(strintpart.length() == 11){
            float pengurang = Float.parseFloat(strintpart.substring(strintpart.length()-6));
            total_harga = (replace_angka - pengurang);
        }
        return total_harga;
    }

    //Dialog Ikwan
    public void alert_dialog_scan(String Judul, String Pesan, DialogInterface.OnClickListener listener, DialogInterface.OnClickListener listener2) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle(Html.fromHtml("<b>"+Judul+"</b>"));
        alertDialogBuilder
                .setMessage(Html.fromHtml(Pesan))
                .setCancelable(false)
                .setPositiveButton("Ya",listener).setNegativeButton("Tidak", listener2);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
