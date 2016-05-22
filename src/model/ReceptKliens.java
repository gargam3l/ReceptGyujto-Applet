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
import javax.swing.JOptionPane;

/**
 *
 * @author 604772006
 */
public class ReceptKliens {

    /**
     *
     */
    public static URL url;

    public static URL getUrl() {
        return url;
    }

    public static void setUrl(URL url) {
        ReceptKliens.url = url;
    }

    public static String kapcsolatTeszt() {

        try {
            // Construct a URL referring to the servlet
            //URL url = new URL(getCodeBase(), "/TestServlet");
            URL url = new URL("http://localhost:8084/ReceptGyujto-web/DBServ?action=test");

            Reader reader = new InputStreamReader(url.openStream(), "UTF-8");
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

            URL url = new URL("http://localhost:8084/ReceptGyujto-web/DBServ?action=inic");
            url.openConnection().connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*   
     public static void kapcsolatNyit() {
     try {
     Class.forName(DRIVER);
     kapcsolat = DriverManager.getConnection(URL, USER, PASSWORD);
     }
     catch (ClassNotFoundException e) {
     //System.out.println("Hiba! Hiányzik a JDBC driver.");
     throw new RuntimeException("Hiba! Hiányzik a JDBC driver.");
     }
     catch (SQLException e) {
     //System.out.println("Hiba! Nem sikerült megnyitni a kapcsolatot az adatbázis-szerverrel.");
     throw new RuntimeException("Hiba! Nem sikerült megnyitni a kapcsolatot az adatbázis-szerverrel. Kérem ellenőrizze, hogy a \"hr\" felhasználó megfelelően van konfigurálva az Oracle adatbázisban!");
     }
     }

     public static void kapcsolatZár() {
     try {
     kapcsolat.close();
     }
     catch (SQLException e) {
     System.out.println("Hiba! Nem sikerült lezárni a kapcsolatot az adatbázis-szerverrel.");
     }
     }
    
    
     public ReceptKezelo(ReceptTar tar) {
     this.tar = tar;
     }
    
     public void ujRecept(Recept recept)
    
     {
     tar.receptetHozzaad(recept);
     setChanged();
     notifyObservers(recept);
     }
     */
    public static ArrayList<String> otevoMennyTipusok() {
        ArrayList<String> eredmeny = new ArrayList<>();
        try {
            //URL dataURL = new URL(ReceptKliens.url, "?action=otevoMennyTipus");
            //JOptionPane.showMessageDialog(null, dataURL.toString(),"URL", JOptionPane.ERROR_MESSAGE);
            URL dataURL = new URL("http://localhost:8084/ReceptGyujto-web/DBServ?action=otevoMennyTipus");
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
    /*
     public boolean receptLetezik(String receptNev)
     {
     try {
     kapcsolatNyit();
     Statement s=kapcsolat.createStatement();
     String sql = "select count(id) from Recept where nev='"+receptNev+"'";
     int tablak_szama=0;
     ResultSet rs=s.executeQuery(sql);
     while (rs.next())    tablak_szama=rs.getInt(1);
     System.out.println(sql);
     kapcsolatZár();
     if(tablak_szama>0) return true;
     }
     catch(SQLException e) {
     System.out.println(e.getMessage());
     }
        
     return false;
     }
    
     public boolean tesztAdatBetoltve()
     {
     try {
     kapcsolatNyit();
     Statement s=kapcsolat.createStatement();
     String sql = "select count(*) from Recept";
     int sorok_szama=0;
     ResultSet rs=s.executeQuery(sql);
     while (rs.next()) sorok_szama=rs.getInt(1);
     kapcsolatZár();
     if(sorok_szama>0) return true;
     }
     catch(SQLException e) {
     System.out.println(e.getMessage());
     }
     return false;
     }
    
     public void receptetBeszur (Recept recept)
     {
     System.out.println("receptet beszúr");
     try {
     kapcsolatNyit();
     Statement s=kapcsolat.createStatement();
     String sql_recept_id="select seq_recept.nextval from dual";
     ResultSet rs1=s.executeQuery(sql_recept_id);
     rs1.next();
     String recept_id=rs1.getString(1);
     System.out.println("recept id sequence kiválasztva");
     String sql_recept_tabla = "INSERT INTO Recept(id,nev,elkeszites)" +
     "VALUES" +
     "('"+recept_id+"','"+recept.getMegnevezes()+"','"+recept.getLeiras()+"')";
     s.executeUpdate(sql_recept_tabla);
     System.out.println("recept hozzáadva");
            
     for (Osszetevok otevo: recept.getOsszetevok())
     {
     String sql_otevo_id="select seq_osszetevo.nextval from dual";
     ResultSet rs2=s.executeQuery(sql_otevo_id);
     rs2.next();
     String otevo_id=rs2.getString(1);
     System.out.println("összetevő id sequence kiválasztva");
                
     String sql_otevo_hozzad = "INSERT INTO Osszetevo(id,nev)" +
     "VALUES" +
     "('"+otevo_id+"','"+otevo.getOsszetevo_fajta()+"')";
     s.executeUpdate(sql_otevo_hozzad);
     System.out.println("összetevő hozzáadva");
                
     String sql_mennyiseg_id="select id from Mennyiseg where nev='"+otevo.getMennyiseg_tipus()+"'";
     ResultSet rs3=s.executeQuery(sql_mennyiseg_id);
     rs3.next();
     String mennyiseg_id=rs3.getString(1);
     System.out.println("mennyiség id sequence kiválasztva");
     String sql_kozponti_hozzaad = "INSERT INTO Kozponti(recept_id,osszetevo_id,mennyiseg,mennyiseg_id)" +
     "VALUES" +
     "('"+recept_id+"','"+otevo_id+"','"+otevo.getMennyiseg_egyseg()+"','"+mennyiseg_id+ "')";
     s.executeUpdate(sql_kozponti_hozzaad);
     System.out.println("központi tábla update-elve");
     }
     kapcsolatZár();
     }
     catch(SQLException e) {
     System.out.println(e.getMessage());
     }
     }
     */

    public void receptetMent(Recept recept) {
        try {
            //URL dataURL = new URL(ReceptKliens.url, "?action=otevoMennyTipus");
            //JOptionPane.showMessageDialog(null, dataURL.toString(),"URL", JOptionPane.ERROR_MESSAGE);
            URL dataURL = new URL("http://localhost:8084/ReceptGyujto-web/DBServ?action=receptetMent");
            URLConnection connection = dataURL.openConnection();
            connection.setUseCaches(false);
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/x-java-serialized-object");
            ObjectOutputStream outputToServer = new ObjectOutputStream(connection.getOutputStream());
            outputToServer.writeObject(recept);
            outputToServer.flush();
            outputToServer.close();
            
            //eredmeny = (ArrayList<String>) in.readObject();

            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void receptetSzerkeszt(String aktualis, Recept uj) {

    }

    /*
     public ReceptTar keresMegnevezesre (String kulcs)
     {
     ReceptTar eredmeny = new ReceptTar();
     try {
     kapcsolatNyit();
     Statement s=kapcsolat.createStatement();
            
     String sql = "SELECT nev, elkeszites FROM Recept WHERE nev LIKE '%"+ kulcs+"%'";
     ResultSet rs=s.executeQuery(sql);
     while(rs.next()) 
     {
                
     eredmeny.receptetHozzaad(new Recept(rs.getString("nev"), rs.getString("elkeszites")));
     }
     kapcsolatZár();
     }
     catch(SQLException e) {
     System.out.println(e.getMessage());
     }
     return eredmeny;
     }
    
     public ArrayList<Osszetevok> keresOsszetevoRecepthez(String kulcs)
    
     {
     System.out.println("Keres összetevőt recepthez");
     ArrayList<Osszetevok> eredmeny = new ArrayList<>();
     try {
     kapcsolatNyit();
     Statement s=kapcsolat.createStatement();
            
     String sql = "SELECT Kozponti.Mennyiseg,Mennyiseg.Nev,Osszetevo.Nev FROM Kozponti FULL OUTER JOIN Recept ON Kozponti.Recept_id=Recept.id FULL OUTER JOIN Osszetevo ON Kozponti.Osszetevo_id=Osszetevo.id FULL OUTER JOIN Mennyiseg ON Kozponti.Mennyiseg_id=Mennyiseg.id WHERE Recept.nev = '"+ kulcs+"'";
     ResultSet rs=s.executeQuery(sql);
     while(rs.next()) 
     {
                
     eredmeny.add(new Osszetevok(rs.getString(1),rs.getString(2),rs.getString(3)));
                
     }
     kapcsolatZár();
     }
     catch(SQLException e) {
     System.out.println(e.getMessage());
     }
     return eredmeny;
     }
    
    
     public void receptetTorol(String receptNev)
     {
     try {
     kapcsolatNyit();
     Statement s=kapcsolat.createStatement();
     String sql_recept_id="select id from Recept where nev='"+receptNev+"'";
     ResultSet rs1=s.executeQuery(sql_recept_id);
     rs1.next();
     String recept_id=rs1.getString(1);
            
     ArrayList<String> osszetevo_id = new ArrayList<>();
     String sql_osszetevok_lista ="select id from Osszetevo where id in (select osszetevo_id FROM Kozponti "
     + "FULL OUTER JOIN Recept ON Kozponti.recept_id=Recept.id "
     + "WHERE Recept.nev ='"+recept_id+"')";
     ResultSet rsOsszetevok = s.executeQuery(sql_osszetevok_lista);
     while (rsOsszetevok.next())
     {
     osszetevo_id.add(rsOsszetevok.getString("id"));
     }
            
     String sql2 = "delete from Kozponti where recept_id ='"+recept_id+"'";
     s.executeUpdate(sql2);
     System.out.println("delete from központi");
     for (String id : osszetevo_id)
     {
     String sql1 = "delete from Osszetevo where id ='"+id+"'";
     s.executeUpdate(sql1);
     }
     System.out.println("delete összetevő");
            
            
     String sql3 = "delete from Recept where nev='"+receptNev+"'";
     s.executeUpdate(sql3);
     kapcsolatZár();
     }
     catch(SQLException e) {
     System.out.println(e.getMessage());
     }
     }
    
     */
}
