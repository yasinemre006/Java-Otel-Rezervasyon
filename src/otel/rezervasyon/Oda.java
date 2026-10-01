/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package otel.rezervasyon;

/**
 *
 * @author Yasin
 */
public class Oda {
 private int odaNo;
 private String tip;
 private double fiyat;
 private boolean bosMu;    
 
public Oda(int odaNo, String tip, double fiyat) {
this.odaNo = odaNo;
this.tip = tip;
this.fiyat = fiyat;
this.bosMu = true;   

    }

    public int getOdaNo() {
        return odaNo;
    }

    public String getTip() {
        return tip;
    }

    public double getFiyat() {
        return fiyat;
    }

    public boolean isBosMu() {
        return bosMu;
        
    }
public void rezervasyonYap() {
  if (bosMu) {
  bosMu = false;
  System.out.println("Rezervasyon yapildi.");     
  }  else {     
   System.out.println("Bu oda zaten dolu.");    
  }
  }
public void rezervasyonIptal() {
 if (!bosMu) {
 bosMu = true;
 System.out.println("Rezervasyon iptal edildi.");    
 }else {
 System.out.println("Bu oda zaten bos.");    
 } 
  } 
    
}
