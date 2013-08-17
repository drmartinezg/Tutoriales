package es.duero4.tddinactionjee.data.spring.jdbc;

import java.util.ArrayList;
import org.springframework.jdbc.core.JdbcTemplate;
import es.duero4.tddinactionjee.data.person.Person;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

/**
 *
 * @author Ramon
 */
public class JdbcTemplatePersonDaoTest {
    
    public JdbcTemplatePersonDaoTest() {
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
        final String lastName = "Smith";
        final List<Person> smiths = createListOfPeopleNamed(lastName);
        
        JdbcTemplate template = createMock(JdbcTemplate.class);
        // 1 - Return hard-coded list of people from query()
        template.query(eq("SELECT * FROM employee WHERE last_name = ?"), 
                       aryEq(new Object[] { lastName }), 
                       isA(PersonRowMapper.class));
        expectLastCall().andReturn(smiths);
        
        replay(template);
        
        // 2 - Populate DAO with mock JdbcTemplate
        JdbcTemplatePersonDao dao = new JdbcTemplatePersonDao();
        dao.setJdbcTemplate(template);
        // 3 - DAO should return list as is
        assertEquals(smiths, dao.findByLastname(lastName));
        verify(template);
    }

    private List<Person> createListOfPeopleNamed(String lastName) {
        List<Person> expectedList = new ArrayList<Person>();
        expectedList.add(new Person("Alice", lastName));
        expectedList.add(new Person("Billy", lastName));
        expectedList.add(new Person("Clark", lastName));
        return expectedList;
    }
}
