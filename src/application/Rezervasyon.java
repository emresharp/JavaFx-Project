package application;

import java.net.URL;
import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import veritabani.connection;

public class Rezervasyon implements Initializable{

    @FXML
    private ComboBox<String> comboPaket;
    
    @FXML
    private ComboBox<String> comboFotopaket;

    @FXML
    private TableView<RezervasyonBilgi> tbl_Rezervasyon;
    @FXML
    private TableColumn<RezervasyonBilgi,Integer> col_id;
    @FXML
    private TableColumn<RezervasyonBilgi,String> col_RezervasyonKisi;

    @FXML
    private TableColumn<RezervasyonBilgi,String> col_Telefon;

    @FXML
    private TableColumn<RezervasyonBilgi,String> col_Paket;
    
    @FXML
    private TableColumn<RezervasyonBilgi,String> col_Fotopaket;

    @FXML
    private TableColumn<RezervasyonBilgi,String> col_Donem;
    @FXML
    private TableColumn<RezervasyonBilgi,String> col_Ucret;
    
    @FXML
    private TableColumn<RezervasyonBilgi,String> col_Tcno;
    
    @FXML
    private TableColumn<RezervasyonBilgi,String> col_Otel;

    @FXML
    private TextField txtDonem;

    @FXML
    private TextField txtUcret;
    
    @FXML
    private TextField txtTcNo;
    
    @FXML
    private TextField txtOtel;

    @FXML
    private Button btnRezervasonYap;

    @FXML
    private Button btnGüncelle;

    @FXML
    private Button btnRezervasyonSil;
    @FXML
    private TextField txtRezervasyonYapan;

    @FXML
    private TextField txtTelefonNumarasý;

    @FXML
    private TextField txtAra;

    @FXML
    private Button btnRezervasyonAra;
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    PreparedStatement sorguIfadesi1=null;
    ResultSet getirilen=null;
    String sql;
    String Paketsec;
   String Fotopaketsec;
    
    ObservableList<RezervasyonBilgi> rezervasyonData;
    
    public void Paketsec(ActionEvent event) {
    	Paketsec=comboPaket.getValue();
    }
    
    
    public void Fotopaketsec(ActionEvent event) {
    	Fotopaketsec=comboFotopaket.getValue();
    }
    
