package vn.edu.imic.hairrstylesticker.view;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import vn.edu.imic.hairrstylesticker.R;
import vn.edu.imic.hairrstylesticker.utils.ConnectionUtils;
import vn.edu.imic.hairrstylesticker.utils.Const;
import vn.edu.imic.hairrstylesticker.utils.Logger;
import vn.edu.imic.hairrstylesticker.view.custom.MoveGestureDetector;
import vn.edu.imic.hairrstylesticker.view.custom.RotateGestureDetector;

public class EditPhotoActivity extends AppCompatActivity {
    private static final String TAG = EditPhotoActivity.class.getSimpleName();
    private Intent intent;
    private Uri uri;
    /*Crop image result*/
    private Unbinder unbinder;

    /*Top*/
    @BindView(R.id.btn_reset)
    RelativeLayout btnReset;
    @BindView(R.id.btn_ad)
    RelativeLayout btnAd;
    @BindView(R.id.btn_whats_new)
    RelativeLayout btnNew;
    @BindView(R.id.btn_save)
    RelativeLayout btnSave;

    /*ImageView hien thi image được chọn và style*/
    @BindView(R.id.img_crop)
    ImageView imgCrop;
    @BindView(R.id.img_choose_style)
    ImageView imgChooseStyle;

    /*Các style được chọn*/
    @BindView(R.id.rl_styles)
    RelativeLayout rlStyles;
    @BindView(R.id.btn_hair)
    RelativeLayout btnHair;
    @BindView(R.id.btn_mus)
    RelativeLayout btnMus;
    @BindView(R.id.btn_beard)
    RelativeLayout btnBeard;
    @BindView(R.id.btn_glasses)
    RelativeLayout btnGlasses;
    @BindView(R.id.btn_tattoo)
    RelativeLayout btnTattoo;
    @BindView(R.id.btn_cap)
    RelativeLayout btnCap;
    @BindView(R.id.btn_suite)
    RelativeLayout btnSuite;

    /*Màu sắc để color filter*/
    @BindView(R.id.rl_color)
    RelativeLayout rlColor;
    @BindView(R.id.ib_color0)
    ImageButton btnColor0;
    @BindView(R.id.ib_color1)
    ImageButton btnColor1;
    @BindView(R.id.ib_color2)
    ImageButton btnColor2;
    @BindView(R.id.ib_color3)
    ImageButton btnColor3;
    @BindView(R.id.ib_color4)
    ImageButton btnColor4;
    @BindView(R.id.ib_color5)
    ImageButton btnColor5;
    @BindView(R.id.ib_color6)
    ImageButton btnColor6;
    @BindView(R.id.ib_color7)
    ImageButton btnColor7;
    @BindView(R.id.ib_color8)
    ImageButton btnColor8;
    @BindView(R.id.ib_color9)
    ImageButton btnColor9;
    @BindView(R.id.ib_color10)
    ImageButton btnColor10;
    @BindView(R.id.ib_color11)
    ImageButton btnColor11;
    @BindView(R.id.ib_color12)
    ImageButton btnColor12;
    @BindView(R.id.ib_color13)
    ImageButton btnColor13;
    @BindView(R.id.ib_color14)
    ImageButton btnColor14;
    @BindView(R.id.ib_color15)
    ImageButton btnColor15;
    @BindView(R.id.ib_color16)
    ImageButton btnColor16;
    @BindView(R.id.ib_color17)
    ImageButton btnColor17;
    @BindView(R.id.ib_color18)
    ImageButton btnColor18;
    @BindView(R.id.ib_color19)
    ImageButton btnColor19;
    @BindView(R.id.ib_color20)
    ImageButton btnColor20;
    @BindView(R.id.ib_color21)
    ImageButton btnColor21;
    @BindView(R.id.ib_color22)
    ImageButton btnColor22;
    @BindView(R.id.ib_color23)
    ImageButton btnColor23;
    @BindView(R.id.ib_color24)
    ImageButton btnColor24;
    @BindView(R.id.ib_color25)
    ImageButton btnColor25;
    @BindView(R.id.ib_color26)
    ImageButton btnColor26;
    @BindView(R.id.ib_color27)
    ImageButton btnColor27;
    @BindView(R.id.ib_color28)
    ImageButton btnColor28;
    @BindView(R.id.ib_color29)
    ImageButton btnColor29;
    @BindView(R.id.ib_color30)
    ImageButton btnColor30;
    @BindView(R.id.ib_color31)
    ImageButton btnColor31;

