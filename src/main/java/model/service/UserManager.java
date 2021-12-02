package model.service;

import java.sql.SQLException;
import java.util.List;

import model.CustomerDTO;
import model.dao.UserDAO;

/**
 * ����� ���� API�� ����ϴ� �����ڵ��� ���� �����ϰ� �Ǵ� Ŭ����.
 * UserDAO�� �̿��Ͽ� �����ͺ��̽��� ������ ���� �۾��� �����ϵ��� �ϸ�,
 * �����ͺ��̽��� �����͵��� �̿��Ͽ� �����Ͻ� ������ �����ϴ� ������ �Ѵ�.
 * �����Ͻ� ������ ������ ��쿡�� �����Ͻ� �������� �����ϴ� Ŭ������ 
 * ������ �� �� �ִ�.
 */
public class UserManager {
	private static UserManager userMan = new UserManager();
	private UserDAO userDAO;

	private UserManager() {
		try {
			userDAO = new UserDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static UserManager getInstance() {
		return userMan;
	}
	
	public int create(CustomerDTO cust) throws SQLException, ExistingUserException {
		if (userDAO.existingUser(cust.getCust_id()) == true) {
			throw new ExistingUserException(cust.getCust_id() + "�� �����ϴ� ���̵��Դϴ�.");
		}
		return userDAO.create(cust);
	}

	public CustomerDTO findUser(String userId)
		throws SQLException, UserNotFoundException {
		CustomerDTO cust = userDAO.findUser(userId);
		
		if (cust == null) {
			throw new UserNotFoundException(userId + "�� �������� �ʴ� ���̵��Դϴ�.");
		}		
		return cust;
	}

	public List<CustomerDTO> findUserList() throws SQLException {
			return userDAO.findUserList();
	}
	
	public List<CustomerDTO> findUserList(int currentPage, int countPerPage)
		throws SQLException {
		return userDAO.findUserList(currentPage, countPerPage);
	}

	public boolean login(String userId, String password)
		throws SQLException, UserNotFoundException, PasswordMismatchException {
		CustomerDTO user = findUser(userId);

		if (!user.matchPassword(password)) {
			throw new PasswordMismatchException("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}
		return true;
	}

	public UserDAO getUserDAO() {
		return this.userDAO;
	}

	public void update(CustomerDTO updateUser) {
		// TODO Auto-generated method stub
		
	}

	public void remove(String deleteId) {
		// TODO Auto-generated method stub
		
	}
}
