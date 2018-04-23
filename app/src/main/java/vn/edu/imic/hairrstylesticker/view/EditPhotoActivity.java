package vn.edu.imic.hairrstylesticker.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.theartofdev.edmodo.cropper.CropImage;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import vn.edu.imic.hairrstylesticker.R;
import vn.edu.imic.hairrstylesticker.network.Style;
import vn.edu.imic.hairrstylesticker.view.fragment.FragmentStyle;

public class EditPhotoActivity extends AppCompatActivity implements FragmentStyle.SendStyle{
    private static final String TAG = EditPhotoActivity.class.getSimpleName();
    private Intent intent;
    private Uri uri;
    /*Crop image result*/
    CropImage.ActivityResult result;
    private Unbinder unbinder;
    @BindView(R.id.img_crop)
    ImageView imgCrop;

    private FragmentManager fmEditPhoto;
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

        /*Đổ fragment*/
        fmEditPhoto = getSupportFragmentManager();
        FragmentTransaction ftStyle = fmEditPhoto.beginTransaction();
        ftStyle.add(R.id.frame_content,new FragmentStyle()).commitAllowingStateLoss();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void sendStyle(Style style) {

    }
}
