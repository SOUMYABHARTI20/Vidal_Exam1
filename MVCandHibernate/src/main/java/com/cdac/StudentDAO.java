package com.cdac;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveStudent(Student student) {
        sessionFactory.getCurrentSession().persist(student);
    }

//    public Student login(String email, String password) {
//        Query<Student> query = sessionFactory
//                .getCurrentSession()
//                .createQuery(
//                    "from Student where email=:email and password=:password",
//                    Student.class);
//
//        query.setParameter("email", email);
//        query.setParameter("password", password);
//
//        return query.uniqueResult();
//    }

    // ✅ NEW METHOD FOR TABLE VIEW
    public List<Student> getAllStudents() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Student", Student.class)
                .list();
    }
}
