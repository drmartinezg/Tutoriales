/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.duero4.tddinactionjee.data.jdbc;


import es.duero4.tddinactionjee.data.person.Person;
import java.util.List;
import javax.sql.DataSource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.mockobjects.sql.MockMultiRowResultSet;

import java.util.ArrayList;
import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

/**
 *
 * @author Ramon
 */
public class JdbcPersonDaoTest {
    
    public JdbcPersonDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testFindByLastName() throws Exception {
        // 1 - Mock database connectin
        DataSource dataSource = createMock(DataSource.class);
        Connection connection = createMock(Connection.class);
        expect(dataSource.getConnection()).andReturn(connection);
        String sql = "SELECT * FROM people WHERE last_name = ?";
        PreparedStatement stmt = createMock(PreparedStatement.class);
        expect(connection.prepareStatement(sql)).andReturn(stmt);
        stmt.setString(1, "Smith");
        
        // 2 - Fake query result
        MockMultiRowResultSet resultset = new MockMultiRowResultSet();
        String[] columns = new String[] { "first_name", "last_name" };
        resultset.setupColumnNames(columns);
        List<Person> smiths = createListOfPeopleWithLastname("Smith");
        resultset.setupRows(asResultSetArray(smiths));
        expect(stmt.executeQuery()).andReturn(resultset);
        
        // 3 - We want resources released
        resultset.setExpectedCloseCalls(1);
        stmt.close();
        connection.close();
        
        replay(dataSource, connection, stmt);
        
        // 4 - Act and verify
        JdbcPersonDao dao = new JdbcPersonDao();
        dao.setDataSource(datasource);
        List<Person> people = dao.findByLastname("Smith");
        assertEquals(smiths, people);
        verify(dataSource, connection, stmt);
        resultset.verify();;
    }

    private List<Person> createListOfPeopleWithLastname(String lastName) {
        List <Person> expected = new ArrayList<Person>();
        expected.add(new Person("Alice", lastName));
        expected.add(new Person("Billy", lastName));
        expected.add(new Person("Clark", lastName));
        return expected;
    }

    private Object[][] asResultSetArray(List<Person> people) {
        Object[][] array = new Object[people.size()][2];
        for (int i = 0; i < array.length; i++) {
            Person person = people.get(i);
            array[i] = new Object[] { person.getFirstName(), person.getLastName() };
        }
        return array;
    }
}
