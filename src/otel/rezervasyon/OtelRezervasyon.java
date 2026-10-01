/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package otel.rezervasyon;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 *
 * @author Yasin
 */
public class OtelRezervasyon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
    Scanner input = new Scanner(System.in);
    Otel otel = new Otel();
    otel.odalariDosyadanOku();
   otel.musterileriDosyadanOku();
   otel.rezervasyonlariDosyadanOku();
    
    while (true) {
     System.out.println("\n===== OTEL REZERVASYON SISTEMI =====");
    System.out.println("1 - Odalari Listele");
    System.out.println("2 - Musterileri Listele");
    System.out.println("3 - Rezervasyonlari Listele");
    System.out.println("4 - Rezervasyon Yap");
    System.out.println("5 - Rezervasyon Iptal Et");
    System.out.println("6 - Rezervasyonlari Dosyaya Kaydet");
    System.out.println("0 - Cikis");
    System.out.print("Seciminiz: ");
    try {
   int secim = input.nextInt();    
     switch (secim) {
    case 1:
    otel.odalariListele();
        break;

    case 2:
        otel.musterileriListele();
        break;

    case 3:
        otel.rezervasyonlariListele();
        break;
    case 4:
    System.out.print("Rezervasyon ID: ");
    String rezervasyonId = input.next();

    System.out.print("Musteri ID: ");
    String musteriId = input.next();

    System.out.print("Oda No: ");
    int odaNo = input.nextInt();

    Musteri musteri = otel.musteriBul(musteriId);
    Oda oda = otel.odaBul(odaNo);

    if (musteri != null && oda != null) {
        otel.rezervasyonYap(rezervasyonId, musteri, oda);
    } else {
        System.out.println("Musteri veya oda bulunamadi.");
    }

    break;   
    case 5:
    System.out.print("Iptal edilecek Rezervasyon ID: ");
    String iptalId = input.next();

    otel.rezervasyonIptal(iptalId);

    break;

    case 0:
     otel.odalariDosyayaYaz();
    otel.musterileriDosyayaYaz();
    otel.rezervasyonlariDosyayaYaz();

    System.out.println("Program kapatiliyor...");

    input.close();
        return;
        case 6:
    otel.odalariDosyayaYaz();
    otel.musterileriDosyayaYaz();
    otel.rezervasyonlariDosyayaYaz();
    break;
   
     
    default:
        System.out.println("Gecersiz secim.");
        }
     }catch (InputMismatchException e) {
      System.out.println("Lutfen sadece sayi giriniz.");
    input.nextLine();    

     }

    }
    }
    
}
