package ph.com.alliance.service;

import java.util.List;

import ph.com.alliance.entity.Exam;
import ph.com.alliance.entity.ExamPK;
import ph.com.alliance.entity.Question;



/**
 * 
 * 
 */
public interface QuestionService {
	/**
	 * 
	 * @return 
	 * @return
	 */
	public void addQuestion(Question newquestion);
	
	
	public List<Question> viewQuestions(String examid);

	public void deleteQuestion(String[] Questions);
	
	public void updateQuestion(String question);
	
}
