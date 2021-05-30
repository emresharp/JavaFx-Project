package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import veritabani.connection;

public class Personeller implements Initializable {

    @FXML
    private TextField txtPersonelAdi;

    @FXML
    private TextField txtPersonelSoyadi;

    @FXML
    private TextField txtPersonelEposta;

    @FXML
    private TextField txtPersonelTelefon;

    @FXML
    private TextField txtPersonelDogumTarihi;
    
    @FXML
    private TextField txtPersonelBirimi;
    
    @FXML
    private TextField txtPersonelCalisma;

    @FXML
    private TableView<PersonelBilgi> tbl_PersonelBilgileri;

    @FXML
    private TableColumn<PersonelBilgi, Integer> col_Id;

    @FXML
    private TableColumn<PersonelBilgi, String> col_PersonelAdi;

    @FXML
    private TableColumn<PersonelBilgi, String> col_PersonelSoyadý;

    @FXML
    private TableColumn<PersonelBilgi, String> col_PersonelEposta;

    @FXML
    private TableColumn<PersonelBilgi, String> col_PersonelTelefon;

    @FXML
    private TableColumn<PersonelBilgi, String> col_PersonelDoðumTarihi;
    
    @FXML
    private TableColumn<PersonelBilgi, String> col_PersonelBirimi;
    
    @FXML
    private TableColumn<PersonelBilgi, String> col_PersonelCalisma;

    @FXML
    private Button btnEkle;
    @FXML
    private Button btnSil;

    @FXML
    private Button btnGuncelle;
    @FXML
    private TextField txtAra;
    @FXML
    private Button btnAra;
    @FXML
    private DatePicker date;
   
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    PreparedStatement sorguIfadesi1=null;
    ResultSet getirilen=null;
    String sql;
    
    ObservableList<PersonelBilgi> personelData;