    /*Cac imageview click*/
    @BindView(R.id.btn_close_hair)
    ImageView btnCloseHair;
    @BindView(R.id.btn_flip)
    ImageView btnRotate;
    @BindView(R.id.btn_save_hair)
    ImageView btnSaveHair;

    /*Lấy ảnh từ drawable*/
    @BindView(R.id.hsv_item)
    HorizontalScrollView hsvItem;

    /*Button edit*/
    @BindView(R.id.btn_edit)
    TextView btnEdit;
    /*Biến số lượng item của */
    private int itemSize;
    //Tag title style
    private String tagStyle;
    //Hien thi tag item
    private String tagItem;

    //anh duoc chon
    private String imageSelected;

    /*Item duoc chon*/

    /*Cac kich thuoc cua icon tab*/
    int sizeIconHair;
    int sizeIconBeard;
    int sizeIconMustachi;
    int sizeIconGlass;
    int sizeIconTattoo;
    int sizeIconCap;
    int sizeIconSuit;

    //Kich thuoc cua anh
    private Bitmap bitmapSelected;
    private Bitmap newBitmap;
    private int imageWidth;
    private int imageHeight;
    private Uri uriImage;

    private int alpha = 255;
    private MoveGestureDetector moveGestureDetector;
    private float focusX = 0.0f;
    private float focusY = 0.0f;
    private int h;
    private int g;
    private RotateGestureDetector rotateGestureDetector;
    private float rotationDegrees = 0.0f;
    private ScaleGestureDetector scaleGestureDetector;
    private float scaleFactor = 0.2f;
    private int ak;
    static int z;
    private class MoveListener extends MoveGestureDetector.SimpleOnMoveGestureListener {
        final EditPhotoActivity editPhotoActivity;

        private MoveListener(EditPhotoActivity editPhotoActivity) {
            this.editPhotoActivity = editPhotoActivity;
        }

        public boolean onMove(MoveGestureDetector moveGestureDetector) {
            PointF focusDelta = moveGestureDetector.getFocusDelta();
            editPhotoActivity.focusX = editPhotoActivity.focusX + focusDelta.x;
            editPhotoActivity.focusY = editPhotoActivity.focusY + focusDelta.y;
            if (editPhotoActivity.focusX <= 0.0f) {
                editPhotoActivity.focusX = 0.0f;
            } else if (editPhotoActivity.focusY <= 0.0f) {
                editPhotoActivity.focusY = 0.0f;
            } else if (editPhotoActivity.focusX > (float) editPhotoActivity.h) {
                editPhotoActivity.focusX = (float) editPhotoActivity.h;
            } else if (editPhotoActivity.focusY > (float) editPhotoActivity.g) {
                editPhotoActivity.focusY = (float) editPhotoActivity.g;
            }
            return true;
        }
    }

    private class RotateListener extends RotateGestureDetector.SimpleOnRotateGestureListener {
        final EditPhotoActivity editPhotoActivity;

        public RotateListener(EditPhotoActivity editPhotoActivity) {
            this.editPhotoActivity = editPhotoActivity;
        }

        public boolean onRotate(RotateGestureDetector rotateGestureDetector) {
            editPhotoActivity.rotationDegrees = editPhotoActivity.rotationDegrees - rotateGestureDetector.getRotationDegreesDelta();
            return true;
        }
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        final EditPhotoActivity editPhotoActivity;

        public ScaleListener(EditPhotoActivity editPhotoActivity) {
            this.editPhotoActivity = editPhotoActivity;
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            editPhotoActivity.scaleFactor = editPhotoActivity.scaleFactor * scaleGestureDetector.getScaleFactor();
            editPhotoActivity.scaleFactor = Math.max(0.1f, Math.min(editPhotoActivity.scaleFactor, 3.0f));
            editPhotoActivity.ak = (int) (editPhotoActivity.scaleFactor * 100000.0f);
            //Sử dụng Vertical Seekbar
            return true;
        }
    }

    /**
     * @param context
     */
    public static void deleteCache(Context context) {
        try {
            deleteDir(context.getCacheDir());
        } catch (Exception ex) {

        }
    }

    /**
     * Phương thức xóa đường dẫn file
     *
     * @param file
     */
    private static boolean deleteDir(File file) {
        if (file == null || !file.isDirectory()) {
            //Nêu file null hoặc không có đường dẫn file
            return (file == null || !file.isFile()) ? false : file.delete();
        } else {
            String[] list = file.list();
            for (String file2 : list) {
                if (!deleteDir(new File(file, file2))) {
                    return false;
                }
            }
            return file.delete();
        }
    }

