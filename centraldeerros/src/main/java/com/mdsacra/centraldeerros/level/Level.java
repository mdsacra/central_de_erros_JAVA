package com.mdsacra.centraldeerros.level;

public enum Level {

    ERR(1), WARN(2), INFO(3);

    private Integer level;

    Level(Integer level){
        this.level = level;
    }

    public Level getLevel(){
        return this;
    }
}
