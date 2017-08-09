package ua.org.nalabs.javalearn.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

/**
 * POJO (Plain Ordinary Java Object) даному класу відповідає таблиця, або набір стовпців в таблиці БД.
 * Цей клас містить інформацію про навчальний курс і список студентів записаних на курс.
 */
@Entity
@Table(name = ("course"))
public class Course implements Serializable {
    // первинний ключ в базі даних
    // дана властивість може називатись будь-яким ім'ям і мати будь-який примітивний тип даних, тип wrapper'a
    // або java.lang.String i java.util.Date
    // Властивість ідентифікатор не є обов'язковим для класу, можна не створювати його
    // і дозволить Hibernate автоматично слідкувати за ідентифікацією об'єкта
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TITLE")
    private String title;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "course_student", joinColumns = {@JoinColumn(name = "COURSE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "STUDENT_ID")})
    private Set<Student> students;
    public Course() {
    }
    public Course(String title) {
        this.title = title;
    }

    public Course(Long id, String title) {
        this.id = id;
        this.title = title;
    }
    public Long getId() {
        return id;
    }
    protected void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Set<Student> getStudents() {
        return students;
    }
    public void setStudents(Set<Student> students) {
        this.students = students;
    }
    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", title=" + title + ", students=" + students + '}';
    }
}

