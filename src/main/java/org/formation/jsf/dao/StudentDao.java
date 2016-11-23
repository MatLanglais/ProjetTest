package org.formation.jsf.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.formation.jsf.model.Student;

public class StudentDao implements IStudentDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");

	@Override
	public List<Student> getStudents() throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tn = em.getTransaction();
		List<Student> listStudents = new ArrayList<>();

		try {

			tn.begin();
			Query query = em.createQuery("from Student", Student.class);
			listStudents = query.getResultList();

			return listStudents;

		} catch (Exception e) {
			if (tn != null) {
				tn.rollback();
			}
		} finally {
			em.close();
		}
		return null;
	}

	@Override
	public void addStudent(Student theStudent) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tn = em.getTransaction();
		List<Student> listStudents = new ArrayList<>();

		try {

			tn.begin();
			em.persist(theStudent);
			tn.commit();

		} catch (Exception e) {
			if (tn != null) {
				tn.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}

	}

	@Override
	public Student getStudent(int studentId) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tn = em.getTransaction();
		Student s = null;

		try {

			tn.begin();
			s = em.find(Student.class, studentId);

		} catch (Exception e) {
			if (tn != null) {
				tn.rollback();
			}
		} finally {
			em.close();
		}
		return s;
	}

	@Override
	public void updateStudent(Student theStudent) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tn = em.getTransaction();
		try {

			tn.begin();
			em.merge(theStudent);
			tn.commit();

		} catch (Exception e) {
			if (tn != null) {
				tn.rollback();
			}
		} finally {
			em.close();
		}

	}

	@Override
	public void deleteStudent(int studentId) throws Exception {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tn = em.getTransaction();
		try {
			tn.begin();			
			em.remove(em.find(Student.class, studentId));
			tn.commit();

		} catch (Exception e) {
			if (tn != null) {
				tn.rollback();
			}
		} finally {
			em.close();
		}

	}

}
