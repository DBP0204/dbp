package controller.class_;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.ClassDTO;
import model.service.ClassManager;

public class ViewClassController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		ClassDTO class_ = null;
		ClassManager manager = ClassManager.getInstance();
		int c_id = Integer.parseInt(request.getParameter("c_id"));
		class_ = manager.findClass(c_id);		// Ŀ�´�Ƽ ���� �˻�			
		
		request.setAttribute("c_id", class_);	// Ŀ�´�Ƽ ���� ����				
		return "/class/class_details.jsp";				// Ŀ�´�Ƽ ���� ȭ������ �̵�
	}
}
