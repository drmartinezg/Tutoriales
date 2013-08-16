/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.duero4.tddinactionjee.data.spring.jdbc;

import org.springframework.jdbc.core.RowMapper;
import com.mockobjects.sql.MockSingleRowResultSet;
import java.util.Map;
import es.duero4.tddinactionjee.data.person.Person;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ramon
 */
public class PersonRowMapperTest {
    
    public PersonRowMapperTest() {
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
    public void testMappingRow() throws Exception {
        Person expected = new Person("John", "Doe");
        
        // 1 - Populate mock ResultSet object
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("first_name", expected.getFirstName());
        data.put("last_name", expected.getLastName());
        MockSingleRowResultSet rs = new MockSingleRowResultSet();
        rs.addExpectedNamedValues(data);
        
        // 2 - Perform mapping and compare result
        assertEquals(expected, new PersonRowMapper().mapRow(rs, 1));
    }
}
