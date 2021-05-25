package com.example.sl.network;

import com.example.sl.model.AnnonceEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AnnonceService {

    @GET("api/annonces")
    Call<List<AnnonceEntity>> getAnnonces();

    @POST("api/annonces")
    Call<AnnonceEntity> addAnnonces(@Body AnnonceEntity annonceEntity);

    @DELETE("api/annonces/id")
    Call<Void> deleteAnnonces(@Path("id") int id);
}
