package com.cookiebots.parsers;

import android.util.Log;

import com.cookiebots.metier.Personne;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import tools.HttpMethodeGetRunnable;

public class ParserPersonne extends DefaultHandler {
    private List<Personne> listPersonnes;
    private Personne temp;
    private String current;

    private String adresse = "a implementer";

    public List<Personne> getListPersonne(){

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
        if(listPersonnes.size() != 0)
            return listPersonnes;
        else
            return null;
    }

    public Personne getPersonne(String nom){

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
        if(listPersonnes != null && listPersonnes.size() != 0)
            return listPersonnes.get(0);
        else
            return null;
    }

    @Override
    public void startDocument() throws SAXException{
        listPersonnes = new ArrayList<Personne>();
    }
    @Override
    public void endDocument()throws SAXException{
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        if(localName.equalsIgnoreCase("Personne")){
            temp = new Personne();
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName)
            throws SAXException {
        if(localName.equalsIgnoreCase("lieu")) {
            listPersonnes.add(temp);
        }
        else {
            if (localName.equalsIgnoreCase("id")) {
                temp.setId(Integer.parseInt(current));
            }
            if (localName.equalsIgnoreCase("nom")) {
                temp.setNom(current);
            }
            if (localName.equalsIgnoreCase("prenom")) {
                temp.setPrenom(current);
            }
            if (localName.equalsIgnoreCase("label")) {
                temp.setSante(current);
            }
        }

    }
    @Override
    public void characters(char ch[], int start, int length) {
        current = new String(ch, start, length);
    }
}

