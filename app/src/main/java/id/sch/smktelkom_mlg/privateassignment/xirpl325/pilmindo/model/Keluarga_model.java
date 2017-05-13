package id.sch.smktelkom_mlg.privateassignment.xirpl325.pilmindo.model;

import java.util.List;

/**
 * Created by Widya on 5/13/2017.
 */

public class Keluarga_model {
    public String page;
    public List<Model> results;
    public String total_results;
    public String total_pages;


    public class Model {

        public String judul;
        public String deskripsi;
        public String imageView;
        public String backdrop_path;
        public String poster_path;
        public String adult;
        public String overview;
        public String release_date;
        public String id;
        public String original_title;
        public String original_language;
        public String title;
        public String popularity;
        public String vote_count;
        public String video;
        public String vote_average;
        public String img;
    }
}

