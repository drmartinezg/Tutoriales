package es.duero4.tddinactionjee.data.hibernate;

import es.duero4.tddinactionjee.data.person.Person;
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
public class HibernatePersonDaoIntegrationTest {
    
    public HibernatePersonDaoIntegrationTest() {
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
    public void persistedObjectExistsInDatabase() throws Exception {
        // 1 - Create SessionFactory that knows about Person class
        SessionFactory sf = getSessionFactory();
        HibernatePersonDao dao = new HibernatePersonDao();
        dao.setSessionFactory(sf);
        
        Person person = new Person("John", "Doe");
        dao.save(person);
        // 2 - Persisted object receives ID
        assertNotNull(person.getId());
        
        // 3 - John Doe now in database
        Session s = sf.openSession();
        Object copy = s.get(Person.class, person.getId());
        assertEquals(person, copy);
    }
}
