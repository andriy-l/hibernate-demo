package ua.org.nalabs.javalearn;

import org.hibernate.Session;
import ua.org.nalabs.javalearn.dao.CourseDAO;
import ua.org.nalabs.javalearn.dao.StudentDAO;
import ua.org.nalabs.javalearn.entity.Course;
import ua.org.nalabs.javalearn.entity.Sex;
import ua.org.nalabs.javalearn.entity.Student;
import ua.org.nalabs.javalearn.util.HibernateUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            StudentDAO studentDAO = new StudentDAO(session);
            CourseDAO courseDAO = new CourseDAO(session);
            String courseTitle1 = "Java";
            Course course1 = new Course();
            course1.setTitle(courseTitle1);
            HashSet<Student> set1 = new HashSet<Student>() {
                {
                    this.add(new Student("Андрій", "Луцків", 18, Sex.MALE));
                    this.add(new Student("Josh", "Bloch", 50, Sex.MALE));
                    this.add(new Student("Foggy", "Hedgehog", 10, Sex.MALE));
                    this.add(new Student("Natalie", "Coughlin", 35, Sex.FEMALE));
                }
            };
            course1.setStudents(set1);
            courseDAO.addCourse(course1);
            String courseTitle2 = "Design Patterns for Java";
            Course course2 = new Course();
            course2.setTitle(courseTitle2);
            courseDAO.addCourse(course2);
            Set<Student> setRes = courseDAO.findRegistedOnCourse(courseTitle1);
            Student student1 = new Student("Voznyak", "Stive", 25, Sex.MALE);
            studentDAO.addStudent(student1);
            System.out.println(setRes);
            Student student2 = studentDAO.getStudent("Josh");
            System.out.println("Persisten student: \n" + student2 + " \n");
            HashSet<Student> set2 = new HashSet<>();
            set2.add(student1);

            course2.setStudents(set2);
            courseDAO.addCourse(course2);
        }

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            StudentDAO studentDAO = new StudentDAO(session);
            Student student = studentDAO.getStudent("Josh");
            System.out.println("\n new session " + student + "\n");
        }
    }
}
