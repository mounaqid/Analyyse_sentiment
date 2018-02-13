package com.xml;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.bo.Circle;
import com.bo.Figure;
import com.bo.Line;
import com.bo.Rectangle;
import com.bo.Square;
import com.bo.Triangle;

public class XmlPrinter {

    public void creer(List<Figure> forme,String fichtowrite) {
        /*
		 * Etape 1 : récupération d'une instance de la classe
		 * "DocumentBuilderFactory"
         */
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            /*
			 * Etape 2 : création d'un parseur
             */
            final DocumentBuilder builder = factory.newDocumentBuilder();

            /*
			 * Etape 3 : création d'un Document
             */
            final Document document = builder.newDocument();

            /*
			 * Etape 4 : création de l'Element racine plan
             */
            //final Element racine = document.createElement("plan");
            final Element racine = document.createElement("plan");
            racine.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "xsi:noNamespaceSchemaLocation", "figure.xsd");
          
            document.appendChild(racine);
            Element figure;

            /* 
			 * Etape 5 : création des figures
             */
            for (int i = 0; i < forme.size(); i++) {
                System.out.println(forme.get(i).getType());
                switch (forme.get(i).getType()) {
                    
                    case "square":
                        Square C1 = (Square) forme.get(i);
                        figure = createSquare(document, racine, C1.getName(), String.valueOf(C1.getColor()),C1.getX(),C1.getY(),C1.getSide());
                        break;
                    case "rectangle":
                        Rectangle R1 = (Rectangle) forme.get(i);
                        figure = createRectangle(document, racine, R1.getName(),String.valueOf(R1.getColor()), R1.getX(), R1.getY(), R1.getHeight(), R1.getWidth());
                        break;
                    case "circle":
                        Circle CD1 = (Circle) forme.get(i);
                        figure = createCircle(document, racine,CD1.getName(), String.valueOf(CD1.getColor()), CD1.getCx(), CD1.getCy(), CD1.getR());
                        break;
                    case "line":
                        Line D1 = (Line) forme.get(i);
                        figure = createLine(document, racine, D1.getName(),String.valueOf(D1.getColor()) , D1.getX1(), D1.getY2(), D1.getX2(),D1.getY2());
                        break;

                    case "triangle":
                        Triangle TQ = (Triangle) forme.get(i);
                        figure = createTriangle(document, racine, TQ.getName(), String.valueOf(TQ.getColor()) , TQ.getX1(), TQ.getY1(), TQ.getX2(), TQ.getY2(),TQ.getX3(), TQ.getY3());

                        break;
                    default:
                        System.out.println("Erreur type");
                        break;
                }
            }

