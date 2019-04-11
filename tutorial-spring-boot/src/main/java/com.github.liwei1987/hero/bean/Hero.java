package com.github.liwei1987.hero.bean;

public class Hero {

    private Long id;
    private String name;
    private String desc;
    private HeroType heroType;

    public Hero(Long id, String name, String desc, HeroType heroType) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.heroType = heroType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public HeroType getHeroType() {
        return heroType;
    }

    public void setHeroType(HeroType heroType) {
        this.heroType = heroType;
    }
}
