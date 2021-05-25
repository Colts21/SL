package com.example.sl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sl.model.AnnonceEntity;
import com.example.sl.network.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnnoncesDetails extends AppCompatActivity {

    ImageView imageView, backView;
    TextView annonceTitle, annoncePrice, annonceDescription;
    String title, price, description;
    Button deleteView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annonces_details);

        Intent intent = getIntent();

        title = intent.getStringExtra("Titre");
        price = intent.getStringExtra("Prix");
        description = intent.getStringExtra("Description");

        imageView = findViewById(R.id.imageView);
        annonceTitle = findViewById(R.id.titleId);
        annoncePrice = findViewById(R.id.priceId);
        annonceDescription = findViewById(R.id.descriptionId);
        backView = findViewById(R.id.backId);
        deleteView = findViewById(R.id.deleteId);

        annonceTitle.setText(title);
        annoncePrice.setText(price + " €");
        annonceDescription.setText(description);

        backView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        deleteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteAnnonce();
            }
        });
    }

    public void deleteAnnonce(){
        Call<Void> call = ApiClient.getAnnonceService().deleteAnnonces(annonceTitle.getId());
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(getApplicationContext(), "Suppression avec succès", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Echec de la suppression", Toast.LENGTH_LONG).show();
            }
        });
    }
}