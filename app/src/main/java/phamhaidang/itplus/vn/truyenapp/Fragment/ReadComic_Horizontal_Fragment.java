package phamhaidang.itplus.vn.truyenapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import phamhaidang.itplus.vn.truyenapp.Activity.ReadManga;
import phamhaidang.itplus.vn.truyenapp.Adapter.MangaPage_Horizontal_Adapter;
import phamhaidang.itplus.vn.truyenapp.R;

/**
 * Created by heroh on 11/30/2017.
 */

public class ReadComic_Horizontal_Fragment extends Fragment {
    ArrayList<String> lst_string=new ArrayList<>();
    ViewPager viewPager;
    TextView txtpagenum;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frm_readcomic_horizontal, container,false);
    }
    public static ReadComic_Horizontal_Fragment newInstance(ArrayList<String> lst) {

        Bundle args = new Bundle();
        if (lst!=null||!lst.isEmpty())
            args.putSerializable(ReadManga.arg_lst_name, lst);
        ReadComic_Horizontal_Fragment fragment = new ReadComic_Horizontal_Fragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager=(ViewPager)getView().findViewById(R.id.viewpager_comicreader);
        txtpagenum=(TextView)getActivity().findViewById(R.id.txtpagenum_readmanga);
        InitView();
    }
    public void InitView(){
        lst_string=getArguments().getStringArrayList(ReadManga.arg_lst_name);
        if(lst_string==null) return;
        viewPager.setAdapter(new MangaPage_Horizontal_Adapter(lst_string));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                txtpagenum.setText(" Trang "+String.valueOf(position+1)+"/"+viewPager.getAdapter().getCount()+" ");
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        txtpagenum.setText(" Trang "+1+"/"+viewPager.getAdapter().getCount()+" ");
    }
}
