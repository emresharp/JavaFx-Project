package application;

public class RezervasyonBilgi {
	int id;
	String isim;
	String telefon;
	String paket;
	String donem;
	String ucret;
	String fotopaket;
	String tcno;
	String otel;
	
	public RezervasyonBilgi(int id,String isim,String telefon,String paket,String donem,String ucret,String fotopaket,String tcno,String otel) {
		this.id=id;
		this.isim=isim;
		this.telefon=telefon;
		this.paket=paket;
		this.donem=donem;
		this.ucret=ucret;
		this.fotopaket=fotopaket;
		this.tcno=tcno;
		this.otel=otel;
				
		
	}
	public String getIsim() {
		return isim;
	}
	public void setIsim(String isim) {
		this.isim = isim;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPaket() {
		return paket;
	}
	public void setPaket(String paket) {
		this.paket = paket;
	}
	public String getDonem() {
		return donem;
	}
	public void setDonem(String donem) {
		this.donem = donem;
	}
	public String getUcret() {
		return ucret;
	}
	public void setUcret(String ucret) {
		this.ucret = ucret;
	}
	public String getFotopaket() {
		return fotopaket;
	}
	public void setFotopaket(String fotopaket) {
		this.fotopaket = fotopaket;
	}
	public String getTcno() {
		return tcno;
	}
	public void setTcno(String tcno) {
		this.tcno = tcno;
	}
	public String getOtel() {
		return otel;
	}
	public void setOtel(String otel) {
		this.otel = otel;
	}
	
	

}
