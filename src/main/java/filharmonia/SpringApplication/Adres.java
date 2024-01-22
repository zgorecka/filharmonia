package filharmonia.SpringApplication;

public class Adres {
    private int id_adres;
    private String kraj;
    private String miasto;
    private String ulica;
    private String numer_budynku;
    private String numer_lokalu;
    private int id_poczty;
    private String kod_poczty;

    public Adres() {super();}

    public Adres(int id_adres, String kraj, String miasto, String ulica, String numer_budynku, String numer_lokalu, int id_poczty, String kod_poczty) {
        this.id_adres = id_adres;
        this.kraj = kraj;
        this.miasto = miasto;
        this.ulica = ulica;
        this.numer_budynku = numer_budynku;
        this.numer_lokalu = numer_lokalu;
        this.id_poczty = id_poczty;
        this.kod_poczty = kod_poczty;
    }

    public int getId_adres() {
        return id_adres;
    }

    public void setId_adres(int id_adres) {
        this.id_adres = id_adres;
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

    public String getKod_poczty() {
        return kod_poczty;
    }

    public void setKod_poczty(String kod_poczty) {
        this.kod_poczty = kod_poczty;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "id_adres=" + id_adres +
                ", kraj='" + kraj + '\'' +
                ", miasto='" + miasto + '\'' +
                ", ulica='" + ulica + '\'' +
                ", numer_budynku='" + numer_budynku + '\'' +
                ", numer_lokalu='" + numer_lokalu + '\'' +
                ", id_poczty=" + id_poczty +
                ", kod_poczty='" + kod_poczty + '\'' +
                '}';
    }
}
