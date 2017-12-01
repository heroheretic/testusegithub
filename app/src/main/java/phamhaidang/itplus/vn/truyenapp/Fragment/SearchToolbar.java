package phamhaidang.itplus.vn.truyenapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import phamhaidang.itplus.vn.truyenapp.R;
import phamhaidang.itplus.vn.truyenapp.Temp;

public class SearchToolbar extends Fragment {
    private EditText toolbaredsearch;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.toolbar_search, container, false);
        toolbaredsearch=(EditText) v.findViewById(R.id.toolbaredsearch);
        if(Temp.tabid==2){
            toolbaredsearch.setGravity(Gravity.CENTER|Gravity.START);
            toolbaredsearch.setPadding(200,0,0,0);
        }
        toolbaredsearch.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                toolbaredsearch.setGravity(Gravity.START);
                toolbaredsearch.setPadding(10,0,0,0);
            }
        });

        return v;
    }
}
