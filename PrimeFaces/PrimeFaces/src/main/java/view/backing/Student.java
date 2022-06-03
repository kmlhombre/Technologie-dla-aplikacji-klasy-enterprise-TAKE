/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.backing;

/**
 *
 * @author student
 */
public class Student {
    private String imie;
    private String nazwisko;
    private double srednia;

    Student(String imie, String nazwisko, double srednia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.srednia = srednia;
    }
    
    /**
     * @return the imie
     */
    public String getImie() {
        return imie;
    }

    /**
     * @param imie the imie to set
     */
    public void setImie(String imie) {
        this.imie = imie;
    }

    /**
     * @return the nazwisko
     */
    public String getNazwisko() {
        return nazwisko;
    }

    /**
     * @param nazwisko the nazwisko to set
     */
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    /**
     * @return the srednia
     */
    public double getSrednia() {
        return srednia;
    }

    /**
     * @param srednia the srednia to set
     */
    public void setSrednia(double srednia) {
        this.srednia = srednia;
    }
    
    
}
