package com.example.animesite;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {

    private final List<Anime> animeList = List.of(
            new Anime(1L,"ゆるゆり","日常",4.9),
            new Anime(2L,"NEW GAME!","お仕事",4.8),
            new Anime(3L,"未確認で進行形","SF",4.7)
    );

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("animeList", animeList);
        return "index";
    }

    @GetMapping("/anime/{id}")
    public String detail(@PathVariable Long id, Model model) {
        for(Anime anime : animeList) {
            if(anime.getId().equals(id)) {
                model.addAttribute("anime", anime);
                return "detail";
            }
        }
        return "redirect:/";
    }
}
