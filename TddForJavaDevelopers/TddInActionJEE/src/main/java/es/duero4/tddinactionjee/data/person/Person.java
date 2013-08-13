package es.duero4.tddinactionjee.data.person;

/**
 *
 * @author Ramon
 */
public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    private String ssn;
    private Person inLoveWith;
    private Person engagedWith;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        return firstName.equals(other.firstName) && lastName.equals(other.lastName);
    }

    @Override
    public String toString() {
        return "{" + firstName + " " + lastName + "}";
    }

    public void proposeTo(Person beloved) {
        if (beloved.acceptProposalFrom(this)) {
            this.engagedWith = beloved;
            beloved.engagedWith = this;
        }
    }

    private boolean acceptProposalFrom(Person person) {
        return person.equals(inLoveWith);
    }
    
    public void isInLoveWith(Person beloved) {
        inLoveWith = beloved;
    }
    
    public boolean isEngagedWith(Person person) {
        return person.equals(engagedWith);
    }
}
