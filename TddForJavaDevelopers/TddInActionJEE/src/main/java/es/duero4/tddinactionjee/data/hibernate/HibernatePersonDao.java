package es.duero4.tddinactionjee.data.hibernate;

import es.duero4.tddinactionjee.data.PersonDao;
import es.duero4.tddinactionjee.data.person.Person;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

/**
 *
 * @author Ramon
 */
class HibernatePersonDao implements PersonDao {
    
    private SessionFactory sessionFactory;
    
    // 1 - Store injected SessionFactory
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Person> findByLastname(String lastname) {
        try {
            // 2 - Get Session
            Session session = sessionFactory.getCurrentSession();
            String hql = "from Person p where p.lastname = :lastname";
            // 3 - Create Query
            Query query = session.createQuery(hql);
            // 4 - Populate Query
            query.setParameter("lastname", lastname);
            return query.list();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public List<Person> findAll() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Person p";
        Query query = session.createQuery(hql);
        List people = query.list();
        return people;
    }

    @Override
    public Person find(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (Person) session.get(Person.class, id);
    }

    @Override
    public void save(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.save(person);
        session.flush();
    }

    @Override
    public void update(Person person) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Person person) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
