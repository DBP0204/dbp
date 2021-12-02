package controller.community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.PostDTO;
import model.service.PostManager;

public class ViewPostController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		PostDTO post = null;
		PostManager manager = PostManager.getInstance();
		int post_id = Integer.parseInt(request.getParameter("post_id"));
		post = manager.findPost(post_id); // �Խñ� �˻�
		
		request.setAttribute("post", post); // �Խñ� ���� ����
		return "/community/postDetail.jsp";	
	}
	
}
