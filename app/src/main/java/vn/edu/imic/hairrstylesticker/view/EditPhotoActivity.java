package vn.edu.imic.hairrstylesticker.view;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import vn.edu.imic.hairrstylesticker.R;

public class EditPhotoActivity extends AppCompatActivity {
    private static final String TAG = EditPhotoActivity.class.getSimpleName();
    private Intent intent;
    private Uri uri;
    /*Crop image result*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_photo);
        intent = getIntent();
        uri = intent.getData();
        Log.d(TAG, "onCreate: " + uri.toString());

        /*Init data*/
        initData();
    }

    /*init data*/
    private void initData() {

    }
}
