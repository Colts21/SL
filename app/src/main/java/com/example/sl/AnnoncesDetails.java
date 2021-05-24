package com.example.sl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AnnoncesDetails extends AppCompatActivity {

    ImageView imageView, backView;
    TextView annonceTitle, annoncePrice, annonceDescription;
    String title, price, description;

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

        annonceTitle.setText(title);
        annoncePrice.setText(price + " €");
        annonceDescription.setText(description);

        backView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}