package phamhaidang.itplus.vn.truyenapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import phamhaidang.itplus.vn.truyenapp.Adapter.CategoryAdapter;
import phamhaidang.itplus.vn.truyenapp.FakeModel.Category;
import phamhaidang.itplus.vn.truyenapp.FakeModel.FakeData;
import phamhaidang.itplus.vn.truyenapp.R;

import java.util.ArrayList;

public class CategoryFragment extends Fragment {
    RecyclerView catreycler;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.frm_category,container,false);
        catreycler=(RecyclerView) v.findViewById(R.id.catreycler);
        ArrayList<Category> fakecategory=new ArrayList<>();
        for(Category item: FakeData.categories){
            fakecategory.add(item);
        }
        CategoryAdapter categoryAdapter=new CategoryAdapter(fakecategory);
        catreycler.setLayoutManager(new GridLayoutManager(getContext(),2));
        catreycler.setAdapter(categoryAdapter);
        return v;
    }
}
