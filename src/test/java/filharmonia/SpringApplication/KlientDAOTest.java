package filharmonia.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KlientDAOTest {

    private KlientDAO dao;

    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@192.168.8.121:1521:xe");
        datasource.setUsername("FILHARMONIA");
        datasource.setPassword("FILHARMONIA");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new KlientDAO(new JdbcTemplate(datasource));
    }

    @Test
    void list() {
        List<Klient> listKlient = dao.list();
        System.out.println(listKlient);
        assertFalse(listKlient.isEmpty());
    }

    @Test
    void get() {
        Klient klient = dao.get(2);
        System.out.println(klient);
        assertNotNull(klient);
    }

    @Test
    void update(){
        Klient klient = new Klient();
        klient.setId_klienta(1);
        klient.setImie("Mateusz");
        klient.setNazwisko("Nowak");
        klient.setEmail("kk");
        klient.setId_adres(4);
        klient.setId_filharmonii(4);

        System.out.println(klient);

        dao.update(klient);
    }
}