package ph.com.alliance.dao;

import java.util.List;

import javax.persistence.EntityManager;

import ph.com.alliance.entity.Exam;
import ph.com.alliance.entity.ExamPK;
import ph.com.alliance.entity.User;

/**
 * 
 * 
 */
public interface ExamsDao {
	
	public List<Exam> viewExams(EntityManager pEM);
		
	public void addExam(Exam newExam,EntityManager pEM);
	
	public void deleteExam(String[] Exams,EntityManager pEM);
	
	public void renameExam(Exam exam, EntityManager pEM);
	
	public Exam getExamById(String id,EntityManager pEM);
}
