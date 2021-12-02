package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CustomerDTO;

/**
 * ����� ������ ���� �����ͺ��̽� �۾��� �����ϴ� DAO Ŭ����
 * USERINFO ���̺� ����� ������ �߰�, ����, ����, �˻� ���� 
 */
public class UserDAO {
	private JDBCUtil jdbcUtil = null;
	
	public UserDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil ��ü ����
	}
		
	/**
	 * ����� ���� ���̺� ���ο� ����� ����.
	 */
	public int create(CustomerDTO cust) throws SQLException { //����ӤӤӤӤӤӤӤӤӤӤ�
		String sql = "INSERT INTO CUSTOMER VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";		
		Object[] param = new Object[] {cust.getCust_id(), cust.getName(), 
						cust.getPassword(), cust.getAddress(), cust.getEmail(), 
						cust.getPhone(), cust.getLocal(), cust.getInterest(), cust.getGender(), cust.getBirth()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil �� insert���� �Ű� ���� ����
						
		try {				
			int result = jdbcUtil.executeUpdate();	// insert �� ����
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ��ȯ
		}		
		return 0;			
	}

	/**
	 * ������ ����� ������ ����.
	 */
	public int update(CustomerDTO cust) throws SQLException {
		String sql = "UPDATE CUSTOMER "
					+ "SET password=?, address=?, email=?, phone=?, local=?, interest=? "
					+ "WHERE cust_id=?";
		Object[] param = new Object[] {cust.getPassword(), cust.getAddress(), 
					cust.getEmail(), cust.getPhone(), cust.getLocal(), cust.getInterest()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil�� update���� �Ű� ���� ����
			
		try {				
			int result = jdbcUtil.executeUpdate();	// update �� ����
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ��ȯ
		}		
		return 0;
	}

	/**
	 * ����� ID�� �ش��ϴ� ����ڸ� ����.
	 */
	public int remove(String userId) throws SQLException {
		String sql = "DELETE FROM CUSTOMER WHERE cust_id=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	// JDBCUtil�� delete���� �Ű� ���� ����

		try {				
			int result = jdbcUtil.executeUpdate();	// delete �� ����
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ��ȯ
		}		
		return 0;
	}

	/**
	 * �־��� ����� ID�� �ش��ϴ� ����� ������ �����ͺ��̽����� ã�� User ������ Ŭ������ 
	 * �����Ͽ� ��ȯ.
	 */
	public CustomerDTO findUser(String userId) throws SQLException { 
        String sql = "SELECT cust_id, name, password, address, email, phone, local, interest, gender, birth "
        			+ "FROM CUSTOMER "
        			+ "WHERE cust_id=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	// JDBCUtil�� query���� �Ű� ���� ����

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query ����
			if (rs.next()) {						// �л� ���� �߰�
				CustomerDTO cust = new CustomerDTO(		// User ��ü�� �����Ͽ� �л� ������ ����
					rs.getString("cust_id"),
					rs.getString("name"),
					rs.getString("password"),
					rs.getString("address"),
					rs.getString("email"),					
					rs.getString("phone"),
					rs.getString("local"),
					rs.getString("interest"),
					rs.getString("gender"),
					rs.getString("birth"));
				return cust;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}
		return null;
	}

	/**
	 * ��ü ����� ������ �˻��Ͽ� List�� ���� �� ��ȯ
	 */
	public List<CustomerDTO> findUserList() throws SQLException {
        String sql = "SELECT cust_id, name, password, address, email, phone, local, interest, gender, birth " 
        		   + "FROM CUSTOMER ";
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil�� query�� ����
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query ����			
			List<CustomerDTO> userList = new ArrayList<CustomerDTO>();	// User���� ����Ʈ ����
			while (rs.next()) {
				CustomerDTO cust = new CustomerDTO(			// User ��ü�� �����Ͽ� ���� ���� ������ ����
					rs.getString("cust_id"),
					rs.getString("name"),
					rs.getString("password"),
					rs.getString("address"),
					rs.getString("email"),
					rs.getString("phone"),
					rs.getString("local"),
					rs.getString("interest"),
					rs.getString("gender"),
					rs.getString("birth"));
				userList.add(cust);				// List�� User ��ü ����
			}		
			return userList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}
		return null;
	}
	
	/**
	 * ��ü ����� ������ �˻��� �� ���� �������� �������� ����� ����� ���� �̿��Ͽ�
	 * �ش��ϴ� ����� �������� List�� �����Ͽ� ��ȯ.
	 */
	public List<CustomerDTO> findUserList(int currentPage, int countPerPage) throws SQLException {
		String sql = "SELECT cust_id, name, password, address, email, phone, local, interest, gender, birth " 
     		   		+ "FROM CUSTOMER ";
		jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil�� query�� ����
				ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll ����
				ResultSet.CONCUR_READ_ONLY);						
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();				// query ����			
			int start = ((currentPage-1) * countPerPage) + 1;	// ����� ������ �� ��ȣ ���
			if ((start >= 0) && rs.absolute(start)) {			// Ŀ���� ���� ������ �̵�
				List<CustomerDTO> userList = new ArrayList<CustomerDTO>();	// User���� ����Ʈ ����
				do {
					CustomerDTO cust = new CustomerDTO(			// User ��ü�� �����Ͽ� ���� ���� ������ ����
						rs.getString("cust_id"),
						rs.getString("name"),
						rs.getString("password"),
						rs.getString("address"),
						rs.getString("email"),
						rs.getString("phone"),
						rs.getString("local"),
						rs.getString("interest"),
						rs.getString("gender"),
						rs.getString("birth"));
					userList.add(cust);								// ����Ʈ�� User ��ü ����
				} while ((rs.next()) && (--countPerPage > 0));		
				return userList;							
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}
		return null;
	}

	/**
	 * Ư�� Ŀ�´�Ƽ�� ���� ����ڵ��� �˻��Ͽ� List�� ���� �� ��ȯ
	 */
