package com.github.liwei1987.hero.controller;

import com.github.liwei1987.hero.bean.Hero;
import com.github.liwei1987.hero.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HeroController {

    @Autowired
    private HeroService heroService;

    @RequestMapping("/heros")
    public List<Hero> fetchAllHeros() {
        return heroService.getAllHeros();
    }

    @RequestMapping("/hero/{id}")
    public Hero fetchHero(@PathVariable int id) {
        return heroService.getHeroById(id);
    }
}
