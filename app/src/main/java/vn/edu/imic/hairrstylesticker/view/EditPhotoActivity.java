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
        }
    }


    /*Show hair item*/
    private void showHorizontalItem(int index) {
        /*Get item type hair*/
        //Ẩm Relative style
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
            int identifier = getResources().getIdentifier(tagStyle + i, "drawable", getPackageName());
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
