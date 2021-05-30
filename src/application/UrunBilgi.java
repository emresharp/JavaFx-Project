package application;

public class UrunBilgi {
	Integer urunId;
	String urunAdi;
	String urunKategori;
	String urunFiyat;
	String urunAdet;
	
	public UrunBilgi(Integer urunId, String urunAdi , String urunKategori, String urunFiyat,String urunAdet) 
	{
		this.urunId=urunId;
		this.urunAdi=urunAdi;
		this.urunKategori=urunKategori;
		this.urunFiyat=urunFiyat;
		this.urunAdet=urunAdet;
				
		
	}
	
	public Integer getUrunId() {
		return urunId;
	}
	public void setUrunId(Integer urunId) {
		this.urunId = urunId;
	}
	public String getUrunAdi() {
		return urunAdi;
	}
	public void setUrunAdi(String urunAdi) {
		this.urunAdi = urunAdi;
	}
	public String getUrunKategori() {
		return urunKategori;
	}
	public void setUrunKategori(String urunKategori) {
		this.urunKategori = urunKategori;
	}
	public String getUrunFiyat() {
		return urunFiyat;
	}
	public void setUrunFiyat(String urunFiyat) {
		this.urunFiyat = urunFiyat;
	}
	public String getUrunAdet() {
		return urunAdet;
	}
	public void setUrunAdet(String urunAdet) {
		this.urunAdet = urunAdet;
	}
	
}
