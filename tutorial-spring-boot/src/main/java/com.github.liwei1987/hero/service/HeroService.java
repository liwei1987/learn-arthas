package com.github.liwei1987.hero.service;

import com.github.liwei1987.hero.bean.Hero;
import com.github.liwei1987.hero.exception.HeroNotFoundException;
import com.github.liwei1987.hero.respository.HeroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroService {

    private static final Logger logger = LoggerFactory.getLogger(HeroService.class);

    @Autowired
    private HeroRepository heroRepository;

    /**
     * 获取所有英雄
     *
     * @return 英雄列表
     */
    public List<Hero> getAllHeros() {
        return heroRepository.getAllHeros();
    }

    /**
     * 通过ID获取英雄
     *
     * @param id 英雄ID
     * @return 英雄
     */
    public Hero getHeroById(int id) {
        logger.debug("get hero by id {}", id);
        Hero hero = heroRepository.getHeroById(id);
        if (hero == null) {
            throw new HeroNotFoundException();
        }
        return hero;
    }
}
