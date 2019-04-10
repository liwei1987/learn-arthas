package com.github.liwei1987.hero.bean;

public class Hero {

    private int heroId;
    private String heroName;
    private HeroType heroType;

    public Hero(int heroId, String heroName, HeroType heroType) {
        this.heroId = heroId;
        this.heroName = heroName;
        this.heroType = heroType;
    }

    public int getHeroId() {
        return heroId;
    }

    public void setHeroId(int heroId) {
        this.heroId = heroId;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public HeroType getHeroType() {
        return heroType;
    }

    public void setHeroType(HeroType heroType) {
        this.heroType = heroType;
    }
}
