package com.xml;

import java.awt.Color;


import java.io.File;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import com.bo.Circle;
import com.bo.Figure;
import com.bo.Line;
import com.bo.Rectangle;
import com.bo.Square;
import com.bo.Triangle;

public class XmlReader {


	private final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

	private DocumentBuilder builder;
	private Document document;
	private Element racine;
	private String FichToRead;
	
	public XmlReader(String FichToRead) {
		
		try {
			this.FichToRead = FichToRead;
			builder = factory.newDocumentBuilder();
			document = builder.parse(new File(FichToRead));
		    racine = document.getDocumentElement();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
   
	public List<Figure> getFigures() {
		
		List<Figure> figures = new ArrayList<Figure>();

		NodeList nodList = racine.getChildNodes();
        
		Node listNodElm;
		for (int i = 0; i < nodList.getLength(); i++) {
			
			listNodElm = nodList.item(i);
			
			 if(listNodElm.getNodeType() == Node.ELEMENT_NODE) {

				final Element figure = (Element) listNodElm;
				
				String name  = figure.getElementsByTagName("name").item(0).getTextContent();
				
				Color color  = Color.getColor( figure.getElementsByTagName("color").item(0).getTextContent());
				
				 if(figure.getAttribute("type").equals("square"))
				 {
					 double x  = Double.parseDouble( figure.getElementsByTagName("x").item(0).getTextContent());
					 double y  = Double.parseDouble( figure.getElementsByTagName("y").item(0).getTextContent());
					 double side  = Double.parseDouble( figure.getElementsByTagName("side").item(0).getTextContent());
					 
					 Figure square= new Square("square",color,name,x,y,side);
					 figures.add(square);	 
				 }


				 if(figure.getAttribute("type").equals("circle"))
				 {
					 double cx  = Double.parseDouble( figure.getElementsByTagName("cx").item(0).getTextContent());
					 double cy  = Double.parseDouble( figure.getElementsByTagName("cy").item(0).getTextContent());
					 double r  = Double.parseDouble( figure.getElementsByTagName("r").item(0).getTextContent());

					 Figure circle= new Circle("rectangle",color,name,cx,cy,r);
					 figures.add(circle);
				 }
				 
				 if(figure.getAttribute("type").equals("rectangle"))
				 {
					 double x  = Double.parseDouble( figure.getElementsByTagName("x").item(0).getTextContent());
					 double y  = Double.parseDouble( figure.getElementsByTagName("y").item(0).getTextContent());
					 double height  = Double.parseDouble( figure.getElementsByTagName("height").item(0).getTextContent());
					 double width  = Double.parseDouble( figure.getElementsByTagName("width").item(0).getTextContent());

					 Figure rectangle= new Rectangle("rectangle",color,name,x,y,height,width);
					 figures.add(rectangle);
				 }
				 
				 if(figure.getAttribute("type").equals("line"))
				 {
					 double x1  = Double.parseDouble( figure.getElementsByTagName("x1").item(0).getTextContent());
					 double y1  = Double.parseDouble( figure.getElementsByTagName("y1").item(0).getTextContent());
					 double x2  = Double.parseDouble( figure.getElementsByTagName("x2").item(0).getTextContent());
					 double y2  = Double.parseDouble( figure.getElementsByTagName("y2").item(0).getTextContent());
					 Figure line= new Line("line",color,name,x1,y1,x2,y2);
					 figures.add(line);
				 }
				 
				 if(figure.getAttribute("type").equals("triangle"))
				 {
					 double x1  = Double.parseDouble( figure.getElementsByTagName("x1").item(0).getTextContent());
					 double x2  = Double.parseDouble( figure.getElementsByTagName("x2").item(0).getTextContent());
					 double x3  = Double.parseDouble( figure.getElementsByTagName("x3").item(0).getTextContent());
					 double y1  = Double.parseDouble( figure.getElementsByTagName("y1").item(0).getTextContent());
					 double y2  = Double.parseDouble( figure.getElementsByTagName("y2").item(0).getTextContent());
					 double y3  = Double.parseDouble( figure.getElementsByTagName("y3").item(0).getTextContent());
					 Figure triangle = new Triangle("triangle",color,name,x1,x2,x3,y1,y2,y3);
					 figures.add(triangle);
				 }
				 
			 }
		}
		return figures;
	}
	
}