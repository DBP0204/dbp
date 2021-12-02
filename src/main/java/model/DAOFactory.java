package model;

import model.dao.*;

public class DAOFactory {
	
	public ClassParticipateDAO getClassParticipateDAO() {
		return new ClassParticipateDAOImpl();
	}
	
	public PostDAO getPostDAO() {
		return new PostDAOImpl();
	}
	
	public BoardDAO getBoardDAO() {
		return new BoardDAOImpl();
	}
}
