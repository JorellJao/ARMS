package ph.com.alliance.service;

import java.util.List;

import ph.com.alliance.entity.Exam;
import ph.com.alliance.entity.ExamPK;



/**
 * 
 * 
 */
public interface ExamService {
	/**
	 * 
	 * @return 
	 * @return
	 */
	public void addExam(Exam newexam);
	
	
	public List<Exam> viewExams();
	
	
	public void deleteExam(String[] Exams);
	
	public void renameExam(Exam exam);
	
	public Exam getExamById(String id);
	
}
