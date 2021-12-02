package controller.community;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.PostDTO;
import model.service.BoardManager;

public class ListPostController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		BoardManager manager = BoardManager.getInstance();
		List<PostDTO> postList = manager.getPostList();

		request.setAttribute("postList", postList);				

		return "/community/communityList.jsp";
	}
}
