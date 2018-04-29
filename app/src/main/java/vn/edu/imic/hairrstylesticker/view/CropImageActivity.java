package vn.edu.imic.hairrstylesticker.view;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.edmodo.cropper.CropImageView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import vn.edu.imic.hairrstylesticker.R;
import vn.edu.imic.hairrstylesticker.utils.Const;

/**
 * Created by MyPC on 29/04/2018.
 */

public class CropImageActivity extends AppCompatActivity{
    private static final String TAG = CropImageActivity.class.getSimpleName();
    @BindView(R.id.btn_camera)
    ImageView btnCamera;
    @BindView(R.id.btn_gallery)
    ImageView btnGallery;
    @BindView(R.id.img_app1)
    ImageView btnApp1;
    @BindView(R.id.img_app2)
    ImageView btnApp2;
    @BindView(R.id.img_app3)
    ImageView btnApp3;
    @BindView(R.id.img_app4)
    ImageView btnApp4;
    @BindView(R.id.img_app5)
    ImageView btnApp5;
    @BindView(R.id.img_app6)
    ImageView btnApp6;
    @BindView(R.id.rl_crop_activity)
    RelativeLayout rlCropActivity;
    @BindView(R.id.btn_free_size)
    Button btnFreeSize;
    @BindView(R.id.btn_square)
    Button btnSquare;
    @BindView(R.id.btn_rotate)
    Button btnRotate;
    @BindView(R.id.btn_done)
    Button btnDone;
    @BindView(R.id.civ_image)
    CropImageView civImage;

    /*Bien luu uri hien tai*/
    private Uri uriSelected;

    private static final String FOLDER_NAME = "photoedit/Image";

    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_option);
        unbinder = ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_camera,R.id.btn_gallery,
    R.id.btn_free_size,R.id.btn_square,R.id.btn_rotate,R.id.btn_done})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_camera:
                openCamera();
                break;
            case R.id.btn_gallery:
                openGallery();
                break;
            case R.id.btn_free_size:
                break;
            case R.id.btn_square:
                break;
            case R.id.btn_rotate:
                break;
            case R.id.btn_done:
                break;
        }
    }

    /*Open gallery*/
    private void openGallery() {
        //Tao intent voi action mo gallery
        Intent iGallery = new Intent(Intent.ACTION_PICK);
        iGallery.setDataAndType(Uri.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath()),"image/*");
        startActivityForResult(iGallery, Const.REQUEST_OPEN_GALLERY);
    }

    /*Open camera*/
    private void openCamera() {
        Intent iCamera = new Intent("android.media.action.IMAGE_CAPTURE");
        String dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File file = Environment.getExternalStorageState().equals("mounted")?
                new File(Environment.getExternalStorageDirectory(), FOLDER_NAME + File.separator + dateFormat + ".jpg")
                : new File(getCacheDir(),FOLDER_NAME + File.separator + dateFormat + ".jpeg");
        File file2 = new File(Environment.getExternalStorageDirectory(),System.currentTimeMillis() + ".jpeg");
        if (file != null){
            iCamera.putExtra("output",Uri.fromFile(file2));
            uriSelected = Uri.fromFile(file2);
            startActivityForResult(iCamera,Const.REQUEST_OPEN_CAMERA);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null){
            if (requestCode == Const.REQUEST_OPEN_GALLERY && resultCode == Activity.RESULT_OK){
                Log.d(TAG, "onActivityResult: ");
                //Neu la mo gallery
                cropImage(data.getData());
            }else if (requestCode == Const.REQUEST_OPEN_CAMERA && resultCode == Activity.RESULT_OK){
                if (Build.VERSION.SDK_INT <= 19){
                    cropImage(data.getData());
                    Log.d(TAG, "UriSelected19: " + data.getData());
                }else if (Build.VERSION.SDK_INT >= 20){
                    cropImage(uriSelected);
                    Log.d(TAG, "UriSelected20: " + this.uriSelected);
                }
            }
        }
    }

    /**/
    private void cropImage(Uri data) {

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        /*Lay ra uri*/
        uriSelected = savedInstanceState.getParcelable(Const.KEY_PHOTO_URI);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        /*Put uri vao*/
        outState.putParcelable(Const.KEY_PHOTO_URI,uriSelected);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //unbinder.unbind();
    }
}
