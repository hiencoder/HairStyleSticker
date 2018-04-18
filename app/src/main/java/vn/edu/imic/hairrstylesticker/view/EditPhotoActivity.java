package vn.edu.imic.hairrstylesticker.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import vn.edu.imic.hairrstylesticker.R;
import vn.edu.imic.hairrstylesticker.utils.Const;
import vn.edu.imic.hairrstylesticker.utils.Logger;

public class EditPhotoActivity extends AppCompatActivity {
    private static final String TAG = EditPhotoActivity.class.getSimpleName();
    private Intent data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_photo);
        data = getIntent();
        String pathPhoto = data.getStringExtra(Const.KEY_PATH_PHOTO);
        Logger.d(TAG, pathPhoto);
    }
}
