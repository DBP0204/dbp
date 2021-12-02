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
    	// POST request (ȸ�������� parameter�� ���۵�)
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
	        return "redirect:/";	// ���� �� ����� ����Ʈ ȭ������ redirect
	        
		} catch (ExistingUserException e) {	// ���� �߻� �� ȸ������ form���� forwarding
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("user", cust);
			return "/user/registerForm.jsp";
		}
    }
}
