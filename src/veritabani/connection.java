package veritabani;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import application.PersonelBilgi;
import application.UrunBilgi;
import application.RezervasyonBilgi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class connection {

	
	static Connection conn=null;
	public static Connection Baglan() {
		try {
			
		conn=DriverManager.getConnection("jdbc:mysql://localhost/haydikampadb?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", "root", "mysql");
			return conn;
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			return null;
			
		}
	}
	   public static ObservableList<PersonelBilgi> getPersonel(){
	    	conn=connection.Baglan();
	        ObservableList<PersonelBilgi> list = FXCollections.observableArrayList();
	        try {
	            PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from personeller");
	            ResultSet rs = ps.executeQuery();
	            
	            while (rs.next()){   
	                list.add(new PersonelBilgi(Integer.parseInt(rs.getString("id")), rs.getString("PersonelAdi"), rs.getString("PersonelSoyadi"), rs.getString("PersonelEposta"), rs.getString("PersonelTelefon"),rs.getString("PersonelDogumTarih"),rs.getString("PersonelBirimi"),rs.getString("PersonelCalisma")));               
	            }
	        } catch (Exception e) {
	        }
	        return list;
	    }
	    
	     public static ObservableList<UrunBilgi> getUrun(){
	    	conn=connection.Baglan();
	        ObservableList<UrunBilgi> list = FXCollections.observableArrayList();
	        try {
	            PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from urunler");
	            ResultSet rs = ps.executeQuery();
	            
	            while (rs.next()){   
	                list.add(new UrunBilgi(Integer.parseInt(rs.getString("id")), rs.getString("UrunAdi"), rs.getString("UrunKategori"), rs.getString("UrunFiyat"),rs.getString("UrunAdet")));               
	            }
	        } catch (Exception e) {
	        }
	        return list;
	    
	   }
	    public static ObservableList<RezervasyonBilgi> getBaglanrezerve(){
	    	conn=connection.Baglan();
	        ObservableList<RezervasyonBilgi> list = FXCollections.observableArrayList();
	        try {
	            PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from rezervasyon");
	            ResultSet rs = ps.executeQuery();
	            
	            while (rs.next()){   
	                list.add(new RezervasyonBilgi(Integer.parseInt(rs.getString("id")),rs.getString("isim"),rs.getString("telefonNumara"), rs.getString("paket"), rs.getString("donem"), rs.getString("ucret"),rs.getString("fotopaket"),rs.getString("tcno"),rs.getString("otel")));               
	            }
	        } catch (Exception e) {
	        }
	        return list;
	    
	   }}
	   
	   
	   

	


