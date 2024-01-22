package filharmonia.SpringApplication;

public class Bilet {
    private int id_biletu;
    private String data_zakupu;
    private float cena;
    private int id_koncertu;
    private int id_klienta;
    private Koncert koncert;


    public Bilet(){super();}

    public Bilet(int id_biletu, String data_zakupu, float cena, int id_koncertu, int id_klienta) {
        this.id_biletu = id_biletu;
        this.data_zakupu = data_zakupu;
        this.cena = cena;
        this.id_koncertu = id_koncertu;
        this.id_klienta = id_klienta;
    }

    public int getId_biletu() {
        return id_biletu;
    }

    public void setId_biletu(int id_biletu) {
        this.id_biletu = id_biletu;
    }

    public String getData_zakupu() {
        return data_zakupu;
    }

    public void setData_zakupu(String data_zakupu) {
        this.data_zakupu = data_zakupu;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public int getId_koncertu() {
        return id_koncertu;
    }

    public void setId_koncertu(int id_koncertu) {
        this.id_koncertu = id_koncertu;
    }

    public int getId_klienta() {
        return id_klienta;
    }

    public void setId_klienta(int id_klienta) {
        this.id_klienta = id_klienta;
    }

    public Koncert getKoncert() {
        return koncert;
    }

    public void setKoncert(Koncert koncert) {
        this.koncert = koncert;
    }

    @Override
    public String toString() {
        return "Bilet{" +
                "id_biletu=" + id_biletu +
                ", data_zakupu='" + data_zakupu + '\'' +
                ", cena=" + cena +
                ", id_koncertu=" + id_koncertu +
                ", id_klienta=" + id_klienta +
                ", koncert=" + koncert +
                '}';
    }
}
