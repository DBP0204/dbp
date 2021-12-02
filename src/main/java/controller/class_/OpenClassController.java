package controller.class_;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.ClassDTO;
import model.service.ClassManager;
import model.service.UserManager;

public class OpenClassController implements Controller{
//int c_id, String c_name, int c_personnel, String c_date, int c_isOnline, String c_local, String c_summary,
//	String c_detail, int c_price, String c_file, String cate_id, String cust_id
	
	private static final Logger Log = LoggerFactory.getLogger(OpenClassController.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ClassDTO class_ = new ClassDTO(
	    		0, request.getParameter("c_name"),
				Integer.parseInt(request.getParameter("c_personnel")),
				request.getParameter("c_date"),
				Integer.parseInt(request.getParameter("c_isOnline")),
				request.getParameter("c_local"),
				request.getParameter("c_summary"),
				request.getParameter("c_detail"),
				Integer.parseInt(request.getParameter("c_price")),
				request.getParameter("c_file"),
				null, null);	
	        
			try {
				ClassManager manager = ClassManager.getInstance();
				manager.createClass(class_);
				
		    	Log.debug("Create Class : {}", class_);
		        return "redirect:/class/list";	// 성공 시 커뮤니티 리스트 화면으로 redirect
		        
			} catch (Exception e) {		// 예외 발생 시 입력 form으로 forwarding
	            request.setAttribute("creationFailed", true);
				request.setAttribute("exception", e);
				request.setAttribute("class", class_);
				return "/class/classOpenform.jsp";
			}
	}

}
