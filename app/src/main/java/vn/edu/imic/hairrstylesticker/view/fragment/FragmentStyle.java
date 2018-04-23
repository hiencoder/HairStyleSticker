package vn.edu.imic.hairrstylesticker.view.fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import vn.edu.imic.hairrstylesticker.R;
import vn.edu.imic.hairrstylesticker.network.Item;
import vn.edu.imic.hairrstylesticker.network.Style;
import vn.edu.imic.hairrstylesticker.utils.Const;
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

    private View view;

    //Tao interface de sendata
    SendStyle sendStyle;
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
        try {
            sendStyle = (SendStyle) getActivity();
        }catch (ClassCastException e){
            throw new ClassCastException("Error when retrieving data!");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_style, container, false);
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
        List<Item> itemHairs = new ArrayList<>();
        itemHairs.add(new Item(R.drawable.img1,"Item 1"));
        itemHairs.add(new Item(R.drawable.img2,"Item 2"));
        itemHairs.add(new Item(R.drawable.img3,"Item 3"));
        itemHairs.add(new Item(R.drawable.img4,"Item 4"));
        itemHairs.add(new Item(R.drawable.img5,"Item 5"));
        itemHairs.add(new Item(R.drawable.img6,"Item 6"));
        itemHairs.add(new Item(R.drawable.img7,"Item 7"));
        itemHairs.add(new Item(R.drawable.img8,"Item 8"));
        itemHairs.add(new Item(R.drawable.img9,"Item 9"));
        itemHairs.add(new Item(R.drawable.img10,"Item 10"));
        itemHairs.add(new Item(R.drawable.img11,"Item 11"));
        itemHairs.add(new Item(R.drawable.img12,"Item 12"));
        itemHairs.add(new Item(R.drawable.img13,"Item 13"));
        itemHairs.add(new Item(R.drawable.img14,"Item 14"));
        itemHairs.add(new Item(R.drawable.img15,"Item 15"));
        itemHairs.add(new Item(R.drawable.img16,"Item 16"));
        itemHairs.add(new Item(R.drawable.img17,"Item 17"));
        itemHairs.add(new Item(R.drawable.img18,"Item 18"));
        itemHairs.add(new Item(R.drawable.img19,"Item 19"));
        itemHairs.add(new Item(R.drawable.img20,"Item 20"));
        itemHairs.add(new Item(R.drawable.img21,"Item 21"));
        itemHairs.add(new Item(R.drawable.img22,"Item 22"));
        itemHairs.add(new Item(R.drawable.img23,"Item 23"));
        itemHairs.add(new Item(R.drawable.img24,"Item 24"));
        itemHairs.add(new Item(R.drawable.img25,"Item 25"));
        itemHairs.add(new Item(R.drawable.img26,"Item 26"));
        itemHairs.add(new Item(R.drawable.img27,"Item 27"));
        itemHairs.add(new Item(R.drawable.img28,"Item 28"));
        itemHairs.add(new Item(R.drawable.img29,"Item 29"));
        itemHairs.add(new Item(R.drawable.img30,"Item 30"));
        itemHairs.add(new Item(R.drawable.img31,"Item 31"));
        itemHairs.add(new Item(R.drawable.img32,"Item 32"));
        itemHairs.add(new Item(R.drawable.img33,"Item 33"));
        itemHairs.add(new Item(R.drawable.img34,"Item 34"));
        itemHairs.add(new Item(R.drawable.img35,"Item 35"));
        itemHairs.add(new Item(R.drawable.img36,"Item 36"));
        itemHairs.add(new Item(R.drawable.img37,"Item 37"));
        itemHairs.add(new Item(R.drawable.img38,"Item 38"));
        itemHairs.add(new Item(R.drawable.img39,"Item 39"));
        itemHairs.add(new Item(R.drawable.img40,"Item 40"));
        itemHairs.add(new Item(R.drawable.img41,"Item 41"));
        itemHairs.add(new Item(R.drawable.img42,"Item 42"));
        Style hairs = new Style(1,R.drawable.hair,getActivity().getResources().getString(R.string.txt_hairs),itemHairs);
        styles.add(hairs);

        List<Item> itemBeards = new ArrayList<>();
        itemBeards.add(new Item(R.drawable.mustachi1,"Item 1"));
        itemBeards.add(new Item(R.drawable.mustachi2,"Item 2"));
        itemBeards.add(new Item(R.drawable.mustachi3,"Item 3"));
        itemBeards.add(new Item(R.drawable.mustachi4,"Item 4"));
        itemBeards.add(new Item(R.drawable.mustachi5,"Item 5"));
        itemBeards.add(new Item(R.drawable.mustachi6,"Item 6"));
        itemBeards.add(new Item(R.drawable.mustachi7,"Item 7"));
        itemBeards.add(new Item(R.drawable.mustachi8,"Item 8"));
        itemBeards.add(new Item(R.drawable.mustachi9,"Item 9"));
        itemBeards.add(new Item(R.drawable.mustachi10,"Item 10"));
        itemBeards.add(new Item(R.drawable.mustachi11,"Item 11"));
        itemBeards.add(new Item(R.drawable.mustachi12,"Item 12"));
        itemBeards.add(new Item(R.drawable.mustachi13,"Item 13"));
        itemBeards.add(new Item(R.drawable.mustachi14,"Item 14"));
        itemBeards.add(new Item(R.drawable.mustachi15,"Item 15"));
        itemBeards.add(new Item(R.drawable.mustachi16,"Item 16"));
        itemBeards.add(new Item(R.drawable.mustachi17,"Item 17"));
        itemBeards.add(new Item(R.drawable.mustachi18,"Item 18"));
        itemBeards.add(new Item(R.drawable.mustachi19,"Item 19"));
        itemBeards.add(new Item(R.drawable.mustachi20,"Item 20"));
        itemBeards.add(new Item(R.drawable.mustachi21,"Item 21"));
        itemBeards.add(new Item(R.drawable.mustachi22,"Item 22"));
        itemBeards.add(new Item(R.drawable.mustachi23,"Item 23"));
        itemBeards.add(new Item(R.drawable.mustachi24,"Item 24"));
        itemBeards.add(new Item(R.drawable.mustachi25,"Item 25"));
        itemBeards.add(new Item(R.drawable.mustachi26,"Item 26"));
        itemBeards.add(new Item(R.drawable.mustachi27,"Item 27"));
        itemBeards.add(new Item(R.drawable.mustachi28,"Item 28"));
        itemBeards.add(new Item(R.drawable.mustachi29,"Item 29"));
        itemBeards.add(new Item(R.drawable.mustachi30,"Item 30"));
        itemBeards.add(new Item(R.drawable.mustachi31,"Item 31"));
        Style beard = new Style(2,R.drawable.beard,getActivity().getResources().getString(R.string.txt_beard),itemBeards);
        styles.add(beard);

        List<Item> itemMus = new ArrayList<>();
        itemMus.add(new Item(R.drawable.mus1,"Item 1"));
        itemMus.add(new Item(R.drawable.mus2,"Item 2"));
        itemMus.add(new Item(R.drawable.mus3,"Item 3"));
        itemMus.add(new Item(R.drawable.mus4,"Item 4"));
        itemMus.add(new Item(R.drawable.mus5,"Item 5"));
        itemMus.add(new Item(R.drawable.mus6,"Item 6"));
        itemMus.add(new Item(R.drawable.mus7,"Item 7"));
        itemMus.add(new Item(R.drawable.mus8,"Item 8"));
        itemMus.add(new Item(R.drawable.mus9,"Item 9"));
        itemMus.add(new Item(R.drawable.mus10,"Item 10"));
        itemMus.add(new Item(R.drawable.mus11,"Item 11"));
        itemMus.add(new Item(R.drawable.mus12,"Item 12"));
        itemMus.add(new Item(R.drawable.mus13,"Item 13"));
        itemMus.add(new Item(R.drawable.mus14,"Item 14"));
        Style mus = new Style(3,R.drawable.mustachi,getActivity().getResources().getString(R.string.txt_mus),itemMus);
        styles.add(mus);

        List<Item> itemGlasses = new ArrayList<>();
        itemGlasses.add(new Item(R.drawable.glass1,"Item 1"));
        itemGlasses.add(new Item(R.drawable.glass2,"Item 2"));
        itemGlasses.add(new Item(R.drawable.glass3,"Item 3"));
        itemGlasses.add(new Item(R.drawable.glass4,"Item 4"));
        itemGlasses.add(new Item(R.drawable.glass5,"Item 5"));
        itemGlasses.add(new Item(R.drawable.glass6,"Item 6"));
        itemGlasses.add(new Item(R.drawable.glass7,"Item 7"));
        itemGlasses.add(new Item(R.drawable.glass8,"Item 8"));
        itemGlasses.add(new Item(R.drawable.glass9,"Item 9"));
        itemGlasses.add(new Item(R.drawable.glass10,"Item 10"));
        itemGlasses.add(new Item(R.drawable.glass11,"Item 11"));
        itemGlasses.add(new Item(R.drawable.glass12,"Item 12"));
        itemGlasses.add(new Item(R.drawable.glass13,"Item 13"));
        itemGlasses.add(new Item(R.drawable.glass14,"Item 14"));
        Style glasses = new Style(4,R.drawable.glass,getActivity().getResources().getString(R.string.txt_glasses),itemGlasses);
        styles.add(glasses);

        List<Item> itemTattoo = new ArrayList<>();
        itemTattoo.add(new Item(R.drawable.tatto1,"Item 1"));
        itemTattoo.add(new Item(R.drawable.tatto2,"Item 2"));
        itemTattoo.add(new Item(R.drawable.tatto3,"Item 3"));
        itemTattoo.add(new Item(R.drawable.tatto4,"Item 4"));
        itemTattoo.add(new Item(R.drawable.tatto5,"Item 5"));
        itemTattoo.add(new Item(R.drawable.tatto6,"Item 6"));
        itemTattoo.add(new Item(R.drawable.tatto7,"Item 7"));
        itemTattoo.add(new Item(R.drawable.tatto8,"Item 8"));
        itemTattoo.add(new Item(R.drawable.tatto9,"Item 9"));
        itemTattoo.add(new Item(R.drawable.tatto10,"Item 10"));
        itemTattoo.add(new Item(R.drawable.tatto11,"Item 11"));
        itemTattoo.add(new Item(R.drawable.tatto12,"Item 12"));
        itemTattoo.add(new Item(R.drawable.tatto13,"Item 13"));
        itemTattoo.add(new Item(R.drawable.tatto14,"Item 14"));
        itemTattoo.add(new Item(R.drawable.tatto15,"Item 15"));
        itemTattoo.add(new Item(R.drawable.tatto16,"Item 16"));
        itemTattoo.add(new Item(R.drawable.tatto17,"Item 17"));
        itemTattoo.add(new Item(R.drawable.tatto18,"Item 18"));
        itemTattoo.add(new Item(R.drawable.tatto19,"Item 19"));
        Style tattoo = new Style(5,R.drawable.tattoo,getActivity().getResources().getString(R.string.txt_tattoos),itemTattoo);
        styles.add(tattoo);

        List<Item> itemCap = new ArrayList<>();
        itemCap.add(new Item(R.drawable.cap1,"Item 1"));
        itemCap.add(new Item(R.drawable.cap2,"Item 2"));
        itemCap.add(new Item(R.drawable.cap3,"Item 3"));
        itemCap.add(new Item(R.drawable.cap4,"Item 4"));
        itemCap.add(new Item(R.drawable.cap5,"Item 5"));
        itemCap.add(new Item(R.drawable.cap6,"Item 6"));
        itemCap.add(new Item(R.drawable.cap7,"Item 7"));
        itemCap.add(new Item(R.drawable.cap8,"Item 8"));
        itemCap.add(new Item(R.drawable.cap9,"Item 9"));
        itemCap.add(new Item(R.drawable.cap10,"Item 10"));
        itemCap.add(new Item(R.drawable.cap11,"Item 11"));
        itemCap.add(new Item(R.drawable.cap12,"Item 12"));
        itemCap.add(new Item(R.drawable.cap13,"Item 13"));
        itemCap.add(new Item(R.drawable.cap14,"Item 14"));
        itemCap.add(new Item(R.drawable.cap15,"Item 15"));
        itemCap.add(new Item(R.drawable.cap16,"Item 16"));
        itemCap.add(new Item(R.drawable.cap17,"Item 17"));
        itemCap.add(new Item(R.drawable.cap18,"Item 18"));
        itemCap.add(new Item(R.drawable.cap19,"Item 19"));
        itemCap.add(new Item(R.drawable.cap20,"Item 20"));
        itemCap.add(new Item(R.drawable.cap21,"Item 21"));
        Style cap = new Style(6,R.drawable.cap,getActivity().getResources().getString(R.string.txt_caps),itemCap);
        styles.add(cap);

        List<Item> itemSuite = new ArrayList<>();
        Style suite = new Style(7,R.drawable.suite,getActivity().getResources().getString(R.string.txt_suits),itemSuite);
        styles.add(suite);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onClick(Style style) {
        //Lấy thông tin style được click truyền sang Fragment
        Toast.makeText(getActivity(),
                "" + style.getStyle(),
                Toast.LENGTH_SHORT).show();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Const.KEY_STYLE,style);
        FragmentDetailStyle detailStyle = new FragmentDetailStyle();
        detailStyle.setArguments(bundle);
        ft.replace(R.id.frame_content,detailStyle).commitAllowingStateLoss();
    }

    /*Interface de send data*/
    public interface SendStyle{
        void sendStyle(Style style);
    }
}
