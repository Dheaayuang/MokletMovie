package id.sch.smktelkom_mlg.privateassignment.xirpl325.pilmindo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl325.pilmindo.adapter.NowPlaying_Adapter;
import id.sch.smktelkom_mlg.privateassignment.xirpl325.pilmindo.adapter.TopRate_Adapter;
import id.sch.smktelkom_mlg.privateassignment.xirpl325.pilmindo.model.Results;
import id.sch.smktelkom_mlg.privateassignment.xirpl325.pilmindo.model.ResultsResponse;
import id.sch.smktelkom_mlg.privateassignment.xirpl325.pilmindo.service.GsonGetRequest;
import id.sch.smktelkom_mlg.privateassignment.xirpl325.pilmindo.service.VolleySingleton;


/**
 * A simple {@link Fragment} subclass.
 */
public class NowPlayingFragment extends Fragment {
    ArrayList<Results> m_List1 = new ArrayList<>();
    NowPlaying_Adapter nowplaying;
    public NowPlayingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_now_playing,container,false);
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.recyclerView_nowplaying);
        rv.setHasFixedSize(true);
        nowplaying = new NowPlaying_Adapter(this,m_List1, getContext());
        rv.setAdapter(nowplaying);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        downloadDataSources();
        return rootView;
    }

    private void downloadDataSources() {
        String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=70f354f1f8ae96f11d8c36c05208ba86&language=en-US&page=1";

        GsonGetRequest<ResultsResponse> myRequest = new GsonGetRequest<ResultsResponse>
                (url, ResultsResponse.class, null, new Response.Listener<ResultsResponse>() {

                    @Override
                    public void onResponse(ResultsResponse response) {
                        Log.d("FLOW", "onResponse: " + (new Gson().toJson(response)));
                        m_List1.addAll(response.results);
                        nowplaying.notifyDataSetChanged();
                    }

                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("FLOW", "onErrorResponse: ", error);
                    }
                });
        VolleySingleton.getInstance(getActivity()).addToRequestQueue(myRequest);
    }

}
