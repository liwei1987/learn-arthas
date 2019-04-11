package com.github.liwei1987.hero.controller;

import com.github.liwei1987.hero.bean.Hero;
import com.github.liwei1987.hero.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HeroController {

    @Autowired
    private HeroService heroService;

    @GetMapping("/heros")
    public List<Hero> fetchAllHeros() {
        return heroService.getAllHeros();
    }

    @GetMapping("/heros/{id}")
    public Hero fetchHero(@PathVariable Long id) {
        return heroService.getHeroById(id);
    }

    @PutMapping("/heros/{id}")
    public Hero addHero(@PathVariable Long id, @RequestBody Hero newHero) {
        return heroService.addHero(id, newHero);
    }
}
