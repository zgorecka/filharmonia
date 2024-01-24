package filharmonia.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class PracownikDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PracownikDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pracownik> lsit(){
        String sql = "SELECT * FROM Pracownicy";

        List<Pracownik> listPracownik = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownik.class));

        return listPracownik;
    }

    public void delete(int id_pracownika){
        String sql = "DELETE FROM PRACOWNICY WHERE id_pracownika = ?";
        jdbcTemplate.update(sql, id_pracownika);
    }

    public void update(Pracownik pracownik){
        System.out.println("update pracownikdao");
        System.out.println(pracownik);
        String sql = "UPDATE PRACOWNICY SET imie=:imie, drugie_imie=:drugie_imie, nazwisko=:nazwisko, data_urodzenia=:data_urodzenia, plec=:plec, pesel=:pesel, data_zatrudnienia=:data_zatrudnienia, data_zwolnienia=:data_zwolnienia WHERE id_pracownika=:id_pracownika";


        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    @Transactional
    public void savePracownikAdres(Pracownik pracownik){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SimpleJdbcInsert insertAction = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("adresy")
                .usingGeneratedKeyColumns("id_adres")
                .usingColumns( "kraj", "miasto", "ulica", "numer_budynku", "numer_lokalu", "id_poczty");

        SimpleJdbcInsert insertAction2 = new SimpleJdbcInsert(jdbcTemplate);

        Adres adres = new Adres();
        adres.setId_adres(pracownik.getId_adres());
        adres.setKraj(pracownik.getKraj());
        adres.setMiasto(pracownik.getMiasto());
        adres.setUlica(pracownik.getUlica());
        adres.setNumer_budynku(pracownik.getNumer_budynku());
        adres.setNumer_lokalu(pracownik.getNumer_lokalu());
        adres.setId_poczty(4);

        BeanPropertySqlParameterSource param2 = new BeanPropertySqlParameterSource(adres);
        Number idAdres = insertAction.executeAndReturnKeyHolder(param2).getKey();

        pracownik.setId_adres(idAdres.intValue());

        pracownik.setId_filharmonii(4);
        System.out.println("pracownik dao save");
        System.out.println(pracownik);
        insertAction2.withTableName("pracownicy").usingColumns("imie", "drugie_imie", "nazwisko", "data_urodzenia", "plec", "pesel", "data_zatrudnienia", "id_filharmonii", "id_adres", "data_zwolnienia");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);
        insertAction2.execute(param);
    }

}
