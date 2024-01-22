package filharmonia;

import filharmonia.SpringApplication.Koncert;
import filharmonia.SpringApplication.KoncertDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KoncertDAOTest {

    private KoncertDAO dao;

    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@192.168.8.121:1521:xe");
        datasource.setUsername("FILHARMONIA");
        datasource.setPassword("FILHARMONIA");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new KoncertDAO(new JdbcTemplate(datasource));
    }

    @Test
    void testList() {
        List<Koncert> listKoncert = dao.list();
        System.out.println(listKoncert);
        assertFalse(listKoncert.isEmpty());
    }

    @Test
    void save() {
    }

    @Test
    void get() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}