package vn.edu.imic.hairrstylesticker.view;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.edmodo.cropper.CropImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import vn.edu.imic.hairrstylesticker.R;
import vn.edu.imic.hairrstylesticker.utils.Const;
import vn.edu.imic.hairrstylesticker.utils.Logger;

/**
 * Created by MyPC on 29/04/2018.
 */

public class CropImageActivity extends AppCompatActivity {
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

    /*Bitmap hien thi thong tin anh*/
    private Bitmap bitmapSelected;


    private static final String FOLDER_NAME = "photoedit/Image/";

    private Unbinder unbinder;

    //Biến góc quay
    private int rotateDegree = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_option);
        unbinder = ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_camera, R.id.btn_gallery,
            R.id.btn_free_size, R.id.btn_square, R.id.btn_rotate, R.id.btn_done})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_camera:
                /*Kiểm tra điều kiện để open camera*/
                if (Build.VERSION.SDK_INT <= 19) {
                    openCameraWithSdk();
                } else {
                    openCamera();
                }
                break;
            case R.id.btn_gallery:
                openGallery();
                break;
            case R.id.btn_free_size:
                handleFreeSize();
                break;
            case R.id.btn_square:
                handleSquareSize();
                break;
            case R.id.btn_rotate:
                handleRotate();
                break;
            case R.id.btn_done:
                handleSave();
                break;
        }
    }

    /*Open camera vs sdk nhỏ hơn 19*/
    private void openCameraWithSdk() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivityForResult(intent, Const.REQUEST_OPEN_CAMERA);
    }


    /*Handle save*/
    private void handleSave() {
        try {
            Bitmap bm = civImage.getCroppedImage();
            if (bm != null) {
                Toast.makeText(this, "Change", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Null", Toast.LENGTH_SHORT).show();
            }
            Uri saveBitmap = saveBitmap(bm);
            Logger.d("SaveBitmap", saveBitmap.toString());
            Intent intent = new Intent(this, EditPhotoActivity.class);
            intent.putExtra(Const.KEY_PHOTO_URI, saveBitmap.toString());
            startActivity(intent);
            finish();
            rlCropActivity.setVisibility(View.INVISIBLE);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    //http://www.appwallettech.com/appwalletftp/StartAdFile.xml
    /*Handle rotate*/
    private void handleRotate() {
        //Tăng góc quay 90 độ
        rotateDegree += 90;
        if (rotateDegree == 360) {
            rotateDegree = 0;
        }
        civImage.rotateImage(rotateDegree);

    }

    /*Handle square size*/
    private void handleSquareSize() {
        civImage.setFixedAspectRatio(true);
        //Set backround cho button
        btnSquare.setBackgroundColor(Color.parseColor("#a5212121"));
        btnFreeSize.setBackgroundColor(Color.parseColor("#ffffff"));
    }

    /*Handle Freesize*/
    private void handleFreeSize() {
        civImage.setFixedAspectRatio(false);
        //Set background cho button
        btnFreeSize.setBackgroundColor(Color.parseColor("#a5212121"));
        btnSquare.setBackgroundColor(Color.parseColor("#ffffff"));
    }

    /*Open gallery*/
    private void openGallery() {
        //Tao intent voi action mo gallery
        Intent iGallery = new Intent(Intent.ACTION_PICK);
        iGallery.setDataAndType(Uri.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath()), "image/*");
        startActivityForResult(iGallery, Const.REQUEST_OPEN_GALLERY);
    }

    /*Open camera*/
    private void openCamera() {
        Intent iCamera = new Intent("android.media.action.IMAGE_CAPTURE");
        String dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File file = Environment.getExternalStorageState().equals("mounted") ?
                new File(Environment.getExternalStorageDirectory(), FOLDER_NAME +
                        File.separator + dateFormat + ".jpeg")
                : new File(getCacheDir(), FOLDER_NAME + File.separator + dateFormat + ".jpeg");
        File file2 = new File(Environment.getExternalStorageDirectory(), System.currentTimeMillis() + ".jpeg");

        if (file != null) {
            iCamera.putExtra("output", Uri.fromFile(file2));
            uriSelected = Uri.fromFile(file2);
            startActivityForResult(iCamera, Const.REQUEST_OPEN_CAMERA);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Const.REQUEST_OPEN_CAMERA && resultCode == Activity.RESULT_OK) {
            if (Build.VERSION.SDK_INT <= 19) {
                cropImage(data.getData());
            } else if (Build.VERSION.SDK_INT >= 20 && requestCode == Const.REQUEST_OPEN_CAMERA
                    && resultCode == Activity.RESULT_OK) {
                cropImage(uriSelected);
            }
        } else if (requestCode == Const.REQUEST_OPEN_GALLERY && resultCode == Activity.RESULT_OK) {
            cropImage(data.getData());
        }
    }

    /*Crop Image*/
    private void cropImage(Uri data) {
        Logger.i(TAG, data.toString());
        if (data != null) {
            InputStream openInputStream;
            try {
                openInputStream = getContentResolver().openInputStream(data);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                openInputStream = null;
            }
            try {
                bitmapSelected = BitmapFactory.decodeStream(openInputStream);
                //Hien thi layout chua bitmap
                rlCropActivity.setVisibility(View.VISIBLE);
                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                bitmapSelected = resizeImageToNewSize(bitmapSelected, displayMetrics.widthPixels,
                        displayMetrics.heightPixels - ((int) (getResources().getDisplayMetrics().density * 50.0f)));
                if (this.bitmapSelected != null) {
                /*Set kich thuoc cho CropImageView*/
                    civImage.getLayoutParams().width = bitmapSelected.getWidth();
                    civImage.getLayoutParams().height = bitmapSelected.getHeight();
                    Logger.d(TAG, "cropImage: Width: " + bitmapSelected.getWidth()
                            + "\nHeight: " + bitmapSelected.getHeight());
                    //Hien thi bitmap len CropImageView
                    civImage.setImageBitmap(bitmapSelected);
                    civImage.setAspectRatio(5, 5);
                    return;
                }
                return;
            } catch (Exception ex2) {
                Toast.makeText(this, "Please select other image!", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        Toast.makeText(this, "Please select other image!", Toast.LENGTH_SHORT).show();
    }

    /**
     * @param bm
     * @param w  : chieu rong ban dau
     * @param h  chieu cao ban dau
     * @return
     */
    private Bitmap resizeImageToNewSize(Bitmap bm, int w, int h) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float f = (float) w; // new size(width)
        float f2 = (float) h; // new size(height)
        if (!(height == h) && (width == w)) {
            f2 = ((float) w) / ((float) width);
            f = ((float) h) / ((float) height);
            if (f2 >= f) {
                f2 = f;
            }
            f = ((float) width) * f2;
            f2 *= (float) height;
        }
        /*Tao mot bitmap duoc chia ti le tu mot bitmap co truoc
        * Neu chieu cao va chieu rong duoc xac dinh giong voi kich thuoc hien
        * tai cua bitmap thi bitmap nguon duoc tra ve va khong co bitmap moi duoc tao ra.*/
        return Bitmap.createScaledBitmap(bm, (int) f, (int) f2, true);
    }

    public void handleSaveBitmap(Bitmap bitmap) {
        OutputStream outputStream = null;
        int nextInt = new Random().nextInt(1000);
        String fileName = "";
    }

    /*Phuong thuc luu Bitmap*/
    public Uri saveBitmap(Bitmap bm) {
        FileOutputStream outputStream;
        ContentValues values;
        Throwable th;
        Uri uri = null;
        if (bm == null || bm.isRecycled()) {
            return null;
        }
        File file = new File(Environment.getExternalStorageDirectory() + "/TempImage");
        if (!file.exists()) {
            file.mkdir();
        }
        int nextInt = new Random().nextInt(1000);
        File file2 = new File(file, String.format("%s_%d.png",
                new Object[]{"TempImage", Integer.valueOf(nextInt)}));
        if (file2.exists() && file2.delete()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            outputStream = new FileOutputStream(file2);
            bm.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
            //Object obj = outputStream;
            if (uri != null) {
            }
            values = new ContentValues(3);
            values.put(MediaStore.Images.Media.TITLE, "TempImage");
            values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
            values.put(MediaStore.Images.Media.DATA, file2.getAbsolutePath());
            uri = Uri.fromFile(file2.getAbsoluteFile());
            getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            return uri;

        }catch (Exception ex){

        }
        return null;
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        /*Lay ra uri*/
        uriSelected = (Uri) savedInstanceState.getParcelable(Const.KEY_PHOTO_URI);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        /*Put uri vao*/
        outState.putParcelable(Const.KEY_PHOTO_URI, uriSelected);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //unbinder.unbind();
    }

    @Override
    protected void onDestroy() {
        Runtime.getRuntime().gc();
        if (bitmapSelected != null) {
            bitmapSelected.recycle();
        }
        super.onDestroy();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }
}
