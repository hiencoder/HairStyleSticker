package vn.edu.imic.hairrstylesticker.view;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import vn.edu.imic.hairrstylesticker.R;
import vn.edu.imic.hairrstylesticker.utils.Const;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btn_open_gallery)
    ImageView btnOpenGallery;

    @BindView(R.id.btn_open_camera)
    ImageView btnOpenCamera;

    @BindView(R.id.btn_more_app)
    ImageView btnOpenMoreApp;

    private Unbinder unbinder;

    /*Bien duong dan anh tu camera*/
    private String currentPhotoPath;
    /*Bien duong danh anh tu gallery*/
    private String myPhotoPath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_open_gallery, R.id.btn_open_camera, R.id.btn_more_app})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_open_gallery:
                handleOpenGallery();
                break;
            case R.id.btn_open_camera:
                handleOpenCamera();
                break;
            case R.id.btn_more_app:
                handleOpenMoreApp();
                break;
        }
    }

    /*Xu ly mo ra app cung id tai khoan*/
    private void handleOpenMoreApp() {
        Intent iOpenMoreApp = new Intent("android.intent.action.VIEW");
        Uri uri = Uri.parse("");
        iOpenMoreApp.setData(uri);
        startActivity(iOpenMoreApp);
    }

    /*Xu ly mo camera*/
    private void handleOpenCamera(){
        Intent iOpenCamera = new Intent("android.media.action.IMAGE_CAPTURE");
        if (iOpenCamera.resolveActivity(getPackageManager()) != null){
            if (createImageFile() != null){
                //Tao file image
                iOpenCamera.putExtra(Const.KEY_PHOTO_CAMERA,
                        FileProvider.getUriForFile(this,"vn.edu.imic.hairrstylesticker",createImageFile()));
                startActivityForResult(iOpenCamera,Const.REQUEST_OPEN_CAMERA);
            }
        }
    }

    /*Tao image file*/
    private File createImageFile(){
        File image = null;
        try {
            image = File.createTempFile("JPEG_" +
            new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + "_",
                    ".jpg",getExternalFilesDir(Environment.DIRECTORY_PICTURES));
            currentPhotoPath = image.getAbsolutePath();
            return image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*Open gallery*/
    private void handleOpenGallery() {
        Intent iGallery = new Intent("android.intent.action.PICK",
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(iGallery, Const.REQUEST_OPEN_GALLERY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null){
            if (requestCode == Const.REQUEST_OPEN_GALLERY && resultCode == Activity.RESULT_OK){
                String[] filePathColumn = new String[]{"_data"};
                Cursor cursor = getContentResolver().query(data.getData(),filePathColumn,null,null,null);
                cursor.moveToFirst();
                /*Gan gia tri duong danh*/
                myPhotoPath = cursor.getString(cursor.getColumnIndex(filePathColumn[0]));
                //Dua duong dan anh vao intent
                data.putExtra(Const.KEY_PATH_PHOTO,myPhotoPath);
                data.setClass(this,EditPhotoActivity.class);
                cursor.close();
                startActivity(data);
            }

            if (requestCode == Const.REQUEST_OPEN_CAMERA && resultCode == Activity.RESULT_OK){
                takePictureCamera();
            }
        }
    }

    /*Take picture from camera*/
    private void takePictureCamera() {
        /*Lay ra anh vua chup cua camera dua sang EditPhotoActivity*/
        if (currentPhotoPath != null){
            addPicToGallery();
            Intent intent = new Intent(this,EditPhotoActivity.class);
            intent.putExtra(Const.KEY_PATH_PHOTO,currentPhotoPath);
            startActivity(intent);
            myPhotoPath = null;
        }
    }


    /*Add pic to gallery*/
    private void addPicToGallery() {
        Intent iScanMedia = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        iScanMedia.setData(Uri.fromFile(new File(currentPhotoPath)));
        sendBroadcast(iScanMedia);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }


}
