package phamhaidang.itplus.vn.truyenapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import phamhaidang.itplus.vn.truyenapp.R;

public class LastestFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frm_lastest, container, false);

        getActivity().getSupportFragmentManager()
                .beginTransaction().replace(R.id.frmlastestcontent, new LastUpdatedFragment()).commit();
        return v;
    }

}
