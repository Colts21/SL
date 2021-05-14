package com.example.sl.repository;

import com.example.sl.model.AnnonceEntity;
import com.example.sl.network.AnnonceService;

import java.util.List;

import retrofit2.Call;

public class AnnonceRepository {

    private AnnonceService annonceService;

    public AnnonceRepository(AnnonceService annonceService){
        this.annonceService = annonceService;
    }

    public Call<List<AnnonceEntity>> getAnnonces(){
        return annonceService.getAnnonces();
    }
}
