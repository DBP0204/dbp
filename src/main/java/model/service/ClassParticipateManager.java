package model.service;

import java.sql.SQLException;
import java.util.List;

import model.ClassParticipateDTO;
import model.DAOFactory;
import model.dao.ClassParticipateDAO;

public class ClassParticipateManager {
	private ClassParticipateDAO dao = null;
	//private ClassParticipateDAO ClassParticipateDAO;

	public ClassParticipateManager() {
		DAOFactory factory = new DAOFactory();
		dao = factory.getClassParticipateDAO();
	}
	
	public List<ClassParticipateDTO> getClassParticipateList() {
		return dao.getClassParticipateList();
		
	}
	public int participateClass(ClassParticipateDTO cla) throws SQLException {
		return dao.participateClass(cla);
	}
	
	public int cancelClass(ClassParticipateDTO cla) throws SQLException {
		return dao.cancelClass(cla);
	}
}
