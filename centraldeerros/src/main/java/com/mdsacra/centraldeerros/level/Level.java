package com.mdsacra.centraldeerros.level;

public enum Level {

    ERR(0), WARN(1), INFO(2);

    private Integer level;

    Level(Integer level){
        this.level = level;
    }

    public Level getLevel(){
        return this;
    }
}
