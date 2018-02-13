package com.xml;

import java.util.ArrayList;
import java.util.List;

import com.bo.*;

public class TestReader {

	public static void main(String[] args) {
		
		XmlReader x = new XmlReader("Plan.xml");
		
		List<Figure> figuresToRead = new ArrayList<Figure>();
		
		figuresToRead = x.getFigures();
		
		for(int i=0;i<figuresToRead.size();i++)
			System.out.println(figuresToRead.get(i));
	}

}

