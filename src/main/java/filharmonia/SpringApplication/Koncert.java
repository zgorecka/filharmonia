package filharmonia.SpringApplication;

public class Koncert {
    private int id_koncertu;
    private float cena;
    private String data;
    private int id_filharmonii;
    private int id_orkiestry;
    private int id_sali;
    private String tytul;
    private Orkiestra orkiestra;

    public Koncert() {super();}

    public Koncert(int id_koncertu, float cena, String data, String sala, int id_filharmonii, int id_orkiestry, int id_sali, String tytul) {
        this.id_koncertu = id_koncertu;
        this.cena = cena;
        this.data = data;
        this.id_filharmonii = id_filharmonii;
        this.id_orkiestry = id_orkiestry;
        this.id_sali = id_sali;
        this.tytul = tytul;
    }

    public int getId_koncertu() {
        return id_koncertu;
    }

    public void setId_koncertu(int id_koncertu) {
        this.id_koncertu = id_koncertu;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId_filharmonii() {
        return id_filharmonii;
    }

    public void setId_filharmonii(int id_filharmonii) {
        this.id_filharmonii = id_filharmonii;
    }

    public int getId_orkiestry() {
        return id_orkiestry;
    }

    public void setId_orkiestry(int id_orkiestry) {
        this.id_orkiestry = id_orkiestry;
    }

    public int getId_sali() {
        return id_sali;
    }

    public void setId_sali(int id_sali) {
        this.id_sali = id_sali;
    }

    public Orkiestra getOrkiestra() {
        return orkiestra;
    }

    public void setOrkiestra(Orkiestra orkiestra) {
        this.orkiestra = orkiestra;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    @Override
    public String toString() {
        return "Koncert{" +
                "id_koncertu=" + id_koncertu +
                ", cena=" + cena +
                ", data='" + data + '\'' +
                ", id_filharmonii=" + id_filharmonii +
                ", id_orkiestry=" + id_orkiestry +
                ", id_sali=" + id_sali +
                ", tytul='" + tytul + '\'' +
                ", orkiestra=" + orkiestra +
                '}';
    }
}
