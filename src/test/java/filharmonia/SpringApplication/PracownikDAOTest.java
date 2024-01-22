package filharmonia.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PracownikDAOTest {

    private PracownikDAO dao;

    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@192.168.8.121:1521:xe");
        datasource.setUsername("FILHARMONIA");
        datasource.setPassword("FILHARMONIA");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new PracownikDAO(new JdbcTemplate(datasource));
    }

    @Test
    void lsit() {
        List<Pracownik> listPracownik = dao.lsit();
        System.out.println(listPracownik);
        assertFalse(listPracownik.isEmpty());
    }

    @Test
    void delete(){
        dao.delete(3);
    }

    @Test
    void update(){
        Pracownik pracownik = new Pracownik();
        pracownik.setId_pracownika(5);
        pracownik.setImie("Rafał");
        pracownik.setNazwisko("Piątkowski");
        pracownik.setData_urodzenia("13/JAN/24");
        pracownik.setId_filharmonii(4);
        pracownik.setId_adres(4);
        pracownik.setPesel("435345");
        pracownik.setPlec("M");
        pracownik.setData_zatrudnienia("13/JAN/24");


        System.out.println(pracownik);

        dao.update(pracownik);
    }
}