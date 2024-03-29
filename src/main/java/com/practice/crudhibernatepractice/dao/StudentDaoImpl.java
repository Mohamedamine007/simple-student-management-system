package com.practice.crudhibernatepractice.dao;

import com.practice.crudhibernatepractice.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void add(Student student) {

        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {

        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findByLastName(String lastName) {

        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName=:Data", Student.class);
        query.setParameter("Data", lastName);
        return query.getResultList();
    }

    @Override
    public List<Student> findAll() {

        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        List<Student> students = theQuery.getResultList();

        return students;
    }

    @Override
    @Transactional
    public void update(Student student) {

        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {

        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }
}
