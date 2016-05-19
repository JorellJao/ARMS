package ph.com.alliance.service;

import java.util.List;

import ph.com.alliance.entity.Answer;
import ph.com.alliance.entity.Exam;
import ph.com.alliance.entity.ExamPK;
import ph.com.alliance.entity.Question;



/**
 * 
 * 
 */
public interface AnswerService {
	/**
	 * 
	 * @return 
	 * @return
	 */
	public void addAnswer(Answer newanswer);
	
	public List<Answer> showAnswers(String questionid);

	public void deleteAnswers(String[] Answers);
	
	public void updateAnswer(String answer);
	
}
