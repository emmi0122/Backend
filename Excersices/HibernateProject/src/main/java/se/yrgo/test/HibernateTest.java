package se.yrgo.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import se.yrgo.domain.Student;
import se.yrgo.domain.Tutor;

public class HibernateTest {

    private static SessionFactory sessionFactory = null;

    public static void main(String[] args) {
        // Student newStudent = new Student("Nick Fame", "Diamond Cameron");
        // System.out.println(newStudent);

        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        Tutor newTutor = new Tutor("ABC234", "Natalie Woodward", 387787);
        Student student1 = new Student("Patrik Howard");
        Student student2 = new Student("Marie Sani");
        Student student3 = new Student("Tom Nikson");

        newTutor.addStudentToTeachingGroup(student1);
        newTutor.addStudentToTeachingGroup(student2);
        newTutor.addStudentToTeachingGroup(student3);

        Set<Student> students = newTutor.getTeachingGroup();

        for (Student student : students) {
            System.out.println(student);
        }

        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(newTutor);

        /*
         * Student studentFromDatabase = session.get(Student.class, 1);
         * System.out.println(studentFromDatabase);
         * 
         * System.out.println(studentFromDatabase.getTutorName());
         * 
         * Tutor tutorForStudentFromDatabase = studentFromDatabase.getTutor();
         * System.out.println(tutorForStudentFromDatabase.getName());
         * 
         * Tutor tutorFromDatabase = session.get(Tutor.class, 1);
         */

        /*
         * Student newStudent = new Student("Susan Lindberg");
         * newStudent.allocateTutor(tutorFromDatabase);
         * session.save(newStudent);
         * 
         * Student student2 = session.get(Student.class, 2);
         * student2.allocateTutor(null);
         */

        /*
         * Tutor tutor = new Tutor("ABC123", "Edward", 30000);
         * Student student = new Student("Sara Hedborn");
         * 
         * student.allocateTutor(tutor);
         * System.out.println(student.getTutorName());
         * 
         * session.save(student);
         * session.save(tutor);
         */

        // session.save(newStudent);
        // Student myStudent = (Student)session.get(Student.class, 1);
        // System.out.println(myStudent + " is the student");

        // Student anotherStudent = new Student("Bob Jones" , "John Westland");
        // session.save(anotherStudent);

        // Student anotherStudent_toUpdate = (Student) session.get(Student.class, 1);
        // anotherStudent_toUpdate.setTutorName("David Graveyard");
        // System.out.println(anotherStudent_toUpdate);

        /*
         * Student newStudent = new Student("Ada Svensson");
         * session.save(newStudent);
         */

        tx.commit();
        session.close();
    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}