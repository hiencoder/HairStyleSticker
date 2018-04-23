package vn.edu.imic.hairrstylesticker.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.imic.hairrstylesticker.R;
import vn.edu.imic.hairrstylesticker.network.Style;
import vn.edu.imic.hairrstylesticker.utils.Const;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetailStyle extends Fragment {
    Style styleSelected;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*Nhan thong tin type*/
        Bundle bundle = getArguments();
        if (bundle != null && bundle.getSerializable(Const.KEY_STYLE) != null){
            styleSelected = (Style) bundle.getSerializable(Const.KEY_STYLE);
            Log.d("Style", "onCreate: " + styleSelected.getStyle());
        }
    }

    public FragmentDetailStyle() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_style, container, false);
    }

    /*phuong thuc hien thi thong tin nhan duoc*/
    public void displayStyle(Style style){

    }
}
