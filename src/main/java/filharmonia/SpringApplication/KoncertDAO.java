package filharmonia.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KoncertDAO {

    public KoncertDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import org.springframework.jd....Template */
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /* Import java.util.List */

    public List<Koncert> list(){
        String sql = "SELECT * FROM Koncerty";

        List<Koncert> listKoncert = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Koncert.class));

        for (Koncert koncert : listKoncert){
            Object arg = koncert.getId_orkiestry();
            String sqlOrkiestra = "SELECT * FROM Orkiestry WHERE Id_orkiestry = " + arg.toString();

            Orkiestra orkiestra = jdbcTemplate.queryForObject(sqlOrkiestra,BeanPropertyRowMapper.newInstance(Orkiestra.class));

            koncert.setOrkiestra(orkiestra);
        }

        return listKoncert;
    }


    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Koncert koncert) {
    }
    /* Read – odczytywanie danych z bazy */
    public Koncert get(int id_koncertu) {
        Object arg = id_koncertu;
        String sql = "SELECT * FROM Koncerty WHERE id_koncertu = " + arg.toString();
        Koncert koncert = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Koncert.class));

        return koncert;
    }
    /* Update – aktualizacja danych */
    public void update(Koncert koncert) {
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int id_koncertu) {
    }

}
