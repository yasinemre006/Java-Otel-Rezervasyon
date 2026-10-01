/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package otel.rezervasyon;

/**
 *
 * @author Yasin
 */
public class Rezervasyon {
private String rezervasyonId;
private Musteri musteri;
private Oda oda;
public Rezervasyon(String rezervasyonId, Musteri musteri, Oda oda) {
this.rezervasyonId = rezervasyonId;
this.musteri = musteri;
this.oda = oda;

    }

    public String getRezervasyonId() {
        return rezervasyonId;
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public Oda getOda() {
        return oda;
    }

}
