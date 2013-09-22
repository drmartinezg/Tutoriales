package es.duero4.tddinactionjee.data.hibernate;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.SessionFactory;
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

    private SessionFactory getSessionFactory() throws Exception {
        return createConfiguration().buildSessionFactory();
    }

    private Configuration createConfiguration() throws Excepton {
        // 1 - Load production config from classpath.
        Configuration cfg = loadProductionConfiguration();
        // 2 - Load test config from file
        loadTestConfigInto(cfg, "/hibernate.test.properties");
        return cfg;
    }

    private Configuration loadProductionConfiguration() {
        // 1 - Load production config from classpath.
        return new Configuration().configure();
    }

    private void loadTestConfigInto(Configuration cfg, String path) throws Exception {
        // 2 - Load test config from file
        Properties properties = loadPropertiesFrom(path);
        Enumeration keys = properties.keys();
        while (keys.hasMoreElements()) {            
            String key = (String) keys.nextElement();
            String value = properties.getProperty(key);
            // 3 - Override individual properties
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
