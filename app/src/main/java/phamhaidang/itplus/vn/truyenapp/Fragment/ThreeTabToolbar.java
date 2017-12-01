package phamhaidang.itplus.vn.truyenapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import phamhaidang.itplus.vn.truyenapp.R;
import phamhaidang.itplus.vn.truyenapp.Temp;

public class ThreeTabToolbar extends Fragment {
    TextView toolbartitle;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.toolbar_cat_do_fa,container,false);
        toolbartitle=(TextView)v.findViewById(R.id.toolbartitle);
        switch (Temp.tabid){
            case 1:
                toolbartitle.setText(getResources().getString(R.string.category));
                Log.d("tab",String.valueOf(Temp.tabid));
                break;
            case 3:
                toolbartitle.setText(getResources().getString(R.string.download));
                Log.d("tab",String.valueOf(Temp.tabid));
                break;
            case 4:
                toolbartitle.setText(getResources().getString(R.string.favorite));
                Log.d("tab",String.valueOf(Temp.tabid));

                break;
        }
        return v;
    }
}
