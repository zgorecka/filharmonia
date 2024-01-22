package filharmonia.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BiletDAOTest {

    private BiletDAO dao;

    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@192.168.8.121:1521:xe");
        datasource.setUsername("FILHARMONIA");
        datasource.setPassword("FILHARMONIA");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new BiletDAO(new JdbcTemplate(datasource));
    }

    @Test
    void list() {
        List<Bilet> listBilet = dao.list(1);
        System.out.println(listBilet);
        assertFalse(listBilet.isEmpty());
    }

    @Test
    void delete(){
        dao.delete(2);
    }
}