    /*Phương thức xoay bitmap*/
    public static Bitmap flip(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        if (i == 1) {
            matrix.preScale(1.0f, -1.0f);
        } else if (i != 2) {
            return null;
        } else {
            matrix.preScale(-1.0f, 1.0f);
        }
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /**
     * Phương thức trả về chiều của ảnh
     *
     * @param editPhotoActivity
     * @param uri
     * @return
     */
    private int getOrientation(EditPhotoActivity editPhotoActivity, Uri uri) {
        Cursor cursor = editPhotoActivity.getContentResolver().query(uri, new String[]{"orientation"},
                null, null, null);
        if (cursor.getCount() != 1) {
            return -1;
        } else {
            cursor.moveToFirst();
            return cursor.getInt(0);
        }
    }

    /**
     * @param editPhotoActivity
     * @param uri
     * @return
     */
    private Bitmap scaleBitmap(EditPhotoActivity editPhotoActivity, Uri uri) {
        int i;
        int i2;
        Bitmap decodeStream;
        try {
            InputStream is = editPhotoActivity.getContentResolver().openInputStream(uri);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(is,null,options);
            is.close();
            int orientation = getOrientation(editPhotoActivity,uri);
            Logger.i("Orientation","Orientation: " + orientation);
            if (orientation == 90 || orientation == 270){
                i = options.outHeight;
                i2 = options.outWidth;
            }else {
                i = options.outWidth;
                i2 = options.outHeight;
            }

            InputStream is2 = editPhotoActivity.getContentResolver().openInputStream(uri);
            if (i > z || i2 > z){
                float max = Math.max(((float)i)/ ((float)z),((float) i2) / ((float) z));
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inSampleSize = (int) max;
                decodeStream = BitmapFactory.decodeStream(is2,null,options2);
            }else {
                decodeStream = BitmapFactory.decodeStream(is2);
            }
            is2.close();
            if (orientation > 0){
                Matrix matrix = new Matrix();
                matrix.postRotate((float) orientation);
                decodeStream = Bitmap.createBitmap(decodeStream,0,0,decodeStream.getWidth(),decodeStream.getHeight(),matrix,true);
            }
            //Lấy ra type của uri
            String type = editPhotoActivity.getContentResolver().getType(uri);
            //Tạo luồng outputStream để chứa dữ liệu ra
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (type.equals("image/png")){ //Nếu ảnh là png
                /*Tạo ra phiên bản nén của bitmap đưa vào outputStream với định dạng ảnh nén PNG,
                * chất lượng (0-100). 0 là nén cho kích thước nhỏ, 100 nén cho chất lượng tối đa.
                * outpuStream: để ghi dữ liệu nén.
                * return true: Nếu nén thành công vào luồng đã chỉ định*/
                decodeStream.compress(Bitmap.CompressFormat.PNG,100,byteArrayOutputStream);
            }else if (type.equals("image/jpg") || (type.equals("image/jpeg"))){
                //Nếu ảnh là định dạng jpg hoặc jpeg
                decodeStream.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            /*Decode một bitmap từ một mảng byte đã xác định
            * toByteArray: Mảng byte dữ liệu ảnh nén.
            * 0: offset bắt đầu đưa dữ liệu ảnh vào
            * toByteArray.length: Số byte cần parse tính từ offset
            * return: Bitmap sau khi được giải mã*/
            return BitmapFactory.decodeByteArray(toByteArray,0,toByteArray.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *Phương thức scale bitmap fit theo chiều rộng
     * @param bitmap
     * @param i
     * @param i2
     * @return
     */
    public static Bitmap scaleToFitWidth(Bitmap bitmap, int i, int i2){
       return ((float)bitmap.getHeight()) > ((float)bitmap.getWidth()) ?
               Bitmap.createScaledBitmap(bitmap, (int) ((((float)i2)/((float)bitmap.getHeight())) * ((float)bitmap.getWidth())),i2,true)
               :Bitmap.createScaledBitmap(bitmap,i, (int) ((((float)i) / ((float)bitmap.getWidth())) * ((float)bitmap.getHeight())),true);
    }

    /*Phương thức kiểm tra network. Nếu không có network thì show ra dialog*/
    public void checkNetworkConnection(){
        if (ConnectionUtils.checkConnection(this)){
            //nếu có internet show dialog
            showDownloadDialog();
        }else {
            Toast.makeText(this, "Vui lòng kết nối internet", Toast.LENGTH_SHORT).show();
        }
    }

    private void showDownloadDialog() {
        //Chuỗi package app trên store
        final String str = "com.appwallet.manphotosuits";
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog);
        TextView btnTryLater = dialog.findViewById(R.id.btn_try_later);
        TextView btnTryNow = dialog.findViewById(R.id.btn_try_now);
        btnTryLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Tạo intent gọi đến google play
                Intent intent = new Intent("android.intent.action.VIEW");
                Uri uri = Uri.parse("market://details?id=" + str);
                intent.setData(uri);
                startActivity(intent);
                dialog.dismiss();
            }
        });
        btnTryNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Open google play
                finish();
            }
        });
        dialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(1024, 1024);
        }
        setContentView(R.layout.activity_edit_photo_3);
        getWindow().addFlags(1024);

        unbinder = ButterKnife.bind(this);
        setTintForButton();
        intent = getIntent();
        initData();
    }


    /*Set tint for button*/
    private void setTintForButton() {
        btnColor0.setColorFilter(Color.parseColor("#9e9e9e"), PorterDuff.Mode.MULTIPLY);
        btnColor1.setColorFilter(Color.parseColor("#FF8000"), PorterDuff.Mode.MULTIPLY);
        btnColor2.setColorFilter(Color.parseColor("#F0E68C"), PorterDuff.Mode.MULTIPLY);
        btnColor3.setColorFilter(Color.parseColor("#00EEEE"), PorterDuff.Mode.MULTIPLY);
        btnColor4.setColorFilter(Color.parseColor("#FF83FA"), PorterDuff.Mode.MULTIPLY);
        btnColor5.setColorFilter(Color.parseColor("#e6cea8"), PorterDuff.Mode.MULTIPLY);
        btnColor6.setColorFilter(Color.parseColor("#a56b46"), PorterDuff.Mode.MULTIPLY);
        btnColor7.setColorFilter(Color.parseColor("#b55239"), PorterDuff.Mode.MULTIPLY);
        btnColor8.setColorFilter(Color.parseColor("#ffaeb9"), PorterDuff.Mode.MULTIPLY);
        btnColor9.setColorFilter(Color.parseColor("#8d4a43"), PorterDuff.Mode.MULTIPLY);
        btnColor10.setColorFilter(Color.parseColor("#eee9e9"), PorterDuff.Mode.MULTIPLY);
        btnColor11.setColorFilter(Color.parseColor("#91553d"), PorterDuff.Mode.MULTIPLY);
        btnColor13.setColorFilter(Color.parseColor("#eee0e5"), PorterDuff.Mode.MULTIPLY);
        btnColor13.setColorFilter(Color.parseColor("#ff4040"), PorterDuff.Mode.MULTIPLY);
        btnColor14.setColorFilter(Color.parseColor("#d02090"), PorterDuff.Mode.MULTIPLY);
        btnColor15.setColorFilter(Color.parseColor("#8e8e38"), PorterDuff.Mode.MULTIPLY);
        btnColor16.setColorFilter(Color.parseColor("#71635a"), PorterDuff.Mode.MULTIPLY);
        btnColor17.setColorFilter(Color.parseColor("#d8bfd8"), PorterDuff.Mode.MULTIPLY);
        btnColor18.setColorFilter(Color.parseColor("#71c671"), PorterDuff.Mode.MULTIPLY);
        btnColor19.setColorFilter(Color.parseColor("#977961"), PorterDuff.Mode.MULTIPLY);
        btnColor20.setColorFilter(Color.parseColor("#7d9ec0"), PorterDuff.Mode.MULTIPLY);
        btnColor21.setColorFilter(Color.parseColor("#ab82ff"), PorterDuff.Mode.MULTIPLY);
        btnColor22.setColorFilter(Color.parseColor("#ffb90f"), PorterDuff.Mode.MULTIPLY);
        btnColor23.setColorFilter(Color.parseColor("#fff5e1"), PorterDuff.Mode.MULTIPLY);
        btnColor24.setColorFilter(Color.parseColor("#4876ff"), PorterDuff.Mode.MULTIPLY);
        btnColor25.setColorFilter(Color.parseColor("#ffa07a"), PorterDuff.Mode.MULTIPLY);
        btnColor26.setColorFilter(Color.parseColor("#bcd2ee"), PorterDuff.Mode.MULTIPLY);
        btnColor27.setColorFilter(Color.parseColor("#7171c6"), PorterDuff.Mode.MULTIPLY);
        btnColor28.setColorFilter(Color.parseColor("#c1ffc1"), PorterDuff.Mode.MULTIPLY);
        btnColor29.setColorFilter(Color.parseColor("#b7a69e"), PorterDuff.Mode.MULTIPLY);
        btnColor30.setColorFilter(Color.parseColor("#bcee68"), PorterDuff.Mode.MULTIPLY);
        btnColor31.setColorFilter(Color.parseColor("#404040"), PorterDuff.Mode.MULTIPLY);
    }

    /*init data*/
    private void initData() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        Logger.d("Size", "Width: " + i + "\nHeight: " + i2);
        z = i;
        System.gc();
        uriImage = Uri.parse(getIntent().getStringExtra(Const.KEY_PHOTO_URI));
        if (uriImage != null){
            InputStream inputStream = null;
            try {
                inputStream = getContentResolver().openInputStream(uriImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            /*Kích thước của image*/
            bitmapSelected = BitmapFactory.decodeStream(inputStream);
            imageWidth = bitmapSelected.getWidth();
            imageHeight = bitmapSelected.getHeight();
            Logger.d("OldSize", "Width: " + imageWidth + "\nHeight: " + imageHeight);
            bitmapSelected = resizeImageToNewSize(bitmapSelected,i,i2);
            newBitmap = bitmapSelected;
            /*Lấy ra kích thước mới image*/
            imageWidth = newBitmap.getWidth();
            imageHeight = newBitmap.getHeight();
            Logger.d("NewSize", "Width: " + imageWidth + "\nHeight: " + imageHeight);
            imgCrop.setImageBitmap(newBitmap);
        }
/*
        result = CropImage.getActivityResult(intent);
        if (result != null) {
            Log.d(TAG, "initData: " + result.getUri());
            imgCrop.setImageURI(result.getUri());
        }
*/

    }

    /**
     *
     * @param z
     */
    @BindView(R.id.rl_image)
    RelativeLayout rlImage;
    private void checkImageRotation(boolean z){
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        /*Lấy kích thước màn hình thiết bị*/
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        Logger.d(TAG,"Width: " + i + "\nHeight: " + i2);
        float f = displayMetrics.density;
        Logger.d(TAG,"Density: " + f);
        int i3 = i2 - ((int) (f*200.0f));
        rlImage.getMeasuredHeight();
        rlImage.getMeasuredWidth();
        Logger.d(TAG,"D_width: " + i + "\nD_height: " + i3);
        newBitmap = resizeImageToNewSize(scaleBitmap(this,uriImage),i,i3);

    }
    /**
     *
     * @param bm
     * @param i
     * @param i2
     * @return
     */
    private Bitmap resizeImageToNewSize(Bitmap bm, int i, int i2) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float f = i;
        float f2 = i2;
        if (!(height == i2 && width == i)){
            f2 = ((float)i) / ((float)width);
            f = ((float)i) / ((float)height);
            if (f2 >= f){
                f2 = f;
            }
            f = ((float) width) * f2;
            f2 *= (float)height;
        }
        return Bitmap.createScaledBitmap(bm,(int) f,(int) f2,true);
    }

    @OnClick({R.id.btn_hair, R.id.btn_beard, R.id.btn_mus, R.id.btn_glasses, R.id.btn_tattoo, R.id.btn_cap, R.id.btn_suite,
            R.id.btn_edit, R.id.btn_close_hair, R.id.btn_flip,
            R.id.ib_color1, R.id.ib_color2, R.id.ib_color3, R.id.ib_color4, R.id.ib_color5, R.id.ib_color6,
            R.id.ib_color7, R.id.ib_color8, R.id.ib_color9, R.id.ib_color10, R.id.ib_color11, R.id.ib_color12,
            R.id.ib_color13, R.id.ib_color14, R.id.ib_color15, R.id.ib_color16, R.id.ib_color17, R.id.ib_color18,
            R.id.ib_color19, R.id.ib_color20, R.id.ib_color21, R.id.ib_color22, R.id.ib_color23, R.id.ib_color24,
            R.id.ib_color25, R.id.ib_color26, R.id.ib_color27, R.id.ib_color28, R.id.ib_color29, R.id.ib_color30,
            R.id.ib_color31})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_hair:
                showHorizontalItem(1);
                break;
            case R.id.btn_beard:
                showHorizontalItem(2);
                break;
            case R.id.btn_mus:
                showHorizontalItem(3);
                break;
            case R.id.btn_glasses:
                showHorizontalItem(4);
                break;
            case R.id.btn_tattoo:
                showHorizontalItem(5);
                break;
            case R.id.btn_cap:
                showHorizontalItem(6);
                break;
            case R.id.btn_suite:
                checkNetworkConnection();
                break;
            case R.id.btn_close_hair:
                /*Ẩn HorizontalScrollView item*/
                if (hsvItem.getVisibility() == View.VISIBLE && rlColor.getVisibility() == View.VISIBLE) {
                    hsvItem.setVisibility(View.INVISIBLE);
                    rlColor.setVisibility(View.INVISIBLE);
                    btnCloseHair.setVisibility(View.INVISIBLE);
                    btnRotate.setVisibility(View.INVISIBLE);
                    btnSaveHair.setVisibility(View.INVISIBLE);
                }
                //Hiển thị categories
                if (rlStyles.getVisibility() == View.INVISIBLE) {
                    rlStyles.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.btn_rotate:
                /*Rotate item selected*/

                break;
            case R.id.btn_save_hair:
                break;
            case R.id.btn_edit:
                openEditEffectActivity();
                break;

            case R.id.ib_color0:
                break;
            case R.id.ib_color1:
                break;
            case R.id.ib_color2:
                break;
            case R.id.ib_color3:
                break;
            case R.id.ib_color4:
                break;
            case R.id.ib_color5:
                break;
            case R.id.ib_color6:
                break;
            case R.id.ib_color7:
                break;
            case R.id.ib_color8:
                break;
            case R.id.ib_color9:
                break;
            case R.id.ib_color10:
                break;
        }
    }

    /**
     *
     */
    private void openEditEffectActivity() {

    }


    //https://www.youtube.com/watch?v=a08gJ_tw_14
    /*Show hair item*/
    private void showHorizontalItem(int index) {
        /*Get item type hair*/
        //Ẩn Relative style
        rlStyles.setVisibility(View.INVISIBLE);
        //Hien thi layout chua horizontal
        rlColor.setVisibility(View.VISIBLE);
        hsvItem.setVisibility(View.VISIBLE);

        //Hien thi cac imageview
        btnCloseHair.setVisibility(View.VISIBLE);
        btnRotate.setVisibility(View.VISIBLE);
        btnSaveHair.setVisibility(View.VISIBLE);
        /*Remove all item*/
        hsvItem.removeAllViews();
        //Tạo LinearLayout horizontal
        LinearLayout llItemStyle = new LinearLayout(this);
        llItemStyle.setOrientation(LinearLayout.HORIZONTAL);
        float f = getResources().getDisplayMetrics().density * 50.0f;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (int) f);
        llItemStyle.setLayoutParams(layoutParams);

        switch (index) {
            case 1:
                itemSize = 31;
                tagStyle = "img";
                tagItem = "Hair";
                break;
            case 2:
                itemSize = 31;
                tagStyle = "mustachi";
                tagItem = "Beard";
                break;
            case 3:
                itemSize = 14;
                tagStyle = "mus";
                tagItem = "Mustachi";
                break;
            case 4:
                itemSize = 12;
                tagStyle = "glass";
                tagItem = "Glass";
                break;
            case 5:
                itemSize = 19;
                tagStyle = "tatto";
                tagItem = "Tattoo";
                break;
            case 6:
                itemSize = 19;
                tagStyle = "cap";
                tagItem = "Caps";
                break;
            case 7:
                break;
        }
        itemSize = 31;
        for (int i = 1; i < itemSize; i++) {
            /*Lay anh tu drawable*/
            final int identifier = getResources().getIdentifier(tagStyle + i, "drawable", getPackageName());
            final ImageButton imageButton = new ImageButton(this);
            imageButton.setLayoutParams(new LinearLayout.LayoutParams((int) f, (int) f));
            imageButton.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageButton.setBackgroundColor(Color.parseColor("#00ffffff"));
            imageButton.setTag(tagItem + "_" + i);
            imageButton.setImageResource(identifier);


            /*Su kien click cho button*/
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Logger.i(tagItem, (String) imageButton.getTag());
                    //set item duoc chon resize item
                    Glide.with(EditPhotoActivity.this).load(identifier).into(imgChooseStyle);
                }
            });
            llItemStyle.addView(imageButton);
        }
        hsvItem.addView(llItemStyle);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

}
