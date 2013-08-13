package es.duero4.tddinactionjee.data;

import es.duero4.tddinactionjee.data.person.Person;
import java.util.List;
/**
 *
 * @author Ramon
 */
public interface PersonDao {
    Person find(Integer id);
    void save(Person person);
    void update(Person person);
    void delete(Person person);
    List<Person> findAll();
    List<Person> findByLastname(String lastname);
}
