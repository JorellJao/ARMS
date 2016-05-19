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
import ph.com.alliance.dao.QuestionsDao;
import ph.com.alliance.dao.UserDao;
import ph.com.alliance.entity.Exam;
import ph.com.alliance.entity.ExamPK;
import ph.com.alliance.entity.Question;
import ph.com.alliance.entity.User;

/**
 * Sample data access object implementation using Java Persistence API.
 * 
 *
 */
@Repository("questions")
public class QuestionDaoImpl implements QuestionsDao {

	@Override
	public List<Question> viewQuestions(String examid,EntityManager pEM) {
		
		Query query = pEM.createQuery("FROM Question questions WHERE questions.id.examId = "+examid);
		
		List<Question> questyeens = query.getResultList();
		
		
		return questyeens;
	}

	@Override
	public void addQuestion(Question newquestion, EntityManager pEM) {
		
		
		pEM.persist(newquestion);
		System.out.println("ni persist siya og question part");
		
		return;
	}

	@Override
	public void deleteQuestion(String[] questionid, EntityManager pEM) {

		Query query = pEM.createQuery("DELETE From Question questions WHERE questions.id.id IN (:qList)");
	
		List<String> questionlist = Arrays.asList(questionid);
		
		query.setParameter("qList",questionlist);
		
		query.executeUpdate();
		
	}

	@Override
	public Question updateQuestion(Question question, EntityManager pEM) {
		Question q = null;
		
		try {
			q = pEM.merge(question);
		} catch (IllegalArgumentException iae) {
			iae.getMessage();
		} catch (TransactionRequiredException trxe) {
			trxe.getMessage();
		}
		
		return q;
		
	}
	

}
