package es.duero4.tddinactionjee.data.spring.jdbc;

import es.duero4.tddinactionjee.data.person.Person;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Ramon
 */
public class PersonRowMapper implements RowMapper {

    public PersonRowMapper() {
    }

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Person(rs.getString("first_name"), rs.getString("last_name"));
    }
    
}
