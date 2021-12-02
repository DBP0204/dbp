package model.service;

import java.sql.SQLException;
import java.util.List;

import model.ClassDTO;
import model.dao.ClassDAO;

public class ClassManager {
	private static ClassManager classMan = new ClassManager();
	private ClassDAO classDAO;

	private ClassManager() {
		try {
			classDAO = new ClassDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static ClassManager getInstance() {
		return classMan;
	}
	
	public ClassDTO createClass(ClassDTO class_) throws SQLException {
		return classDAO.create(class_);		
	}

	public int updateClass(ClassDTO class_) throws SQLException {
		return classDAO.update(class_);				
	}
	
	public ClassDTO findClass(int c_id) throws SQLException {
		ClassDTO class_ = classDAO.findClass(c_id); 
	
		return class_;
	}
	
	public List<ClassDTO> findClassList() throws SQLException {
		return classDAO.findClassList();
	}
	
}
