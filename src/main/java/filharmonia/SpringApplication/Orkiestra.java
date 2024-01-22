package filharmonia.SpringApplication;

public class Orkiestra {
    private int id_orkiestry;
    private String nazwa;
    private int wielkosc_skladu;
    private Integer id_filharmonii; //nullable

    public Orkiestra() {super();}

    public Orkiestra(int id_orkiestry, String nazwa, int wielkosc_skladu, int id_filharmonii) {
        this.id_orkiestry = id_orkiestry;
        this.nazwa = nazwa;
        this.wielkosc_skladu = wielkosc_skladu;
        this.id_filharmonii = id_filharmonii;
    }

    public int getId_orkiestry() {
        return id_orkiestry;
    }

    public void setId_orkiestry(int id_orkiestry) {
        this.id_orkiestry = id_orkiestry;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getWielkosc_skladu() {
        return wielkosc_skladu;
    }

    public void setWielkosc_skladu(int wielkosc_skladu) {
        this.wielkosc_skladu = wielkosc_skladu;
    }

    public Integer getId_filharmonii() {
        return id_filharmonii;
    }

    public void setId_filharmonii(Integer id_filharmonii) {
        this.id_filharmonii = id_filharmonii;
    }

    @Override
    public String toString() {
        return "Orkiestra{" +
                "id_orkiestry=" + id_orkiestry +
                ", nazwa='" + nazwa + '\'' +
                ", wielkosc_skladu=" + wielkosc_skladu +
                ", id_filharmonii=" + id_filharmonii +
                '}';
    }
}
