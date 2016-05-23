/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.net.*;
import java.applet.*;
import java.io.ByteArrayOutputStream;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 604772006
 */
public class ReceptKliens {

    /**
     *
     */
    public static String url;

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        ReceptKliens.url = url;
    }

    public static String kapcsolatTeszt() {

        try {
            // Construct a URL referring to the servlet
            //URL url = new URL(getCodeBase(), "/TestServlet");
            URL urlTest = new URL(url+"?action=test");
            //JOptionPane.showMessageDialog(null, urlTest.toString(), "Hiba", JOptionPane.ERROR_MESSAGE);
            Reader reader = new InputStreamReader(urlTest.openStream(), "UTF-8");
            // Return the string representation of the Date
            String servRead = "";
            int r;
            while ((r = reader.read()) != -1) {
                char ch = (char) r;
                servRead = new StringBuilder(servRead).append(ch).toString();
            }
//return reader.toString();
            return servRead;
        } catch (Exception e) {
            // If there was a problem, print to System.out
            // (typically the Java console) and return null
            e.printStackTrace();
            return e.toString() + " " + e.getMessage() + " " + e.getLocalizedMessage();
        }
    }

    public static void inic() {

        try {

            //URL dataURL = new URL("http://localhost:8084/ReceptGyujto-web/DBServ?action=inic");
            URL dataURL = new URL(url+"?action=inic");
            URLConnection connection = dataURL.openConnection();
            connection.setUseCaches(false);
            Reader reader = new InputStreamReader(dataURL.openStream(), "UTF-8");
            // Return the string representation of the Date
            String servRead = "";
            int r;
            while ((r = reader.read()) != -1) {
                char ch = (char) r;
                servRead = new StringBuilder(servRead).append(ch).toString();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + " " + e.getMessage() + " " + e.getLocalizedMessage(), "Hiba", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    public static ArrayList<String> otevoMennyTipusok() {
        ArrayList<String> eredmeny = new ArrayList<>();
        try {
            //URL dataURL = new URL(ReceptKliens.url, "?action=otevoMennyTipus");
            //JOptionPane.showMessageDialog(null, dataURL.toString(),"URL", JOptionPane.ERROR_MESSAGE);
            //URL dataURL = new URL("http://localhost:8084/ReceptGyujto-web/DBServ?action=otevoMennyTipus");
            URL dataURL = new URL(url+"?action=otevoMennyTipus");
            URLConnection connection = dataURL.openConnection();
            connection.setUseCaches(false);
            ObjectInputStream in = new ObjectInputStream(connection.getInputStream());
            eredmeny = (ArrayList<String>) in.readObject();

            in.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return eredmeny;
    }
    

    public static void receptetMent(Recept recept) {
        try {
            //URL dataURL = new URL(ReceptKliens.url, "?action=otevoMennyTipus");
            //JOptionPane.showMessageDialog(null, dataURL.toString(),"URL", JOptionPane.ERROR_MESSAGE);
            //                     http://localhost:8084/ReceptGyujto-web/DBServ?action=otevoMennyTipus
            //URL dataURL = new URL("http://localhost:8084/ReceptGyujto-web/DBServ?action=receptetMent");
            URL dataURL = new URL(url+"?action=receptetMent");
            URLConnection connection = dataURL.openConnection();
            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            //connection.set
            
             connection.setRequestProperty("Content-Type", "application/octet-stream");
             
             ObjectOutputStream outputToServer = new ObjectOutputStream(connection.getOutputStream()); 
             outputToServer.writeObject(recept);
             outputToServer.flush();
             
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
               System.out.println(line);
            }
            //outputToServer.close();

        } catch (Exception e) {
            //System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage(), "Hiba", JOptionPane.ERROR_MESSAGE);
          Logger.getLogger(ReceptKliens.class.getName()).log(Level.SEVERE, null, e);
          

        }
    
    }

    public static void receptetSzerkeszt(String aktualis, Recept uj) {
        try {
            //URL dataURL = new URL(ReceptKliens.url, "?action=otevoMennyTipus");
            //JOptionPane.showMessageDialog(null, dataURL.toString(),"URL", JOptionPane.ERROR_MESSAGE);
            //                     http://localhost:8084/ReceptGyujto-web/DBServ?action=otevoMennyTipus
            
            //URL dataURL = new URL("http://localhost:8084/ReceptGyujto-web/DBServ?action=receptetSzerkeszt");
            URL dataURL = new URL(url+"?action=receptetSzerkeszt");
            URLConnection connection = dataURL.openConnection();
            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            //connection.set
            
             connection.setRequestProperty("Content-Type", "application/octet-stream");
             
             ObjectOutputStream outputToServer = new ObjectOutputStream(connection.getOutputStream()); 
             outputToServer.writeUTF(aktualis);
             outputToServer.flush();
             outputToServer.writeObject(uj);
             outputToServer.flush();
             
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
               System.out.println(line);
            }
            //outputToServer.close();

        } catch (Exception e) {
            //System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage(), "Hiba", JOptionPane.ERROR_MESSAGE);
          Logger.getLogger(ReceptKliens.class.getName()).log(Level.SEVERE, null, e);
          

        }
    }

    
     public static ReceptTar keresMegnevezesre (String kulcs)
     {
     ReceptTar eredmeny = new ReceptTar();
     try {
         //String baseURL="http://localhost:8084/ReceptGyujto-web/DBServ?action=keresMegnevezesre";
         String baseURL=url+"?action=keresMegnevezesre";
         String param=URLEncoder.encode(kulcs, "UTF-8");
         
         URL dataURL = new URL(baseURL.concat("&kulcs="+param));
         
         
            URLConnection connection = dataURL.openConnection();
            connection.setUseCaches(false);
            ObjectInputStream in = new ObjectInputStream(connection.getInputStream());
            eredmeny.setTar((ArrayList<Recept>) in.readObject());

            in.close();
     }
     catch(Exception e) {
     System.out.println(e.getMessage());
     }
     return eredmeny;
     }
    
     public static ArrayList<Osszetevok> keresOsszetevoRecepthez(String kulcs)
    
     {
     
     ArrayList<Osszetevok> eredmeny = new ArrayList<>();
     try {
         
        // String baseURL="http://localhost:8084/ReceptGyujto-web/DBServ?action=keresOsszetevoRecepthez";
         String baseURL=url+"?action=keresOsszetevoRecepthez";
         String param=URLEncoder.encode(kulcs, "UTF-8");
         
         URL dataURL = new URL(baseURL.concat("&kulcs="+param));
         
         //URL dataURL = new URL("http://localhost:8084/ReceptGyujto-web/DBServ?action=keresOsszetevoRecepthez");
            URLConnection connection = dataURL.openConnection();
            connection.setUseCaches(false);
            connection.setDoInput(true);
            //connection.setDoOutput(true);
            //ObjectOutputStream outputToServer = new ObjectOutputStream(connection.getOutputStream()); 
             //outputToServer.writeUTF(kulcs);
             //outputToServer.flush();
            ObjectInputStream in = new ObjectInputStream(connection.getInputStream());
            eredmeny=(ArrayList<Osszetevok>) in.readObject();

            in.close();
     }
     catch(Exception e) {
     System.out.println(e.getMessage());
     }
     return eredmeny;
     }
    
    
     public static void receptetTorol(String receptNev)
     {
     try {
            
            
            //URL dataURL = new URL("http://localhost:8084/ReceptGyujto-web/DBServ?action=receptetTorol");
            URL dataURL = new URL(url+"?action=receptetTorol");
            URLConnection connection = dataURL.openConnection();
            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);
                        
             connection.setRequestProperty("Content-Type", "application/octet-stream");
             
             ObjectOutputStream outputToServer = new ObjectOutputStream(connection.getOutputStream()); 
             outputToServer.writeUTF(receptNev);
             outputToServer.flush();
             
             
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
               System.out.println(line);
            }
            //outputToServer.close();

        } catch (Exception e) {
            //System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage(), "Hiba", JOptionPane.ERROR_MESSAGE);
          Logger.getLogger(ReceptKliens.class.getName()).log(Level.SEVERE, null, e);
          

        }
     }
    
     
}
