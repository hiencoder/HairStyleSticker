package vn.edu.imic.hairrstylesticker.utils;

import android.graphics.Bitmap;

/**
 * Created by GMO on 4/19/2018.
 */

public class BitmapUtils {
    /*Hàm resize bitmap*/
    public static Bitmap resizeBitmapSquare(Bitmap srcBitmap){
        Bitmap desBitmap = null;
        if (srcBitmap.getWidth() >= srcBitmap.getHeight()){
            desBitmap = Bitmap.createBitmap(srcBitmap,
                    srcBitmap.getWidth()/2 - srcBitmap.getHeight(),
                    0,
                    srcBitmap.getHeight(),
                    srcBitmap.getHeight());
        }else {
            desBitmap = Bitmap.createBitmap(srcBitmap,
                    0,
                    srcBitmap.getHeight()/2 - srcBitmap.getWidth()/2,
                    srcBitmap.getWidth(),
                    srcBitmap.getWidth());
        }
        return desBitmap;
    }
}
