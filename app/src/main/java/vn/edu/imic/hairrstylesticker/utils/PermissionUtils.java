package vn.edu.imic.hairrstylesticker.utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.support.v4.app.ActivityCompat;

/**
 * Created by MyPC on 17/04/2018.
 */

public class PermissionUtils {
    public static boolean isPermissionCameraGranted(Context context){
        if (VERSION.SDK_INT >= 23
                && ActivityCompat.checkSelfPermission(context,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){

            return false;
        }
        return true;
    }

    public static boolean isPermissionExternalStorageGranted(Context context){
        if (VERSION.SDK_INT >= 23
                && ActivityCompat.checkSelfPermission(context,
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            return false;
        }
        return true;
    }

    //public static boolean isPermission
}
