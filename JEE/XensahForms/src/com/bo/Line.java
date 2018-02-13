package com.bo;

import java.awt.Color;


public class Line extends Figure{ 
    private double x1,x2;
    private double y1,y2;
    
	public Line(String type, Color color, String name, double x1, double x2, double y1, double y2) {
		super(type, color, name);
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	 public Line(double x1, double x2, double y1, double y2, Color color, String name) {
	        super("line", color, name);
	        this.x1 = x1;
	        this.x2 = x2;
	        this.y1 = y1;
	        this.y2 = y2;
	    }
	public double getX1() {
		return x1;
	}

	public void setX1(double x1) {
		this.x1 = x1;
	}

	public double getX2() {
		return x2;
	}

	public void setX2(double x2) {
		this.x2 = x2;
	}

	public double getY1() {
		return y1;
	}

	public void setY1(double y1) {
		this.y1 = y1;
	}

	public double getY2() {
		return y2;
	}

	public void setY2(double y2) {
		this.y2 = y2;
	}

	public String toString()
    {
    	return "c'est une ligne x1 "+x1+" y1 "+y1+" x2 "+x2+" y2 "+y2;
    }
    
    
}