    public void Guncelle(TableView<RezervasyonBilgi> tbl) {
 
        	sql="select * from rezervasyon";
        	
        	ObservableList<RezervasyonBilgi> rezervasyonData=FXCollections.observableArrayList();
        	try {
    			
        		sorguIfadesi=baglanti.prepareStatement(sql);
        		
        		ResultSet getirilen=sorguIfadesi.executeQuery();
        		
        		
        		
        		while(getirilen.next()) {
        			rezervasyonData.add(new RezervasyonBilgi(getirilen.getInt("id"),getirilen.getString("isim"),getirilen.getString("telefonNumara"),getirilen.getString("paket"),getirilen.getString("donem"),getirilen.getString("ucret"),getirilen.getString("fotopaket"),getirilen.getString("tcno"),getirilen.getString("otel")));}
    	col_id.setCellValueFactory(new PropertyValueFactory<RezervasyonBilgi,Integer>("id"));
    	col_RezervasyonKisi.setCellValueFactory(new PropertyValueFactory<RezervasyonBilgi,String>("isim"));
    	col_Telefon.setCellValueFactory(new PropertyValueFactory<RezervasyonBilgi,String>("telefon"));
    	col_Paket.setCellValueFactory(new PropertyValueFactory<RezervasyonBilgi,String>("paket"));
    	col_Donem.setCellValueFactory(new PropertyValueFactory<RezervasyonBilgi,String>("donem"));
        col_Ucret.setCellValueFactory(new PropertyValueFactory<RezervasyonBilgi,String>("ucret"));
    	col_Fotopaket.setCellValueFactory(new PropertyValueFactory<RezervasyonBilgi,String>("fotopaket"));
    	col_Tcno.setCellValueFactory(new PropertyValueFactory<RezervasyonBilgi,String>("tcno"));
    	col_Otel.setCellValueFactory(new PropertyValueFactory<RezervasyonBilgi,String>("otel"));



        
        rezervasyonData=connection.getBaglanrezerve();
        tbl_Rezervasyon.setItems(rezervasyonData);
       
		System.out.println("baþarýlý");
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
}
        
    
    @Override
   	public void initialize(URL arg0, ResourceBundle arg1) {
   		
   		baglanti=connection.Baglan();
           if(baglanti==null)
           {
           	System.out.println("Baðlantý Kurulamadý");
   	}
        col_id.setCellValueFactory(new PropertyValueFactory<RezervasyonBilgi,Integer>("id"));
       	col_RezervasyonKisi.setCellValueFactory(new PropertyValueFactory<RezervasyonBilgi,String>("isim"));
       	col_Telefon.setCellValueFactory(new PropertyValueFactory<RezervasyonBilgi,String>("telefon"));
       	col_Paket.setCellValueFactory(new PropertyValueFactory<RezervasyonBilgi,String>("paket"));
       	col_Donem.setCellValueFactory(new PropertyValueFactory<RezervasyonBilgi,String>("donem"));
        col_Ucret.setCellValueFactory(new PropertyValueFactory<RezervasyonBilgi,String>("ucret"));
        col_Fotopaket.setCellValueFactory(new PropertyValueFactory<RezervasyonBilgi,String>("fotopaket"));
        col_Tcno.setCellValueFactory(new PropertyValueFactory<RezervasyonBilgi,String>("tcno"));
    	col_Otel.setCellValueFactory(new PropertyValueFactory<RezervasyonBilgi,String>("otel"));


        
        ObservableList<String> Paketsec=FXCollections.observableArrayList("Extreme ","Fethiye Plus","Fethiye Eko","Mini Fethiye","Mini Fethiye Extreme","Mini Doða","Mini Doða Extreme","Mini Doða - Mini Fethiye",
        		"Mini Doða Extreme + Mini Fethiye","1 Yýldýz Dalýþ Kursu","2 Yýldýz Dalýþ Kursu","Tecrübe Dalýþ Paketi");
       	comboPaket.setItems(Paketsec);
       	
       	ObservableList<String> Fotopaketsec=FXCollections.observableArrayList("Evet ","Hayýr");
       	comboFotopaket.setItems(Fotopaketsec);
           
           rezervasyonData=connection.getBaglanrezerve();
           tbl_Rezervasyon.setItems(rezervasyonData);
    }
    public Rezervasyon() {
    	baglanti=connection.Baglan();
    }

    @FXML
    void btn_ClickGüncelle(ActionEvent event)throws SQLException {
    	
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Rezervasyon Güncelleme");
    	alert.setHeaderText("");
    	alert.setContentText("Güncellemek istediðinize emin misiniz?");
    	Optional<ButtonType> result=alert.showAndWait();
    	if(result.get()==ButtonType.OK) {
    	baglanti=(Connection) connection.Baglan();

    	RezervasyonBilgi rezervasyonData;
    	rezervasyonData= tbl_Rezervasyon.getSelectionModel().getSelectedItem();
    	int value=rezervasyonData.getId();
    	
     String sql = "update rezervasyon set isim=?,telefonNumara=?,paket=?, donem=?, ucret=?,fotopaket=?,tcno=?,otel=? where id='"+value+ "'";
  
   	try {
   		sorguIfadesi=baglanti.prepareStatement(sql);
		sorguIfadesi.setString(1,txtRezervasyonYapan.getText().trim());
		sorguIfadesi.setString(2,txtTelefonNumarasý.getText().trim());
		sorguIfadesi.setString(3,Paketsec.trim());
		sorguIfadesi.setString(4,txtDonem.getText().trim());
		sorguIfadesi.setString(5,txtUcret.getText().trim());
		sorguIfadesi.setString(6,Fotopaketsec.trim());
		sorguIfadesi.setString(7,txtTcNo.getText().trim());
		sorguIfadesi.setString(8,txtOtel.getText().trim());


		sorguIfadesi.execute();
		Guncelle(tbl_Rezervasyon);
		

                } catch (Exception e) {
               

             }
   finally {
   	sorguIfadesi.close();
   	     	
   }}
    	else {
     		alert.close();
     	}

    }

    @FXML
    void btn_ClickRezervasonYap(ActionEvent event) throws SQLException{

        baglanti=(Connection) connection.Baglan();

    	 String sql = "insert into rezervasyon(isim,telefonNumara,paket,donem,ucret,fotopaket,tcno,otel) values(?,?,?,?,?,?,?,?)";
   
    	try {
    	  
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1,txtRezervasyonYapan.getText());
    		sorguIfadesi.setString(2,txtTelefonNumarasý.getText());
    		sorguIfadesi.setString(3,Paketsec);
    		sorguIfadesi.setString(4,txtDonem.getText());
    		sorguIfadesi.setString(5,txtUcret.getText());
    		sorguIfadesi.setString(6,Fotopaketsec);
    		sorguIfadesi.setString(7,txtTcNo.getText());
    		sorguIfadesi.setString(8,txtOtel.getText().trim());


    		

    	
    		sorguIfadesi.execute();
    		Guncelle(tbl_Rezervasyon);
    		
    	    
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Rezervasyon Ýþlemi");
            alert.setContentText("Rezervasyon Ýþlemi Tamamlandý.");
            alert.showAndWait();
			

                 } catch (Exception e) {
                	 Alert alert = new Alert(Alert.AlertType.ERROR);
                     alert.setHeaderText("Rezervasyon Ýþlemi");
                     alert.setContentText("Rezervasyon Ýþlemi Baþarýsýz Oldu.");
                     alert.showAndWait();
         			e.printStackTrace();

              }
    finally {
    	sorguIfadesi.close();
    	     	
    }}

    

