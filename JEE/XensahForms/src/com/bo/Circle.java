package com.bo;

import java.awt.Color;

public class Circle extends Figure{

	double cx;
	double cy;
	double r;
	
	public Circle(String type, Color color, String name, double cx, double cy, double r) {
		super(type, color, name);
		this.cx = cx;
		this.cy = cy;
		this.r = r;
	}
	public Circle(Color color, String name, double cx, double cy, double r) {
		super("circle", color, name);
		this.cx = cx;
		this.cy = cy;
		this.r = r;
	}
	public double getCx() {
		return cx;
	}
	public void setCx(double cx) {
		this.cx = cx;
	}
	public double getCy() {
		return cy;
	}
	public void setCy(double cy) {
		this.cy = cy;
	}
	public double getR() {
		return r;
	}
	public void setR(double r) {
		this.r = r;
	}
	
	public String toString()
    {
    	return "c'est une cercle cx : "+cx+" cy : "+cy+" rayon : "+r;
    }
   
	
	
}
