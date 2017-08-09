package ua.org.nalabs.javalearn.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = ("student"))
@NamedQuery(name="findStudentByLastName",
        query="select s from Student s where s.lastName = :lastName")
public class Student implements Serializable {
    @Id
    @GenericGenerator(name="auto_inc", strategy = "increment")
    @GeneratedValue(generator="auto_inc")
    @Column(name = ("ID"))
    private Long id;
    @Column(name = ("LAST_NAME"))
    private String lastName;
    @Column(name = ("FIRST_NAME"))
    private String firstName;

    @Column
    @Enumerated(value = STRING)
    private Sex sex;

    @Transient
    private int age;

    public Student() { /* more code */ }
    public Student(String lastName, String firstName, int age, Sex sex) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.sex = sex;
    }
    public Student(Long id, String lastName, String firstName, int age, Sex sex) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.sex = sex;
    }
    // getters and setters
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", age=" + age + ", sex=" + sex + "}";
    }
}
