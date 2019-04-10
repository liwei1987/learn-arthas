package com.github.liwei1987.hero.bean;

public enum HeroType {

    Mage(1, "法师"),
    Warrior(2, "战士"),
    Archer(3, "射手");

    private int typeId;
    private String typeName;

    HeroType(int typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
