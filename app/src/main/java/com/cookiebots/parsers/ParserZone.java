package com.cookiebots.parsers;


import android.util.Log;

import com.cookiebots.metier.Zone;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import tools.HttpMethodeGetRunnable;

public class ParserZone extends DefaultHandler{
    private List<Zone> listZones;
    private Zone temp;
    private String current;

    private String adresse = "a implementer";

    public List<Zone> getListZone(){

        try{
            // On récupère un SaxParser depuis le SaxParserFactory
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxFactory.newSAXParser();
            XMLReader readerxml = saxParser.getXMLReader();
            // creer un lecteur de flux alimenté par le SAXparser
            readerxml.setContentHandler(this);

            // On récupère l'objet InputStream depuis la méthode ci-dessous définie
            InputStream is = new HttpMethodeGetRunnable().getInputStream("a implementer");
            // Si l'objet n'est pas null
            if(is != null){
                // On le parse avec notre readerxml (appuyé par notre parserxml)
                readerxml.parse(new InputSource(is));
                // On ferme l'objet dont on a plus besoins
                is.close();
            }
        }
        catch(Exception e) {}
        if(listZones.size() != 0)
            return listZones;
        else
            return null;
    }

    public Zone getZone(String nom){

        try{
            // On récupère un SaxParser depuis le SaxParserFactory
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxFactory.newSAXParser();
            XMLReader readerxml = saxParser.getXMLReader();
            // creer un lecteur de flux alimenté par le SAXparser
            readerxml.setContentHandler(this);
            // On récupère l'objet InputStream depuis la méthode ci-dessous définie
            InputStream is = new HttpMethodeGetRunnable().getInputStream(adresse + nom);
            // Si l'objet n'est pas null
            if(is != null){
                // On le parse avec notre readerxml (appuyé par notre parserxml)
                readerxml.parse(new InputSource(is));
                // On ferme l'objet dont on a plus besoins
                is.close();
            }
        }
        catch(Exception e) {
            //Toast.makeText(context, "Erreur", Toast.LENGTH_LONG).show();
            Log.e("BIO", e.getMessage());
        }
        if(listZones != null && listZones.size() != 0)
            return listZones.get(0);
        else
            return null;
    }

    @Override
    public void startDocument() throws SAXException {
        listZones = new ArrayList<Zone>();
    }
    @Override
    public void endDocument()throws SAXException{
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        if(localName.equalsIgnoreCase("Zone")){
            temp = new Zone();
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName)
            throws SAXException {

    }
    @Override
    public void characters(char ch[], int start, int length) {
        current = new String(ch, start, length);
    }
}