            /*
			 * Etape 8 : affichage
             */
            final TransformerFactory transformerFactory = TransformerFactory.newInstance();
            final Transformer transformer = transformerFactory.newTransformer();
            final DOMSource source = new DOMSource(document);
            final StreamResult sortie = new StreamResult(new File(fichtowrite));
            // final StreamResult result = new StreamResult(System.out);
            Node pi = document.createProcessingInstruction
                    ("xml-stylesheet", "type=\"text/xsl\" href=\"XensahForms.xsl\"");
                 document.insertBefore(pi, racine);
            // prologue
            transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "no");

            // formatage
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            // sortie
            transformer.transform(source, sortie);
        } catch (final ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public Element createSquare(Document document, Element racine, String nomobj, String couleurobj, double d,
            double e, double coteobj) {

        String type = "square";

        Element figure = Traitement(document, racine, nomobj, couleurobj, d, e, type, coteobj);
        return figure;
    }

    public Element createRectangle(Document document, Element racine, String nomobj, String couleurobj, double d,
            double e, double coteobj1, double coteobj2) {
        String type = "rectangle";
        Element figure = Traitement(document, racine, nomobj, couleurobj, d, e, type, coteobj1, coteobj2);
        return figure;

    }

    public Element createCircle(Document document, Element racine, String nomobj, String couleurobj, double d,
            double e, double rayonobj) {

        String type = "circle";
        Element figure = Traitement(document, racine, nomobj, couleurobj, d, e, type, rayonobj);
        return figure;

    }

    public Element createLine(Document document, Element racine, String nomobj, String couleurobj, double d,
            double e,double ppx2,double ppy2) {
        String type = "line";
        Element figure = Traitement(document, racine, nomobj, couleurobj, d, e, type, ppx2,ppy2);
        return figure;

    }

    // Triangle
    public Element createTriangle(Document document, Element racine, String nomobj, String couleurobj,
           double x1,double y1,double x2,double y2,double x3,double y3) {

        String type = "triangle";
        Element figure = Traitement(document, racine, nomobj, couleurobj, x1, y1, type, x2,y2,x3,y3);
        return figure;

    }

    public Element setDataCom(Document document, Element figure, String nomobj, String couleurobj, double ppxobj,
            double ppyobj) {
        final Element nom = document.createElement("name");
        nom.appendChild(document.createTextNode(nomobj));

        final Element couleur = document.createElement("color");
        couleur.appendChild(document.createTextNode(couleurobj));

        figure.appendChild(nom);
        figure.appendChild(couleur);

        return figure;
    }

    public Element Traitement(Document document, Element racine, String nomobj, String couleurobj, double ppxobj,
            double ppyobj, String type, double... pts) {
        Element ppx,ppy;
        Element figure = document.createElement("figure");
        figure.setAttribute("type", type);
        racine.appendChild(figure);
        String[] tabpts = new String[pts.length];
        for (int i = 0; i < pts.length; i++) {
            tabpts[i] = String.valueOf(pts[i]);
        }
        figure = this.setDataCom(document, figure, nomobj, couleurobj, ppxobj, ppyobj);
        switch (type) {
            case "square":
                ppx = document.createElement("x");
                ppx.appendChild(document.createTextNode(String.valueOf(ppxobj)));

                ppy = document.createElement("y");
                ppy.appendChild(document.createTextNode(String.valueOf(ppyobj)));
                figure.appendChild(ppx);
                figure.appendChild(ppy);
                Element cote = document.createElement("side");
                cote.appendChild(document.createTextNode(tabpts[0]));
                figure.appendChild(cote);
                break;
            case "rectangle":
                ppx = document.createElement("x");
                ppx.appendChild(document.createTextNode(String.valueOf(ppxobj)));

                ppy = document.createElement("y");
                ppy.appendChild(document.createTextNode(String.valueOf(ppyobj)));
                figure.appendChild(ppx);
                figure.appendChild(ppy);
                Element cote1 = document.createElement("height");
                cote1.appendChild(document.createTextNode(tabpts[0]));
                Element cote2 = document.createElement("width");
                //ici
                cote2.appendChild(document.createTextNode(tabpts[1]));
                figure.appendChild(cote1);
                figure.appendChild(cote2);
                break;
            case "circle":
               
                Element abscisseC = document.createElement("cx");
                abscisseC.appendChild(document.createTextNode(String.valueOf(ppxobj)));
                Element ordonneeC = document.createElement("cy");
                ordonneeC.appendChild(document.createTextNode(String.valueOf(ppyobj)));

                Element rayon = document.createElement("r");
                rayon.appendChild(document.createTextNode(tabpts[0]));

                figure.appendChild(abscisseC);
                figure.appendChild(ordonneeC);
                figure.appendChild(rayon);
                break;
            case "line":
                ppx = document.createElement("x1");
                ppx.appendChild(document.createTextNode(String.valueOf(ppxobj)));

                ppy = document.createElement("y1");
                ppy.appendChild(document.createTextNode(String.valueOf(ppyobj)));
                
                Element x2 = document.createElement("x2");
                x2.appendChild(document.createTextNode( tabpts[0]));
                
                Element y2 = document.createElement("y2");
                y2.appendChild(document.createTextNode( tabpts[1]));
                figure.appendChild(ppx);
                figure.appendChild(ppy);
                figure.appendChild(x2);
                figure.appendChild(y2);
                break;
            case "triangle": 
                ppx = document.createElement("x1");
                ppx.appendChild(document.createTextNode(String.valueOf(ppxobj)));

                ppy = document.createElement("y1");
                ppy.appendChild(document.createTextNode(String.valueOf(ppyobj)));
                
                Element x22 = document.createElement("x2");
                x22.appendChild(document.createTextNode( tabpts[0]));
                Element y22 = document.createElement("y2");
                y22.appendChild(document.createTextNode( tabpts[1]));
                 Element x3 = document.createElement("x3");
                 x3.appendChild(document.createTextNode( tabpts[2]));
                Element y3 = document.createElement("y3");
                y3.appendChild(document.createTextNode( tabpts[3]));
                figure.appendChild(ppx);
                figure.appendChild(ppy);
                figure.appendChild(x22);
                figure.appendChild(y22);
                figure.appendChild(x3);
                figure.appendChild(y3);
                break;
           

        }

        return figure;

    }
}
