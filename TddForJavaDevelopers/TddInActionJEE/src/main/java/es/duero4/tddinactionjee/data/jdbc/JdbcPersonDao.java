package es.duero4.tddinactionjee.data.jdbc;

import es.duero4.tddinactionjee.data.PersonDao;
import es.duero4.tddinactionjee.data.person.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author Ramon
 */
class JdbcPersonDao implements PersonDao {
    private DataSource datasource;

    public JdbcPersonDao() {
    }

    void setDataSource(DataSource datasource) {
        this.datasource = datasource;
    }

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
        try {
            Connection conn = datasource.getConnection();
            String sql = "SELECT * FROM people WHERE last_name = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, lastname);
            ResultSet rset = stmt.executeQuery();
            List<Person> people = new ArrayList<Person>();
            while (rset.next()) {                
                String firstName = rset.getString("first_name");
                String lastName = rset.getString("last_name");
                people.add(new Person(firstName, lastName));
            }
            rset.close();
            stmt.close();
            conn.close();
            return people;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
