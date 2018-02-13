package com.xml;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com.bo.Circle;
import com.bo.Figure;
import com.bo.Line;
import com.bo.Rectangle;
import com.bo.Square;
import com.bo.Triangle;

public class TestPrinter {

	public static void main(String[] args) {

	List<Figure> figuresToWrite=new ArrayList<Figure>();
	
    XmlPrinter P=new XmlPrinter();

         Square C1=new Square(10, 10, 15, Color.yellow,"Square1");
         Circle Ci1=new Circle(Color.yellow, "C1", 90, 50, 30);
         Line l1=new Line(10, 10, 15, 16, Color.yellow, "l1");
         Rectangle R1=new Rectangle(10, 10, 15, 16, Color.yellow, "rec1");
         Triangle TR1=new Triangle(Color.DARK_GRAY, "T1", 10, 10, 20, 20, 30, 30);

         figuresToWrite.add(l1);
         figuresToWrite.add(R1);
         figuresToWrite.add(TR1);
         figuresToWrite.add(Ci1);
         figuresToWrite.add(C1);
 
         String lien="./Plan.xml";
	     P.creer(figuresToWrite,lien);
}

	

}
