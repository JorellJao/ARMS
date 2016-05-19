package ph.com.alliance.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class ModuleInterceptor extends HandlerInterceptorAdapter {

	public ModuleInterceptor() {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	    throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute("isLoggedIn") != null) {
			System.out.println("I'm still logged in");
			if(request.getRequestURL().indexOf("loadedit") > 0) {
				if(session.getAttribute("role").equals("manager")) {
					System.out.println("THIS IS A REQUEST TO THE EDIT JSP. CURRENT ROLE IS MANAGER.");
				} else {
					System.out.println("THIS IS A REQUEST TO THE EDIT JSP. CURRENT ROLE IS NOT MANAGER.");
					response.sendRedirect(request.getContextPath() + "/modulename/notallowed");
				}
			}
			
			
		} else if(request.getRequestURL().indexOf("notloggedin") > 0) {
			System.out.println("THIS IS A REQUEST TO THE NOTLOGGEDIN JSP. Allow this request.");
		} else if(request.getRequestURL().indexOf("forcelogin") > 0) {
			System.out.println("THIS IS A LOGIN REQUEST.");
		} else if(request.getRequestURL().indexOf("forcelogout") > 0) {
			System.out.println("THIS IS A LOGOUT REQUEST");
		} else {
			System.out.println("I'M NOT LOGGED IN!!");
			response.sendRedirect(request.getContextPath() + "/modulename/notloggedin");
			return false;
		}
		
		return true;
	}
	
	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
	}
}