package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ClassDTO;

public class ClassDAO {
private JDBCUtil jdbcUtil = null;
	
	public ClassDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil ��ü ����
	}
		
	/**
	 * Ŭ���� ���̺� ���ο� �� ���� (PK ���� Sequence�� �̿��Ͽ� �ڵ� ����)
	 * INSERT INTO CLASS VALUES (1, 'class', 1, null, null, null, null, null, null, null, 0, null);
	 * C_ID
C_NAME
C_PERSONNEL
C_ISONLINE
C_LOCAL
C_SUMMARY
C_DETAIL
C_DATE
CUST_ID
CATE_ID
C_PRICE
C_FILE
	 */
	public ClassDTO create(ClassDTO class_) throws SQLException {
		String sql = "INSERT INTO CLASS VALUES (C_ID_seq.nextval, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?)";		
		Object[] param = new Object[] {class_.getC_name(), class_.getC_personnel(), class_.getC_isOnline(), 
									class_.getC_local(), class_.getC_summary(), class_.getC_detail(), class_.getC_date(),
									class_.getCust_id(), class_.getCate_id(), class_.getC_price(), class_.getC_file()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil �� insert���� �Ű� ���� ����
						
		String key[] = {"C_ID"};	// PK �÷��� �̸�     
		try {    
			jdbcUtil.executeUpdate(key);  // insert �� ����
		   	ResultSet rs = jdbcUtil.getGeneratedKeys();
		   	if(rs.next()) {
		   		int generatedKey = rs.getInt(1);   // ������ PK ��
		   		class_.setC_id(generatedKey); 	// id�ʵ忡 ����  
		   	}
		   	return class_;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ��ȯ
		}		
		return null;			
	}

	/**
	 * ������ Ŭ���� ������ ����
	 */
	public int update(ClassDTO class_) throws SQLException {
		String sql = "UPDATE CLASS "
					+ "SET C_NAME=?, C_PERSONNEL=?, C_ISONLINE=?, C_LOCAL=?, C_SUMMARY=?, C_DETAIL=?, C_DATE=?, CUST_ID=?, CATE_ID=?, C_PRICE=?, C_FILE =? "
					+ "WHERE C_ID=?";
		int c_id = class_.getC_id();
		//if (chairId.equals("")) chairId = null;
		Object[] param = new Object[] {class_.getC_name(), class_.getC_personnel(), class_.getC_isOnline(), 
				class_.getC_local(), class_.getC_summary(), class_.getC_detail(), class_.getC_date(),
				class_.getCust_id(), class_.getCate_id(), class_.getC_price(), class_.getC_file(), class_.getC_id()};				
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
	 * �־��� ID�� �ش��ϴ� Ŀ�´�Ƽ ������ ����.
	 */
	public int remove(String c_id) throws SQLException {
		String sql = "DELETE FROM Community WHERE C_ID=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {c_id});	// JDBCUtil�� delete���� �Ű� ���� ����

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
	 * �־���  ID�� �ش��ϴ� Ŭ���� ������ �����ͺ��̽����� ã�� class ������ Ŭ������ 
	 * �����Ͽ� ��ȯ.
	 * CUST_ID, CATE_ID, -> �߰�?
	 * LEFT OUTER JOIN CUSTOMER u ON c.chairId = u.userId 
	 * public ClassDTO(int c_id, String c_name, int c_personnel, String c_date, int c_isOnline, String c_local, String c_summary,
		String c_detail, int c_price, String c_file)
	 */
	public ClassDTO findClass(int c_id) throws SQLException {
        String sql = "SELECT C_NAME, C_PERSONNEL, C_ISONLINE, C_LOCAL, C_SUMMARY, C_DETAIL, C_DATE,  C_PRICE, C_FILE  "
        			+ "FROM CLASS c "
        			+ "WHERE C_ID=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {c_id});	// JDBCUtil�� query���� �Ű� ���� ����
		ClassDTO class_ = null;
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query ����
			if (rs.next()) {						// �л� ���� �߰�
				class_ = new ClassDTO(		// Community ��ü�� �����Ͽ� Ŀ�´�Ƽ ������ ����
					c_id,
					rs.getString("C_NAME"),
					rs.getInt("C_PERSONNEL"),
					rs.getString("C_DATE"),
					rs.getInt("C_ISONLINE"),
		            rs.getString("C_LOCAL"),
		            rs.getString("C_SUMMARY"),
		            rs.getString("C_DETAIL"),
		            rs.getInt("C_PRICE"),
		            rs.getString("C_FILE"));   

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}
		return class_;
	}

	/**
	 * ��ü Ŀ�´�Ƽ ������ �˻��Ͽ� List�� ���� �� ��ȯ
	 */
	public List<ClassDTO> findClassList() throws SQLException {
        String sql = "SELECT C_ID, C_NAME, C_LOCAL, C_PRICE, C_FILE "
        		   + "FROM CLASS "
        		   + "ORDER BY C_ID"; 
        
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil�� query�� ����
			
		//(int c_id, String c_name, String c_local, int c_price, String c_file)
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query ����			
			List<ClassDTO> classList = new ArrayList<ClassDTO>();	// Community���� ����Ʈ ����
			while (rs.next()) {
				ClassDTO class_ = new ClassDTO(			// Community ��ü�� �����Ͽ� ���� ���� ������ ����
						rs.getInt("C_ID"),
						rs.getString("C_NAME"),
						rs.getString("C_LOCAL"),
						rs.getInt("C_PRICE"),
						rs.getString("C_FILE"));
				classList.add(class_);				// List�� Community ��ü ����
			}		
			return classList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}
		return null;
	}
	
	/**
	 * �־���  ID�� �ش��ϴ� class�� �����ϴ��� �˻� 
	 */
	public boolean existingClass(String c_id) throws SQLException {
		String sql = "SELECT count(*) FROM CLASS WHRE C_ID=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {c_id});	// JDBCUtil�� query���� �Ű� ���� ����

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
