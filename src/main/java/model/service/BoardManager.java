package model.service;

import java.util.List;

import model.DAOFactory;
import model.PostDTO;
import model.dao.BoardDAO;

public class BoardManager {
	private static BoardManager boardMan = new BoardManager();
	private BoardDAO dao = null;
	
	public BoardManager() {
		DAOFactory factory = new DAOFactory();
		dao = factory.getBoardDAO();
	}
	
	public static BoardManager getInstance() {
		return boardMan;
	}
	
	public List<PostDTO> getPostList() {
		return dao.getPostList();
	}
}
