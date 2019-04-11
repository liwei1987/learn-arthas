package com.github.liwei1987.hero.respository;

import com.github.liwei1987.hero.bean.Hero;
import com.github.liwei1987.hero.bean.HeroType;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class HeroRepository {

    private static Map<String, HeroType> heroTypeMap = new HashMap<String, HeroType>() {{
        put("Mage", new HeroType("法师"));
        put("Warrior", new HeroType("战士"));
        put("Archer", new HeroType("射手"));
    }};

    private static List<Hero> heros = new LinkedList<>();

    static {
        heros.add(new Hero(1L, "妲己", "峡谷第一强，231一套带走。", heroTypeMap.get("Mage")));
        heros.add(new Hero(2L, "亚瑟", "能打能抗，边路一霸。", heroTypeMap.get("Warrior")));
        heros.add(new Hero(3L, "后裔", "脆皮小菜鸡，快去抱辅助大腿吧！！", heroTypeMap.get("Archer")));
    }

    public List<Hero> getAllHeros() {
        return heros;
    }

    public Hero getHeroById(Long id) {
        Hero hero = null;
        Iterator<Hero> iterator = heros.iterator();
        while (iterator.hasNext()) {
            Hero currentHero = iterator.next();
            if (currentHero.getId().equals(id)) {
                hero = currentHero;
                break;
            }
        }
        return hero;
    }

    public void addHero(Long id, Hero newHero) {
        newHero.setId(id);
        heros.add(newHero);
    }
}
