package vn.edu.imic.hairrstylesticker.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import vn.edu.imic.hairrstylesticker.R;
import vn.edu.imic.hairrstylesticker.network.Style;
import vn.edu.imic.hairrstylesticker.view.adapter.StyleAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentStyle extends Fragment implements StyleAdapter.StyleClickListener{
    private static final String TAG = FragmentStyle.class.getSimpleName();
    @BindView(R.id.rv_style)
    RecyclerView rvStyle;
    private StyleAdapter styleAdapter;
    private List<Style> styles = new ArrayList<>();
    private Unbinder unbinder;

    public FragmentStyle() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_style, container, false);
        unbinder = ButterKnife.bind(this,view);
        createStyle();
        styleAdapter = new StyleAdapter(getActivity(),styles,this);
        rvStyle.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        rvStyle.setAdapter(styleAdapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    /*Create style*/
    private void createStyle(){
        Style hairs = new Style(1,R.drawable.hair,getActivity().getResources().getString(R.string.txt_hairs));
        styles.add(hairs);
        Style beard = new Style(2,R.drawable.beard,getActivity().getResources().getString(R.string.txt_beard));
        styles.add(beard);
        Style mus = new Style(3,R.drawable.mustachi,getActivity().getResources().getString(R.string.txt_mus));
        styles.add(mus);
        Style glasses = new Style(4,R.drawable.glass,getActivity().getResources().getString(R.string.txt_glasses));
        styles.add(glasses);
        Style tattoo = new Style(5,R.drawable.tattoo,getActivity().getResources().getString(R.string.txt_tattoos));
        styles.add(tattoo);
        Style cap = new Style(6,R.drawable.cap,getActivity().getResources().getString(R.string.txt_caps));
        styles.add(cap);
        Style suite = new Style(7,R.drawable.suite,getActivity().getResources().getString(R.string.txt_suits));
        styles.add(suite);
    }

    @Override
    public void onClick(Style style) {
        //Lấy thông tin style được click truyền sang Fragment
    }
}
