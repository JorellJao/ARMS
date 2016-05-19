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
import ph.com.alliance.entity.User;
import ph.com.alliance.service.ExamService;

/**
 * Example controller class that hadles static view requests. All requests that
 * returns pages (html, xhtml, jsp, jspx, etc.) is handled here.
 *
 */
@Controller
@RequestMapping("/exam")
public class ExamController {

	@Autowired
	ExamService ExamService;

	/**
	 * 
	 * @param request
	 * @param response
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/showexams", method = RequestMethod.GET)
	public String showExams(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
		System.out.println("@/exam/showexams MODULE VIEW CONTROLLER CALLED.");

		List<Exam> exams = ExamService.viewExams();

		System.out.println("number of exams : " + exams.size());

		System.out.println("exam 1 : " + exams.get(0).getId().getName());

		map.addAttribute("examlist", exams);

		return "exam/exams";
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/addexam", method = RequestMethod.GET)
	public String addExam(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
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

			ExamService.addExam(newexam);

			try {
				response.sendRedirect("../exam/showexams");
			} catch (IOException e) {
				// TODO Auto-generated catch block
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
	@RequestMapping(value = "/deleteexam", method = RequestMethod.GET)
	public String deleteExams(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
		System.out.println("@/exam/deleteexam MODULE VIEW CONTROLLER CALLED.");

		String[] toDelete = request.getParameterValues("examid");

		if (toDelete != null) {
			ExamService.deleteExam(toDelete);

			
		} else {

			System.out.println("no exams to delete!");
		}

		return this.showExams(request, response, map);
	}

	
	@RequestMapping(value = "/loadrename", method = RequestMethod.GET)
	public String loadrename(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
		System.out.println("@/exam/loadrename MODULE VIEW CONTROLLER CALLED.");
		
		String id = request.getParameter("Eid");
		
		if(id !=null){
			System.out.println("loadrename id : " + id);
			map.addAttribute("idtorename",id);
			
		}else{
			
			System.out.println("id is empty");
		}
		
		return this.showExams(request, response, map);
		
	}
	
	@RequestMapping(value = "/renameexam", method = RequestMethod.GET)
	public String renameExams(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
		System.out.println("@/exam/renameexam MODULE VIEW CONTROLLER CALLED.");

		
		String id = request.getParameter("Eid");
		
		String name = request.getParameter("newname");
		
		System.out.println("id : "+id);
		System.out.println("rename to :" + name);
		
		Exam exam = ExamService.getExamById(id);
		
		exam.getId().setName(name);

		ExamService.renameExam(exam);
		
		return this.showExams(request, response, map);
	}
}
