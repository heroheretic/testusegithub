package phamhaidang.itplus.vn.truyenapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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

public class MangaPage_Vertical_Adapter extends RecyclerView.Adapter<MangaPage_Vertical_Adapter.Viewholder_ReadManga> {
    ArrayList<String> listimg;
    Context context;

    public MangaPage_Vertical_Adapter(ArrayList<String> listimg) {
        this.listimg = listimg;
    }

    @Override
    public Viewholder_ReadManga onCreateViewHolder(ViewGroup parent, int viewType) {
        context=parent.getContext();
        return new Viewholder_ReadManga(LayoutInflater.from(context).inflate(R.layout.item_page_mangareader,parent,false));
    }

    @Override
    public void onBindViewHolder(Viewholder_ReadManga holder, int position) {
        Picasso.with(context).load(listimg.get(position)).fit().centerCrop().into(holder.imageView);
        Picasso.with(context).setLoggingEnabled(true);
    }
    @Override
    public int getItemCount() {
        return listimg.size();
    }

    public class Viewholder_ReadManga extends RecyclerView.ViewHolder{
        ZoomageView imageView;
        public Viewholder_ReadManga(View itemView) {
            super(itemView);
            imageView=(ZoomageView)itemView.findViewById(R.id.itempagecomic);
        }
    }
}
