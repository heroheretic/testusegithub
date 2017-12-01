package phamhaidang.itplus.vn.truyenapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import phamhaidang.itplus.vn.truyenapp.Activity.MangaDetailActivity;
import phamhaidang.itplus.vn.truyenapp.FakeModel.Manga;
import phamhaidang.itplus.vn.truyenapp.R;

import java.util.ArrayList;

/**
 * Created by heroh on 11/8/2017.
 */

public class MangaAdapter extends RecyclerView.Adapter<MangaAdapter.Viewholder_Manga> {
    ArrayList<Manga> mangas;
    Context context;

    public MangaAdapter(ArrayList<Manga> mangas) {
        this.mangas = mangas;
    }

    @Override
    public Viewholder_Manga onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new Viewholder_Manga(LayoutInflater.from(context).inflate(R.layout.latesttab_item, parent, false));
    }

    @Override
    public void onBindViewHolder(Viewholder_Manga holder, int position) {
        final Manga item=mangas.get(position);
        holder.txtname.setText(item.getName());
        Picasso.with(context).load(Uri.parse(item.getAvatar())).resize(200,264).into(holder.Avartar);
        holder.Avartar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity activity=(Activity)context;
                Intent intent=new Intent(activity, MangaDetailActivity.class);
                intent.putExtra("Mangadetail",item);
                activity.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return mangas.size();
    }

    public class Viewholder_Manga extends RecyclerView.ViewHolder {
        TextView txtname;
        ImageView Avartar;

        public Viewholder_Manga(View itemView) {
            super(itemView);
            txtname = (TextView) itemView.findViewById(R.id.txt_latesttab);
            Avartar = (ImageView) itemView.findViewById(R.id.img_avatar_latesttab);
        }


    }
    public static class itemdecor_manga extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.top=10;
            outRect.bottom=10;
            outRect.left=5;
            outRect.right=5;
        }
    }
}
