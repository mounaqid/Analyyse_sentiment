package com.bo;

import java.awt.Color;

public class Square extends Figure {
    private double x,y,side;

    
    public Square(String type, Color color, String name, double x, double y, double side) {
		super(type, color, name);
		this.x = x;
		this.y = y;
		this.side = side;
	}

    public Square(double x, double y, double side, Color color, String name) {
        super("square", color, name);
        this.x = x;
        this.y = y;
        this.side = side;
    }
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	public String toString()
    {
    	return "c'est un carré x:"+x+" y :"+y+" coté : "+side;
    }
   
    }

    
    
   

