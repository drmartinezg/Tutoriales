package es.duero4.tddinactionjee.data.spring.jdbc;

import es.duero4.tddinactionjee.data.PersonDao;
import es.duero4.tddinactionjee.data.person.Person;
import java.util.List;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 *
 * @author Ramon
 */
class JdbcTemplatePersonDao extends JdbcDaoSupport implements PersonDao {

    @Override
    public Person find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void save(Person person) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Person person) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Person person) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Person> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Person> findByLastname(String lastname) {
        String sql ="SELECT * FROM employee WHERE last_name = ?";
        String[] args = new String[]{ lastname };
        // Use PersonRowMapper to convert rows to object
        PersonRowMapper mapper = new PersonRowMapper();
        // Delegate hard work to JdbcTemplate
        return getJdbcTemplate().query(sql, args, mapper);
    }
    
}
