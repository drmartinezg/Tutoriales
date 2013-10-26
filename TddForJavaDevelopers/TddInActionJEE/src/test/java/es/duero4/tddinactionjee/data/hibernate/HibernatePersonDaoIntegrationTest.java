package es.duero4.tddinactionjee.data.hibernate;

import org.junit.Ignore;
import java.util.List;
import org.hibernate.Transaction;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.SessionFactory;
import es.duero4.tddinactionjee.data.person.Person;
import java.util.ArrayList;
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
    
    private SessionFactory sf;
    private Transaction tx;
    private HibernatePersonDao dao;
    
    public HibernatePersonDaoIntegrationTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() throws Exception {
        sf = getSessionFactory();
        dao = new HibernatePersonDao();
        dao.setSessionFactory(sf);    
        // 1 - Begin transaction in setup
        tx = sf.getCurrentSession().beginTransaction();
        tx.begin();
    }
    
    @After
    public void tearDown() {
        // 2 - Rollback in teardown
        if (tx != null) {
            tx.rollback();
        }
    }
    
    @Ignore
    @Test
    public void persistedObjectExistsInDatabase() throws Exception {

        Person person = new Person("John", "Doe");
        dao.save(person);
        // Persisted object receives ID
        assertNotNull(person.getId());
        
        // John Doe now in database
        Session s = sf.openSession();
        Object copy = s.get(Person.class, person.getId());
        assertEquals(person, copy);
    }

    @Ignore
    @Test
    public void testFindingAllSmiths() throws Exception {
        // 1 - Create objects
        List<Person> theSmiths = new ArrayList<Person>();
        theSmiths.add(new Person("Alice", "Smith"));
        theSmiths.add(new Person("Billy", "Smith"));
        
        List<Person> allPeople = new ArrayList<Person>();
        allPeople.addAll(theSmiths);
        allPeople.add(new Person("John", "Doe"));
        
        // 2 - Persist objects with Hibernate API
        persist(allPeople);
        assertEquals(theSmiths, dao.findByLastname("Smith"));
    }

    private void persist(List<? extends Object> objects) {
        Session s = sf.getCurrentSession();
        for (Object object : objects) {
            s.save(object);
        }
        s.flush();
    }
    
    private SessionFactory getSessionFactory() throws Exception {
        return createConfiguration().buildSessionFactory();
    }

    private Configuration createConfiguration() throws Exception {
        // Load production config from classpath.
        Configuration cfg = loadProductionConfiguration();
        // Load test config from file
        loadTestConfigInto(cfg, "/hibernate.test.properties");
        return cfg;
    }

    private Configuration loadProductionConfiguration() {
        // Load production config from classpath.
        return new Configuration().configure();
    }

    private void loadTestConfigInto(Configuration cfg, String path) throws Exception {
        // Load test config from file
        Properties properties = loadPropertiesFrom(path);
        Enumeration keys = properties.keys();
        while (keys.hasMoreElements()) {            
            String key = (String) keys.nextElement();
            String value = properties.getProperty(key);
            // Override individual properties
            cfg.setProperty(key, value);
        }
    }

    private Properties loadPropertiesFrom(String path) throws Exception {
        InputStream stream = getClass().getResourceAsStream(path);
        assertNotNull("Resource not found: " + path, stream);
        Properties props = new Properties();
        props.load(stream);
        stream.close();
        return props;
    }

}
