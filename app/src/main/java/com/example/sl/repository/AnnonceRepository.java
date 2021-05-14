package com.example.sl.repository;

import com.example.sl.model.AnnonceEntity;
import com.example.sl.network.AnnonceService;

import retrofit2.Call;

public class AnnonceRepository {

    private AnnonceService annonceService;

    public AnnonceRepository(AnnonceService annonceService){
        this.annonceService = annonceService;
    }

    public Call<AnnonceEntity> getAnnoncesById(String id){
        return annonceService.getAnnonces(id);
    }
}
