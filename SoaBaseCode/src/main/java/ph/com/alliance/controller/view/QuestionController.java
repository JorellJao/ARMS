package ph.com.alliance.controller.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ph.com.alliance.entity.Exam;
import ph.com.alliance.entity.ExamPK;
import ph.com.alliance.entity.Question;
import ph.com.alliance.entity.User;
import ph.com.alliance.service.ExamService;

/**
 * Example controller class that hadles static view requests. All requests that
 * returns pages (html, xhtml, jsp, jspx, etc.) is handled here.
 *
 */
@Controller
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	ph.com.alliance.service.QuestionService QuestionService;

	/**
	 * 
	 * @param request
	 * @param response
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/showquestions", method = RequestMethod.GET)
	public String showQuestion(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
		System.out.println("@/question/showquestions MODULE VIEW CONTROLLER CALLED.");

		String id = request.getParameter("Eid");
		
		System.out.println("examid "+id);
		
		List<Question> kwestyens = QuestionService.viewQuestions(id);

//		System.out.println(kwestyens.size());
		
//		System.out.println(kwestyens.get(0).getQuestionLabel());
		
		map.addAttribute("questionlist",kwestyens);

		return "questions/Examquestions";
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/addquestions", method = RequestMethod.GET)
	public String addQuestion(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
		System.out.println("@/exam/showexams MODULE VIEW CONTROLLER CALLED.");

		String name = request.getParameter("examName");

		if (name == null || name.length() <= 0) {

			System.out.println("eroooowr in getting examName");

			return null;
		} else {
			System.out.println("trying to add exam . . ");

			ExamPK newexampk = new ExamPK();

			Exam newexam = new Exam();

			newexampk.setName(name);

			newexam.setId(newexampk);

//			ExamService.addExam(newexam);

			try {
				response.sendRedirect("../exam/showexams");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}

		return null;
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/deletequestions", method = RequestMethod.GET)
	public String deleteQuestion(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
		System.out.println("@/exam/deleteexam MODULE VIEW CONTROLLER CALLED.");

		String[] toDelete = request.getParameterValues("examid");

		if (toDelete != null) {
//			ExamService.deleteExam(toDelete);

			return "exam/viewexams";

		} else {

			System.out.println("no exams to delete!");
		}

		return null;
	}

	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/editquestion", method = RequestMethod.POST)
	public String editQuestion(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
		System.out.println("@/exam/deleteexam MODULE VIEW CONTROLLER CALLED.");

		return "";
	}
	
	
}
