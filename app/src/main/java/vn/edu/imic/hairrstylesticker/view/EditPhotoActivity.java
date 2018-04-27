package vn.edu.imic.hairrstylesticker.view;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.theartofdev.edmodo.cropper.CropImage;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import vn.edu.imic.hairrstylesticker.R;
import vn.edu.imic.hairrstylesticker.utils.Logger;

public class EditPhotoActivity extends AppCompatActivity {
    private static final String TAG = EditPhotoActivity.class.getSimpleName();
    private Intent intent;
    private Uri uri;
    /*Crop image result*/
    CropImage.ActivityResult result;
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

    /*Item duoc chon*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_photo_3);
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
        result = CropImage.getActivityResult(intent);
        if (result != null) {
            Log.d(TAG, "initData: " + result.getUri());
            imgCrop.setImageURI(result.getUri());
        }

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

/*    package com.appwallet.manhairstylepro;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore.Images.Media;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.appwallet.manhairstylepro.MoveGestureDetector.SimpleOnMoveGestureListener;
import com.appwallet.manhairstylepro.RotateGestureDetector.SimpleOnRotateGestureListener;
import com.appwallet.manhairstylepro.ShoveGestureDetector.SimpleOnShoveGestureListener;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.InterstitialAdListener;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader.Builder;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeAppInstallAdView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

    public class Imageselection extends Activity implements OnTouchListener {
        private static final String ADMOB_AD_UNIT_ID = "ca-app-pub-8976725004497773/6810576621";
        private static final String ADMOB_APP_ID = "ca-app-pub-8976725004497773~5645321046";
        private static final int CHECK_PERMISSION_REQUEST_WRITE_STORAGE = 51;
        public static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 1;
        public static int Request_Code = 3;
        static int z;
        ScaleGestureDetector A;
        Matrix B;
        int C;
        int D;
        boolean E = false;
        Uri F = null;
        ImageButton G;
        ImageButton H;
        ImageButton I;
        ImageButton J;
        ImageButton K;
        ImageButton L;
        ImageButton M;
        ImageButton N;
        ImageButton O;
        ImageButton P;
        ImageButton Q;
        ImageButton R;
        Button S;
        Button T;
        ImageView U;
        ImageView V;
        final Context W = this;
        ImageButton X;
        ImageButton Y;
        RelativeLayout Z;
        Integer a;
        int aa;
        String ab = null;
        int ac = 0;
        VerticalSeekBar ad;
        VerticalSeekBar ae;
        RelativeLayout af;
        RelativeLayout ag;
        RelativeLayout ah;
        RelativeLayout ai;
        RelativeLayout aj;
        int ak;
        LinearLayout al;
        TextView am;
        Bitmap b;
        Boolean c = Boolean.valueOf(true);
        Boolean d = Boolean.valueOf(false);
        float e;
        float f;
        int g;
        int h;
        int i;
        int j;
        int k;
        int l;
        int m;
        private int mAlpha = 255;
        private float mFocusX = 0.0f;
        private float mFocusY = 0.0f;
        private int mImageHeight;
        private int mImageWidth;
        private Matrix mMatrix = new Matrix();
        private BroadcastReceiver mMessageReceiver = new BroadcastReceiver(this) {
            final *//* synthetic *//* Imageselection a;

            {
                this.a = r1;
            }

            public void onReceive(Context context, Intent intent) {
                boolean z = intent.getExtras().getBoolean("adLoaded");
                System.out.println("Ad loaded  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                if (z && !this.a.E) {
                    this.a.showFullscreenAd();
                }
            }
        };
        private MoveGestureDetector mMoveDetector;
        private RotateGestureDetector mRotateDetector;
        private float mRotationDegrees = 0.0f;
        private ScaleGestureDetector mScaleDetector;
        private float mScaleFactor = 0.2f;
        private ShoveGestureDetector mShoveDetector;
        private float minScaleFactor = 0.1f;
        int n;
        int o;
        int p;
        int q;
        int r;
        int s;
        int t;
        boolean u = false;
        InterstitialAd v;
        Uri w;
        Bitmap x;
        Bitmap y;

        private class MoveListener extends SimpleOnMoveGestureListener {
            final *//* synthetic *//* Imageselection a;

            private MoveListener(Imageselection imageselection) {
                this.a = imageselection;
            }

            public boolean onMove(MoveGestureDetector moveGestureDetector) {
                PointF focusDelta = moveGestureDetector.getFocusDelta();
                this.a.mFocusX = this.a.mFocusX + focusDelta.x;
                this.a.mFocusY = focusDelta.y + this.a.mFocusY;
                if (this.a.mFocusX <= 0.0f) {
                    this.a.mFocusX = 0.0f;
                } else if (this.a.mFocusY <= 0.0f) {
                    this.a.mFocusY = 0.0f;
                } else if (this.a.mFocusX > ((float) this.a.h)) {
                    this.a.mFocusX = (float) this.a.h;
                } else if (this.a.mFocusY > ((float) this.a.g)) {
                    this.a.mFocusY = (float) this.a.g;
                }
                return true;
            }
        }

        private class RotateListener extends SimpleOnRotateGestureListener {
            final *//* synthetic *//* Imageselection a;

            private RotateListener(Imageselection imageselection) {
                this.a = imageselection;
            }

            public boolean onRotate(RotateGestureDetector rotateGestureDetector) {
                this.a.mRotationDegrees = this.a.mRotationDegrees - rotateGestureDetector.getRotationDegreesDelta();
                return true;
            }
        }

        private class ScaleListener extends SimpleOnScaleGestureListener {
            final *//* synthetic *//* Imageselection a;

            private ScaleListener(Imageselection imageselection) {
                this.a = imageselection;
            }

            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                this.a.mScaleFactor = this.a.mScaleFactor * scaleGestureDetector.getScaleFactor();
                this.a.mScaleFactor = Math.max(0.1f, Math.min(this.a.mScaleFactor, 3.0f));
                this.a.ak = (int) (this.a.mScaleFactor * 100000.0f);
                this.a.ad.post(new Runnable(this) {
                    final *//* synthetic *//* ScaleListener a;

                    {
                        this.a = r1;
                    }

                    public void run() {
                        this.a.a.ad.setProgress(this.a.a.ak);
                    }
                });
                System.out.println("**********************************************************" + this.a.mScaleFactor + "seek value" + this.a.ak);
                return true;
            }
        }

        public class ScaleLitener extends SimpleOnScaleGestureListener {
            final *//* synthetic *//* Imageselection a;

            public ScaleLitener(Imageselection imageselection) {
                this.a = imageselection;
            }

            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                float max = Math.max(0.1f, Math.min(scaleGestureDetector.getScaleFactor(), 0.5f));
                this.a.B.setScale(max, max);
                this.a.U.setImageMatrix(this.a.B);
                System.out.println("sf" + max);
                return true;
            }
        }

        private class ShoveListener extends SimpleOnShoveGestureListener {
            final *//* synthetic *//* Imageselection a;

            private ShoveListener(Imageselection imageselection) {
                this.a = imageselection;
            }

            public boolean onShove(ShoveGestureDetector shoveGestureDetector) {
                this.a.mAlpha = (int) (((float) this.a.mAlpha) + shoveGestureDetector.getShovePixelsDelta());
                if (this.a.mAlpha > 255) {
                    this.a.mAlpha = 255;
                } else if (this.a.mAlpha < 0) {
                    this.a.mAlpha = 0;
                }
                this.a.mAlpha = 255;
                return true;
            }
        }

        private boolean checkPermissionReadExtStorage(int i) {
            if (VERSION.SDK_INT < 23 || checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) {
                return true;
            }
            requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, i);
            return false;
        }

        private boolean checkPermissionWriteExtStorage(int i) {
            if (VERSION.SDK_INT < 23 || checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                return true;
            }
            requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, i);
            return false;
        }

        public static void deleteCache(Context context) {
            try {
                deleteDir(context.getCacheDir());
            } catch (Exception e) {
            }
        }

        public static boolean deleteDir(File file) {
            if (file == null || !file.isDirectory()) {
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

        private int getOrientation(Imageselection imageselection, Uri uri) {
            Cursor query = imageselection.getContentResolver().query(uri, new String[]{"orientation"}, null, null, null);
            if (query.getCount() != 1) {
                return -1;
            }
            query.moveToFirst();
            return query.getInt(0);
        }

        private boolean haveNetworkConnection() {
            boolean z = false;
            boolean z2 = false;
            for (NetworkInfo networkInfo : ((ConnectivityManager) getSystemService("connectivity")).getAllNetworkInfo()) {
                if (networkInfo.getTypeName().equalsIgnoreCase("WIFI") && networkInfo.isConnected()) {
                    z2 = true;
                }
                if (networkInfo.getTypeName().equalsIgnoreCase("MOBILE") && networkInfo.isConnected()) {
                    z = true;
                }
            }
            System.out.print(" haveConnectedWifi :- " + z2);
            System.out.print(" haveConnectedMobile :- " + z);
            return z2 || z;
        }

        private void populateAppInstallAdView(NativeAppInstallAd nativeAppInstallAd, NativeAppInstallAdView nativeAppInstallAdView) {
            VideoController videoController = nativeAppInstallAd.getVideoController();
            videoController.setVideoLifecycleCallbacks(new VideoLifecycleCallbacks(this) {
                final *//* synthetic *//* Imageselection a;

                {
                    this.a = r1;
                }

                public void onVideoEnd() {
                    super.onVideoEnd();
                }
            });
            nativeAppInstallAdView.setHeadlineView(nativeAppInstallAdView.findViewById(R.id.appinstall_headline));
            nativeAppInstallAdView.setBodyView(nativeAppInstallAdView.findViewById(R.id.appinstall_body));
            nativeAppInstallAdView.setCallToActionView(nativeAppInstallAdView.findViewById(R.id.appinstall_call_to_action));
            nativeAppInstallAdView.setIconView(nativeAppInstallAdView.findViewById(R.id.appinstall_app_icon));
            ((TextView) nativeAppInstallAdView.getHeadlineView()).setText(nativeAppInstallAd.getHeadline());
            ((TextView) nativeAppInstallAdView.getBodyView()).setText(nativeAppInstallAd.getBody());
            ((Button) nativeAppInstallAdView.getCallToActionView()).setText(nativeAppInstallAd.getCallToAction());
            ((ImageView) nativeAppInstallAdView.getIconView()).setImageDrawable(nativeAppInstallAd.getIcon().getDrawable());
            MediaView mediaView = (MediaView) nativeAppInstallAdView.findViewById(R.id.appinstall_media);
            ImageView imageView = (ImageView) nativeAppInstallAdView.findViewById(R.id.appinstall_image);
            if (videoController.hasVideoContent()) {
                nativeAppInstallAdView.setMediaView(mediaView);
                imageView.setVisibility(8);
            } else {
                nativeAppInstallAdView.setImageView(imageView);
                mediaView.setVisibility(8);
                imageView.setImageDrawable(((Image) nativeAppInstallAd.getImages().get(0)).getDrawable());
            }
            nativeAppInstallAdView.setNativeAd(nativeAppInstallAd);
        }

        private Bitmap scaleImage(Imageselection imageselection, Uri uri) {
            int i;
            int i2;
            Bitmap decodeStream;
            InputStream openInputStream = imageselection.getContentResolver().openInputStream(uri);
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(openInputStream, null, options);
            openInputStream.close();
            int orientation = getOrientation(imageselection, uri);
            if (orientation == 90 || orientation == 270) {
                i = options.outHeight;
                i2 = options.outWidth;
            } else {
                i = options.outWidth;
                i2 = options.outHeight;
            }
            InputStream openInputStream2 = imageselection.getContentResolver().openInputStream(uri);
            if (i > z || i2 > z) {
                float max = Math.max(((float) i) / ((float) z), ((float) i2) / ((float) z));
                Options options2 = new Options();
                options2.inSampleSize = (int) max;
                decodeStream = BitmapFactory.decodeStream(openInputStream2, null, options2);
            } else {
                decodeStream = BitmapFactory.decodeStream(openInputStream2);
            }
            openInputStream2.close();
            if (orientation > 0) {
                Matrix matrix = new Matrix();
                matrix.postRotate((float) orientation);
                decodeStream = Bitmap.createBitmap(decodeStream, 0, 0, decodeStream.getWidth(), decodeStream.getHeight(), matrix, true);
            }
            String type = imageselection.getContentResolver().getType(uri);
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (type.equals("image/png")) {
                decodeStream.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
            } else if (type.equals("image/jpg") || type.equals("image/jpeg")) {
                decodeStream.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return BitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length);
        }

        public static Bitmap scaleToFitWidth(Bitmap bitmap, int i, int i2) {
            return ((float) bitmap.getHeight()) > ((float) bitmap.getWidth()) ? Bitmap.createScaledBitmap(bitmap, (int) ((((float) i2) / ((float) bitmap.getHeight())) * ((float) bitmap.getWidth())), i2, true) : Bitmap.createScaledBitmap(bitmap, i, (int) ((((float) i) / ((float) bitmap.getWidth())) * ((float) bitmap.getHeight())), true);
        }

        public void AdmobNativeAddLoad() {
            MobileAds.initialize(this, ADMOB_APP_ID);
            Builder builder = new Builder((Context) this, ADMOB_AD_UNIT_ID);
            new AdRequest.Builder().addTestDevice("D83D8E23241AFC8AF71C019B9C3B1602");
            builder.forAppInstallAd(new OnAppInstallAdLoadedListener(this) {
                final *//* synthetic *//* Imageselection a;

                {
                    this.a = r1;
                }

                public void onAppInstallAdLoaded(NativeAppInstallAd nativeAppInstallAd) {
                    FrameLayout frameLayout = (FrameLayout) this.a.findViewById(R.id.fl_adplaceholder);
                    NativeAppInstallAdView nativeAppInstallAdView = (NativeAppInstallAdView) this.a.getLayoutInflater().inflate(R.layout.ad_app_install, null);
                    this.a.populateAppInstallAdView(nativeAppInstallAd, nativeAppInstallAdView);
                    frameLayout.removeAllViews();
                    frameLayout.addView(nativeAppInstallAdView);
                }
            });
            builder.withNativeAdOptions(new NativeAdOptions.Builder().setVideoOptions(new VideoOptions.Builder().setStartMuted(true).build()).build());
            builder.withAdListener(new AdListener(this) {
                final *//* synthetic *//* Imageselection a;

                {
                    this.a = r1;
                }

                public void onAdFailedToLoad(int i) {
                }

                public void onAdLoaded() {
                    super.onAdLoaded();
                }
            }).build().loadAd(new AdRequest.Builder().build());
        }

        public void ApplyColors(View view) {
            switch (view.getId()) {
                case R.id.color0:
                    this.V.setColorFilter(Color.parseColor("#FFFFFF"), Mode.MULTIPLY);
                    return;
                case R.id.color1:
                    this.V.setColorFilter(Color.parseColor("#FF8000"), Mode.MULTIPLY);
                    return;
                case R.id.color10:
                    this.V.setColorFilter(Color.parseColor("#EEE9E9"), Mode.MULTIPLY);
                    return;
                case R.id.color11:
                    this.V.setColorFilter(Color.parseColor("#91553D"), Mode.MULTIPLY);
                    return;
                case R.id.color12:
                    this.V.setColorFilter(Color.parseColor("#EEE0E5"), Mode.MULTIPLY);
                    return;
                case R.id.color13:
                    this.V.setColorFilter(Color.parseColor("#FF4040"), Mode.MULTIPLY);
                    return;
                case R.id.color14:
                    this.V.setColorFilter(Color.parseColor("#D02090"), Mode.MULTIPLY);
                    return;
                case R.id.color15:
                    this.V.setColorFilter(Color.parseColor("#8E8E38"), Mode.MULTIPLY);
                    return;
                case R.id.color16:
                    this.V.setColorFilter(Color.parseColor("#71635A"), Mode.MULTIPLY);
                    return;
                case R.id.color17:
                    this.V.setColorFilter(Color.parseColor("#D8BFD8"), Mode.MULTIPLY);
                    return;
                case R.id.color18:
                    this.V.setColorFilter(Color.parseColor("#71C671"), Mode.MULTIPLY);
                    return;
                case R.id.color19:
                    this.V.setColorFilter(Color.parseColor("#977961"), Mode.MULTIPLY);
                    return;
                case R.id.color2:
                    this.V.setColorFilter(Color.parseColor("#F0E68C"), Mode.MULTIPLY);
                    return;
                case R.id.color20:
                    this.V.setColorFilter(Color.parseColor("#7D9EC0"), Mode.MULTIPLY);
                    return;
                case R.id.color21:
                    this.V.setColorFilter(Color.parseColor("#AB82FF"), Mode.MULTIPLY);
                    return;
                case R.id.color22:
                    this.V.setColorFilter(Color.parseColor("#FFB90F"), Mode.MULTIPLY);
                    return;
                case R.id.color23:
                    this.V.setColorFilter(Color.parseColor("#FFF5E1"), Mode.MULTIPLY);
                    return;
                case R.id.color24:
                    this.V.setColorFilter(Color.parseColor("#4876FF"), Mode.MULTIPLY);
                    return;
                case R.id.color25:
                    this.V.setColorFilter(Color.parseColor("#FFA07A"), Mode.MULTIPLY);
                    return;
                case R.id.color26:
                    this.V.setColorFilter(Color.parseColor("#BCD2EE"), Mode.MULTIPLY);
                    return;
                case R.id.color27:
                    this.V.setColorFilter(Color.parseColor("#7171C6"), Mode.MULTIPLY);
                    return;
                case R.id.color28:
                    this.V.setColorFilter(Color.parseColor("#C1FFC1"), Mode.MULTIPLY);
                    return;
                case R.id.color29:
                    this.V.setColorFilter(Color.parseColor("#B7A69E"), Mode.MULTIPLY);
                    return;
                case R.id.color3:
                    this.V.setColorFilter(Color.parseColor("#00EEEE"), Mode.MULTIPLY);
                    return;
                case R.id.color30:
                    this.V.setColorFilter(Color.parseColor("#BCEE68"), Mode.MULTIPLY);
                    return;
                case R.id.color31:
                    this.V.setColorFilter(Color.parseColor("#404040"), Mode.MULTIPLY);
                    return;
                case R.id.color4:
                    this.V.setColorFilter(Color.parseColor("#FF83FA"), Mode.MULTIPLY);
                    return;
                case R.id.color5:
                    this.V.setColorFilter(Color.parseColor("#E6CEA8"), Mode.MULTIPLY);
                    return;
                case R.id.color6:
                    this.V.setColorFilter(Color.parseColor("#A56B46"), Mode.MULTIPLY);
                    return;
                case R.id.color7:
                    this.V.setColorFilter(Color.parseColor("#B55239"), Mode.MULTIPLY);
                    return;
                case R.id.color8:
                    this.V.setColorFilter(Color.parseColor("#FFAEB9"), Mode.MULTIPLY);
                    return;
                case R.id.color9:
                    this.V.setColorFilter(Color.parseColor("#8D4A43"), Mode.MULTIPLY);
                    return;
                default:
                    return;
            }
        }

        public void Change_Ad_Icon_Color() {
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable(this) {
                final *//* synthetic *//* Imageselection b;

                public void run() {
                    switch ((int) (Math.random() * 20.0d)) {
                        case 1:
                            this.b.X.setColorFilter(Color.parseColor("#EF5350"), Mode.MULTIPLY);
                            break;
                        case 2:
                            this.b.X.setColorFilter(Color.parseColor("#EC407A"), Mode.MULTIPLY);
                            break;
                        case 3:
                            this.b.X.setColorFilter(Color.parseColor("#AB47BC"), Mode.MULTIPLY);
                            break;
                        case 4:
                            this.b.X.setColorFilter(Color.parseColor("#7E57C2"), Mode.MULTIPLY);
                            break;
                        case 5:
                            this.b.X.setColorFilter(Color.parseColor("#5C6BC0"), Mode.MULTIPLY);
                            break;
                        case 6:
                            this.b.X.setColorFilter(Color.parseColor("#42A5F5"), Mode.MULTIPLY);
                            break;
                        case 7:
                            this.b.X.setColorFilter(Color.parseColor("#29B6F6"), Mode.MULTIPLY);
                            break;
                        case 8:
                            this.b.X.setColorFilter(Color.parseColor("#26C6DA"), Mode.MULTIPLY);
                            break;
                        case 9:
                            this.b.X.setColorFilter(Color.parseColor("#26A69A"), Mode.MULTIPLY);
                            break;
                        case 10:
                            this.b.X.setColorFilter(Color.parseColor("#66BB6A"), Mode.MULTIPLY);
                            break;
                        case 11:
                            this.b.X.setColorFilter(Color.parseColor("#9CCC65"), Mode.MULTIPLY);
                            break;
                        case 12:
                            this.b.X.setColorFilter(Color.parseColor("#D4E157"), Mode.MULTIPLY);
                            break;
                        case 13:
                            this.b.X.setColorFilter(Color.parseColor("#FFEE58"), Mode.MULTIPLY);
                            break;
                        case 14:
                            this.b.X.setColorFilter(Color.parseColor("#FFCA28"), Mode.MULTIPLY);
                            break;
                        case 15:
                            this.b.X.setColorFilter(Color.parseColor("#FFA726"), Mode.MULTIPLY);
                            break;
                        case 16:
                            this.b.X.setColorFilter(Color.parseColor("#FF7043"), Mode.MULTIPLY);
                            break;
                        case 17:
                            this.b.X.setColorFilter(Color.parseColor("#8D6E63"), Mode.MULTIPLY);
                            break;
                        case 18:
                            this.b.X.setColorFilter(Color.parseColor("#BDBDBD"), Mode.MULTIPLY);
                            break;
                        case 19:
                            this.b.X.setColorFilter(Color.parseColor("#78909C"), Mode.MULTIPLY);
                            break;
                        case 20:
                            this.b.X.setColorFilter(Color.parseColor("#7D9EC0"), Mode.MULTIPLY);
                            break;
                    }
                    this.b.X.invalidate();
                    handler.postDelayed(this, 2000);
                }
            }, 2000);
        }

        public void CheckInternetConnection() {
            haveNetworkConnection();
            if (haveNetworkConnection()) {
                Download_Dialog_Box();
            } else {
                Toast.makeText(this, "Please connect to Internet", 1).show();
            }
        }

        public void DialogBoxClass_Back() {
            final Dialog dialog = new Dialog(this.W, R.style.Theme.IAPTheme);
            dialog.setContentView(R.layout.dialogbox_back);
            Button button = (Button) dialog.findViewById(R.id.dialogButton_no);
            ((Button) dialog.findViewById(R.id.dialogButtonyes)).setOnClickListener(new OnClickListener(this) {
                final *//* synthetic *//* Imageselection a;

                {
                    this.a = r1;
                }

                public void onClick(View view) {
                    this.a.finish();
                }
            });
            button.setOnClickListener(new OnClickListener(this) {
                final *//* synthetic *//* Imageselection b;

                public void onClick(View view) {
                    dialog.cancel();
                }
            });
            dialog.show();
        }

        public void Download_Dialog_Box() {
            String str;
            final Dialog dialog = new Dialog(this.W, R.style.Theme.IAPTheme);
            dialog.setContentView(R.layout.download_dialog_box);
            Button button = (Button) dialog.findViewById(R.id.dialogButtonyes);
            Button button2 = (Button) dialog.findViewById(R.id.dialogButton_no);
            TextView textView = (TextView) dialog.findViewById(R.id.message);
            TextView textView2 = (TextView) dialog.findViewById(R.id.app_name);
            ImageButton imageButton = (ImageButton) dialog.findViewById(R.id.app_icon);
            switch (this.aa) {
                case 1:
                    textView.setText("Do you want to try 69+ tattoo ?? Please download Tattoo design maker app .");
                    textView2.setText("Tattoo design maker");
                    imageButton.setImageResource(R.drawable.tattoo_maker);
                    str = "com.appwallet.tattoodesignmaker";
                    break;
                case 2:
                    textView.setText("Do you want to try 170+ tattoo ?? Please download Tattoo Design Maker Man Woman app .");
                    textView2.setText("Tattoo Design Maker Man Woman");
                    imageButton.setImageResource(R.drawable.tattoo_all);
                    str = "com.appwallet.tattoodesignforall";
                    break;
                case 3:
                    textView.setText("Do you want to try 24+ glasses ?? Please download Sunglass 4 man and woman app .");
                    textView2.setText("Sunglass 4 man and woman");
                    imageButton.setImageResource(R.drawable.sunglass);
                    str = "com.appwallet.sunglasses";
                    break;
                case 4:
                    textView.setText("Do you want to try 25+ suits ?? Please download Man Photo Suit Montage app .");
                    textView2.setText("Man Photo Suit Montage");
                    imageButton.setImageResource(R.drawable.suit);
                    str = "com.appwallet.manphotosuits";
                    break;
                default:
                    str = null;
                    break;
            }
            button.setOnClickListener(new OnClickListener(this) {
                final *//* synthetic *//* Imageselection b;

                public void onClick(View view) {
                    try {
                        this.b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str)));
                    } catch (ActivityNotFoundException e) {
                        this.b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + str)));
                    }
                }
            });
            button2.setOnClickListener(new OnClickListener(this) {
                final *//* synthetic *//* Imageselection b;

                public void onClick(View view) {
                    dialog.cancel();
                }
            });
            dialog.show();
        }

        public void RotatePanZoomHair(int i, int i2) {
            this.mFocusX = ((float) i) / 2.0f;
            this.mFocusY = ((float) i2) / 2.0f;
            this.e = this.mFocusX;
            this.f = this.mFocusY;
            System.out.println(" mFocusX : ++++ " + this.mFocusX + " mFocusY : ++++ " + this.mFocusY);
            ImageView imageView = (ImageView) findViewById(R.id.top);
            imageView.setOnTouchListener(this);
            Drawable drawable = getResources().getDrawable(R.drawable.img_1);
            this.mImageHeight = drawable.getIntrinsicHeight();
            this.mImageWidth = drawable.getIntrinsicWidth();
            float f = (((float) this.mImageWidth) * this.mScaleFactor) / 2.0f;
            float f2 = (((float) this.mImageHeight) * this.mScaleFactor) / 2.0f;
            this.mMatrix.postScale(this.mScaleFactor, this.mScaleFactor);
            if (this.mScaleFactor <= this.minScaleFactor) {
                this.mScaleFactor = 0.2f;
                this.mMatrix.postScale(this.mScaleFactor, this.mScaleFactor);
            }
            this.mMatrix.postTranslate(this.mFocusX - f, this.mFocusY - f2);
            imageView.setImageMatrix(this.mMatrix);
            System.out.println("MFocus x:" + this.mFocusX + "MFocus y:" + this.mFocusY + "Nex x" + (this.mFocusX - f) + "New Y:" + (this.mFocusY - f2));
            this.mScaleDetector = new ScaleGestureDetector(getApplicationContext(), new ScaleListener());
            this.mRotateDetector = new RotateGestureDetector(getApplicationContext(), new RotateListener());
            this.mMoveDetector = new MoveGestureDetector(getApplicationContext(), new MoveListener());
            this.mShoveDetector = new ShoveGestureDetector(getApplicationContext(), new ShoveListener());
        }

        public void SetTintforButton() {
            ((ImageButton) findViewById(R.id.color1)).setColorFilter(Color.parseColor("#FF8000"), Mode.MULTIPLY);
            ((ImageButton) findViewById(R.id.color2)).setColorFilter(Color.parseColor("#F0E68C"), Mode.MULTIPLY);
            ((ImageButton) findViewById(R.id.color3)).setColorFilter(Color.parseColor("#00EEEE"), Mode.MULTIPLY);
            ((ImageButton) findViewById(R.id.color4)).setColorFilter(Color.parseColor("#FF83FA"), Mode.MULTIPLY);
            ((ImageButton) findViewById(R.id.color5)).setColorFilter(Color.parseColor("#E6CEA8"), Mode.MULTIPLY);
            ((ImageButton) findViewById(R.id.color6)).setColorFilter(Color.parseColor("#A56B46"), Mode.MULTIPLY);
            ((ImageButton) findViewById(R.id.color7)).setColorFilter(Color.parseColor("#B55239"), Mode.MULTIPLY);
            ((ImageButton) findViewById(R.id.color8)).setColorFilter(Color.parseColor("#FFAEB9"), Mode.MULTIPLY);
            ((ImageButton) findViewById(R.id.color9)).setColorFilter(Color.parseColor("#8D4A43"), Mode.MULTIPLY);
            ((ImageButton) findViewById(R.id.color10)).setColorFilter(Color.parseColor("#EEE9E9"), Mode.MULTIPLY);
            ((ImageButton) findViewById(R.id.color11)).setColorFilter(Color.parseColor("#91553D"), Mode.MULTIPLY);
            ((ImageButton) findViewById(R.id.color12)).setColorFilter(Color.parseColor("#EEE0E5"), Mode.MULTIPLY);
            ((ImageButton) findViewById(R.id.color13)).setColorFilter(Color.parseColor("#FF4040"), Mode.MULTIPLY);
            ((ImageButton) findViewById(R.id.color14)).setColorFilter(Color.parseColor("#D02090"), Mode.MULTIPLY);
            ((ImageButton) findViewById(R.id.color15)).setColorFilter(Color.parseColor("#8E8E38"), Mode.MULTIPLY);
            ((ImageButton) findViewById(R.id.color16)).setColorFilter(Color.parseColor("#71635A"), Mode.MULTIPLY);
            ((ImageButton) findViewById(R.id.color17)).setColorFilter(Color.parseColor("#D8BFD8"), Mode.MULTIPLY);
            ((ImageButton) findViewById(R.id.color18)).setColorFilter(Color.parseColor("#71C671"), Mode.MULTIPLY);
            ((ImageButton) findViewById(R.id.color19)).setColorFilter(Color.parseColor("#977961"), Mode.MULTIPLY);
            ((ImageButton) findViewById(R.id.color20)).setColorFilter(Color.parseColor("#7D9EC0"), Mode.MULTIPLY);
            ((ImageButton) findViewById(R.id.color21)).setColorFilter(Color.parseColor("#AB82FF"), Mode.MULTIPLY);
            ((ImageButton) findViewById(R.id.color22)).setColorFilter(Color.parseColor("#FFB90F"), Mode.MULTIPLY);
            ((ImageButton) findViewById(R.id.color23)).setColorFilter(Color.parseColor("#FFF5E1"), Mode.MULTIPLY);
            ((ImageButton) findViewById(R.id.color24)).setColorFilter(Color.parseColor("#4876FF"), Mode.MULTIPLY);
            ((ImageButton) findViewById(R.id.color25)).setColorFilter(Color.parseColor("#FFA07A"), Mode.MULTIPLY);
            ((ImageButton) findViewById(R.id.color26)).setColorFilter(Color.parseColor("#BCD2EE"), Mode.MULTIPLY);
            ((ImageButton) findViewById(R.id.color27)).setColorFilter(Color.parseColor("#7171C6"), Mode.MULTIPLY);
            ((ImageButton) findViewById(R.id.color28)).setColorFilter(Color.parseColor("#C1FFC1"), Mode.MULTIPLY);
            ((ImageButton) findViewById(R.id.color29)).setColorFilter(Color.parseColor("#B7A69E"), Mode.MULTIPLY);
            ((ImageButton) findViewById(R.id.color30)).setColorFilter(Color.parseColor("#BCEE68"), Mode.MULTIPLY);
        }

        public void VisibilityThings(boolean z) {
            int i = 4;
            this.ag.setVisibility(4);
            if (z) {
                removeScrollview();
                this.ag.setVisibility(0);
            } else {
                i = 0;
            }
            this.N.setVisibility(i);
            this.P.setVisibility(i);
            this.Q.setVisibility(i);
            this.ah.setVisibility(i);
            this.aj.setVisibility(i);
            this.ai.setVisibility(i);
        }

        public void addSelectedImage(View view, int i) {
            this.V.setColorFilter(-1, Mode.MULTIPLY);
            String str = (String) ((ImageButton) view).getTag();
            int identifier;
            if (this.ab.equals("tatto")) {
                if (i < 16) {
                    identifier = this.W.getResources().getIdentifier(str, "drawable", this.W.getPackageName());
                    this.V.setImageResource(identifier);
                    this.b = ((BitmapDrawable) getResources().getDrawable(identifier)).getBitmap();
                    this.V.setImageBitmap(this.b);
                    return;
                }
                this.N.setVisibility(4);
                this.Q.setVisibility(4);
                this.P.setVisibility(4);
                this.aj.setVisibility(4);
                this.ai.setVisibility(4);
                switch (i) {
                    case 16:
                        this.aa = 1;
                        CheckInternetConnection();
                        return;
                    case 17:
                        this.aa = 2;
                        CheckInternetConnection();
                        return;
                    case 18:
                        this.aa = 1;
                        CheckInternetConnection();
                        return;
                    case 19:
                        this.aa = 2;
                        CheckInternetConnection();
                        return;
                    default:
                        return;
                }
            } else if (!this.ab.equals("glass")) {
                identifier = this.W.getResources().getIdentifier(str, "drawable", this.W.getPackageName());
                this.V.setImageResource(identifier);
                this.b = ((BitmapDrawable) getResources().getDrawable(identifier)).getBitmap();
                this.V.setImageBitmap(this.b);
            } else if (i < 13) {
                identifier = this.W.getResources().getIdentifier(str, "drawable", this.W.getPackageName());
                this.V.setImageResource(identifier);
                this.b = ((BitmapDrawable) getResources().getDrawable(identifier)).getBitmap();
                this.V.setImageBitmap(this.b);
            } else {
                this.N.setVisibility(4);
                this.Q.setVisibility(4);
                this.P.setVisibility(4);
                this.aj.setVisibility(4);
                this.ai.setVisibility(4);
                switch (i) {
                    case 13:
                        this.aa = 3;
                        CheckInternetConnection();
                        return;
                    case 14:
                        this.aa = 3;
                        CheckInternetConnection();
                        return;
                    default:
                        return;
                }
            }
        }

        public void checkImageRotation(final boolean z) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            float f = getResources().getDisplayMetrics().density;
            System.out.println("************" + f);
            int i3 = i2 - ((int) (f * 200.0f));
            final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rootRelative);
            relativeLayout.getMeasuredWidth();
            relativeLayout.getMeasuredHeight();
            System.out.println("D_width" + i + "D_height" + i3);
            try {
                this.y = resizeImageToNewSize(scaleImage(this, this.F), i, i3);
                this.mImageWidth = this.y.getWidth();
                this.mImageHeight = this.y.getHeight();
                Bitmap scaleToFitWidth = scaleToFitWidth(this.y, i, i3);
                fixOrientation(scaleToFitWidth);
                this.b = scaleToFitWidth;
                this.U.setImageBitmap(scaleToFitWidth);
                this.U.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                    final *//* synthetic *//* Imageselection c;

                    public boolean onPreDraw() {
                        this.c.U.getViewTreeObserver().removeOnPreDrawListener(this);
                        this.c.g = this.c.U.getMeasuredHeight();
                        this.c.h = this.c.U.getMeasuredWidth();
                        relativeLayout.getLayoutParams().width = this.c.h;
                        relativeLayout.getLayoutParams().height = this.c.g;
                        relativeLayout.requestLayout();
                        this.c.U.getLayoutParams().width = this.c.mImageWidth;
                        this.c.U.getLayoutParams().height = this.c.mImageHeight;
                        this.c.V.getLayoutParams().width = this.c.mImageWidth;
                        this.c.V.getLayoutParams().height = this.c.mImageHeight;
                        if (z) {
                            this.c.RotatePanZoomHair(this.c.h, this.c.g);
                        }
                        return true;
                    }
                });
            } catch (Exception e) {
                this.y = resizeImageToNewSize(this.y, i, i3);
                this.mImageWidth = this.y.getWidth();
                this.mImageHeight = this.y.getHeight();
                this.U.setImageBitmap(this.y);
                Bitmap scaleToFitWidth2 = scaleToFitWidth(this.y, i, i3);
                fixOrientation(scaleToFitWidth2);
                this.b = scaleToFitWidth2;
                this.U.setImageBitmap(scaleToFitWidth2);
                System.out.println("*************" + scaleToFitWidth2);
                this.U.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                    final *//* synthetic *//* Imageselection c;

                    public boolean onPreDraw() {
                        this.c.U.getViewTreeObserver().removeOnPreDrawListener(this);
                        this.c.g = this.c.U.getMeasuredHeight();
                        this.c.h = this.c.U.getMeasuredWidth();
                        relativeLayout.getLayoutParams().width = this.c.h;
                        relativeLayout.getLayoutParams().height = this.c.g;
                        this.c.u = true;
                        this.c.U.getLayoutParams().width = this.c.mImageWidth;
                        this.c.U.getLayoutParams().height = this.c.mImageHeight;
                        this.c.V.getLayoutParams().width = this.c.mImageWidth;
                        this.c.V.getLayoutParams().height = this.c.mImageHeight;
                        if (z) {
                            this.c.RotatePanZoomHair(this.c.h, this.c.g);
                        }
                        relativeLayout.requestLayout();
                        return true;
                    }
                });
            }
        }

        public Bitmap fixOrientation(Bitmap bitmap) {
            if (bitmap.getWidth() <= bitmap.getHeight()) {
                return bitmap;
            }
            Matrix matrix = new Matrix();
            matrix.postRotate(90.0f);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        }

        public Bitmap getScreenShot() {
            View findViewById = findViewById(R.id.rootRelative);
            findViewById.setDrawingCacheEnabled(true);
            Bitmap createBitmap = Bitmap.createBitmap(findViewById.getDrawingCache());
            findViewById.setDrawingCacheEnabled(false);
            createBitmap = Bitmap.createBitmap(createBitmap.getWidth(), createBitmap.getHeight(), Config.ARGB_8888);
            findViewById.draw(new Canvas(createBitmap));
            return createBitmap;
        }

        public void loadAdmobFullScreenAd() {
            this.v = new InterstitialAd(this);
            AdSettings.addTestDevice("b53920a84ef0877ad9802fd53743f0a2");
            this.v.setAdUnitId("ca-app-pub-8976725004497773/7122054244");
            this.v.loadAd(new AdRequest.Builder().addTestDevice("4cb9c10aebd5f3198ced52c1ed996c7b").build());
            this.v.setAdListener(new AdListener(this) {
                final *//* synthetic *//* Imageselection a;

                {
                    this.a = r1;
                }

                public void onAdClosed() {
                    super.onAdClosed();
                    this.a.v.loadAd(new AdRequest.Builder().addTestDevice("BE1CF57BCC1403EE6E6823EA5C157E82").build());
                }

                public void onAdFailedToLoad(int i) {
                    super.onAdFailedToLoad(i);
                }

                public void onAdLoaded() {
                    super.onAdLoaded();
                    System.out.println("Ad loaded admob !!!!!!!!!!!!!!");
                    MyApplicationClass.interstitialAd_admob = this.a.v;
                    Intent intent = new Intent("AdLoadedNotification");
                    intent.putExtra("adLoaded", true);
                    LocalBroadcastManager.getInstance(this.a).sendBroadcast(intent);
                }

                public void onAdOpened() {
                    super.onAdOpened();
                }
            });
            MyApplicationClass.interstitialAd_admob = this.v;
        }

        public void loadFacebookFullScreenAd() {
            final com.facebook.ads.InterstitialAd interstitialAd = new com.facebook.ads.InterstitialAd(this, "1034598203292120_1052045518214055");
            AdSettings.addTestDevice("b53920a84ef0877ad9802fd53743f0a2");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            interstitialAd.loadAd();
            interstitialAd.setAdListener(new InterstitialAdListener(this) {
                final *//* synthetic *//* Imageselection b;

                public void onAdClicked(Ad ad) {
                }

                public void onAdLoaded(Ad ad) {
                    System.out.println("ad loaded^^^^^^^^^^^^^^^");
                    MyApplicationClass.interstitialAd_facebook = interstitialAd;
                    Intent intent = new Intent("AdLoadedNotification");
                    intent.putExtra("adLoaded", true);
                    LocalBroadcastManager.getInstance(this.b).sendBroadcast(intent);
                }

                public void onError(Ad ad, AdError adError) {
                }

                public void onInterstitialDismissed(Ad ad) {
                    System.out.println("Dismissed  ^^^^^^^^^^^^^^^");
                    interstitialAd.loadAd();
                }

                public void onInterstitialDisplayed(Ad ad) {
                }

                public void onLoggingImpression(Ad ad) {
                }
            });
            MyApplicationClass.interstitialAd_facebook = interstitialAd;
        }

        protected void onActivityResult(int i, int i2, Intent intent) {
            super.onActivityResult(i, i2, intent);
            if (i == Request_Code && i2 == 3) {
                this.F = Uri.parse(intent.getStringExtra("erase_image"));
                InputStream inputStream = null;
                try {
                    inputStream = getContentResolver().openInputStream(this.F);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                this.y = BitmapFactory.decodeStream(inputStream);
                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                checkImageRotation(false);
            }
        }

        public void onBackPressed() {
            DialogBoxClass_Back();
        }

        @RequiresApi(api = 16)
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            if (VERSION.SDK_INT < 16) {
                getWindow().setFlags(1024, 1024);
            }
            setContentView(R.layout.imageselection);
            getWindow().addFlags(1024);
            showFullscreenAd();
            LocalBroadcastManager.getInstance(this).registerReceiver(this.mMessageReceiver, new IntentFilter("AdLoadedNotification"));
            Change_Ad_Icon_Color();
            checkPermissionWriteExtStorage(51);
            checkPermissionReadExtStorage(1);
            this.am = (TextView) findViewById(R.id.appname);
            this.am.setVisibility(4);
            this.af = (RelativeLayout) findViewById(R.id.parent_layout);
            this.ag = (RelativeLayout) findViewById(R.id.main_layout);
            this.ah = (RelativeLayout) findViewById(R.id.sub_parent_layout);
            this.ag.setVisibility(0);
            this.ah.setVisibility(4);
            this.S = (Button) findViewById(R.id.styles);
            this.T = (Button) findViewById(R.id.done);
            this.S.setTextColor(SupportMenu.CATEGORY_MASK);
            this.G = (ImageButton) findViewById(R.id.selectsuitbutton);
            this.H = (ImageButton) findViewById(R.id.bread);
            this.I = (ImageButton) findViewById(R.id.selectmustachebutton);
            this.J = (ImageButton) findViewById(R.id.glasses);
            this.K = (ImageButton) findViewById(R.id.tattoos);
            this.L = (ImageButton) findViewById(R.id.cap);
            this.U = (ImageView) findViewById(R.id.bottom);
            this.V = (ImageView) findViewById(R.id.top);
            this.N = (ImageButton) findViewById(R.id.SaveHair);
            this.P = (ImageButton) findViewById(R.id.close_hair);
            this.N.setVisibility(4);
            this.P.setVisibility(4);
            this.Q = (ImageButton) findViewById(R.id.flip);
            this.Q.setVisibility(4);
            this.M = (ImageButton) findViewById(R.id.reset);
            this.O = (ImageButton) findViewById(R.id.save);
            this.R = (ImageButton) findViewById(R.id.suite);
            this.al = (LinearLayout) findViewById(R.id.progress_bar);
            this.al.setVisibility(4);
            this.aj = (RelativeLayout) findViewById(R.id.rotation_layout);
            this.aj.setVisibility(4);
            this.ai = (RelativeLayout) findViewById(R.id.zoom_layout);
            this.ai.setVisibility(4);
            this.ad = (VerticalSeekBar) findViewById(R.id.zoom);
            this.ae = (VerticalSeekBar) findViewById(R.id.rotate);
            this.B = new Matrix();
            this.A = new ScaleGestureDetector(this, new ScaleLitener(this));
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            z = i;
            System.gc();
            this.F = Uri.parse(getIntent().getStringExtra("image_Uri"));
            if (this.F != null) {
                InputStream inputStream = null;
                try {
                    inputStream = getContentResolver().openInputStream(this.F);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                this.y = BitmapFactory.decodeStream(inputStream);
                this.mImageWidth = this.y.getWidth();
                this.mImageHeight = this.y.getHeight();
                AdmobNativeAddLoad();
                this.X = (ImageButton) findViewById(R.id.admobNativeButton);
                this.Z = (RelativeLayout) findViewById(R.id.admobNativeAdsShow);
                this.Z.setVisibility(4);
                this.Y = (ImageButton) findViewById(R.id.close);
                findViewById(R.id.admobNativeButton).setOnClickListener(new OnClickListener(this) {
                    final *//* synthetic *//* Imageselection a;

                    {
                        this.a = r1;
                    }

                    public void onClick(View view) {
                        if (this.a.Z.getVisibility() == 4) {
                            this.a.Z.setVisibility(0);
                        } else {
                            this.a.Z.setVisibility(4);
                        }
                    }
                });
                this.Y.setOnClickListener(new OnClickListener(this) {
                    final *//* synthetic *//* Imageselection a;

                    {
                        this.a = r1;
                    }

                    public void onClick(View view) {
                        this.a.Z.setVisibility(4);
                    }
                });
                SetTintforButton();
                displayMetrics = getResources().getDisplayMetrics();
                this.C = displayMetrics.widthPixels;
                this.D = displayMetrics.heightPixels;
                this.y = resizeImageToNewSize(this.y, this.C, this.D);
                if (this.y == null) {
                    Toast.makeText(this, "Please select image", 0).show();
                    return;
                }
                this.b = this.y;
                this.mImageWidth = this.y.getWidth();
                this.mImageHeight = this.y.getHeight();
                System.out.println("mImageWidth" + this.mImageWidth + "mImageHeight" + this.mImageHeight);
                checkImageRotation(true);
                Drawable drawable = getResources().getDrawable(R.drawable.img_1);
                this.j = drawable.getIntrinsicHeight();
                this.i = drawable.getIntrinsicWidth();
                drawable = getResources().getDrawable(R.drawable.mustachi_1);
                this.l = drawable.getIntrinsicHeight();
                this.k = drawable.getIntrinsicWidth();
                drawable = getResources().getDrawable(R.drawable.mus_1);
                this.n = drawable.getIntrinsicHeight();
                this.m = drawable.getIntrinsicWidth();
                drawable = getResources().getDrawable(R.drawable.glass_1);
                this.p = drawable.getIntrinsicHeight();
                this.o = drawable.getIntrinsicWidth();
                drawable = getResources().getDrawable(R.drawable.tatto_1);
                this.r = drawable.getIntrinsicHeight();
                this.q = drawable.getIntrinsicWidth();
                drawable = getResources().getDrawable(R.drawable.cap_1);
                this.t = drawable.getIntrinsicHeight();
                this.s = drawable.getIntrinsicWidth();
                this.ae.setMax(180);
                this.ae.setProgress(90);
                this.ae.setOnSeekBarChangeListener(new OnSeekBarChangeListener(this) {
                    final *//* synthetic *//* Imageselection a;

                    {
                        this.a = r1;
                    }

                    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                        this.a.mRotationDegrees = (float) (i - 90);
                        System.out.println("mRotationDegrees :--------" + this.a.mRotationDegrees);
                        float b = (((float) this.a.mImageWidth) * this.a.mScaleFactor) / 2.0f;
                        float d = (((float) this.a.mImageHeight) * this.a.mScaleFactor) / 2.0f;
                        this.a.mMatrix.reset();
                        this.a.mMatrix.postScale(this.a.mScaleFactor, this.a.mScaleFactor);
                        this.a.mMatrix.postRotate(this.a.mRotationDegrees, b, d);
                        this.a.mMatrix.postTranslate(this.a.mFocusX - b, this.a.mFocusY - d);
                        this.a.V.setImageMatrix(this.a.mMatrix);
                        this.a.V.setAlpha(this.a.mAlpha);
                    }

                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                });
                this.ad.setMax(300000);
                this.ad.setOnSeekBarChangeListener(new OnSeekBarChangeListener(this) {
                    final *//* synthetic *//* Imageselection a;

                    {
                        this.a = r1;
                    }

                    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                        System.out.println("progress:-2 " + i);
                        float f = ((float) i) / 100000.0f;
                        System.out.println("progress:-3 " + f);
                        if (f > 0.1f) {
                            this.a.mScaleFactor = f;
                            f = (((float) this.a.mImageWidth) * this.a.mScaleFactor) / 2.0f;
                            float d = (((float) this.a.mImageHeight) * this.a.mScaleFactor) / 2.0f;
                            this.a.mMatrix.reset();
                            this.a.mMatrix.postScale(this.a.mScaleFactor, this.a.mScaleFactor);
                            if (this.a.mScaleFactor <= this.a.minScaleFactor) {
                                this.a.mScaleFactor = 0.2f;
                                this.a.mMatrix.postScale(this.a.mScaleFactor, this.a.mScaleFactor);
                            }
                            this.a.mMatrix.postRotate(this.a.mRotationDegrees, f, d);
                            this.a.mMatrix.postTranslate(this.a.mFocusX - f, this.a.mFocusY - d);
                            this.a.V.setImageMatrix(this.a.mMatrix);
                            this.a.V.setAlpha(this.a.mAlpha);
                        }
                    }

                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                });
                this.Q.setOnClickListener(new OnClickListener(this) {
                    final *//* synthetic *//* Imageselection a;

                    {
                        this.a = r1;
                    }

                    public void onClick(View view) {
                        if (this.a.V.getDrawable() == null) {
                            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                        } else if (((BitmapDrawable) this.a.V.getDrawable()).getBitmap() == null) {
                        } else {
                            if (this.a.c.booleanValue()) {
                                this.a.c = Boolean.valueOf(false);
                                this.a.V.setImageBitmap(Imageselection.flip(this.a.b, 2));
                                this.a.Q.setImageResource(R.drawable.flip_2);
                                return;
                            }
                            this.a.c = Boolean.valueOf(true);
                            this.a.V.setImageBitmap(this.a.b);
                            this.a.Q.setImageResource(R.drawable.flip_1);
                        }
                    }
                });
                this.T.setOnClickListener(new OnClickListener(this) {
                    final *//* synthetic *//* Imageselection a;

                    {
                        this.a = r1;
                    }

                    public void onClick(View view) {
                        this.a.a = Integer.valueOf(3);
                        this.a.T.setTextColor(SupportMenu.CATEGORY_MASK);
                        this.a.al.setVisibility(0);
                        new Handler().postDelayed(new Runnable(this) {
                            final *//* synthetic *//* AnonymousClass6 a;

                            {
                                this.a = r1;
                            }

                            public void run() {
                                this.a.a.x = this.a.a.getScreenShot();
                                this.a.a.saveBitmap(this.a.a.x);
                                Intent intent = new Intent(this.a.a, Effect_Activity.class);
                                intent.putExtra("imageToShare-uri", this.a.a.w.toString());
                                this.a.a.startActivityForResult(intent, Imageselection.Request_Code);
                                this.a.a.al.setVisibility(4);
                                this.a.a.T.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                            }
                        }, 1000);
                    }
                });
                this.G.setOnClickListener(new OnClickListener(this) {
                    final *//* synthetic *//* Imageselection a;

                    {
                        this.a = r1;
                    }

                    public void onClick(View view) {
                        this.a.showScrollViewWithIndex(1);
                    }
                });
                this.H.setOnClickListener(new OnClickListener(this) {
                    final *//* synthetic *//* Imageselection a;

                    {
                        this.a = r1;
                    }

                    public void onClick(View view) {
                        this.a.showScrollViewWithIndex(2);
                    }
                });
                this.I.setOnClickListener(new OnClickListener(this) {
                    final *//* synthetic *//* Imageselection a;

                    {
                        this.a = r1;
                    }

                    public void onClick(View view) {
                        this.a.showScrollViewWithIndex(3);
                    }
                });
                this.J.setOnClickListener(new OnClickListener(this) {
                    final *//* synthetic *//* Imageselection a;

                    {
                        this.a = r1;
                    }

                    public void onClick(View view) {
                        this.a.showScrollViewWithIndex(4);
                    }
                });
                this.K.setOnClickListener(new OnClickListener(this) {
                    final *//* synthetic *//* Imageselection a;

                    {
                        this.a = r1;
                    }

                    public void onClick(View view) {
                        this.a.showScrollViewWithIndex(5);
                    }
                });
                this.L.setOnClickListener(new OnClickListener(this) {
                    final *//* synthetic *//* Imageselection a;

                    {
                        this.a = r1;
                    }

                    public void onClick(View view) {
                        this.a.showScrollViewWithIndex(6);
                    }
                });
                this.R.setOnClickListener(new OnClickListener(this) {
                    final *//* synthetic *//* Imageselection a;

                    {
                        this.a = r1;
                    }

                    public void onClick(View view) {
                        this.a.aa = 4;
                        this.a.CheckInternetConnection();
                    }
                });
                this.N.setOnClickListener(new OnClickListener(this) {
                    final *//* synthetic *//* Imageselection a;

                    {
                        this.a = r1;
                    }

                    public void onClick(View view) {
                        this.a.saveImageSaveHair(null);
                        this.a.removeScrollview();
                        this.a.VisibilityThings(true);
                        this.a.V.setImageBitmap(null);
                        Toast.makeText(this.a, " Edited image is saved", 0).show();
                    }
                });
                this.P.setOnClickListener(new OnClickListener(this) {
                    final *//* synthetic *//* Imageselection a;

                    {
                        this.a = r1;
                    }

                    public void onClick(View view) {
                        this.a.removeScrollview();
                        this.a.VisibilityThings(true);
                        this.a.V.setImageBitmap(null);
                    }
                });
                this.M.setOnClickListener(new OnClickListener(this) {
                    final *//* synthetic *//* Imageselection a;

                    {
                        this.a = r1;
                    }

                    public void onClick(View view) {
                        String stringExtra = this.a.getIntent().getStringExtra("image_Uri");
                        this.a.F = Uri.parse(stringExtra);
                        this.a.checkImageRotation(false);
                        this.a.V.setImageBitmap(null);
                        this.a.removeScrollview();
                        this.a.VisibilityThings(true);
                    }
                });
                ((ImageButton) findViewById(R.id.whats_new)).setOnClickListener(new OnClickListener(this) {
                    final *//* synthetic *//* Imageselection a;

                    {
                        this.a = r1;
                    }

                    public void onClick(View view) {
                        this.a.haveNetworkConnection();
                        if (this.a.haveNetworkConnection()) {
                            this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.appwallettech.com/trendy-hair-style/")));
                            return;
                        }
                        Toast.makeText(this.a, "Please connect to Internet", 1).show();
                    }
                });
                this.O.setOnClickListener(new OnClickListener(this) {
                    final *//* synthetic *//* Imageselection a;

                    {
                        this.a = r1;
                    }

                    public void onClick(View view) {
                        this.a.a = Integer.valueOf(2);
                        this.a.am.setVisibility(0);
                        this.a.VisibilityThings(true);
                        this.a.al.setVisibility(0);
                        new Handler().postDelayed(new Runnable(this) {
                            final *//* synthetic *//* AnonymousClass18 a;

                            {
                                this.a = r1;
                            }

                            public void run() {
                                this.a.a.x = this.a.a.getScreenShot();
                                this.a.a.saveBitmap(this.a.a.x);
                                Intent intent = new Intent(this.a.a, ShareImage.class);
                                intent.putExtra("imageToShare-uri", this.a.a.w.toString());
                                this.a.a.startActivityForResult(intent, 5);
                                this.a.a.al.setVisibility(4);
                                this.a.a.am.setVisibility(4);
                            }
                        }, 500);
                    }
                });
            }
        }

        protected void onDestroy() {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mMessageReceiver);
            Runtime.getRuntime().gc();
            if (this.y != null) {
                this.y.recycle();
                this.y = null;
            }
            deleteCache(this);
            Runtime.getRuntime().runFinalization();
            Runtime.getRuntime().gc();
            super.onDestroy();
        }

        protected void onPause() {
            super.onPause();
        }

        protected void onPostResume() {
            super.onPostResume();
        }

        public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
            switch (i) {
                case 51:
                    if (iArr[0] == 0) {
                        Environment.getExternalStorageDirectory().canWrite();
                        return;
                    } else {
                        Snackbar.make(findViewById(16908290), (CharSequence) "App Requires Storage Permissions Please Enable it", -2).setAction((CharSequence) "ENABLE", new OnClickListener(this) {
                            final *//* synthetic *//* Imageselection a;

                            {
                                this.a = r1;
                            }

                            public void onClick(View view) {
                                Intent intent = new Intent();
                                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                                intent.addCategory("android.intent.category.DEFAULT");
                                intent.setData(Uri.parse("package:" + this.a.getPackageName()));
                                intent.addFlags(268435456);
                                intent.addFlags(1073741824);
                                intent.addFlags(8388608);
                                this.a.startActivity(intent);
                            }
                        }).show();
                        return;
                    }
                default:
                    return;
            }
        }

        protected void onRestart() {
            super.onRestart();
        }

        protected void onResume() {
            super.onResume();
        }

        protected void onStop() {
            super.onStop();
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.mScaleDetector.onTouchEvent(motionEvent);
            this.mRotateDetector.onTouchEvent(motionEvent);
            this.mMoveDetector.onTouchEvent(motionEvent);
            this.mShoveDetector.onTouchEvent(motionEvent);
            float f = (((float) this.mImageWidth) * this.mScaleFactor) / 2.0f;
            float f2 = (((float) this.mImageHeight) * this.mScaleFactor) / 2.0f;
            this.mMatrix.reset();
            this.mMatrix.postScale(this.mScaleFactor, this.mScaleFactor);
            this.mMatrix.postRotate(this.mRotationDegrees, f, f2);
            this.mMatrix.postTranslate(this.mFocusX - f, this.mFocusY - f2);
            ImageView imageView = (ImageView) view;
            imageView.setImageMatrix(this.mMatrix);
            imageView.setAlpha(this.mAlpha);
            return true;
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            this.A.onTouchEvent(motionEvent);
            return true;
        }

        public void removeScrollview() {
            HorizontalScrollView horizontalScrollView = (HorizontalScrollView) findViewById(R.id.scrollviewForItem);
            LinearLayout linearLayout = (LinearLayout) horizontalScrollView.getChildAt(0);
            if (linearLayout != null && linearLayout.getChildCount() > 0) {
                linearLayout.removeAllViews();
            }
            if (horizontalScrollView.getChildCount() > 0) {
                horizontalScrollView.removeAllViews();
            }
            horizontalScrollView.setVisibility(4);
        }

        public Bitmap resizeImageToNewSize(Bitmap bitmap, int i, int i2) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float f = (float) i;
            float f2 = (float) i2;
            if (!(height == i2 && width == i)) {
                f2 = ((float) i) / ((float) width);
                f = ((float) i2) / ((float) height);
                if (f2 >= f) {
                    f2 = f;
                }
                f = ((float) width) * f2;
                f2 *= (float) height;
            }
            return Bitmap.createScaledBitmap(bitmap, (int) f, (int) f2, true);
        }

        *//* JADX WARNING: inconsistent code. *//*
    *//* Code decompiled incorrectly, please refer to instructions dump. *//*
        public void saveBitmap(Bitmap bitmap) {
            OutputStream fileOutputStream;
            ContentValues contentValues;
            Throwable th;
            OutputStream outputStream = null;
            if (bitmap != null && !bitmap.isRecycled()) {
                File file;
                File file2;
                if (this.a.intValue() == 2) {
                    file = new File(Environment.getExternalStorageDirectory() + "/ManHairMustacheStylePRO");
                    int nextInt = new Random().nextInt(1000);
                    file2 = new File(file, String.format("%s_%d.png", new Object[]{"ManHairMustachePro", Integer.valueOf(nextInt)}));
                } else {
                    file = new File(Environment.getExternalStorageDirectory() + "/Temp");
                    file2 = new File(file, String.format("%s_%d.png", new Object[]{"temp", Integer.valueOf(100)}));
                }
                if (!file.exists()) {
                    file.mkdirs();
                }
                if (file2.exists() && file2.delete()) {
                    try {
                        file2.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
                    } catch (Exception e2) {
                        if (fileOutputStream != null) {
                        }
                        contentValues = new ContentValues(3);
                        contentValues.put("title", "ManHairMustachePro");
                        contentValues.put("mime_type", "image/jpeg");
                        contentValues.put("_data", file2.getAbsolutePath());
                        this.w = Uri.fromFile(file2.getAbsoluteFile());
                        getContentResolver().insert(Media.EXTERNAL_CONTENT_URI, contentValues);
                    } catch (Throwable th2) {
                        outputStream = fileOutputStream;
                        th = th2;
                        if (outputStream == null) {
                            throw th;
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    fileOutputStream = null;
                    if (fileOutputStream != null) {
                    }
                    contentValues = new ContentValues(3);
                    contentValues.put("title", "ManHairMustachePro");
                    contentValues.put("mime_type", "image/jpeg");
                    contentValues.put("_data", file2.getAbsolutePath());
                    this.w = Uri.fromFile(file2.getAbsoluteFile());
                    getContentResolver().insert(Media.EXTERNAL_CONTENT_URI, contentValues);
                } catch (Throwable th3) {
                    th = th3;
                    if (outputStream == null) {
                        throw th;
                    }
                    throw th;
                }
            }
        }

        public void saveImageSaveHair(View view) {
            System.out.println(" saved" + view);
            this.x = getScreenShot();
            this.U.setImageBitmap(this.x);
        }

        public void showFullscreenAd() {
            System.out.println("isadshowvalue" + this.E);
            com.facebook.ads.InterstitialAd interstitialAd = MyApplicationClass.interstitialAd_facebook;
            if (interstitialAd == null) {
                loadFacebookFullScreenAd();
            }
            InterstitialAd interstitialAd2 = MyApplicationClass.interstitialAd_admob;
            if (interstitialAd2 == null) {
                loadAdmobFullScreenAd();
            }
            if (interstitialAd != null && interstitialAd.isAdLoaded()) {
                this.E = true;
                LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mMessageReceiver);
                interstitialAd.show();
            } else if (interstitialAd2 == null || !interstitialAd2.isLoaded()) {
                this.E = false;
                System.out.println("######################################");
            } else {
                this.E = true;
                LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mMessageReceiver);
                interstitialAd2.show();
            }
        }

        public void showScrollViewWithIndex(int i) {
            VisibilityThings(false);
            this.ag.setVisibility(4);
            this.ah.setVisibility(0);
            this.V.setColorFilter(-1, Mode.MULTIPLY);
            removeScrollview();
            this.af.setVisibility(0);
            HorizontalScrollView horizontalScrollView = (HorizontalScrollView) findViewById(R.id.scrollviewForItem);
            horizontalScrollView.setVisibility(0);
            float f = getResources().getDisplayMetrics().density * 50.0f;
            View linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(0);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (int) f);
            linearLayout.setBackgroundColor(0);
            linearLayout.setLayoutParams(layoutParams);
            horizontalScrollView.addView(linearLayout);
            switch (i) {
                case 1:
                    this.mImageHeight = this.j;
                    this.mImageWidth = this.i;
                    this.ac = 42;
                    this.ab = "img";
                    break;
                case 2:
                    this.mImageHeight = this.l;
                    this.mImageWidth = this.k;
                    this.ac = 31;
                    this.ab = "mustachi";
                    break;
                case 3:
                    this.mImageHeight = this.n;
                    this.mImageWidth = this.m;
                    this.ac = 14;
                    this.ab = "mus";
                    break;
                case 4:
                    this.mImageHeight = this.p;
                    this.mImageWidth = this.o;
                    this.ac = 14;
                    this.ab = "glass";
                    break;
                case 5:
                    this.mImageHeight = this.r;
                    this.mImageWidth = this.q;
                    this.ac = 19;
                    this.ab = "tatto";
                    break;
                case 6:
                    this.mImageHeight = this.t;
                    this.mImageWidth = this.t;
                    this.ac = 21;
                    this.ab = "cap";
                    break;
            }
            for (int i2 = 1; i2 <= this.ac; i2++) {
                int identifier = this.W.getResources().getIdentifier(this.ab + i2, "drawable", this.W.getPackageName());
                View imageButton = new ImageButton(this);
                imageButton.setLayoutParams(new LinearLayout.LayoutParams((int) f, (int) f));
                imageButton.setScaleType(ScaleType.CENTER_CROP);
                imageButton.setBackgroundColor(Color.parseColor("#00ffffff"));
                imageButton.setTag(this.ab + "_" + i2);
                imageButton.setImageResource(identifier);
                imageButton.setOnClickListener(new OnClickListener(this) {
                    final *//* synthetic *//* Imageselection b;

                    public void onClick(View view) {
                        this.b.addSelectedImage(view, i2);
                    }
                });
                linearLayout.addView(imageButton);
            }
        }
    }*/

}
