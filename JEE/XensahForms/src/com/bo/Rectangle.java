package com.bo;

import java.awt.Color;

public class Rectangle extends Figure {

    private double x,y;
    private double height;
    private double width;
    
	public Rectangle(String type, Color color, String name, double x, double y, double height, double width) {
		super(type, color, name);
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}

	public Rectangle(double x, double y, double height, double width, Color color, String name) {
        super("rectangle", color, name);
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
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



	public double getHeight() {
		return height;
	}



	public void setHeight(double height) {
		this.height = height;
	}



	public double getWidth() {
		return width;
	}



	public void setWidth(double width) {
		this.width = width;
	}



	public String toString()
    {
    	return "c'est un rectangle x : "+x+" y :"+y+" Height : "+height+" Width "+width ;
    }
}
