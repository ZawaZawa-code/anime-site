package com.example.animesite;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "タイトルは必須です")
    private String title;

    @NotBlank(message = "ジャンルは必須です")
    private String genre;

    private double rating;

    public Anime() {
    }

    public Anime(String title, String genre, double rating){
        this.title = title;
        this.genre = genre;
        this.rating = rating;
    }

    public Long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getGenre(){
        return genre;
    }

    public double getRating(){
        return rating;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
