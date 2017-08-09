package ua.org.nalabs.javalearn.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class HibernateUtil {

    /*
    Інтерфейс Session використовується для збереження в базу даних та відновлення з неї об'єктів класів Course і Student.
     Екземпляр SessionFactory - потокобезпечний, незмінюваний кеш скомпільованих відображень для одної Бази даних,
     фабрика для створення об'єктів  Session .
1. Створюється об'єкт

    SessionFactory SessionFactory factory = new Configuration().Configure(). BuildSessionFactory();

Метод configure() класу  Configuration заносить інформацію в об'єкт  Configuration з конфігураційного файлу Hibernate;

2. Створюється сесія

    Session session = factory.openSession();

3. В кінці звертання сесія закривається:

    session.close ();

Інтерфейс org.hibernate.SessionFactory містить ряд необхідних методів:
openSession() - створює зв'язок із базою даних і відкриває сесію.
В якості параметра може бути передано і з'єднання, тоді буде створено Session на основі існуючого з'єднання;
close() - знищення SessionFactory і звільнення всіх ресурсів, що використовуються об'єктом.
Інтерфейс org.hibernate.Session - однопоточний, короткоживучий об'єкт,
який є посередником між програмою і  сховищем персистентних об'єктів,
використовується для навігації по об'єктному графу або для пошуку об'єктів за ідентифікатором.
По суті, цей клас є оболонкою навколо JDBC-з'єднання.
 В той же час представляє собою фабрику для об'єктів Transacation.
     */
    private static final SessionFactory sessionFactory;

    static {
        try {
// create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();

            /*
            якщо відображувані класи не були задані в конфігураційному файлі, то задаємо їх так:

            Configuration aconf = new Configuration()
            .addAnnotatedClass(ua.org.nalabs.javalearn.entity.Course.class)
            .addAnnotatedClass(ua.org.nalabs.javalearn.entity.Student.class);
            aconf.configure();
            sessionFactory = aconf.buildSessionFactory();

             */
        } catch (Throwable e) {
// make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

