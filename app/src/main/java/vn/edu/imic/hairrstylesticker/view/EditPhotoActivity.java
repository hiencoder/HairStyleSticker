package vn.edu.imic.hairrstylesticker.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.theartofdev.edmodo.cropper.CropImage;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import vn.edu.imic.hairrstylesticker.R;
import vn.edu.imic.hairrstylesticker.network.Style;
import vn.edu.imic.hairrstylesticker.view.fragment.FragmentStyle;

public class EditPhotoActivity extends AppCompatActivity implements FragmentStyle.SendStyle {
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

    /*Lấy ảnh từ drawable*/
    private FragmentManager fmEditPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_photo_3);
        unbinder = ButterKnife.bind(this);
        intent = getIntent();
        initData();
    }

    /*init data*/
    private void initData() {
        result = CropImage.getActivityResult(intent);
        if (result != null) {
            Log.d(TAG, "initData: " + result.getUri());
            imgCrop.setImageURI(result.getUri());
        }
        //imgCrop.setImageURI(result.getUri());

        /*Đổ fragment*/
/*
        fmEditPhoto = getSupportFragmentManager();
        FragmentTransaction ftStyle = fmEditPhoto.beginTransaction();
        ftStyle.add(R.id.frame_content,new FragmentStyle()).commitAllowingStateLoss();
*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void sendStyle(Style style) {

    }

    /*
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
                    final */
/* synthetic *//*
 Imageselection b;

                public void onClick(View view) {
                    this.b.addSelectedImage(view, i2);
                }
            });
            linearLayout.addView(imageButton);
        }
    }
*/
    /*public void SetTintforButton() {
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
*/

}
