package com.example.sl.ui.home;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.sl.R;
import com.example.sl.RecyclerViewAdapter;
import com.example.sl.databinding.FragmentHomeBinding;
import com.example.sl.databinding.ItemDesignBinding;
import com.example.sl.model.AnnonceEntity;
import com.example.sl.network.AnnonceService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {

    //La classe FragmentHomeBinding est générée automatiquement grâce aux tag <layout>
    private FragmentHomeBinding binding;
    private List<AnnonceEntity> annonceList = new ArrayList<>();;
    private RecyclerViewAdapter recyclerViewAdapter;

    //Appel de l'API via retrofit
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://localhost:5001/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    AnnonceService annonceService = retrofit.create(AnnonceService.class);

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //Accès à tous le layout et les vues via le binding
        binding = FragmentHomeBinding.inflate(getLayoutInflater());

        //Appel de la liste via l'API
        Call<List<AnnonceEntity>> call = annonceService.getAnnonces();

        call.enqueue(new Callback<List<AnnonceEntity>>() {
            @Override
            public void onResponse(Call<List<AnnonceEntity>> call, Response<List<AnnonceEntity>> response) {
                annonceList = response.body();
                recyclerViewAdapter = new RecyclerViewAdapter(annonceList);
                binding.recyclerView.setAdapter(recyclerViewAdapter);
            }

            @Override
            public void onFailure(Call<List<AnnonceEntity>> call, Throwable t) {

            }
        });

       /* annonceList.add(new AnnonceEntity(1, ResourcesCompat.getDrawable(getResources(), R.drawable.fifa,null), "Fifa", "25€", "10/04/2021", "Test"));
        annonceList.add(new AnnonceEntity(2, ResourcesCompat.getDrawable(getResources(), R.drawable.rl,null), "Rocket League", "5€", "05/04/2021","Test1"));
        annonceList.add(new AnnonceEntity(3, ResourcesCompat.getDrawable(getResources(), R.drawable.uno,null), "Uno", "5€", "01/04/2021","Test2"));
        annonceList.add(new AnnonceEntity(4, ResourcesCompat.getDrawable(getResources(), R.drawable.fortnite,null), "Fornite", "1€", "24/03/2021","Test3"));
        annonceList.add(new AnnonceEntity(1, ResourcesCompat.getDrawable(getResources(), R.drawable.fifa,null), "Fifa", "25€", "Test"));
        annonceList.add(new AnnonceEntity(2, ResourcesCompat.getDrawable(getResources(), R.drawable.rl,null), "Rocket League", "5€", "Test1"));
        annonceList.add(new AnnonceEntity(3, ResourcesCompat.getDrawable(getResources(), R.drawable.uno,null), "Uno", "5€", "Test2"));
        annonceList.add(new AnnonceEntity(4, ResourcesCompat.getDrawable(getResources(), R.drawable.fortnite,null), "Fornite", "1€", "Test3"));*/

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(annonceList);

        binding.recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        binding.recyclerView.setAdapter(adapter);

        return binding.getRoot();
    }
}