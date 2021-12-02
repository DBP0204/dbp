package controller.class_;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.ClassDTO;
import model.service.ClassManager;

public class ListClassController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ClassManager manager = ClassManager.getInstance();
		List<ClassDTO> classList = manager.findClassList();

		request.setAttribute("classList", classList);			

		return "/class/classList.jsp"; 
	}

}