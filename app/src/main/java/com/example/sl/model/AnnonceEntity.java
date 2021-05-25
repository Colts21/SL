package com.example.sl.model;

import android.graphics.drawable.Drawable;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

import java.time.LocalDateTime;

public class AnnonceEntity {

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "image")
    Drawable image;

    @ColumnInfo(name = "title")
    String title;

    @ColumnInfo(name = "price")
    String price;

    @ColumnInfo(name = "date")
    LocalDateTime date;

    @ColumnInfo(name = "description")
    String description;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
