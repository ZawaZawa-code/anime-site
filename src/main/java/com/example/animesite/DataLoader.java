package com.example.animesite;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final AnimeRepository animeRepository;

    public DataLoader(AnimeRepository animeRepository){
        this.animeRepository = animeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(animeRepository.count() == 0){
            animeRepository.save(new Anime("ゆるゆり","日常",4.9));
            animeRepository.save(new Anime("NEW GAME!","お仕事",4.8));
            animeRepository.save(new Anime("未確認で進行形","SF",4.7));
            animeRepository.save(new Anime("私に天使が舞い降りた！","日常",4.9));
        }
    }

}
