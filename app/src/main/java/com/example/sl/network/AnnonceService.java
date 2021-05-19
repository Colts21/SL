package com.example.sl.network;

import com.example.sl.model.AnnonceEntity;
import com.example.sl.model.AnnonceRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AnnonceService {

    @GET("annonces")
    Call<List<AnnonceEntity>> getAnnonces();

    @POST("annonces")
    Call<AnnonceEntity> addAnnonces(@Body AnnonceRequest annonceRequest);

    @DELETE("annonces/id")
    Call<Void> deleteAnnonces(@Path("id") String id);
}
