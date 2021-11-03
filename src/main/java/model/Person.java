package model;
import enums.Role;
import java.util.Objects;


public class Person {
    private final String name;
    private final Role role;
    private int priority;

    public Person(String name, Role role, int priority) {
        //Implementing Validation
        this.name = name;
        this.role = role != null ? role : Role.TEACHER;

        setPriority();
    }

    private void setPriority() {
        if(role == Role.TEACHER) {
            this.priority = Role.TEACHER.getPriority();
        } else if(role == Role.SENIOR_STUDENT) {
            this.priority = Role.SENIOR_STUDENT.getPriority();
        } else {
            this.priority = Role.JUNIOR_STUDENT.getPriority();
        }
    }

    public int getPriority() {
        return priority;
    }
    /*public Person(String damilola, Role others) {
    }*/

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return priority == person.priority && getName().equals(person.getName()) &&
                getRole().equals(person.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getRole(), priority);
    }

    @Override
    public String toString() {
        return "Person{" + "name = " + name + '\'' + ", role = " + role + '}';
    }
}
