package ph.com.alliance.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;

import ph.com.alliance.dao.ExamsDao;
import ph.com.alliance.dao.QuestionsDao;
import ph.com.alliance.dao.ExamsDao;
import ph.com.alliance.entity.Exam;
import ph.com.alliance.entity.ExamPK;
import ph.com.alliance.entity.Question;
import ph.com.alliance.entity.User;
import ph.com.alliance.service.ExamService;
import ph.com.alliance.service.QuestionService;

/**
 * Example service implementation that hadles database transaction. Database
 * transaction starts in this layer of the application, and it also ends here.
 *
 */
@Service("QuestionService")
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private JpaTransactionManager transactionManager;

	@Autowired
	private QuestionsDao QuestionsDao;

	@Override
	public void addQuestion(Question newquestion) {
		EntityManager pEM = transactionManager.getEntityManagerFactory().createEntityManager();
		EntityTransaction trans = pEM.getTransaction();
		
		try {
			trans.begin();

			QuestionsDao.addQuestion(newquestion, pEM);

			System.out.println("question added!");
			
			trans.commit();

		} catch (Exception e) {
			
			System.out.println("Exception while adding new question!");
			
			System.out.println(e);

			trans.rollback();
		}
		
	}

	@Override
	public List<Question> viewQuestions(String examid) {
		
		EntityManager pEM = transactionManager.getEntityManagerFactory().createEntityManager();
		
		List<Question> qlist = QuestionsDao.viewQuestions(examid, pEM);
		
		System.out.println("(QuestionService)qlist size : "+qlist.size());
		
		if (qlist != null && pEM.isOpen()) {

			pEM.close();
		}
		
		//business logic
		
		return qlist;
	}

	@Override
	public void deleteQuestion(String[] Questions) {
		
		EntityManager pEM = transactionManager.getEntityManagerFactory().createEntityManager();

		EntityTransaction trans = pEM.getTransaction();

		try {
			trans.begin();

			QuestionsDao.deleteQuestion(Questions, pEM);

			System.out.println("questions deleted!");
			
			trans.commit();

		} catch (Exception e) {
			
			System.out.println("Exception while deleting Questions!\n"+e);

			trans.rollback();
		}
		
	}

	@Override
	public void updateQuestion(String question) {
		// TODO Auto-generated method stub
		
	}




}
