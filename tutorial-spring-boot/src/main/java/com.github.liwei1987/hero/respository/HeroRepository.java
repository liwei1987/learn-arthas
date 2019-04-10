package com.github.liwei1987.hero.respository;

import com.github.liwei1987.hero.bean.Hero;
import com.github.liwei1987.hero.bean.HeroType;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Service
public class HeroRepository {

    private static List<Hero> heros;

    static {
        Hero daji = new Hero(1, "妲己", HeroType.Mage);
        Hero yase = new Hero(2, "亚瑟", HeroType.Warrior);
        Hero houyi = new Hero(3, "后裔", HeroType.Archer);
        heros = new LinkedList<Hero>();
        heros.add(daji);
        heros.add(yase);
        heros.add(houyi);
    }

    public List<Hero> getAllHeros() {
        return heros;
    }

    public Hero getHeroById(int id) {
        Hero hero = null;
        Iterator<Hero> iterator = heros.iterator();
        while (iterator.hasNext()) {
            Hero currentHero = iterator.next();
            if (id == currentHero.getHeroId()) {
                hero = currentHero;
                break;
            }
        }
        return hero;
    }
}
