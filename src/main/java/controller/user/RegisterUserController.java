package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.CustomerDTO;
import model.service.ExistingUserException;
import model.service.UserManager;

public class RegisterUserController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(RegisterUserController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	// POST request (회원정보가 parameter로 전송됨)
       	CustomerDTO cust = new CustomerDTO(
				request.getParameter("userId"),
				request.getParameter("name"),
				request.getParameter("password"),
				request.getParameter("address"),
				request.getParameter("email"),					
				request.getParameter("phone"),
				request.getParameter("local"),
				request.getParameter("interest"),
				request.getParameter("gender"),
				request.getParameter("birth"));
		
        log.debug("Create User : {}", cust);

		try {
			UserManager manager = UserManager.getInstance();
			manager.create(cust);
	        return "redirect:/";	// 성공 시 사용자 리스트 화면으로 redirect
	        
		} catch (ExistingUserException e) {	// 예외 발생 시 회원가입 form으로 forwarding
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("user", cust);
			return "/user/registerForm.jsp";
		}
    }
}
