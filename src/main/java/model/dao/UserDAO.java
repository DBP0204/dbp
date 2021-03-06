package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CustomerDTO;

/**
 * 紫遂切 淫軒研 是背 汽戚斗今戚什 拙穣聖 穿眼馬澗 DAO 適掘什
 * USERINFO 砺戚鷺拭 紫遂切 舛左研 蓄亜, 呪舛, 肢薦, 伊事 呪楳 
 */
public class UserDAO {
	private JDBCUtil jdbcUtil = null;
	
	public UserDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 梓端 持失
	}
		
	/**
	 * 紫遂切 淫軒 砺戚鷺拭 歯稽錘 紫遂切 持失.
	 */
	public int create(CustomerDTO cust) throws SQLException { //食奄びびびびびびびびびびび
		String sql = "INSERT INTO CUSTOMER VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";		
		Object[] param = new Object[] {cust.getCust_id(), cust.getName(), 
						cust.getPassword(), cust.getAddress(), cust.getEmail(), 
						cust.getPhone(), cust.getLocal(), cust.getInterest(), cust.getGender(), cust.getBirth()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 拭 insert庚引 古鯵 痕呪 竺舛
						
		try {				
			int result = jdbcUtil.executeUpdate();	// insert 庚 叔楳
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 鋼発
		}		
		return 0;			
	}

	/**
	 * 奄糎税 紫遂切 舛左研 呪舛.
	 */
	public int update(CustomerDTO cust) throws SQLException {
		String sql = "UPDATE CUSTOMER "
					+ "SET password=?, address=?, email=?, phone=?, local=?, interest=? "
					+ "WHERE cust_id=?";
		Object[] param = new Object[] {cust.getPassword(), cust.getAddress(), 
					cust.getEmail(), cust.getPhone(), cust.getLocal(), cust.getInterest()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil拭 update庚引 古鯵 痕呪 竺舛
			
		try {				
			int result = jdbcUtil.executeUpdate();	// update 庚 叔楳
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 鋼発
		}		
		return 0;
	}

	/**
	 * 紫遂切 ID拭 背雁馬澗 紫遂切研 肢薦.
	 */
	public int remove(String userId) throws SQLException {
		String sql = "DELETE FROM CUSTOMER WHERE cust_id=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	// JDBCUtil拭 delete庚引 古鯵 痕呪 竺舛

		try {				
			int result = jdbcUtil.executeUpdate();	// delete 庚 叔楳
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 鋼発
		}		
		return 0;
	}

	/**
	 * 爽嬢遭 紫遂切 ID拭 背雁馬澗 紫遂切 舛左研 汽戚斗今戚什拭辞 達焼 User 亀五昔 適掘什拭 
	 * 煽舌馬食 鋼発.
	 */
	public CustomerDTO findUser(String userId) throws SQLException { 
        String sql = "SELECT cust_id, name, password, address, email, phone, local, interest, gender, birth "
        			+ "FROM CUSTOMER "
        			+ "WHERE cust_id=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	// JDBCUtil拭 query庚引 古鯵 痕呪 竺舛

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 叔楳
			if (rs.next()) {						// 俳持 舛左 降胃
				CustomerDTO cust = new CustomerDTO(		// User 梓端研 持失馬食 俳持 舛左研 煽舌
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
			jdbcUtil.close();		// resource 鋼発
		}
		return null;
	}

	/**
	 * 穿端 紫遂切 舛左研 伊事馬食 List拭 煽舌 貢 鋼発
	 */
	public List<CustomerDTO> findUserList() throws SQLException {
        String sql = "SELECT cust_id, name, password, address, email, phone, local, interest, gender, birth " 
        		   + "FROM CUSTOMER ";
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil拭 query庚 竺舛
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 叔楳			
			List<CustomerDTO> userList = new ArrayList<CustomerDTO>();	// User級税 軒什闘 持失
			while (rs.next()) {
				CustomerDTO cust = new CustomerDTO(			// User 梓端研 持失馬食 薄仙 楳税 舛左研 煽舌
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
				userList.add(cust);				// List拭 User 梓端 煽舌
			}		
			return userList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 鋼発
		}
		return null;
	}
	
	/**
	 * 穿端 紫遂切 舛左研 伊事廃 板 薄仙 凪戚走人 凪戚走雁 窒径拝 紫遂切 呪研 戚遂馬食
	 * 背雁馬澗 紫遂切 舛左幻聖 List拭 煽舌馬食 鋼発.
	 */
	public List<CustomerDTO> findUserList(int currentPage, int countPerPage) throws SQLException {
		String sql = "SELECT cust_id, name, password, address, email, phone, local, interest, gender, birth " 
     		   		+ "FROM CUSTOMER ";
		jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil拭 query庚 竺舛
				ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll 亜管
				ResultSet.CONCUR_READ_ONLY);						
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();				// query 叔楳			
			int start = ((currentPage-1) * countPerPage) + 1;	// 窒径聖 獣拙拝 楳 腰硲 域至
			if ((start >= 0) && rs.absolute(start)) {			// 朕辞研 獣拙 楳生稽 戚疑
				List<CustomerDTO> userList = new ArrayList<CustomerDTO>();	// User級税 軒什闘 持失
				do {
					CustomerDTO cust = new CustomerDTO(			// User 梓端研 持失馬食 薄仙 楳税 舛左研 煽舌
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
					userList.add(cust);								// 軒什闘拭 User 梓端 煽舌
				} while ((rs.next()) && (--countPerPage > 0));		
				return userList;							
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 鋼発
		}
		return null;
	}

	/**
	 * 働舛 朕溝艦銅拭 紗廃 紫遂切級聖 伊事馬食 List拭 煽舌 貢 鋼発
	 */
//	public List<CustomerDTO> findUsersInCommunity(int communityId) throws SQLException {
//        String sql = "SELECT cust_id, name, password, address, email, phone, local, interest, gender, birth " 
// 		   			+ "FROM CUSTOMER ";                     
//		jdbcUtil.setSqlAndParameters(sql, new Object[] {communityId});	// JDBCUtil拭 query庚引 古鯵 痕呪 竺舛
//		
//		try {
//			ResultSet rs = jdbcUtil.executeQuery();		// query 叔楳
//			List<CustomerDTO> memList = new ArrayList<CustomerDTO>();	// member級税 軒什闘 持失
//			while (rs.next()) {
//				CustomerDTO cust = new CustomerDTO(			// User 梓端研 持失馬食 薄仙 楳税 舛左研 煽舌
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
//				memList.add(cust);			// List拭 Community 梓端 煽舌
//			}		
//			return memList;					
//				
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		} finally {
//			jdbcUtil.close();		// resource 鋼発
//		}
//		return null;
//	}
	
	/**
	 * 働舛 朕溝艦銅拭 紗廃 紫遂切級税 呪研 count馬食 鋼発
	 */
//	public int getNumberOfUsersInCommunity(int communityId) {
//		String sql = "SELECT COUNT(userId) FROM UserInfo "
//     				+ "WHERE commId = ?";              
//		jdbcUtil.setSqlAndParameters(sql, new Object[] {communityId});	// JDBCUtil拭 query庚引 古鯵 痕呪 竺舛
//		
//		try {
//			ResultSet rs = jdbcUtil.executeQuery();		// query 叔楳
//			rs.next();										
//			return rs.getInt(1);			
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		} finally {
//			jdbcUtil.close();		// resource 鋼発
//		}
//		return 0;
//	}
	
	/**
	 * 爽嬢遭 紫遂切 ID拭 背雁馬澗 紫遂切亜 糎仙馬澗走 伊紫 
	 */
	public boolean existingUser(String userId) throws SQLException {
		String sql = "SELECT count(*) FROM CUSTOMER WHERE cust_id=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	// JDBCUtil拭 query庚引 古鯵 痕呪 竺舛

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 叔楳
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 鋼発
		}
		return false;
	}

}