    @FXML
    void btn_ClickRezervasyonSil(ActionEvent event)throws SQLException{

    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Rezervasyon Ýptal");
    	alert.setHeaderText("");
    	alert.setContentText("Silmek istediðinize emin misiniz?");
    	Optional<ButtonType> result=alert.showAndWait();
    	if(result.get()==ButtonType.OK) {
    	baglanti=(Connection) connection.Baglan();

    	RezervasyonBilgi rezervasyonData;
    	rezervasyonData=tbl_Rezervasyon.getSelectionModel().getSelectedItem();
    	int value=rezervasyonData.getId();
    	
       String sql = "delete from rezervasyon where id='"+value+ "'";
  
   	try {
   		sorguIfadesi=baglanti.prepareStatement(sql);
    	sorguIfadesi.executeUpdate();
    	Guncelle(tbl_Rezervasyon);
  

                } catch (Exception e) {   	

             }}
    	else {
     		alert.close();
     	}
    }

    
    
    @FXML
    void btn_ClickRezervasyonAra(ActionEvent event) {
    	
    	sql="select*from rezervasyon where isim=? ";
    	ObservableList<RezervasyonBilgi> rezervasyonData=FXCollections.observableArrayList();
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1, txtAra.getText());
    		ResultSet getirilen=sorguIfadesi.executeQuery();
    		while (getirilen.next()){   
    			rezervasyonData.add(new RezervasyonBilgi(getirilen.getInt("id"),getirilen.getString("isim"),getirilen.getString("telefonNumara"),getirilen.getString("paket"),getirilen.getString("donem"),getirilen.getString("ucret"),getirilen.getString("fotopaket"),getirilen.getString("tcno"),getirilen.getString("otel")));}
    		
    		col_id.setCellValueFactory(new PropertyValueFactory<RezervasyonBilgi,Integer>("id"));
        	col_RezervasyonKisi.setCellValueFactory(new PropertyValueFactory<RezervasyonBilgi,String>("isim"));
        	col_Telefon.setCellValueFactory(new PropertyValueFactory<RezervasyonBilgi,String>("telefon"));
        	col_Paket.setCellValueFactory(new PropertyValueFactory<RezervasyonBilgi,String>("paket"));
        	col_Donem.setCellValueFactory(new PropertyValueFactory<RezervasyonBilgi,String>("donem"));
            col_Ucret.setCellValueFactory(new PropertyValueFactory<RezervasyonBilgi,String>("ucret"));
        	col_Fotopaket.setCellValueFactory(new PropertyValueFactory<RezervasyonBilgi,String>("fotopaket"));
        	col_Tcno.setCellValueFactory(new PropertyValueFactory<RezervasyonBilgi,String>("tcno"));
        	col_Otel.setCellValueFactory(new PropertyValueFactory<RezervasyonBilgi,String>("otel"));

            tbl_Rezervasyon.setItems(rezervasyonData);
            
           }
catch(Exception e){	
    		
    		
    	}

    }

}