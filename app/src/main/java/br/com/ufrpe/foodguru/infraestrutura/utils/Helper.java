package br.com.ufrpe.foodguru.infraestrutura.utils;

import android.app.ProgressDialog;
import android.app.Service;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {

    public static void criarToast(Context context, String texto){
        Toast.makeText(context, texto, Toast.LENGTH_SHORT).show();
    }

    public static boolean verificaExpressaoRegularEmail(String email) {

        if (!email.isEmpty()) {
            String excecoes = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$";
            Pattern pattern = Pattern.compile(excecoes);
            Matcher matcher = pattern.matcher(email);

            return matcher.matches();
        }
        return false;
    }
    public static boolean isConected(Context context){
        ConnectivityManager connectivity = (ConnectivityManager)
                context.getSystemService(Service.CONNECTIVITY_SERVICE);
        if (connectivity != null){
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null){
                return info.getState() == NetworkInfo.State.CONNECTED;
            }
        }
        return false;
    }
    public static Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

}
