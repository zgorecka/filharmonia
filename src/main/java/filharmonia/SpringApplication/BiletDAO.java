package filharmonia.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BiletDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public BiletDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Bilet> list(int id_klienta){
        Object arg = id_klienta;
        String sql = "SELECT * FROM Bilety WHERE id_klienta = " + arg.toString();

        List<Bilet> listBilet = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Bilet.class));

        for (Bilet bilet : listBilet){
            Object arg2 = bilet.getId_koncertu();
            String sql2 = "SELECT * FROM KONCERTY WHERE id_koncertu = " + arg2.toString();

            Koncert koncert = jdbcTemplate.queryForObject(sql2,BeanPropertyRowMapper.newInstance(Koncert.class));

            bilet.setKoncert(koncert);
        }

        return listBilet;
    }

    public void delete(int id_biletu){
        String sql = "DELETE FROM BILETY WHERE id_biletu = ?";
        jdbcTemplate.update(sql, id_biletu);
    }

    public void save(Bilet bilet){
        SimpleJdbcInsert insertAction = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("bilety")
                .usingColumns("data_zakupu", "cena", "id_koncertu", "id_klienta");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(bilet);
        insertAction.execute(param);
    }
}
