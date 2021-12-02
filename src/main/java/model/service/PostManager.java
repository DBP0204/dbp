package model.service;

import java.util.List;

import model.CommentaryDTO;
import model.DAOFactory;
import model.PostDTO;
import model.dao.PostDAO;

public class PostManager {
	private static PostManager postMan = new PostManager();
	private PostDAO dao = null;
	
	public PostManager() {
		DAOFactory factory = new DAOFactory();
		dao = factory.getPostDAO();
	}
	
	public static PostManager getInstance() {
		return postMan;
	}
	
	public int createPost(PostDTO post) {
		return dao.createPost(post);
	}
	
	public int deletePost(int postId) {
		return dao.deletePost(postId);
	}
	
	public int updatePost(PostDTO post) {
		return dao.updatePost(post);
	}
	
	public PostDTO findPost(int postId) {
		return dao.findPost(postId);
	}
	
	public List<CommentaryDTO> getCommentaryList(int postId) {
		return dao.getCommentaryList(postId);
	}

}
