package ph.com.alliance.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;

import ph.com.alliance.dao.ExamsDao;
import ph.com.alliance.dao.ExamsDao;
import ph.com.alliance.entity.Exam;
import ph.com.alliance.entity.ExamPK;
import ph.com.alliance.entity.User;
import ph.com.alliance.service.ExamService;

/**
 * Example service implementation that hadles database transaction. Database
 * transaction starts in this layer of the application, and it also ends here.
 *
 */
@Service("ExamService")
public class ExamServiceImpl implements ExamService {

	@Autowired
	private JpaTransactionManager transactionManager;

	@Autowired
	private ExamsDao exams;

	@Override
	public List<Exam> viewExams() {

		EntityManager pEM = transactionManager.getEntityManagerFactory().createEntityManager();

		List<Exam> examlist = exams.viewExams(pEM);

		if (examlist != null && pEM.isOpen()) {

			pEM.close();
		}
		// business logic

		return examlist;
	}

	@Override
	public void addExam(Exam newexam) {

		EntityManager pEM = transactionManager.getEntityManagerFactory().createEntityManager();

		EntityTransaction trans = pEM.getTransaction();

		try {
			trans.begin();

			exams.addExam(newexam, pEM);

			System.out.println("exam added!");
			
			trans.commit();

		} catch (Exception e) {
			
			System.out.println("Exception while adding new exam!");

			trans.rollback();
		}

	}

	@Override
	public void deleteExam(String[] Exams) {
		
		EntityManager pEM = transactionManager.getEntityManagerFactory().createEntityManager();

		EntityTransaction trans = pEM.getTransaction();

		try {
			trans.begin();

			exams.deleteExam(Exams, pEM);

			System.out.println("exams deleted!");
			
			trans.commit();

		} catch (Exception e) {
			
			System.out.println("Exception while deleting exams!\n"+e);

			trans.rollback();
		}
		
		
	}

	@Override
	public void renameExam(Exam exam) {
		
		EntityManager pEM = transactionManager.getEntityManagerFactory().createEntityManager();
		
		EntityTransaction trans = pEM.getTransaction();
		try{
		trans.begin();
		
		exams.renameExam(exam, pEM);
		
		System.out.println("exam renamed!");
		
		trans.commit();
		}catch (Exception e) {
			
			System.out.println("Exception while renaming exams!\n"+e);

			trans.rollback();
		}
	}

	@Override
	public Exam getExamById(String id) {
		
		EntityManager pEM = transactionManager.getEntityManagerFactory().createEntityManager();
		
		return exams.getExamById(id, pEM);
	}

}
