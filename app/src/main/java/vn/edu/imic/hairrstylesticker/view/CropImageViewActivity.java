package vn.edu.imic.hairrstylesticker.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageOptions;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.File;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import vn.edu.imic.hairrstylesticker.R;
import vn.edu.imic.hairrstylesticker.utils.Const;
import vn.edu.imic.hairrstylesticker.utils.Logger;

public class CropImageViewActivity extends AppCompatActivity implements CropImageView.OnSetImageUriCompleteListener,
        CropImageView.OnCropImageCompleteListener {
    private static final String TAG = CropImageViewActivity.class.getSimpleName();
    private Intent data;
    private String currentPathImage;

    @BindView(R.id.btn_free_size)
    RadioButton btnFreeSize;

    @BindView(R.id.btn_square)
    RadioButton btnSquare;

    @BindView(R.id.btn_rotate)
    TextView btnRotate;

    @BindView(R.id.btn_done)
    TextView btnDone;

    @BindView(R.id.civ_avatar)
    CropImageView civPhoto;

    private Unbinder unbinder;

    /*Đối tượng bitmap ban đầu*/
    private Bitmap bitmapFreeSize;

    /*Bitmap square*/
    private Bitmap bitmapSquare;

    /*Uri image*/
    private Uri uriImage;

    /*the options that were set for the crop image*/
    private CropImageOptions mOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_photo);
        unbinder = ButterKnife.bind(this);

        initData();

        initEvent();
    }

    private void initData() {
        data = getIntent();
        currentPathImage = data.getStringExtra(Const.KEY_PHOTO_PATH);
        Logger.d(TAG, currentPathImage);
        mOptions = new CropImageOptions();
        mOptions.validate();
        /*Lấy ra bitmap từ đường dẫn ảnh set ảnh*/
/*
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        bitmap = BitmapFactory.decodeFile(currentPathImage,options);
        //Set ảnh lên crop image
        civPhoto.setImageBitmap(bitmap);
*/

        //Bundle bundle = getIntent().getBundleExtra(CropImage.CROP_IMAGE_EXTRA_BUNDLE);
        //uriImage = bundle.getParcelable(CropImage.CROP_IMAGE_EXTRA_SOURCE);
        //mOptions = bundle.getParcelable(CropImage.CROP_IMAGE_EXTRA_OPTIONS);

        //Set ảnh sử dụng uri
        uriImage = Uri.fromFile(new File(currentPathImage));
        civPhoto.setImageUriAsync(uriImage);
    }

    /*Init event*/
    private void initEvent() {
        civPhoto.setOnCropImageCompleteListener(new CropImageView.OnCropImageCompleteListener() {
            @Override
            public void onCropImageComplete(CropImageView view, CropImageView.CropResult result) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        civPhoto.setOnSetImageUriCompleteListener(this);
        civPhoto.setOnCropImageCompleteListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        civPhoto.setOnCropImageCompleteListener(null);
        civPhoto.setOnSetImageUriCompleteListener(null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_free_size, R.id.btn_square, R.id.btn_rotate, R.id.btn_done})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_free_size:
                break;
            case R.id.btn_square:
                break;
            case R.id.btn_rotate:
                civPhoto.rotateImage(90);
                break;
            case R.id.btn_done:
                /*Save crop va put bitmap sang activity*/
                cropImage();
                break;
        }
    }

    /*Crop image truyền size image*/
    private void cropImage() {
        /*output Uri*/
        Uri uriOutput = getOutputUri();
        /*Save trạng thái */
        civPhoto.saveCroppedImageAsync(
                uriOutput,
                mOptions.outputCompressFormat,
                mOptions.outputCompressQuality,
                mOptions.outputRequestWidth,
                mOptions.outputRequestHeight,
                mOptions.outputRequestSizeOptions
        );
    }

    /*Tạo output Uri*/
    private Uri getOutputUri() {
        Uri outputUri = mOptions.outputUri;
        if (outputUri == null || outputUri.equals(Uri.EMPTY)) {
            try {
                String ext = mOptions.outputCompressFormat == Bitmap.CompressFormat.JPEG ? ".jpg" :
                        mOptions.outputCompressFormat == Bitmap.CompressFormat.PNG ? ".png" : "webp";
                outputUri = Uri.fromFile(File.createTempFile("cropped", ext, getCacheDir()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return outputUri;
    }

    @Override
    public void onCropImageComplete(CropImageView view, CropImageView.CropResult result) {
        Log.d(TAG, "onCropImageComplete: " + result.getSampleSize());
        setResult(result.getUri(),result.getError(),result.getSampleSize());
    }

    @Override
    public void onSetImageUriComplete(CropImageView view, Uri uri, Exception error) {
        Log.d(TAG, "onSetImageUriComplete: ");
    }

    /**
     *
     * @param uri
     * @param error
     * @param sampleSize
     */
    protected void setResult(Uri uri, Exception error, int sampleSize){
       /*Put data image sang màn hình EditPhotoActivity, đóng activity*/
       startActivity(getResultIntent(uri,error,sampleSize));
       finish();
    }

    /**
     *
     * @param uri
     * @param error
     * @param sampleSize
     */
    private Intent getResultIntent(Uri uri, Exception error, int sampleSize) {
        Intent intent = new Intent(CropImageViewActivity.this,EditPhotoActivity.class);
        CropImage.ActivityResult result = new CropImage.ActivityResult(
                civPhoto.getImageUri(),
                uri,
                error,
                civPhoto.getCropPoints(),
                civPhoto.getCropRect(),
                civPhoto.getRotatedDegrees(),
                civPhoto.getWholeImageRect(),
                sampleSize);
        intent.putExtra(CropImage.CROP_IMAGE_EXTRA_RESULT,result);
        return intent;
    }
}
