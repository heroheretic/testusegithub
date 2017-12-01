package phamhaidang.itplus.vn.truyenapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import phamhaidang.itplus.vn.truyenapp.FakeModel.Category;
import phamhaidang.itplus.vn.truyenapp.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>{
    private ArrayList<Category> datasource;

    public CategoryAdapter(ArrayList<Category> datasource) {
        this.datasource = datasource;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itcatgenre.setText(datasource.get(position).getGenre());
        if(position%2==0){
            if(position>1){

                holder.itcatgenre.getRootView().setPadding(20,10,20,10);
            }else {
                holder.itcatgenre.getRootView().setPadding(20,20,20,10);

            }
        }else {
            if(position>1){
                holder.itcatgenre.getRootView().setPadding(0,10,20,10);
            }else {
                holder.itcatgenre.getRootView().setPadding(0,20,20,10);
            }
        }
    }

    @Override
    public int getItemCount() {
        return datasource.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView itcatgenre;
        public ViewHolder(View itemView) {
            super(itemView);
            itcatgenre=(TextView)itemView.findViewById(R.id.itcatgenre);
        }
    }
}
