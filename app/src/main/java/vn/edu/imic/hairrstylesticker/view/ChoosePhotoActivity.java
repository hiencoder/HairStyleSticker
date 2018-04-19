package vn.edu.imic.hairrstylesticker.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import vn.edu.imic.hairrstylesticker.R;
import vn.edu.imic.hairrstylesticker.utils.Const;
import vn.edu.imic.hairrstylesticker.utils.Logger;

public class ChoosePhotoActivity extends AppCompatActivity {
    private static final String TAG = ChoosePhotoActivity.class.getSimpleName();
    private Intent data;
    private String currentPathImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_photo);
        data = getIntent();
        String pathPhoto = data.getStringExtra(Const.KEY_PATH_PHOTO);
        Logger.d(TAG, pathPhoto);
    }
}
