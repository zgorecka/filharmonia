package filharmonia.SpringApplication;

import java.util.Date;

public class Pracownik {
    private int id_pracownika;
    private String imie;
    private String drugie_imie;
    private String nazwisko;
    private Date data_urodzenia;
    private String plec;
    private String pesel;
    private Date data_zatrudnienia;
    private Date data_zwolnienia;
    private int id_filharmonii;
    private int id_adres;

    public Pracownik(){super();}

    public Pracownik(int id_pracownika, String imie, String drugie_imie, String nazwisko, Date data_urodzenia, String plec, String pesel, Date data_zatrudnienia, Date data_zwolnienia, int id_filharmonii, int id_adres) {
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

    public Date getData_urodzenia() {
        System.out.println(data_urodzenia);
        return data_urodzenia;
    }
    public String getData_urodzeniaString(){
        return data_urodzenia.toString();
    }

    public void setData_urodzenia(Date data_urodzenia) {
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

    public Date getData_zatrudnienia() {
        return data_zatrudnienia;
    }

    public void setData_zatrudnienia(Date data_zatrudnienia) {
        this.data_zatrudnienia = data_zatrudnienia;
    }

    public Date getData_zwolnienia() {
        return data_zwolnienia;
    }

    public void setData_zwolnienia(Date data_zwolnienia) {
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
                '}';
    }
}
