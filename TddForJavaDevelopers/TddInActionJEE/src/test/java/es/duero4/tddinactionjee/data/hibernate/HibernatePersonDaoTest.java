package es.duero4.tddinactionjee.data.hibernate;

import es.duero4.tddinactionjee.data.person.Person;
import java.util.List;
import java.util.ArrayList;
import org.hibernate.*;
import org.hibernate.classic.Session;
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
public class HibernatePersonDaoTest {
    
    private SessionFactory factory;
    private Session session;
    private Query query;
    
    public HibernatePersonDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        factory = createMock(SessionFactory.class);
        session = createMock(Session.class);
        query = createMock(Query.class);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testFindByLastname() throws Exception {
        String hql = "from Person p where p.lastname = :lastname";
        String lastname = "Smith";
        
        List<Person> theSmiths = new ArrayList<Person>();
        theSmiths.add(new Person("Alice", lastname));
        theSmiths.add(new Person("Billy", lastname));
        theSmiths.add(new Person("Clark", lastname));
        
        expect( factory.getCurrentSession() ).andReturn(session);
        expect( session.createQuery(hql) ).andReturn(query);
        expect( query.setParameter("lastname", lastname) ).andReturn(query);
        expect( query.list() ).andReturn(theSmiths);
    }
}
