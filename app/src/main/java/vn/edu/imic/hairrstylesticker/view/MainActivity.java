package vn.edu.imic.hairrstylesticker.view;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
    @BindView(R.id.img_data)
    ImageView imgData;

    /*Duong dan luu anh*/

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
        Intent iOpenCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
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
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
            String imageFileName = "IMG_" + timeStamp + "_";
            File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            image = File.createTempFile(imageFileName,".jpg",storageDir);
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
                data.putExtra(Const.KEY_PHOTO_PATH,myPhotoPath);
                //data.setClass(this,CropImageViewActivity.class);
                /*Chỉnh sửa gọi đến phương thức getIntent của CropImage*/
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
        /*Lay ra anh vua chup cua camera dua sang CropImageViewActivity*/
        if (currentPhotoPath != null){
            addPicToGallery();
            Log.d("ImagePath", "takePictureCamera: " + currentPhotoPath);
            //Intent intent = new Intent(this,CropImageViewActivity.class);
            //intent.putExtra(Const.KEY_PHOTO_PATH,currentPhotoPath);
            imgData.setImageURI(Uri.parse(currentPhotoPath));
            //Glide.with(this).load(currentPhotoPath).into(imgData);
            //startActivity(intent);
            //currentPhotoPath = null;
        }
    }

    //https://android.jlelse.eu/androids-new-image-capture-from-a-camera-using-file-provider-dd178519a954
    //https://developer.android.com/training/camera/photobasics
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


    /*package com.appwallet.manhairstylepro;

import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.internal.view.SupportMenu;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.edmodo.cropper.CropImageView;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class ChooseOption extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 1888;
    private static final int CHECK_PERMISSION_REQUEST_WRITE_STORAGE = 51;
    private static final String FOLDER_NAME = "photoedit/Image/";
    private static final int IMAGE_GALLERY_REQUEST = 20;
    public static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 1;
    int A;
    int B;
    boolean C = Boolean.parseBoolean(null);
    RelativeLayout D;
    CropImageView E;
    int F = 0;
    ImageButton n;
    ImageButton o;
    String p = "http://www.appwallettech.com/appwalletftp/StartAdFile.xml";
    boolean q = false;
    AdView r;
    String[] s = null;
    private Uri selectedImageUri = null;
    int t = VERSION.SDK_INT;
    TextView u;
    TextView v;
    Bitmap w;
    String x;
    int y;
    int z;

    public class AsyncTaskRunner extends AsyncTask<String, Void, NodeList> {
        final /* synthetic */ /*ChooseOption a;

    public AsyncTaskRunner(ChooseOption chooseOption) {
        this.a = chooseOption;
    }

    protected NodeList a(String... strArr) {
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new FileInputStream(new File(Environment.getExternalStorageDirectory(), "2131427360Demo.xml").getPath())));
            parse.getDocumentElement().normalize();
            NodeList elementsByTagName = parse.getElementsByTagName(MimeTypes.BASE_TYPE_APPLICATION);
            System.out.println("Node" + elementsByTagName.getLength());
            this.a.s = new String[elementsByTagName.getLength()];
            return elementsByTagName;
        } catch (Exception e) {
            System.out.println("XML Pasing Excpetion = " + e);
            return null;
        }
    }

    protected void a(NodeList nodeList) {
        int i = 0;
        while (i < nodeList.getLength()) {
            try {
                Element element = (Element) nodeList.item(i);
                String nodeValue = ((Element) element.getElementsByTagName("apkid").item(0)).getChildNodes().item(0).getNodeValue();
                System.out.println(Param.VALUE + nodeValue);
                this.a.s[i] = nodeValue;
                String nodeValue2 = ((Element) element.getElementsByTagName("appname").item(0)).getChildNodes().item(0).getNodeValue();
                System.out.println(Param.VALUE + nodeValue2);
                String nodeValue3 = ((Element) element.getElementsByTagName("imageurl").item(0)).getChildNodes().item(0).getNodeValue();
                System.out.println(Param.VALUE + nodeValue3);
                this.a.updateAd(i, nodeValue, nodeValue3, nodeValue2);
                i++;
            } catch (Exception e) {
                return;
            }
        }
    }

    protected *//* synthetic *//* Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected *//* synthetic *//* void onPostExecute(Object obj) {
        a((NodeList) obj);
    }

    protected void onPreExecute() {
    }
}

public class GetImageClass extends AsyncTask<String, Void, Bitmap> {
    final *//* synthetic *//* ChooseOption a;
    private ImageButton button;
    private String imageUrl;

    private GetImageClass(ChooseOption chooseOption, String str, ImageButton imageButton) {
        this.a = chooseOption;
        this.imageUrl = str;
        this.button = imageButton;
    }

    protected Bitmap a(String... strArr) {
        try {
            return BitmapFactory.decodeStream(new URL(this.imageUrl).openConnection().getInputStream());
        } catch (Exception e) {
            return null;
        }
    }

    protected void a(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        this.button.setImageBitmap(bitmap);
    }

    protected *//* synthetic *//* Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected *//* synthetic *//* void onPostExecute(Object obj) {
        a((Bitmap) obj);
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

    public void Camera(View view) {
        startActivityForResult(new Intent("android.media.action.IMAGE_CAPTURE"), CAMERA_REQUEST);
    }

    public void ImageCrop(Uri uri) {
        if (uri != null) {
            InputStream openInputStream;
            try {
                openInputStream = getContentResolver().openInputStream(uri);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                openInputStream = null;
            }
            try {
                this.w = BitmapFactory.decodeStream(openInputStream);
                this.D.setVisibility(0);
                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                this.w = resizeImageToNewSize(this.w, displayMetrics.widthPixels, displayMetrics.heightPixels - ((int) (getResources().getDisplayMetrics().density * 50.0f)));
                if (this.w != null) {
                    this.E.getLayoutParams().width = this.w.getWidth();
                    this.E.getLayoutParams().height = this.w.getHeight();
                    System.out.println("###################" + this.w.getWidth() + " ### " + this.w.getHeight());
                    this.E.setImageBitmap(this.w);
                    this.E.setAspectRatio(5, 5);
                    return;
                }
                return;
            } catch (Exception e2) {
                Toast.makeText(this, "Please select other image", 0).show();
                return;
            }
        }
        Toast.makeText(this, "Please select other image", 0).show();
    }

    public Uri decodeUri(Uri uri) {
        File file = new File(Environment.getExternalStorageDirectory() + "/Temp");
        if (file.isDirectory()) {
            String[] list = file.list();
            for (String file2 : list) {
                new File(file, file2).delete();
            }
        }
        InputStream inputStream = null;
        try {
            inputStream = getContentResolver().openInputStream(uri);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.w = BitmapFactory.decodeStream(inputStream);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.w = resizeImageToNewSize(this.w, displayMetrics.widthPixels, displayMetrics.heightPixels);
        return saveBitmap(this.w);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == CAMERA_REQUEST && i2 == -1) {
            if (this.t <= 19) {
                ImageCrop(intent.getData());
            } else if (this.t >= 20 && i == CAMERA_REQUEST && i2 == -1) {
                ImageCrop(this.selectedImageUri);
            }
        } else if (i == 20 && i2 == -1) {
            ImageCrop(intent.getData());
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getSupportActionBar().hide();
        if (VERSION.SDK_INT < 16) {
            getWindow().setFlags(1024, 1024);
        }
        setContentView((int) R.layout.chooseoption);
        this.E = (CropImageView) findViewById(R.id.CropImageView);
        this.D = (RelativeLayout) findViewById(R.id.Crop_Activity);
        this.D.setVisibility(4);
        setButtonPlacement();
        this.n = (ImageButton) findViewById(R.id.camera);
        this.o = (ImageButton) findViewById(R.id.gallery);
        parseUrl();
        getWindow().addFlags(1024);
        this.u = (TextView) findViewById(R.id.text2);
        this.v = (TextView) findViewById(R.id.text9);
        this.x = Build.MANUFACTURER;
        System.out.println("manufacturer" + this.x);
        this.n.setOnClickListener(new OnClickListener(this) {
            final *//* synthetic *//* ChooseOption a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (this.a.t <= 19) {
                    this.a.Camera(view);
                } else {
                    this.a.openCamera(view);
                }
            }
        });
        this.o.setOnClickListener(new OnClickListener(this) {
            final *//* synthetic *//* ChooseOption a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.openGallery(view);
            }
        });
        checkPermissionWriteExtStorage(51);
        checkPermissionReadExtStorage(1);
        this.r = new AdView(this, "1034598203292120_1034599049958702", AdSize.BANNER_HEIGHT_50);
        ((LinearLayout) findViewById(R.id.bannerAd)).addView(this.r);
        this.r.setAdListener(new AdListener(this) {
            final *//* synthetic *//* ChooseOption a;

            {
                this.a = r1;
            }

            public void onAdClicked(Ad ad) {
            }

            public void onAdLoaded(Ad ad) {
            }

            public void onError(Ad ad, AdError adError) {
                System.out.println("Not Show Adds" + adError);
            }

            public void onLoggingImpression(Ad ad) {
            }
        });
        AdSettings.addTestDevice("eda8890eef54c7fe6984e0e9ec5d853a");
        this.r.loadAd();
        findViewById(R.id.free_size).setBackgroundColor(Color.parseColor("#a5212121"));
        findViewById(R.id.free_size).setOnClickListener(new OnClickListener(this) {
            final *//* synthetic *//* ChooseOption a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.E.setFixedAspectRatio(false);
                this.a.findViewById(R.id.square).setBackgroundColor(Color.parseColor("#FFFFFF"));
                this.a.findViewById(R.id.free_size).setBackgroundColor(Color.parseColor("#a5212121"));
            }
        });
        findViewById(R.id.square).setOnClickListener(new OnClickListener(this) {
            final *//* synthetic *//* ChooseOption a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.E.setFixedAspectRatio(true);
                this.a.findViewById(R.id.free_size).setBackgroundColor(Color.parseColor("#FFFFFF"));
                this.a.findViewById(R.id.square).setBackgroundColor(Color.parseColor("#a5212121"));
            }
        });
        findViewById(R.id.rotate).setOnClickListener(new OnClickListener(this) {
            final *//* synthetic *//* ChooseOption a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                int i = this.a.F + 90;
                if (this.a.F == 360) {
                    this.a.F = 0;
                }
                this.a.E.rotateImage(i);
                System.out.println("###################" + this.a.w.getWidth() + " ### &&&&&&&&& " + this.a.w.getHeight());
            }
        });
        findViewById(R.id.done).setOnClickListener(new OnClickListener(this) {
            final *//* synthetic *//* ChooseOption a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                Uri saveBitmap = this.a.saveBitmap(this.a.E.getCroppedImage());
                Intent intent = new Intent(this.a, Imageselection.class);
                intent.putExtra("image_Uri", saveBitmap.toString());
                this.a.startActivity(intent);
                this.a.finish();
                this.a.D.setVisibility(4);
            }
        });
    }

    protected void onDestroy() {
        this.r.destroy();
        Runtime.getRuntime().gc();
        if (this.w != null) {
            this.w.recycle();
        }
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
                    this.C = true;
                    return;
                }
                Snackbar action = Snackbar.make(findViewById(16908290), (CharSequence) "App Requires Storage Permissions Please Enable it", -2).setAction((CharSequence) "ENABLE", new OnClickListener(this) {
                    final *//* synthetic *//* ChooseOption a;

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
                });
                action.setActionTextColor((int) SupportMenu.CATEGORY_MASK);
                ((TextView) action.getView().findViewById(R.id.snackbar_text)).setTextColor(-1);
                action.show();
                return;
            default:
                return;
        }
    }

    protected void onRestart() {
        super.onRestart();
    }

    protected void onRestoreInstanceState(@NonNull Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.selectedImageUri = (Uri) bundle.getParcelable("picUri");
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("picUri", this.selectedImageUri);
    }

    protected void onStop() {
        super.onStop();
    }

    public void openCamera(View view) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File file = Environment.getExternalStorageState().equals("mounted") ? new File(Environment.getExternalStorageDirectory(), FOLDER_NAME + File.separator + format + ".jpeg") : new File(getCacheDir(), FOLDER_NAME + File.separator + format + ".jpeg");
        File file2 = new File(Environment.getExternalStorageDirectory(), System.currentTimeMillis() + ".jpeg");
        if (file != null) {
            intent.putExtra("output", Uri.fromFile(file2));
            this.selectedImageUri = Uri.fromFile(file2);
            startActivityForResult(intent, CAMERA_REQUEST);
        }
    }

    public void openGallery(View view) {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setDataAndType(Uri.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath()), "image*//*");
        startActivityForResult(intent, 20);
    }

    public void openStore(View view) {
        String str = "com.appwallet.faceeditor";
        if (this.s == null) {
            try {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://search?q=pub:Appwallet Technologies")));
                return;
            } catch (Exception e) {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/search?q=pub:Appwallet Technologies")));
                return;
            }
        }
        switch (view.getId()) {
            case R.id.adid1:
                str = this.s[0];
                break;
            case R.id.adid2:
                str = this.s[1];
                break;
            case R.id.adid3:
                str = this.s[2];
                break;
            case R.id.adid4:
                str = this.s[3];
                break;
            case R.id.adid5:
                str = this.s[4];
                break;
            case R.id.adid6:
                str = this.s[5];
                break;
        }
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str)));
        } catch (ActivityNotFoundException e2) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + str)));
        }
    }

    public void parseUrl() {
        new AsyncTaskRunner(this).execute(new String[0]);
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
    public Uri saveBitmap(Bitmap bitmap) {
        OutputStream fileOutputStream;
        ContentValues contentValues;
        Throwable th;
        Uri uri = null;
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        File file = new File(Environment.getExternalStorageDirectory() + "/Temp");
        if (!file.exists()) {
            file.mkdirs();
        }
        int nextInt = new Random().nextInt(1000);
        File file2 = new File(file, String.format("%s_%d.png", new Object[]{"Temp", Integer.valueOf(nextInt)}));
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
                Object obj = fileOutputStream;
                if (uri != null) {
                }
                contentValues = new ContentValues(3);
                contentValues.put("title", "Temp");
                contentValues.put("mime_type", "image/jpeg");
                contentValues.put("_data", file2.getAbsolutePath());
                uri = Uri.fromFile(file2.getAbsoluteFile());
                getContentResolver().insert(Media.EXTERNAL_CONTENT_URI, contentValues);
                return uri;
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream == null) {
                    throw th;
                }
                throw th;
            }
        } catch (Exception e3) {
            if (uri != null) {
            }
            contentValues = new ContentValues(3);
            contentValues.put("title", "Temp");
            contentValues.put("mime_type", "image/jpeg");
            contentValues.put("_data", file2.getAbsolutePath());
            uri = Uri.fromFile(file2.getAbsoluteFile());
            getContentResolver().insert(Media.EXTERNAL_CONTENT_URI, contentValues);
            return uri;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            fileOutputStream = null;
            th = th4;
            if (fileOutputStream == null) {
                throw th;
            }
            throw th;
        }
    }

    public void setButtonPlacement() {
        this.B = getResources().getDisplayMetrics().heightPixels;
        System.out.println("height_adLayout2_screen_height" + this.B);
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.textLayout);
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.adLayout);
        final LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.adlayout1);
        final LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.adlayout2);
        final LinearLayout linearLayout4 = (LinearLayout) findViewById(R.id.buttonLayout);
        linearLayout.post(new Runnable(this) {
            final *//* synthetic *//* ChooseOption b;

            public void run() {
                this.b.y = linearLayout.getHeight();
            }
        });
        linearLayout2.post(new Runnable(this) {
            final *//* synthetic *//* ChooseOption b;

            public void run() {
                this.b.z = linearLayout2.getHeight();
            }
        });
        linearLayout3.post(new Runnable(this) {
            final *//* synthetic *//* ChooseOption d;

            public void run() {
                this.d.A = linearLayout3.getHeight();
                System.out.println("height_adLayout2" + this.d.A);
                this.d.A = this.d.z + this.d.A;
                System.out.println("height_adLayout2" + this.d.A);
                relativeLayout.getLayoutParams().height = this.d.A + 100;
                linearLayout4.getHeight();
                int i = this.d.B - (this.d.A + 100);
                System.out.println("height_adLayout2_finalHeight" + i);
                i = (i / 2) + 40;
                System.out.println("height_adLayout2_finalHeight" + i);
                linearLayout4.setPadding(0, i, 0, 0);
            }
        });
    }

    public void updateAd(int i, String str, String str2, String str3) {
        int i2;
        int i3;
        switch (i) {
            case 0:
                i2 = R.id.adid1;
                i3 = R.id.adname1;
                break;
            case 1:
                i2 = R.id.adid2;
                i3 = R.id.adname2;
                break;
            case 2:
                i2 = R.id.adid3;
                i3 = R.id.adname3;
                break;
            case 3:
                i2 = R.id.adid4;
                i3 = R.id.adname4;
                break;
            case 4:
                i2 = R.id.adid5;
                i3 = R.id.adname5;
                break;
            case 5:
                i2 = R.id.adid6;
                i3 = R.id.adname6;
                break;
            default:
                i3 = 0;
                i2 = 0;
                break;
        }
        ImageButton imageButton = (ImageButton) findViewById(i2);
        ((TextView) findViewById(i3)).setText(str3);
        new GetImageClass(str2, imageButton).execute(new String[0]);
    }*/
}
