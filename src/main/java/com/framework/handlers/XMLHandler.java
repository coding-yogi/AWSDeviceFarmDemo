package com.framework.handlers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aniket on 01/05/15.
 */
public class XMLHandler {

    Document document;

    public XMLHandler (String filePath){
        try{
            File fXmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            document = dBuilder.parse(fXmlFile);
        }
        catch(IOException ex){
            System.out.println("Exception occured while loading the file " + filePath);
        }
        catch(Exception ex){
            System.out.println("Exception " +  ex + " occured while parsing Xml " + filePath);
        }
    }

    public XMLHandler(InputStream fileInput){
        try{

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            document = dBuilder.parse(fileInput);
        }
        catch(IOException ex){
            System.out.println("Exception occured while loading the file from Input stream");
        }
        catch(Exception ex){
            System.out.println("Exception " +  ex + " occured while parsing Xml ");
        }
    }

    public Element getElementByName(String name){

        try{
            document.getDocumentElement().normalize();
            XPath xPath =  XPathFactory.newInstance().newXPath();
            String Expression = "//*[@name='" + name + "']";
            return ((Element) xPath.compile(Expression).evaluate(document, XPathConstants.NODE));
        }
        catch(Exception ex){
            System.out.println("Exception " + ex + "occured while getting an element by ID " + name);
            return null;
        }
    }

    public List<Element> getElementsByTagName(String tagName){
        try{
            List<Element> list = new ArrayList<Element>();
            document.getDocumentElement().normalize();
            NodeList nodes = document.getElementsByTagName(tagName);

            for(int i = nodes.getLength(); i > 0 ; i--){
                list.add((Element) nodes.item(i-1));
            }

            return list;
        }
        catch (Exception ex){
            System.out.println("Exception " + ex + "occured while fetching elements by tagName " + tagName);
            return null;
        }
    }

    public List<Element> getChildElements(Element parent){

        NodeList nodeList = null;
        List<Element> childElements = new ArrayList<Element>();

        if(parent.hasChildNodes()){
            nodeList = parent.getChildNodes();
            for(int i=0;i<nodeList.getLength();i++){
                if(nodeList.item(i).getNodeType() == Node.ELEMENT_NODE)
                    childElements.add((Element)nodeList.item(i));
            }
        }

        return childElements;
    }

    public String getElementText(Element element){
        return element.getTextContent();
    }
}
