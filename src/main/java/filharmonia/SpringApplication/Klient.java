package filharmonia.SpringApplication;

public class Klient {
    private int id_klienta;
    private String imie;
    private String nazwisko;
    private String email;
    private String numer_telefonu;
    private int id_filharmonii;
    private int id_adres;

    public Klient(){super();}

    public Klient(int id_klienta, String imie, String nazwisko, String email, String numer_telefonu, int id_filharmonii, int id_adres) {
        this.id_klienta = id_klienta;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.numer_telefonu = numer_telefonu;
        this.id_filharmonii = id_filharmonii;
        this.id_adres = id_adres;
    }

    public int getId_klienta() {
        return id_klienta;
    }

    public void setId_klienta(int id_klienta) {
        this.id_klienta = id_klienta;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumer_telefonu() {
        return numer_telefonu;
    }

    public void setNumer_telefonu(String numer_telefonu) {
        this.numer_telefonu = numer_telefonu;
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
        return "Klient{" +
                "id_klienta=" + id_klienta +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", email='" + email + '\'' +
                ", numer_telefonu='" + numer_telefonu + '\'' +
                ", id_filharmonii=" + id_filharmonii +
                ", id_adres=" + id_adres +
                '}';
    }
}
