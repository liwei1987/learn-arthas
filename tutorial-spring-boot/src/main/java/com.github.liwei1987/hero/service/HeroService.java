package com.github.liwei1987.hero.service;

import com.github.liwei1987.hero.bean.Hero;
import com.github.liwei1987.hero.exception.HeroInfoNotEnoughException;
import com.github.liwei1987.hero.exception.HeroNotFoundException;
import com.github.liwei1987.hero.respository.HeroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroService {

    private static final Logger logger = LoggerFactory.getLogger(HeroService.class.getSimpleName());

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
     * 获取英雄总数
     *
     * @return 英雄总数
     */
    public long getTotalHeroCount() {
        return heroRepository.getTotalHeroCount();
    }

    /**
     * 通过ID获取英雄
     *
     * @param id 英雄ID
     * @return 英雄
     */
    public Hero getHeroById(Long id) throws HeroNotFoundException {
        logger.debug("get hero by id {}", id);
        Hero hero = heroRepository.getHeroById(id);
        if (hero == null) {
            throw new HeroNotFoundException();
        }
        return hero;
    }

    /**
     * 添加英雄
     *
     * @param id      英雄ID
     * @param newHero 新英雄
     * @return 新增英雄
     */
    public Hero addHero(Long id, Hero newHero) throws HeroInfoNotEnoughException {
        logger.debug("add hero {} {}", id, newHero);
        if (id == null || id <= 0
                || newHero.getName() == null || newHero.getName().trim().equals("")
                || newHero.getDesc() == null || newHero.getDesc().trim().equals("")) {
            throw new HeroInfoNotEnoughException();
        }
        Hero hero = heroRepository.getHeroById(id);
        if (hero == null) {
            heroRepository.addHero(id, newHero);
            hero = heroRepository.getHeroById(id);
        }
        return hero;
    }
}
