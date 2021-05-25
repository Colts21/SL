package com.example.sl.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.sl.R;
import com.example.sl.model.AnnonceEntity;
import com.example.sl.network.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddFragment extends Fragment {

    private AddViewModel addViewModel;
    EditText titleId, priceId, descriptionId;
    Button buttonId;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        addViewModel =
                new ViewModelProvider(this).get(AddViewModel.class);
        View root = inflater.inflate(R.layout.fragment_add, container, false);

        titleId = root.findViewById(R.id.titleId);
        priceId = root.findViewById(R.id.priceId);
        descriptionId = root.findViewById(R.id.descriptionId);
        buttonId = root.findViewById(R.id.buttonId);

        buttonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveAnnonce(createRequest());
            }
        });

        return root;
    }

    public AnnonceEntity createRequest(){

        AnnonceEntity annonceEntity = new AnnonceEntity();
        annonceEntity.setTitle(titleId.getText().toString());
        annonceEntity.setPrice(priceId.getText().toString());
        annonceEntity.setDescription(descriptionId.getText().toString());

        return annonceEntity;
    }

    public void saveAnnonce(AnnonceEntity annonceEntity){

        Call<AnnonceEntity> annonceEntityCall= ApiClient.getAnnonceService().addAnnonces(annonceEntity);
        annonceEntityCall.enqueue(new Callback<AnnonceEntity>() {
            @Override
            public void onResponse(Call<AnnonceEntity> call, Response<AnnonceEntity> response) {

                if(response.isSuccessful()){
                    Toast.makeText(getActivity(), "Ajout avec succès", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getActivity(), "Échec de l'ajout", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<AnnonceEntity> call, Throwable t) {
                Toast.makeText(getActivity(), "Échec de l'ajout" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}