package com.progmatic.hibernate.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="orszagok")
@NamedQuery(
        name="getTTCar",
        query="Select c FROM CountryE c WHERE autojel like :carSign"
)
public class CountryE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "orszag", nullable = false, length = 27)
    private String orszag;

    @Column(name = "fovaros", nullable = false, length = 19)
    private String fovaros;

    @Column(name = "foldr_hely", nullable = false, length = 37)
    private String foldrHely;

    @Column(name = "terulet", nullable = false, precision = 11, scale = 2)
    private BigDecimal terulet;

    @Column(name = "allamforma", nullable = false, length = 30)
    private String allamforma;

    @Column(name = "nepesseg", nullable = false)
    private Integer nepesseg;

    @Column(name = "nep_fovaros", nullable = false)
    private Integer nepFovaros;

    @Column(name = "autojel", nullable = false, length = 3)
    private String autojel;

    @Column(name = "country", nullable = false, length = 31)
    private String country;

    @Column(name = "capital", nullable = false, length = 19)
    private String capital;

    @Column(name = "penznem", nullable = false, length = 20)
    private String penznem;

    @Column(name = "penzjel", nullable = false, length = 3)
    private String penzjel;

    @Column(name = "valtopenz", nullable = false, length = 18)
    private String valtopenz;

    @Column(name = "telefon", nullable = false)
    private Integer telefon;

    @Column(name = "gdp", nullable = false)
    private Integer gdp;

    @Column(name = "kat", nullable = false)
    private Integer kat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getKat() {
        return kat;
    }

    public void setKat(Integer kat) {
        this.kat = kat;
    }

    public Integer getGdp() {
        return gdp;
    }

    public void setGdp(Integer gdp) {
        this.gdp = gdp;
    }

    public Integer getTelefon() {
        return telefon;
    }

    public void setTelefon(Integer telefon) {
        this.telefon = telefon;
    }

    public String getValtopenz() {
        return valtopenz;
    }

    public void setValtopenz(String valtopenz) {
        this.valtopenz = valtopenz;
    }

    public String getPenzjel() {
        return penzjel;
    }

    public void setPenzjel(String penzjel) {
        this.penzjel = penzjel;
    }

    public String getPenznem() {
        return penznem;
    }

    public void setPenznem(String penznem) {
        this.penznem = penznem;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAutojel() {
        return autojel;
    }

    public void setAutojel(String autojel) {
        this.autojel = autojel;
    }

    public Integer getNepFovaros() {
        return nepFovaros;
    }

    public void setNepFovaros(Integer nepFovaros) {
        this.nepFovaros = nepFovaros;
    }

    public Integer getNepesseg() {
        return nepesseg;
    }

    public void setNepesseg(Integer nepesseg) {
        this.nepesseg = nepesseg;
    }

    public String getAllamforma() {
        return allamforma;
    }

    public void setAllamforma(String allamforma) {
        this.allamforma = allamforma;
    }

    public BigDecimal getTerulet() {
        return terulet;
    }

    public void setTerulet(BigDecimal terulet) {
        this.terulet = terulet;
    }

    public String getFoldrHely() {
        return foldrHely;
    }

    public void setFoldrHely(String foldrHely) {
        this.foldrHely = foldrHely;
    }

    public String getFovaros() {
        return fovaros;
    }

    public void setFovaros(String fovaros) {
        this.fovaros = fovaros;
    }

    public String getOrszag() {
        return orszag;
    }

    public void setOrszag(String orszag) {
        this.orszag = orszag;
    }

    @Override
    public String toString() {
        return "CountryE {" +
                "id=" + id +
                ", orszag='" + orszag + '\'' +
                ", fovaros='" + fovaros + '\'' +
                ", foldrHely='" + foldrHely + '\'' +
                ", terulet=" + terulet +
                ", allamforma='" + allamforma + '\'' +
                ", nepesseg=" + nepesseg +
                ", nepFovaros=" + nepFovaros +
                ", autojel='" + autojel + '\'' +
                ", country='" + country + '\'' +
                ", capital='" + capital + '\'' +
                ", penznem='" + penznem + '\'' +
                ", penzjel='" + penzjel + '\'' +
                ", valtopenz='" + valtopenz + '\'' +
                ", telefon=" + telefon +
                ", gdp=" + gdp +
                ", kat=" + kat +
                '}';
    }
}
