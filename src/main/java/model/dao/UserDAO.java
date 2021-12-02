package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CustomerDTO;

/**
 * 사용자 관리를 위해 데이터베이스 작업을 전담하는 DAO 클래스
 * USERINFO 테이블에 사용자 정보를 추가, 수정, 삭제, 검색 수행 
 */
public class UserDAO {
	private JDBCUtil jdbcUtil = null;
	
	public UserDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
		
	/**
	 * 사용자 관리 테이블에 새로운 사용자 생성.
	 */
	public int create(CustomerDTO cust) throws SQLException { //여기ㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣ
		String sql = "INSERT INTO CUSTOMER VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";		
		Object[] param = new Object[] {cust.getCust_id(), cust.getName(), 
						cust.getPassword(), cust.getAddress(), cust.getEmail(), 
						cust.getPhone(), cust.getLocal(), cust.getInterest(), cust.getGender(), cust.getBirth()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정
						
		try {				
			int result = jdbcUtil.executeUpdate();	// insert 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;			
	}

	/**
	 * 기존의 사용자 정보를 수정.
	 */
	public int update(CustomerDTO cust) throws SQLException {
		String sql = "UPDATE CUSTOMER "
					+ "SET password=?, address=?, email=?, phone=?, local=?, interest=? "
					+ "WHERE cust_id=?";
		Object[] param = new Object[] {cust.getPassword(), cust.getAddress(), 
					cust.getEmail(), cust.getPhone(), cust.getLocal(), cust.getInterest()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 update문과 매개 변수 설정
			
		try {				
			int result = jdbcUtil.executeUpdate();	// update 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}

	/**
	 * 사용자 ID에 해당하는 사용자를 삭제.
	 */
	public int remove(String userId) throws SQLException {
		String sql = "DELETE FROM CUSTOMER WHERE cust_id=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	// JDBCUtil에 delete문과 매개 변수 설정

		try {				
			int result = jdbcUtil.executeUpdate();	// delete 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}

	/**
	 * 주어진 사용자 ID에 해당하는 사용자 정보를 데이터베이스에서 찾아 User 도메인 클래스에 
	 * 저장하여 반환.
	 */
	public CustomerDTO findUser(String userId) throws SQLException { 
        String sql = "SELECT cust_id, name, password, address, email, phone, local, interest, gender, birth "
        			+ "FROM CUSTOMER "
        			+ "WHERE cust_id=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// 학생 정보 발견
				CustomerDTO cust = new CustomerDTO(		// User 객체를 생성하여 학생 정보를 저장
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
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	/**
	 * 전체 사용자 정보를 검색하여 List에 저장 및 반환
	 */
	public List<CustomerDTO> findUserList() throws SQLException {
        String sql = "SELECT cust_id, name, password, address, email, phone, local, interest, gender, birth " 
        		   + "FROM CUSTOMER ";
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<CustomerDTO> userList = new ArrayList<CustomerDTO>();	// User들의 리스트 생성
			while (rs.next()) {
				CustomerDTO cust = new CustomerDTO(			// User 객체를 생성하여 현재 행의 정보를 저장
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
				userList.add(cust);				// List에 User 객체 저장
			}		
			return userList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	/**
	 * 전체 사용자 정보를 검색한 후 현재 페이지와 페이지당 출력할 사용자 수를 이용하여
	 * 해당하는 사용자 정보만을 List에 저장하여 반환.
	 */
	public List<CustomerDTO> findUserList(int currentPage, int countPerPage) throws SQLException {
		String sql = "SELECT cust_id, name, password, address, email, phone, local, interest, gender, birth " 
     		   		+ "FROM CUSTOMER ";
		jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil에 query문 설정
				ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll 가능
				ResultSet.CONCUR_READ_ONLY);						
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();				// query 실행			
			int start = ((currentPage-1) * countPerPage) + 1;	// 출력을 시작할 행 번호 계산
			if ((start >= 0) && rs.absolute(start)) {			// 커서를 시작 행으로 이동
				List<CustomerDTO> userList = new ArrayList<CustomerDTO>();	// User들의 리스트 생성
				do {
					CustomerDTO cust = new CustomerDTO(			// User 객체를 생성하여 현재 행의 정보를 저장
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
					userList.add(cust);								// 리스트에 User 객체 저장
				} while ((rs.next()) && (--countPerPage > 0));		
				return userList;							
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	/**
	 * 특정 커뮤니티에 속한 사용자들을 검색하여 List에 저장 및 반환
	 */
//	public List<CustomerDTO> findUsersInCommunity(int communityId) throws SQLException {
//        String sql = "SELECT cust_id, name, password, address, email, phone, local, interest, gender, birth " 
// 		   			+ "FROM CUSTOMER ";                     
//		jdbcUtil.setSqlAndParameters(sql, new Object[] {communityId});	// JDBCUtil에 query문과 매개 변수 설정
//		
//		try {
//			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
//			List<CustomerDTO> memList = new ArrayList<CustomerDTO>();	// member들의 리스트 생성
//			while (rs.next()) {
//				CustomerDTO cust = new CustomerDTO(			// User 객체를 생성하여 현재 행의 정보를 저장
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
//				memList.add(cust);			// List에 Community 객체 저장
//			}		
//			return memList;					
//				
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		} finally {
//			jdbcUtil.close();		// resource 반환
//		}
//		return null;
//	}
	
	/**
	 * 특정 커뮤니티에 속한 사용자들의 수를 count하여 반환
	 */
//	public int getNumberOfUsersInCommunity(int communityId) {
//		String sql = "SELECT COUNT(userId) FROM UserInfo "
//     				+ "WHERE commId = ?";              
//		jdbcUtil.setSqlAndParameters(sql, new Object[] {communityId});	// JDBCUtil에 query문과 매개 변수 설정
//		
//		try {
//			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
//			rs.next();										
//			return rs.getInt(1);			
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		} finally {
//			jdbcUtil.close();		// resource 반환
//		}
//		return 0;
//	}
	
	/**
	 * 주어진 사용자 ID에 해당하는 사용자가 존재하는지 검사 
	 */
	public boolean existingUser(String userId) throws SQLException {
		String sql = "SELECT count(*) FROM CUSTOMER WHERE cust_id=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return false;
	}

}
