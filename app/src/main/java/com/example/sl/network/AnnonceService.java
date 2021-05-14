package com.example.sl.network;

import com.example.sl.model.AnnonceEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AnnonceService {

    @GET("annonces")
    Call<List<AnnonceEntity>> getAnnonces();
}
