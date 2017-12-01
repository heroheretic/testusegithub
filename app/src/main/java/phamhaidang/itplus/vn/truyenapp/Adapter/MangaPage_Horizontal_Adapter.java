package phamhaidang.itplus.vn.truyenapp.Adapter;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jsibbold.zoomage.ZoomageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import phamhaidang.itplus.vn.truyenapp.R;

/**
 * Created by heroh on 11/30/2017.
 */

public class MangaPage_Horizontal_Adapter extends PagerAdapter {
    ArrayList<String> linklist;
    public MangaPage_Horizontal_Adapter(ArrayList<String> linklist) {
        this.linklist = linklist;
    }

    @Override
    public int getCount() {
        return linklist.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals((View)object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view= LayoutInflater.from(container.getContext()).inflate(R.layout.item_page_mangareader,null);
        ZoomageView img = view.findViewById(R.id.itempagecomic);
        Picasso.with(container.getContext()).load(linklist.get(position)).fit().centerCrop().into(img);

        container.addView(view);
        return view;
    }
}
