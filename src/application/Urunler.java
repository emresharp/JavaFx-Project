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

public class Urunler implements Initializable{

    @FXML
    private TableView<UrunBilgi> tblUrun;

    @FXML
    private TableColumn<UrunBilgi, Integer> col_Id;

    @FXML
    private TableColumn<UrunBilgi, String> col_UrunAdi;

    @FXML
    private TableColumn<UrunBilgi, String> col_UrunKategori;

    @FXML
    private TableColumn<UrunBilgi, String> col_UrunFiyat;
    
    @FXML
    private TableColumn<UrunBilgi, String> col_UrunAdet;

    @FXML
    private TextField txtUrunAdi;

    @FXML
    private TextField txtUrunFiyat;

    @FXML
    private ComboBox<String> comboKategori;

    @FXML
    private Button btnUrunEkle;
    @FXML
    private Button btnUrunGuncelle;

    @FXML
    private Button btnUrunSil;

    @FXML
    private TextField txtAra;
    
    @FXML
    private TextField txtUrunAdeti;

    @FXML
    private Button btnUrunAra;

    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    PreparedStatement sorguIfadesi1=null;
    ResultSet getirilen=null;
    String sql;
    String urunKategori;
    
    ObservableList<UrunBilgi> urunData;
    
    public void UrunSec(ActionEvent event) {
    	urunKategori=comboKategori.getValue();
    }
    
    public void Guncelle() {
    	col_Id.setCellValueFactory(new PropertyValueFactory<UrunBilgi, Integer>("urunId"));
    	col_UrunAdi.setCellValueFactory(new PropertyValueFactory<UrunBilgi, String>("urunAdi"));
    	 col_UrunKategori.setCellValueFactory(new PropertyValueFactory<UrunBilgi, String>("urunKategori"));
    	 col_UrunFiyat.setCellValueFactory(new PropertyValueFactory<UrunBilgi, String>("urunFiyat"));
    	 col_UrunAdet.setCellValueFactory(new PropertyValueFactory<UrunBilgi, String>("urunAdet"));

        
        
    	urunData= connection.getUrun();
    	 tblUrun.setItems(urunData); 
    }
    
    @Override
   	public void initialize(URL arg0, ResourceBundle arg1) {
   		
   		baglanti=connection.Baglan();
           if(baglanti==null)
           {
           	System.out.println("Ba�lant� Kurulamad�");
           	}
           

       	tblUrun.setItems(urunData);
       	col_Id.setCellValueFactory(new PropertyValueFactory<UrunBilgi,Integer>("urunId"));
       	col_UrunAdi.setCellValueFactory(new PropertyValueFactory<UrunBilgi,String>("urunAdi"));
       	col_UrunKategori.setCellValueFactory(new PropertyValueFactory<UrunBilgi,String>("urunKategori"));
       	col_UrunFiyat.setCellValueFactory(new PropertyValueFactory<UrunBilgi,String>("urunFiyat"));
       	col_UrunAdet.setCellValueFactory(new PropertyValueFactory<UrunBilgi,String>("urunAdet"));

       	
       	ObservableList<String> urunKategori=FXCollections.observableArrayList("Ofis","Mutfak","Temizlik","Di�er");
       	comboKategori.setItems(urunKategori);
       	urunData= connection.getUrun();
    	tblUrun.setItems(urunData); 
           
           
   	}
    
  
    
    public Urunler() {
    	baglanti =connection.Baglan();
    }
 
