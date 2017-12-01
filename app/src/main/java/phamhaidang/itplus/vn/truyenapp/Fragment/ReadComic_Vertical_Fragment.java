package phamhaidang.itplus.vn.truyenapp.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import phamhaidang.itplus.vn.truyenapp.Activity.ReadManga;
import phamhaidang.itplus.vn.truyenapp.Adapter.MangaPage_Vertical_Adapter;
import phamhaidang.itplus.vn.truyenapp.R;

/**
 * Created by heroh on 11/30/2017.
 */

public class ReadComic_Vertical_Fragment extends Fragment {
    ArrayList<String> lst_img = new ArrayList<>();
    RecyclerView recyclerView;
    TextView txtpagenum;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frm_readcomic_vertical, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Init_view(view);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void Init_view(View view) {
        if (view == null) return;
        recyclerView = (RecyclerView) view.findViewById(R.id.rycview_readmanga);
        txtpagenum = getActivity().findViewById(R.id.txtpagenum_readmanga);
        lst_img = getArguments().getStringArrayList(ReadManga.arg_lst_name);
        if (lst_img.isEmpty()) return;
        final MangaPage_Vertical_Adapter adapter = new MangaPage_Vertical_Adapter(lst_img);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int pos = linearLayoutManager.findFirstVisibleItemPosition() + 1;
                txtpagenum.setText(" Trang " + pos + "/" + adapter.getItemCount() + " ");
            }
        });
        txtpagenum.setText(" Trang " + linearLayoutManager.findFirstVisibleItemPosition() + "/" + adapter.getItemCount() + " ");

    }

    public static ReadComic_Vertical_Fragment newInstance(ArrayList<String> lst) {
        Bundle args = new Bundle();
        args.putSerializable(ReadManga.arg_lst_name, lst);
        ReadComic_Vertical_Fragment fragment = new ReadComic_Vertical_Fragment();
        fragment.setArguments(args);
        return fragment;
    }
}
