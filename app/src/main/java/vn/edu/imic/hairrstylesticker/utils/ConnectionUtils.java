package vn.edu.imic.hairrstylesticker.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by MyPC on 07/05/2018.
 */

public class ConnectionUtils {
    public static boolean checkConnection(Context context){
        boolean z = false;
        boolean z2 = false;
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInfo = manager.getAllNetworkInfo();
        for (NetworkInfo info: networkInfo){
           if (info.getTypeName().equalsIgnoreCase("WIFI") && info.isConnected()){
               //Nếu là wifi
               z = true;
           }
           if (info.getTypeName().equalsIgnoreCase("MOBILE") && info.isConnected()){
               z2 = true;
           }
        }
        return z || z2;
    }
}
