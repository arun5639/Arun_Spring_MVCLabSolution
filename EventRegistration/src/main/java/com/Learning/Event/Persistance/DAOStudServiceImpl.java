package com.Learning.Event.Persistance;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Learning.Event.DAO.DAOStudService;
import com.Learning.Event.Entity.Student;
import java.util.List;

@Repository
public class DAOStudServiceImpl implements DAOStudService {
	
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;	
	
	public DAOStudServiceImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
		
		try {
			session = this.sessionFactory.getCurrentSession();
		}catch(HibernateException ex) {
			session = this.sessionFactory.openSession();	
		}
	}

	@Override
	public boolean addStudent(Student stud) {		
		Query<Student> query = session.createQuery("from Student where studName=:sName and studDept=:sDept and studCountry=:sCountry", Student.class);
		query.setParameter("sName", stud.getStudName());
		query.setParameter("sDept", stud.getStudDept());
		query.setParameter("sCountry", stud.getStudCountry());
		
		List<Student> results = query.getResultList();
		
		if(!results.isEmpty()) {		
			return false;
		}
		else {			
			Transaction tx = session.beginTransaction();
			session.save(stud);
			tx.commit();
			return true;
		}				
	}

	@Override
	public void updateStudent(Student stud) {		
		Transaction tx = session.beginTransaction();
		session.merge(stud);
		tx.commit();		
	}

	@Override
	public void deleteStudent(int studId) {
		Transaction tx = session.beginTransaction();
		Student stud = session.get(Student.class, studId);
		session.delete(stud);
		tx.commit();		
	}

	@Override
	public Student getStudent(int studId) {		
		Transaction tx = session.beginTransaction();
		Student theStud = session.get(Student.class,studId);
		tx.commit();
		return theStud;
	}

	@Override
	public List<Student> getAllStudent() {
		Query<Student> query = session.createQuery("from Student",Student.class);
		List<Student> allStudent = query.getResultList();
		return allStudent;
	}
}
