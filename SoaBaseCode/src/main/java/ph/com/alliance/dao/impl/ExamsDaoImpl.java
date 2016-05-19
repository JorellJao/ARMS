package ph.com.alliance.dao.impl;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import ph.com.alliance.dao.ExamsDao;
import ph.com.alliance.dao.UserDao;
import ph.com.alliance.entity.Exam;
import ph.com.alliance.entity.ExamPK;
import ph.com.alliance.entity.User;

/**
 * Sample data access object implementation using Java Persistence API.
 * 
 *
 */
@Repository("exams")
public class ExamsDaoImpl implements ExamsDao {

	@Override
	public List<Exam> viewExams(EntityManager pEM) {
		
		Query query = pEM.createQuery("FROM Exam");
		
		List<Exam> examlist = query.getResultList();
		
		return examlist;
	}

	@Override
	public void addExam(Exam newExam, EntityManager pEM) {
		
		pEM.persist(newExam);
		System.out.println("ni persist sya og exam part");

		
	}

	@Override
	public void deleteExam(String[] Exams, EntityManager pEM) {
		
		Query query = pEM.createQuery("DELETE From Exam exam WHERE exam.id.id IN (:idList)");
	
		List<String> examlist = Arrays.asList(Exams);
		
		query.setParameter("idList",examlist);
		
		query.executeUpdate();
	}

	@Override
	public void renameExam(Exam exam,EntityManager pEM) {
		
		pEM.merge(exam);
		
		
	}

	@Override
	public Exam getExamById(String id,EntityManager pEM) {
		
		Query query = pEM.createQuery("FROM Exam exam WHERE exam.id.id = :id");
		
		query.setParameter("id",id);
		
		Exam renamed = (Exam)query.getSingleResult();
		
		return renamed;
	}

	

}
