package vn.edu.imic.hairrstylesticker.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.theartofdev.edmodo.cropper.CropImage;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import vn.edu.imic.hairrstylesticker.R;

public class EditPhotoActivity extends AppCompatActivity {
    private static final String TAG = EditPhotoActivity.class.getSimpleName();
    private Intent intent;
    private Uri uri;
    /*Crop image result*/
    CropImage.ActivityResult result;
    private Unbinder unbinder;
    @BindView(R.id.img_crop)
    ImageView imgCrop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_photo);
        unbinder = ButterKnife.bind(this);
        intent = getIntent();
        initData();
    }

    /*init data*/
    private void initData() {
        result = CropImage.getActivityResult(intent);
        if (result != null){
            Log.d(TAG, "initData: " + result.getUri());
            imgCrop.setImageURI(result.getUri());
        }
        //imgCrop.setImageURI(result.getUri());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
