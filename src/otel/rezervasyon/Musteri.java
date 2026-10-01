/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package otel.rezervasyon;

/**
 *
 * @author Yasin
 */
public class Musteri {
private String musteriId;
private String ad;
private String soyad;
private String telefon;
public Musteri(String musteriId, String ad, String soyad, String telefon) {
this.musteriId = musteriId;
this.ad = ad;
this.soyad = soyad;
this.telefon = telefon;

    }

    public String getMusteriId() {
        return musteriId;
    }

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public String getTelefon() {
        return telefon;
        
    }public void bilgileriGoster(){
   System.out.println("Müsteri ID: "+ this.musteriId );
   System.out.println("Ad: "+ this.ad );
   System.out.println("Soyad: "+ this.soyad );
   System.out.println("Telefon: "+ this.telefon);
    }

}
