package filharmonia.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KlientDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public KlientDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Klient> list(){
        String sql = "SELECT * FROM Klienci";

        List<Klient> listKlient = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Klient.class));

        return listKlient;
    }

    public Klient get(int id_klienta){
        Object arg = id_klienta;
        String sql = "SELECT * FROM Klienci WHERE id_klienta = " + arg.toString();

        Klient KlientById = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Klient.class));

        return KlientById;
    }

    public void update(Klient klient){
        String sql = "UPDATE KLIENCI SET imie=:imie, nazwisko=:nazwisko, email=:email, numer_telefonu=:numer_telefonu WHERE id_klienta=:id_klienta";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klient);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }
}
