package com.goldenictsolutions.win.jobready365_.Employee.PojoJavaClasses;

/**
 * Created by Win on 2/6/2017.
 */
public class Skill {
    String type;
    String level;

    public Skill(String type, String level) {
        this.type = type;
        this.level = level;
    }

    public Skill() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
