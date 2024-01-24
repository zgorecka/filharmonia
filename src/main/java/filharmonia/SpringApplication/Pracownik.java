package filharmonia.SpringApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Pracownik {
    private int id_pracownika;
    private String imie;
    private String drugie_imie;
    private String nazwisko;
    private String data_urodzenia;
    private String plec;
    private String pesel;
    private String data_zatrudnienia;
    private String data_zwolnienia;
    private int id_filharmonii;
    private int id_adres;
    private Date data_urodzeniaDate;
    private Date data_zatrudnieniaDate;
    private  Date data_zwolnieniaDate;
    private String kraj;
    private String miasto;
    private String ulica;
    private String numer_budynku;
    private String numer_lokalu;
    private int id_poczty;


    public Pracownik(){super();}

    public Pracownik(int id_pracownika, String imie, String drugie_imie, String nazwisko, String data_urodzenia, String plec, String pesel, String data_zatrudnienia, String data_zwolnienia, int id_filharmonii, int id_adres) {
        this.id_pracownika = id_pracownika;
        this.imie = imie;
        this.drugie_imie = drugie_imie;
        this.nazwisko = nazwisko;
        this.data_urodzenia = data_urodzenia;
        this.plec = plec;
        this.pesel = pesel;
        this.data_zatrudnienia = data_zatrudnienia;
        this.data_zwolnienia = data_zwolnienia;
        this.id_filharmonii = id_filharmonii;
        this.id_adres = id_adres;
    }

    public int getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(int id_pracownika) {
        this.id_pracownika = id_pracownika;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getDrugie_imie() {
        return drugie_imie;
    }

    public void setDrugie_imie(String drugie_imie) {
        this.drugie_imie = drugie_imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getData_urodzenia() {
        if (data_urodzenia != null){
            String dataBezGodziny = data_urodzenia.replaceAll(" .*", "");
            return dataBezGodziny;
        }
        return null;
    }
    public LocalDate getData_urodzeniaDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //formatter = formatter.withLocale( Locale.UK);
        String data_bez_godziny = data_urodzenia.replaceAll(" .*", "");
        LocalDate date = LocalDate.parse(data_bez_godziny, formatter);
        return date;
    }

    public void setData_urodzenia(String data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getData_zatrudnienia() {
        if(data_zatrudnienia != null){
            String dataBezGodziny = data_zatrudnienia.replaceAll(" .*", "");
            return dataBezGodziny;
        }
        return null;
    }

    public LocalDate getData_zatrudnieniaDate() throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //formatter = formatter.withLocale( Locale.UK);
        String data_bez_godziny = data_zatrudnienia.replaceAll(" .*", "");
        LocalDate date = LocalDate.parse(data_bez_godziny, formatter);
        return date;
    }

    public void setData_zatrudnienia(String data_zatrudnienia) {
        this.data_zatrudnienia = data_zatrudnienia;
    }

    public String getData_zwolnienia() {
        if (data_zwolnienia != null){
            String dataBezGodziny = data_zwolnienia.replaceAll(" .*", "");
            return dataBezGodziny;
        }else {
            return null;
        }
    }

    public LocalDate getData_zwolnieniaDate() throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //formatter = formatter.withLocale( Locale.UK);
        if(data_zwolnienia == null){
            return null;

        }
        String data_bez_godziny = data_zwolnienia.replaceAll(" .*", "");
        LocalDate date = LocalDate.parse(data_bez_godziny, formatter);
        return date;
    }

    public void setData_zwolnienia(String data_zwolnienia) {
        this.data_zwolnienia = data_zwolnienia;
    }

    public int getId_filharmonii() {
        return id_filharmonii;
    }

    public void setId_filharmonii(int id_filharmonii) {
        this.id_filharmonii = id_filharmonii;
    }

    public int getId_adres() {
        return id_adres;
    }

    public void setId_adres(int id_adres) {
        this.id_adres = id_adres;
    }

    public void setData_urodzeniaDate(Date data_urodzeniaDate) {
        this.data_urodzeniaDate = data_urodzeniaDate;
    }

    public void setData_zatrudnieniaDate(Date data_zatrudnieniaDate) {
        this.data_zatrudnieniaDate = data_zatrudnieniaDate;
    }

    public void setData_zwolnieniaDate(Date data_zwolnieniaDate) {
        this.data_zwolnieniaDate = data_zwolnieniaDate;
    }

    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNumer_budynku() {
        return numer_budynku;
    }

    public void setNumer_budynku(String numer_budynku) {
        this.numer_budynku = numer_budynku;
    }

    public String getNumer_lokalu() {
        return numer_lokalu;
    }

    public void setNumer_lokalu(String numer_lokalu) {
        this.numer_lokalu = numer_lokalu;
    }

    public int getId_poczty() {
        return id_poczty;
    }

    public void setId_poczty(int id_poczty) {
        this.id_poczty = id_poczty;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "id_pracownika=" + id_pracownika +
                ", imie='" + imie + '\'' +
                ", drugie_imie='" + drugie_imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", data_urodzenia='" + data_urodzenia + '\'' +
                ", plec='" + plec + '\'' +
                ", pesel='" + pesel + '\'' +
                ", data_zatrudnienia='" + data_zatrudnienia + '\'' +
                ", data_zwolnienia='" + data_zwolnienia + '\'' +
                ", id_filharmonii=" + id_filharmonii +
                ", id_adres=" + id_adres +
                ", data_urodzeniaDate=" + data_urodzeniaDate +
                ", data_zatrudnieniaDate=" + data_zatrudnieniaDate +
                ", data_zwolnieniaDate=" + data_zwolnieniaDate +
                ", kraj='" + kraj + '\'' +
                ", miasto='" + miasto + '\'' +
                ", ulica='" + ulica + '\'' +
                ", numer_budynku='" + numer_budynku + '\'' +
                ", numer_lokalu='" + numer_lokalu + '\'' +
                ", id_poczty=" + id_poczty +
                '}';
    }
}
