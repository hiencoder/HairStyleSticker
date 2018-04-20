package vn.edu.imic.hairrstylesticker.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.imic.hairrstylesticker.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetailStyle extends Fragment {


    public FragmentDetailStyle() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_style, container, false);
    }

}
