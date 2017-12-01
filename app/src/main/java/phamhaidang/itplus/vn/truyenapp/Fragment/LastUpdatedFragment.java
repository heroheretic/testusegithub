package phamhaidang.itplus.vn.truyenapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import phamhaidang.itplus.vn.truyenapp.Adapter.MangaAdapter;
import phamhaidang.itplus.vn.truyenapp.FakeModel.FakeData;
import phamhaidang.itplus.vn.truyenapp.R;

public class LastUpdatedFragment extends Fragment {
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frm_tablastupdated, container, false);
        recyclerView=(RecyclerView)v.findViewById(R.id.lastestupdate_recycleview);
        MangaAdapter adapter=new MangaAdapter(FakeData.mangalist);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),3);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new MangaAdapter.itemdecor_manga());
        recyclerView.setAdapter(adapter);
        return v;
    }
}
