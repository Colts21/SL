package com.example.sl.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.sl.RecyclerViewAdapter;
import com.example.sl.databinding.FragmentHomeBinding;
import com.example.sl.model.AnnonceEntity;
import com.example.sl.network.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    //La classe FragmentHomeBinding est générée automatiquement grâce aux tag <layout>
    private FragmentHomeBinding binding;
    private List<AnnonceEntity> annonceList = new ArrayList<>();;
    private RecyclerViewAdapter recyclerViewAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //Accès à tous le layout et les vues via le binding
        binding = FragmentHomeBinding.inflate(getLayoutInflater());

        //Appel de la liste via l'API
        Call<List<AnnonceEntity>> call = ApiClient.getAnnonceService().getAnnonces();

        call.enqueue(new Callback<List<AnnonceEntity>>() {
            @Override
            public void onResponse(Call<List<AnnonceEntity>> call, Response<List<AnnonceEntity>> response) {
                annonceList = response.body();
                recyclerViewAdapter = new RecyclerViewAdapter(getContext() , annonceList);
                binding.recyclerView.setAdapter(recyclerViewAdapter);
            }

            @Override
            public void onFailure(Call<List<AnnonceEntity>> call, Throwable t) {

            }
        });

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext() , annonceList);

        binding.recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        binding.recyclerView.setAdapter(adapter);

        return binding.getRoot();
    }
}