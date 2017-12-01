package phamhaidang.itplus.vn.truyenapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import phamhaidang.itplus.vn.truyenapp.Activity.ReadManga;
import phamhaidang.itplus.vn.truyenapp.FakeModel.Chap;
import phamhaidang.itplus.vn.truyenapp.R;

import java.util.ArrayList;

/**
 * Created by heroh on 11/12/2017.
 */

public class ChapsAdapter extends RecyclerView.Adapter<ChapsAdapter.Viewholder_chap> {
    ArrayList<Chap> chaps;
    String Name;
    Context context;
    public ChapsAdapter(ArrayList<Chap> lst,String Name){
        this.chaps=lst;
        this.Name=Name;
    }

    @Override
    public Viewholder_chap onCreateViewHolder(ViewGroup parent, int viewType) {
        context=parent.getContext();
        return new Viewholder_chap(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tabchap_mangadetail,null));
    }

    @Override
    public void onBindViewHolder(Viewholder_chap holder, int position) {
        final Chap item=chaps.get(position);
        holder.txtchapname.setText("Chap "+String.valueOf(item.getChap()));
        holder.btview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity activity=null;
                if(context instanceof Activity)
                    activity=(Activity)context;
                else return;
                Intent intent=new Intent(activity, ReadManga.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable(ReadManga.arg_Chap_name,item);
                bundle.putString(ReadManga.arg_Manganame_name,Name);
                intent.putExtras(bundle);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return chaps.size();
    }

    public class Viewholder_chap extends RecyclerView.ViewHolder{
        TextView txtchapname;
        Button btdownload,btview;
        public Viewholder_chap(View itemView) {
            super(itemView);
            txtchapname=(TextView)itemView.findViewById(R.id.txtchapname_detailmanga);
            btdownload=(Button)itemView.findViewById(R.id.btdownload_detailmanga);
            btview=(Button)itemView.findViewById(R.id.btview_detailmanga);
        }
    }
}
