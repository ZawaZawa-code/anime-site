package com.example.animesite;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {

    private final AnimeRepository animeRepository;

    public HomeController(AnimeRepository animeRepository){
        this.animeRepository = animeRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("animeList", animeRepository.findAll());
        return "index";
    }

    @GetMapping("/anime/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Anime anime = animeRepository.findById(id).orElse(null);

        if(anime == null) {
            return "redirect:/";
        }

        model.addAttribute("anime", anime);
        return "detail";
    }

    @GetMapping("/anime/new")
    public String showCreateForm(Model model) {
        model.addAttribute("anime", new Anime());
        return "create";
    }

    @PostMapping("/anime")
    public String createAnime(@ModelAttribute Anime anime) {

        if(anime.getTitle() == null || anime.getTitle().trim().isEmpty()){
            return "redirect:/anime/new";
        }

        animeRepository.save(anime);
        return "redirect:/";
    }

    @PostMapping("/anime/{id}/delete")
    public String deleteAnime(@PathVariable Long id) {
        animeRepository.deleteById(id);
        return "redirect:/";
    }

}
