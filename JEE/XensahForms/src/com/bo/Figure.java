package com.bo;

import java.awt.Color;

public abstract class Figure {

    
    private String type;
    private Color color;
    private String name;

    public Figure(String type, Color color, String name) {
        this.type = type;
        this.color = color;
        this.name = name;
    }
   
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

}
