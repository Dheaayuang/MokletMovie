package id.sch.smktelkom_mlg.privateassignment.xirpl325.pilmindo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl325.pilmindo.TopRateFragment;
import id.sch.smktelkom_mlg.privateassignment.xirpl325.pilmindo.R;
import id.sch.smktelkom_mlg.privateassignment.xirpl325.pilmindo.model.Results;

/**
 * Created by Widya on 5/13/2017.
 */

public class TopRate_Adapter extends RecyclerView.Adapter<TopRate_Adapter.ViewHolder> {

    public String url = "https://image.tmdb.org/t/p/w500";
    public String image;
    ArrayList<Results> keluargaList;
    TopRateFragment keluargaFragment;
    Context context;
    private int lastposition = -1;

    public TopRate_Adapter(TopRateFragment keluargaFragment, ArrayList<Results> keluarga_List, Context context) {
        this.keluargaList = keluarga_List;
        this.keluargaFragment = keluargaFragment;
        this.context = context;

    }

    @Override
    public TopRate_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Results results = keluargaList.get(position);
        holder.tvJudul.setText(results.title);
        holder.tvDeskripsi.setText(results.overview);
        image = url + results.backdrop_path;
        Glide.with(context).load(image)
                .crossFade()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher)
                .into(holder.ivFoto);
    }

    @Override
    public int getItemCount() {
        if (keluargaList != null)
            return keluargaList.size();
        return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvJudul;
        TextView tvDeskripsi;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageViewPoster);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudul);
            tvDeskripsi = (TextView) itemView.findViewById(R.id.textViewDeskripsi);
        }
    }
}
