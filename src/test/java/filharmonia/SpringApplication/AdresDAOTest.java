package filharmonia.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdresDAOTest {

    private AdresDAO dao;

    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        datasource.setUsername("FILHARMONIA");
        datasource.setPassword("FILHARMONIA");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new AdresDAO(new JdbcTemplate(datasource));
    }

    @Test
    void list() {
        List<Adres> listAdres = dao.list();
        System.out.println(listAdres);
        assertFalse(listAdres.isEmpty());
    }

    @Test
    void get() {
        Adres adres = dao.get(4);
        System.out.println(adres);
        assertNotNull(adres);
    }

    @Test
    void update(){
        Adres adres = new Adres();
        adres.setKraj("Polsza");
        adres.setMiasto("Wrocław");
        adres.setId_adres(4);
        adres.setUlica("truskawkowa");
        adres.setNumer_budynku("666");
        adres.setId_poczty(4);

        dao.update(adres);
    }
}