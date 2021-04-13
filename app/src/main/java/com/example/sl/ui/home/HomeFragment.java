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
import com.example.sl.model.AnnonceEntity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;

public class HomeFragment extends Fragment {


    //La classe FragmentHomeBinding est générée automatiquement grâce aux tag <layout>
    private FragmentHomeBinding binding;

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .build();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //Accès à tous le layout et les vues via le binding
        binding = FragmentHomeBinding.inflate(getLayoutInflater());

        List<AnnonceEntity> annonceList = new ArrayList<>();

        annonceList.add(new AnnonceEntity(1, ResourcesCompat.getDrawable(getResources(), R.drawable.fifa,null), "Fifa", "25€", "10/04/2021"));
        annonceList.add(new AnnonceEntity(2, ResourcesCompat.getDrawable(getResources(), R.drawable.rl,null), "Rocket League", "5€", "05/04/2021"));
        annonceList.add(new AnnonceEntity(3, ResourcesCompat.getDrawable(getResources(), R.drawable.uno,null), "Uno", "5€", "01/04/2021"));
        annonceList.add(new AnnonceEntity(4, ResourcesCompat.getDrawable(getResources(), R.drawable.fortnite,null), "Fornite", "1€", "24/03/2021"));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(annonceList);

        binding.recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        binding.recyclerView.setAdapter(adapter);

        return binding.getRoot();

    }
}