    @FXML
    void btn_ClickUrunEkle(ActionEvent event) throws SQLException 
    {
    	 baglanti=(Connection) connection.Baglan();

    	 String sql = "insert into urunler(UrunAdi,UrunKategori,UrunFiyat,UrunAdet) values(?,?,?,?)";
   
    	try {
    	  
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1,txtUrunAdi.getText());
    		sorguIfadesi.setString(2,urunKategori);
    		sorguIfadesi.setString(3,txtUrunFiyat.getText());
    		sorguIfadesi.setString(4,txtUrunAdeti.getText());

    
    		sorguIfadesi.execute();
    		Guncelle();
    		
    	    
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("�r�n Ekleme");
            alert.setContentText("�r�n Ekleme Tamamland�.");
            alert.showAndWait();
			

                 } catch (Exception e) {
                	 Alert alert = new Alert(Alert.AlertType.ERROR);
                     alert.setHeaderText("�r�n Ekleme");
                     alert.setContentText("�r�n Ekleme Ba�ar�s�z Oldu.");
                     alert.showAndWait();
         			e.printStackTrace();

              }
    	finally {
    	   	sorguIfadesi.close();
    	   	     	
    	   }
  }
    @FXML
    void btn_ClickUrunAra(ActionEvent event) {
    	
    	sql="select*from urunler where UrunAdi=? ";
    	ObservableList<UrunBilgi> urunData=FXCollections.observableArrayList();
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1, txtAra.getText());
    		ResultSet getirilen=sorguIfadesi.executeQuery();
    		while (getirilen.next()){   
    			urunData.add(new UrunBilgi(getirilen.getInt("id"),getirilen.getString("UrunAdi"),getirilen.getString("UrunKategori"),getirilen.getString("UrunFiyat"),getirilen.getString("UrunAdet")));            
            }
    		
           	col_Id.setCellValueFactory(new PropertyValueFactory<UrunBilgi,Integer>("urunId"));
           	col_UrunAdi.setCellValueFactory(new PropertyValueFactory<UrunBilgi,String>("urunAdi"));
           	col_UrunKategori.setCellValueFactory(new PropertyValueFactory<UrunBilgi,String>("urunKategori"));
           	col_UrunFiyat.setCellValueFactory(new PropertyValueFactory<UrunBilgi,String>("urunFiyat"));
           	col_UrunAdet.setCellValueFactory(new PropertyValueFactory<UrunBilgi,String>("urunAdet"));

           	tblUrun.setItems(urunData);
            
           }
catch(Exception e){	
    		
    		
    	}

    }
    @FXML
    void btn_ClickUrunGuncelle(ActionEvent event) throws SQLException {
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("�r�n Bilgi G�ncelleme");
    	alert.setHeaderText("");
    	alert.setContentText("G�ncellemek istedi�inize emin misiniz?");
    	Optional<ButtonType> result=alert.showAndWait();
    	if(result.get()==ButtonType.OK) {
    	baglanti=(Connection) connection.Baglan();

    	UrunBilgi urunData;
    	urunData=tblUrun.getSelectionModel().getSelectedItem();
    	int value=urunData.getUrunId();
    	
     String sql = "update urunler set UrunAdi=?,UrunKategori=?,UrunFiyat=?,UrunAdet=? where id='"+value+ "'";
  
   	try {
   	  
   		sorguIfadesi=baglanti.prepareStatement(sql);
		sorguIfadesi.setString(1,txtUrunAdi.getText().trim());
		sorguIfadesi.setString(2,urunKategori.trim());
		sorguIfadesi.setString(3,txtUrunFiyat.getText().trim());
		sorguIfadesi.setString(4,txtUrunAdeti.getText().trim());

		sorguIfadesi.execute();
		Guncelle();

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
    void btn_ClickUrunSil(ActionEvent event) {
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("�r�n Bilgileri");
    	alert.setHeaderText("");
    	alert.setContentText("Silmek istedi�inize emin misiniz?");
    	Optional<ButtonType> result=alert.showAndWait();
    	if(result.get()==ButtonType.OK) {
    	
    	baglanti=(Connection) connection.Baglan();

    	UrunBilgi urunData;
    	urunData=tblUrun.getSelectionModel().getSelectedItem();
    	int value=urunData.getUrunId();
    	
       String sql = "delete from urunler where id='"+value+ "'";
  
   	try {
   		sorguIfadesi=baglanti.prepareStatement(sql);
    	sorguIfadesi.executeUpdate();
    	Guncelle();
  

                } catch (Exception e) {   	

             }}
    	else {
     		alert.close();
     	}
    }

    }

    	

    


