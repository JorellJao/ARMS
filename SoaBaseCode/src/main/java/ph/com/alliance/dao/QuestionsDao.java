package ph.com.alliance.dao;

import java.util.List;

import javax.persistence.EntityManager;

import ph.com.alliance.entity.Exam;
import ph.com.alliance.entity.ExamPK;
import ph.com.alliance.entity.Question;
import ph.com.alliance.entity.User;

/**
 * 
 * 
 */
public interface QuestionsDao {
	
	public List<Question> viewQuestions(String examid,EntityManager pEM);
		
	public void addQuestion(Question newquestion,EntityManager pEM);
	
	public void deleteQuestion(String[] questions,EntityManager pEM);
	
	public Question updateQuestion(Question question,EntityManager pEM);
	
}
