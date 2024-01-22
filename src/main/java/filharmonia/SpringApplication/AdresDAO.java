package filharmonia.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdresDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AdresDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Adres> list(){
        String sql = "SELECT * FROM Adresy";

        List<Adres> listAdres = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adres.class));

        return listAdres;
    }

    public Adres get(int id_adres){
        Object arg = id_adres;
        String sql = "SELECT * FROM Adresy WHERE id_adres = " + arg.toString();

        Adres AdresById = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Adres.class));

        return AdresById;
    }

    public void update(Adres adres){
        String sql = "UPDATE ADRESY SET kraj=:kraj, miasto=:miasto, ulica=:ulica, numer_budynku=:numer_budynku, numer_lokalu=:numer_lokalu, id_poczty=:id_poczty WHERE id_adres=:id_adres";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }
}
