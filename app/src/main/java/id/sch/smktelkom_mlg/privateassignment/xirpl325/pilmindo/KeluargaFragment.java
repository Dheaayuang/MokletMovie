package id.sch.smktelkom_mlg.privateassignment.xirpl325.pilmindo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl325.pilmindo.adapter.Keluarga;
import id.sch.smktelkom_mlg.privateassignment.xirpl325.pilmindo.model.Keluarga_model;


/**
 * A simple {@link Fragment} subclass.
 */
public class KeluargaFragment extends Fragment {
    ArrayList<Keluarga_model.Model> mList;
    Keluarga keluarga;
    public KeluargaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_keluarga,container,false);
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.recyclerView_keluarga);
        rv.setHasFixedSize(true);
        keluarga = new Keluarga(this,mList);
        rv.setAdapter(keluarga);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        downloadDataSources();
        return rootView;
    }

    private void downloadDataSources() {
        String url="https://api.themoviedb.org/3/movie/top_rated?api_key=70f354f1f8ae96f11d8c36c05208ba86&language=en-US&page=1";


    }

}