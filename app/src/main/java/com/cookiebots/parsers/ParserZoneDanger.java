package com.cookiebots.parsers;


import android.util.Log;

import com.cookiebots.metier.Lieu;
import com.cookiebots.metier.ZoneDanger;

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

public class ParserZoneDanger extends DefaultHandler{
    private List<ZoneDanger> listZoneDangers;
    private ZoneDanger temp;
    private String current;

    private String adresse = "http://alexandreplaitant.ddns.net/ndl/";

    public List<ZoneDanger> getListZone(){

        try{
            // On récupère un SaxParser depuis le SaxParserFactory
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxFactory.newSAXParser();
            XMLReader readerxml = saxParser.getXMLReader();
            // creer un lecteur de flux alimenté par le SAXparser
            readerxml.setContentHandler(this);

            // On récupère l'objet InputStream depuis la méthode ci-dessous définie
            InputStream is = new HttpMethodeGetRunnable().getInputStream("zonnedanger.php");
            // Si l'objet n'est pas null
            if(is != null){
                // On le parse avec notre readerxml (appuyé par notre parserxml)
                readerxml.parse(new InputSource(is));
                // On ferme l'objet dont on a plus besoins
                is.close();
            }
        }
        catch(Exception e) {}
        if(listZoneDangers.size() != 0)
            return listZoneDangers;
        else
            return null;
    }

    public ZoneDanger getZone(String nom){

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
        if(listZoneDangers != null && listZoneDangers.size() != 0)
            return listZoneDangers.get(0);
        else
            return null;
    }

    @Override
    public void startDocument() throws SAXException {
        listZoneDangers = new ArrayList<ZoneDanger>();
    }
    @Override
    public void endDocument()throws SAXException{
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        if(localName.equalsIgnoreCase("ZoneDanger")){
            temp = new ZoneDanger();
        }
        if(localName.equalsIgnoreCase("ZonesDanger")){
            listZoneDangers = new ArrayList<ZoneDanger>();
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName)
            throws SAXException {
        if(localName.equalsIgnoreCase("zonedanger")) {
            listZoneDangers.add(temp);
        }
        else {
            if (localName.equalsIgnoreCase("id")) {
                temp.setId(Integer.parseInt(current));
            }
            if (localName.equalsIgnoreCase("rayon")) {
                temp.setRayon(Integer.parseInt(current));
            }
            if (localName.equalsIgnoreCase("longitude")) {
                temp.setLongitude(Float.parseFloat(current));
            }
            if (localName.equalsIgnoreCase("latitude")) {
                temp.setLatitude(Float.parseFloat(current));
            }
            if(localName.equalsIgnoreCase("label")) {
                temp.setdanger(current);
            }
            if (localName.equalsIgnoreCase("deignation")) {
                temp.setDesignation(current);
            }
        }
    }
    @Override
    public void characters(char ch[], int start, int length) {
        current = new String(ch, start, length);
    }
}
