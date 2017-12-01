package phamhaidang.itplus.vn.truyenapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import phamhaidang.itplus.vn.truyenapp.R;

/**
 * Created by heroh on 11/12/2017.
 */

public class Info_tabdetailmanga_fragment extends android.support.v4.app.Fragment {
    TextView txt_Gern_infodetailmanga,txt_Description_infodetailmanga;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frm_tabinfo_detailmanga,container,false);
        return view;
    }

    public static Info_tabdetailmanga_fragment newInstance(String Gerne, String Descripton) {
        Bundle args = new Bundle();
        Info_tabdetailmanga_fragment fragment = new Info_tabdetailmanga_fragment();
        args.putString("Gerne",Gerne);
        args.putString("Descripton",Descripton);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        txt_Description_infodetailmanga=(TextView)view.findViewById(R.id.txt_Description_infodetailmanga);
        txt_Gern_infodetailmanga=(TextView)view.findViewById(R.id.txt_Gern_infodetailmanga);
        String gerne = "", description = "";
        gerne = getArguments().getString("Gerne");
        description = getArguments().getString("Descripton");
        txt_Description_infodetailmanga.setText(description);
        txt_Gern_infodetailmanga.setText(gerne);
    }


}
