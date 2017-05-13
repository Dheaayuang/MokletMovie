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

import id.sch.smktelkom_mlg.privateassignment.xirpl325.pilmindo.KeluargaFragment;
import id.sch.smktelkom_mlg.privateassignment.xirpl325.pilmindo.R;
import id.sch.smktelkom_mlg.privateassignment.xirpl325.pilmindo.model.Keluarga_model;

/**
 * Created by Widya on 5/13/2017.
 */

public class Keluarga extends RecyclerView.Adapter<Keluarga.ViewHolder> {

    ArrayList<Keluarga_model.Model> keluargaList;
    KeluargaFragment keluargaFragment;
    Context context;
    public String url = "http://image.tmdb.org/t/p/w500";
    public String image;
    private int lastposition = -1;


    public Keluarga(KeluargaFragment keluargaFragment, ArrayList<Keluarga_model.Model> mList) {
        this.keluargaFragment = keluargaFragment;
        this.keluargaList = mList;
    }

    @Override
    public Keluarga.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(Keluarga.ViewHolder holder, int position) {
        Keluarga_model.Model klg = keluargaList.get(position);
        holder.tvJudul.setText(klg.judul);
        holder.tvDeskripsi.setText(klg.deskripsi);
        image = url+klg.backdrop_path;
        Glide.with(context).load(image)
                .crossFade()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher)
                .into(holder.ivFoto);

    }

    @Override
    public int getItemCount() {
        if(keluargaList != null)
            return keluargaList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivFoto;
        TextView tvJudul;
        TextView tvDeskripsi;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageView);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudul);
            tvDeskripsi = (TextView) itemView.findViewById(R.id.textViewDeskripsi);
        }
    }
}
