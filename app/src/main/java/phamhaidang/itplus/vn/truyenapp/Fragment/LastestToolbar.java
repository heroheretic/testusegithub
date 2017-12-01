package phamhaidang.itplus.vn.truyenapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import phamhaidang.itplus.vn.truyenapp.R;

public class LastestToolbar extends Fragment {
    private TextView lastupdate,hotmanga;
    private boolean tabselected=true;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.toolbar_lastest, container, false);
        lastupdate=(TextView)v.findViewById(R.id.lastupdate);
        hotmanga=(TextView)v.findViewById(R.id.hotmanga);
        lastupdate.setSelected(true);
        hotmanga.setSelected(false);
        tabSelectedListener();
        return v;
    }
    private void tabSelectedListener() {
        lastupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!tabselected) {
                    lastupdate.setSelected(true);
                    hotmanga.setSelected(false);
                    lastupdate.setTextColor(ContextCompat.getColor(getContext(), R.color.tabselectedtext));
                    hotmanga.setTextColor(ContextCompat.getColor(getContext(), R.color.tabtext));
                    tabselected = !tabselected;
                    getActivity().getSupportFragmentManager()
                            .beginTransaction().
                            replace(R.id.frmlastestcontent,new LastUpdatedFragment())
                            .commit();
                }
            }
        });
        hotmanga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tabselected) {
                    lastupdate.setTextColor(ContextCompat.getColor(getContext(), R.color.tabtext));
                    hotmanga.setTextColor(ContextCompat.getColor(getContext(), R.color.tabselectedtext));
                    lastupdate.setSelected(false);
                    hotmanga.setSelected(true);

                    tabselected = !tabselected;
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frmlastestcontent,new HotMangaFragment())
                            .commit();
                }
            }
        });
    }
}
