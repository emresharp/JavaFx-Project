package application;

public class PersonelBilgi {
	Integer id;
	String personelAdi;
	String personelSoyadi;
	String personelEposta;
	String personelTelefon;
	String personelDogumTarihi;
	String personelBirimi;
	String personelCalisma;
	
	
	public PersonelBilgi(Integer id,String personelAdi ,String personelSoyadi,String personelEposta,String personelTelefon,String personelDogumTarihi,String personelBirimi,String personelCalisma) {
		this.id=id;
		this.personelAdi=personelAdi;
		this.personelSoyadi=personelSoyadi;
		this.personelEposta=personelEposta;
		this.personelTelefon=personelTelefon;
		this.personelDogumTarihi=personelDogumTarihi;
		this.personelBirimi=personelBirimi;
		this.personelCalisma=personelCalisma;
				
	}
	
	
	
	
	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public String getPersonelAdi() {
		return personelAdi;
	}
	public void setPersonelAdi(String personelAdi) {
		this.personelAdi = personelAdi;
	}
	public String getPersonelSoyadi() {
		return personelSoyadi;
	}
	public void setPersonelSoyadi(String personelSoyadi) {
		this.personelSoyadi = personelSoyadi;
	}
	public String getPersonelEposta() {
		return personelEposta;
	}
	public void setPersonelEposta(String personelEposta) {
		this.personelEposta = personelEposta;
	}
	public String getPersonelTelefon() {
		return personelTelefon;
	}
	public void setPersonelTelefon(String personelTelefon) {
		this.personelTelefon = personelTelefon;
	}
	public String getPersonelDogumTarihi() {
		return personelDogumTarihi;
	}
	public void setPersonelDogumTarihi(String personelDogumTarihi) {
		this.personelDogumTarihi = personelDogumTarihi;
	}
	public String getPersonelBirimi() {
		return personelBirimi;
	}
	public void setPersonelBirimi(String personelBirimi) {
		this.personelBirimi = personelBirimi;
	}
	public String getPersonelCalisma() {
		return personelCalisma;
	}
	public void setPersonelCalisma(String personelCalisma) {
		this.personelCalisma = personelCalisma;
	}
	

	
	

}
