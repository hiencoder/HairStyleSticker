package vn.edu.imic.hairrstylesticker.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import vn.edu.imic.hairrstylesticker.R;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btn_open_gallery)
    ImageView btnOpenGallery;

    @BindView(R.id.btn_open_camera)
    ImageView btnOpenCamera;

    @BindView(R.id.btn_more_app)
    ImageView btnOpenMoreApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_open_gallery, R.id.btn_open_camera, R.id.btn_more_app})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_open_gallery:

                break;
        }
    }
}
