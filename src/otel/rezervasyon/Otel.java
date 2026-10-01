/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package otel.rezervasyon;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author Yasin
 */
public class Otel {
private ArrayList<Oda> odaListesi = new ArrayList<>();
private ArrayList<Musteri> musteriListesi = new ArrayList<>();
private ArrayList<Rezervasyon> rezervasyonListesi = new ArrayList<>();

public void odaEkle(Oda oda) {
odaListesi.add(oda);    
}public void musteriEkle(Musteri musteri) {
musteriListesi.add(musteri);

}public Musteri musteriBul(String musteriId) {

    for (Musteri musteri : musteriListesi) {

        if (musteri.getMusteriId().equals(musteriId)) {
            return musteri;
        }
    }

    return null;
}
public void rezervasyonEkle(Rezervasyon rezervasyon){
rezervasyonListesi.add(rezervasyon);
}public Oda odaBul(int odaNo) {
for (Oda oda : odaListesi) {
if (oda.getOdaNo() == odaNo) {
 return oda;   
 
}    
} 
return null;
}
public void odalariListele() {
  for (Oda oda : odaListesi) {
   System.out.println("Oda No: " + oda.getOdaNo());
   System.out.println("Tip: " + oda.getTip());
   System.out.println("Fiyat: " + oda.getFiyat());
   System.out.println("Bos mu: " + oda.isBosMu());
   System.out.println("----------------------");    
  } 
}
public void musterileriListele() {
for(Musteri musteri : musteriListesi){
System.out.println("Musteri ID: "+ musteri.getMusteriId());
System.out.println("Musteri Adi: "+ musteri.getAd());
System.out.println("Musteri Soyad: "+ musteri.getSoyad());
System.out.println("Musteri Telefon: "+ musteri.getTelefon());

}    
}
public void rezervasyonlariListele() {
for(Rezervasyon rezervasyon : rezervasyonListesi){
 System.out.println("Rezervasyon ID: " + rezervasyon.getRezervasyonId());
 System.out.println("Musteri: "+ rezervasyon.getMusteri().getAd()+ " " + rezervasyon.getMusteri().getSoyad());
  System.out.println("Oda No: " + rezervasyon.getOda().getOdaNo());
System.out.println("----------------------");
}    
}
public void rezervasyonYap(String rezervasyonId, Musteri musteri, Oda oda) {
    if (rezervasyonBul(rezervasyonId) != null) {
      System.out.println("Bu rezervasyon ID zaten kullaniliyor.");
    return;    
    }
 if (oda.isBosMu()) {
   oda.rezervasyonYap();

        Rezervasyon rezervasyon = new Rezervasyon(rezervasyonId, musteri,oda);

        rezervasyonListesi.add(rezervasyon);

        System.out.println("Rezervasyon basariyla olusturuldu.");    
 } else {
  System.out.println("Bu oda zaten dolu.");   
 }  
}
public void rezervasyonIptal(String rezervasyonId) {
Iterator<Rezervasyon> iterator = rezervasyonListesi.iterator();
 while (iterator.hasNext()) {
 Rezervasyon rezervasyon = iterator.next(); 
if (rezervasyon.getRezervasyonId().equals(rezervasyonId)) {
  rezervasyon.getOda().rezervasyonIptal();
iterator.remove();
System.out.println("Rezervasyon iptal edildi.");
return;           
        }
 }
 System.out.println("Rezervasyon bulunamadi."); 
}
public void rezervasyonlariDosyayaYaz() {
try {
 FileWriter writer = new FileWriter("rezervasyonlar.txt");
 for (Rezervasyon rezervasyon : rezervasyonListesi) {
    writer.write(rezervasyon.getRezervasyonId()+ ","+ rezervasyon.getMusteri().getMusteriId()+ ","+ rezervasyon.getOda().getOdaNo() + "\n");   
 } writer.close();
System.out.println("Rezervasyonlar dosyaya kaydedildi.");
} catch (IOException e) {
 System.out.println("Dosyaya yazilirken hata olustu.");   
}
    
}public void rezervasyonlariDosyadanOku() throws IOException {
 try {
 BufferedReader reader = new BufferedReader(new FileReader("rezervasyonlar.txt"));
 String satir;
 while ((satir = reader.readLine()) != null) {
 String[] bilgiler = satir.split(",");
 String rezervasyonId = bilgiler[0];
 String musteriId = bilgiler[1];
 int odaNo = Integer.parseInt(bilgiler[2]);
 Musteri musteri = musteriBul(musteriId);
 Oda oda = odaBul(odaNo);
 if (musteri != null && oda != null && oda.isBosMu()) {
 rezervasyonYap(rezervasyonId, musteri, oda);     
  }
   }
 reader.close();
System.out.println("Rezervasyonlar dosyadan okundu.");
 } catch (IOException e) {
   System.out.println("Dosya okunurken hata olustu.");    
 } catch (NumberFormatException e) {
    System.out.println("Dosyadaki oda numarasi veya fiyat bilgisi hatali.");
}
 }
public void musterileriDosyayaYaz() throws IOException {
try {
FileWriter writer = new FileWriter("musteriler.txt");    
 for (Musteri musteri : musteriListesi) {
 writer.write(musteri.getMusteriId()+ "," + musteri.getAd()+ "," + musteri.getSoyad() + ","+ musteri.getTelefon()+ "\n");   
 }
   writer.close();
   System.out.println("Musteriler dosyaya kaydedildi.");
}catch (IOException e) {
  System.out.println("Musteriler kaydedilirken hata olustu.");   
}    
}public void musterileriDosyadanOku() throws IOException {
  File dosya = new File("musteriler.txt");

    if (!dosya.exists()) {

        System.out.println("Musteri dosyasi bulunamadi.");

        Musteri musteri1 = new Musteri(
                "M001",
                "Yasin",
                "Yilmaz",
                "05551234567"
        );

        Musteri musteri2 = new Musteri(
                "M002",
                "Ahmet",
                "Demir",
                "05559876543"
        );

        musteriEkle(musteri1);
        musteriEkle(musteri2);

        return;
    }

    try {

        BufferedReader reader = new BufferedReader(
                new FileReader("musteriler.txt")
        );

        String satir;

        while ((satir = reader.readLine()) != null) {

            String[] bilgiler = satir.split(",");

            String musteriId = bilgiler[0];
            String ad = bilgiler[1];
            String soyad = bilgiler[2];
            String telefon = bilgiler[3];

            Musteri musteri = new Musteri(
                    musteriId,
                    ad,
                    soyad,
                    telefon
            );

            musteriEkle(musteri);
        }

        reader.close();

        System.out.println("Musteriler dosyadan okundu.");

    } catch (IOException e) {

        System.out.println("Musteriler okunurken hata olustu.");
    }
}public void odalariDosyayaYaz() {
 try {

        FileWriter writer = new FileWriter("odalar.txt");

        for (Oda oda : odaListesi) {

            writer.write(
                oda.getOdaNo()
                + ","
                + oda.getTip()
                + ","
                + oda.getFiyat()
                + "\n"
            );
        }

        writer.close();

        System.out.println("Odalar dosyaya kaydedildi.");

    } catch (IOException e) {

        System.out.println("Odalar kaydedilirken hata olustu.");
    }
}public void odalariDosyadanOku() {
 File dosya = new File("odalar.txt");

    if (!dosya.exists()) {

        System.out.println("Oda dosyasi bulunamadi.");

        Oda oda1 = new Oda(101, "Tek Kisilik", 1500);
        Oda oda2 = new Oda(102, "Cift Kisilik", 2500);

        odaEkle(oda1);
        odaEkle(oda2);

        return;
    }

    try {

        BufferedReader reader = new BufferedReader(
                new FileReader("odalar.txt")
        );

        String satir;

        while ((satir = reader.readLine()) != null) {

            String[] bilgiler = satir.split(",");

            int odaNo = Integer.parseInt(bilgiler[0]);
            String tip = bilgiler[1];
            double fiyat = Double.parseDouble(bilgiler[2]);

            Oda oda = new Oda(
                    odaNo,
                    tip,
                    fiyat
            );

            odaEkle(oda);
        }

        reader.close();

        System.out.println("Odalar dosyadan okundu.");

    } catch (IOException e) {

        System.out.println("Odalar okunurken hata olustu.");
    }
    
}public Rezervasyon rezervasyonBul(String rezervasyonId) {
  for (Rezervasyon rezervasyon : rezervasyonListesi) {
  if (rezervasyon.getRezervasyonId().equals(rezervasyonId)) {
   return rezervasyon;    
  }    
}
    return null;
}
}