    public void Guncelle(TableView<PersonelBilgi> tbl){
    	
    	sql="select * from personeller";
    	
    	ObservableList<PersonelBilgi> personelData=FXCollections.observableArrayList();
    	try {
			
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		
    		ResultSet getirilen=sorguIfadesi.executeQuery();
    		
    		
    		
    		while(getirilen.next()) {
    			personelData.add(new PersonelBilgi(getirilen.getInt("id"),getirilen.getString("PersonelAdi"),getirilen.getString("PersonelSoyadi"),getirilen.getString("PersonelEposta"),getirilen.getString("PersonelTelefon"),getirilen.getString("PersonelDogumTarih"),getirilen.getString("PersonelBirimi"),getirilen.getString("PersonelCalisma")));}
    	col_Id.setCellValueFactory(new PropertyValueFactory<PersonelBilgi, Integer>("id"));
    	col_PersonelAdi.setCellValueFactory(new PropertyValueFactory<PersonelBilgi, String>("personelAdi"));
        col_PersonelSoyadý.setCellValueFactory(new PropertyValueFactory<PersonelBilgi, String>("personelSoyadi"));
        col_PersonelEposta.setCellValueFactory(new PropertyValueFactory<PersonelBilgi, String>("personelEposta"));
        col_PersonelTelefon.setCellValueFactory(new PropertyValueFactory<PersonelBilgi, String>("personelTelefon"));
        col_PersonelDoðumTarihi.setCellValueFactory(new PropertyValueFactory<PersonelBilgi, String>("personelDogumTarihi"));
        col_PersonelBirimi.setCellValueFactory(new PropertyValueFactory<PersonelBilgi, String>("personelBirimi"));
        col_PersonelCalisma.setCellValueFactory(new PropertyValueFactory<PersonelBilgi, String>("personelCalisma"));
        
       personelData = connection.getPersonel();
        tbl_PersonelBilgileri.setItems(personelData);   
       
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
         
        
        col_Id.setCellValueFactory(new PropertyValueFactory<PersonelBilgi, Integer>("id"));
    	col_PersonelAdi.setCellValueFactory(new PropertyValueFactory<PersonelBilgi, String>("personelAdi"));
        col_PersonelSoyadý.setCellValueFactory(new PropertyValueFactory<PersonelBilgi, String>("personelSoyadi"));
        col_PersonelEposta.setCellValueFactory(new PropertyValueFactory<PersonelBilgi, String>("personelEposta"));
        col_PersonelTelefon.setCellValueFactory(new PropertyValueFactory<PersonelBilgi, String>("personelTelefon"));
        col_PersonelDoðumTarihi.setCellValueFactory(new PropertyValueFactory<PersonelBilgi, String>("personelDogumTarihi"));
        col_PersonelBirimi.setCellValueFactory(new PropertyValueFactory<PersonelBilgi, String>("personelBirimi"));
        col_PersonelCalisma.setCellValueFactory(new PropertyValueFactory<PersonelBilgi, String>("personelCalisma"));
        
        personelData = connection.getPersonel();
        tbl_PersonelBilgileri.setItems(personelData);    
        
    
        

}
    public Personeller() {
    	baglanti =connection.Baglan();
    }
  
    @FXML
    void btn_ClickEkle(ActionEvent event) throws SQLException {
        
        baglanti=(Connection) connection.Baglan();

    	 String sql = "insert into personeller(PersonelAdi,PersonelSoyadi,PersonelEposta,PersonelTelefon,PersonelDogumTarih,PersonelBirimi,PersonelCalisma) values(?,?,?,?,?,?,?)";
   
    	try {
    	  
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1,txtPersonelAdi.getText());
    		sorguIfadesi.setString(2,txtPersonelSoyadi.getText());
    		sorguIfadesi.setString(3,txtPersonelEposta.getText());
    		sorguIfadesi.setString(4,txtPersonelTelefon.getText());
    		sorguIfadesi.setString(5,txtPersonelDogumTarihi.getText());
    		sorguIfadesi.setString(6,txtPersonelBirimi.getText());
    		sorguIfadesi.setString(7,txtPersonelCalisma.getText());
    		
    		sorguIfadesi.execute();
    		Guncelle(tbl_PersonelBilgileri);
    		
    	    
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Personel Ekleme");
            alert.setContentText("Personel Ekleme Tamamlandý.");
            alert.showAndWait();
			

                 } catch (Exception e) {
                	 Alert alert = new Alert(Alert.AlertType.ERROR);
                     alert.setHeaderText("Personel Ekleme");
                     alert.setContentText("Personel Ekleme Baþarýsýz Oldu.");
                     alert.showAndWait();
         			e.printStackTrace();

              }
    finally {
    	sorguIfadesi.close();
    	     	
    }}
    @FXML
    void btn_ClickGuncelle(ActionEvent event) throws SQLException {
    	
    	
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Personel Bilgi Güncelleme");
    	alert.setHeaderText("");
    	alert.setContentText("Güncellemek istediðinize emin misiniz?");
    	Optional<ButtonType> result=alert.showAndWait();
    	if(result.get()==ButtonType.OK) {
    	baglanti=(Connection) connection.Baglan();

    	PersonelBilgi personelData;
    	personelData=tbl_PersonelBilgileri.getSelectionModel().getSelectedItem();
    	int value=personelData.getId();
    	
 String sql = "update personeller set PersonelAdi=?,PersonelSoyadi=?,PersonelEposta=?,PersonelTelefon=?,PersonelDogumTarih=?,PersonelBirimi=?,PersonelCalisma=? where id='"+value+ "'";
  
   	try {
   	  
   		sorguIfadesi=baglanti.prepareStatement(sql);
   		sorguIfadesi.setString(1,txtPersonelAdi.getText().trim());
   		sorguIfadesi.setString(2,txtPersonelSoyadi.getText().trim());
   		sorguIfadesi.setString(3,txtPersonelEposta.getText().trim());
   		sorguIfadesi.setString(4,txtPersonelTelefon.getText().trim());
   		sorguIfadesi.setString(5,txtPersonelDogumTarihi.getText().trim());
   		sorguIfadesi.setString(6,txtPersonelBirimi.getText().trim());
   		sorguIfadesi.setString(7,txtPersonelCalisma.getText().trim());
   		
   		sorguIfadesi.execute();
   		Guncelle(tbl_PersonelBilgileri);

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
    void btn_ClickSil(ActionEvent event) {
    	
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Personel Bilgileri");
    	alert.setHeaderText("");
    	alert.setContentText("Silmek istediðinize emin misiniz?");
    	Optional<ButtonType> result=alert.showAndWait();
    	if(result.get()==ButtonType.OK) {
    	
    	baglanti=(Connection) connection.Baglan();

    	PersonelBilgi personelData;
    	personelData=tbl_PersonelBilgileri.getSelectionModel().getSelectedItem();
    	int value=personelData.getId();
    	
       String sql = "delete from personeller where id='"+value+ "'";
  
   	try {
   		sorguIfadesi=baglanti.prepareStatement(sql);
   		
   	
   		
    	sorguIfadesi.executeUpdate();
    	Guncelle(tbl_PersonelBilgileri);
  

                } catch (Exception e) {   	

             }}
    	else {
     		alert.close();
     	}
    }
    
 
  
    

    @FXML
    void btn_ClickAra(ActionEvent event) {
    	sql="select*from personeller where PersonelAdi=? ";
    	ObservableList<PersonelBilgi> personelData=FXCollections.observableArrayList();
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1, txtAra.getText());
    		ResultSet getirilen=sorguIfadesi.executeQuery();
    		while (getirilen.next()){   
    			personelData.add(new PersonelBilgi(getirilen.getInt("id"),getirilen.getString("PersonelAdi"),getirilen.getString("PersonelSoyadi"),getirilen.getString("PersonelEposta"),getirilen.getString("PersonelAdres"),getirilen.getString("PersonelDogumTarih"),getirilen.getString("PersonelBirimi"),getirilen.getString("PersonelCalisma")));            
            }
    		col_Id.setCellValueFactory(new PropertyValueFactory<PersonelBilgi, Integer>("id"));
        	col_PersonelAdi.setCellValueFactory(new PropertyValueFactory<PersonelBilgi, String>("personelAdi"));
            col_PersonelSoyadý.setCellValueFactory(new PropertyValueFactory<PersonelBilgi, String>("personelSoyadi"));
            col_PersonelEposta.setCellValueFactory(new PropertyValueFactory<PersonelBilgi, String>("personelEposta"));
            col_PersonelTelefon.setCellValueFactory(new PropertyValueFactory<PersonelBilgi, String>("personelTelefon"));
            col_PersonelDoðumTarihi.setCellValueFactory(new PropertyValueFactory<PersonelBilgi, String>("personelDogumTarihi"));
            col_PersonelBirimi.setCellValueFactory(new PropertyValueFactory<PersonelBilgi, String>("personelBirimi"));
            col_PersonelCalisma.setCellValueFactory(new PropertyValueFactory<PersonelBilgi, String>("personelCalisma"));
            
            tbl_PersonelBilgileri.setItems(personelData);    
            
           }
catch(Exception e){	
    		
    		
    	}

    }
}


    
   

	