//	public List<CustomerDTO> findUsersInCommunity(int communityId) throws SQLException {
//        String sql = "SELECT cust_id, name, password, address, email, phone, local, interest, gender, birth " 
// 		   			+ "FROM CUSTOMER ";                     
//		jdbcUtil.setSqlAndParameters(sql, new Object[] {communityId});	// JDBCUtil�� query���� �Ű� ���� ����
//		
//		try {
//			ResultSet rs = jdbcUtil.executeQuery();		// query ����
//			List<CustomerDTO> memList = new ArrayList<CustomerDTO>();	// member���� ����Ʈ ����
//			while (rs.next()) {
//				CustomerDTO cust = new CustomerDTO(			// User ��ü�� �����Ͽ� ���� ���� ������ ����
//					rs.getString("cust_id"),
//					rs.getString("name"),
//					rs.getString("password"),
//					rs.getString("address"),
//					rs.getString("email"),
//					rs.getString("phone"),
//					rs.getString("local"),
//					rs.getString("interest"),
//					rs.getString("gender"),
//					rs.getString("birth"));
//				memList.add(cust);			// List�� Community ��ü ����
//			}		
//			return memList;					
//				
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		} finally {
//			jdbcUtil.close();		// resource ��ȯ
//		}
//		return null;
//	}
	
	/**
	 * Ư�� Ŀ�´�Ƽ�� ���� ����ڵ��� ���� count�Ͽ� ��ȯ
	 */
//	public int getNumberOfUsersInCommunity(int communityId) {
//		String sql = "SELECT COUNT(userId) FROM UserInfo "
//     				+ "WHERE commId = ?";              
//		jdbcUtil.setSqlAndParameters(sql, new Object[] {communityId});	// JDBCUtil�� query���� �Ű� ���� ����
//		
//		try {
//			ResultSet rs = jdbcUtil.executeQuery();		// query ����
//			rs.next();										
//			return rs.getInt(1);			
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		} finally {
//			jdbcUtil.close();		// resource ��ȯ
//		}
//		return 0;
//	}
	
	/**
	 * �־��� ����� ID�� �ش��ϴ� ����ڰ� �����ϴ��� �˻� 
	 */
	public boolean existingUser(String userId) throws SQLException {
		String sql = "SELECT count(*) FROM CUSTOMER WHERE cust_id=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	// JDBCUtil�� query���� �Ű� ���� ����

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query ����
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}
		return false;
	}

}
