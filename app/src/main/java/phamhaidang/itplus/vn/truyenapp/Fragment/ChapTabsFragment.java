package phamhaidang.itplus.vn.truyenapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import phamhaidang.itplus.vn.truyenapp.Adapter.ChapsAdapter;
import phamhaidang.itplus.vn.truyenapp.FakeModel.Chap;
import phamhaidang.itplus.vn.truyenapp.FakeModel.Manga;
import phamhaidang.itplus.vn.truyenapp.R;

import java.util.ArrayList;

/**
 * Created by heroh on 11/12/2017.
 */

public class ChapTabsFragment extends android.support.v4.app.Fragment {
    ArrayList<Chap> chaps;
    String MangaName;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getContext()).inflate(R.layout.frm_tabchapter_detailmanga, null);
    }

    public static ChapTabsFragment newInstance(ArrayList<Chap> chaps, String MangaName) {
        Bundle args = new Bundle();
        args.putSerializable("chaps", chaps);
        args.putString("Name", MangaName);
        ChapTabsFragment fragment = new ChapTabsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rycycleview_tabchap_mangadetail);
        chaps = (ArrayList<Chap>) getArguments().getSerializable("chaps");
        MangaName = getArguments().getString("Name");
        if (chaps == null) return;
        ChapsAdapter adapter = new ChapsAdapter(chaps, MangaName);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

    }

}
