package controller.community;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.PostDTO;
import model.service.PostManager;

public class RegisterPostController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String id = (String) request.getSession().getAttribute("userId");
		String title = request.getParameter("postTitle");
		String content = request.getParameter("postContent");
		String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		PostDTO post = new PostDTO(title, content, id, date);
		
		try {
			PostManager manager = PostManager.getInstance();
			manager.createPost(post);
			
			return "redirect:/community/list";	// ���� �� Ŀ�´�Ƽ ����Ʈ ȭ������ redirect
			
		} catch (Exception ex) {	// ���� �߻� �� �Է� form���� forwarding
			request.setAttribute("creationFailed", true);
			request.setAttribute("exception", ex);
			request.setAttribute("post", post);
			
			return "/community/postWrite.jsp";
		}
	}

}
