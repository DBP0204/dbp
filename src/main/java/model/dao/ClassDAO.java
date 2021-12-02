package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ClassDTO;

public class ClassDAO {
private JDBCUtil jdbcUtil = null;
	
	public ClassDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
		
	/**
	 * 클래스 테이블에 새로운 행 생성 (PK 값은 Sequence를 이용하여 자동 생성)
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
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정
						
		String key[] = {"C_ID"};	// PK 컬럼의 이름     
		try {    
			jdbcUtil.executeUpdate(key);  // insert 문 실행
		   	ResultSet rs = jdbcUtil.getGeneratedKeys();
		   	if(rs.next()) {
		   		int generatedKey = rs.getInt(1);   // 생성된 PK 값
		   		class_.setC_id(generatedKey); 	// id필드에 저장  
		   	}
		   	return class_;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return null;			
	}

	/**
	 * 기존의 클래스 정보를 수정
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
	 * 주어진 ID에 해당하는 커뮤니티 정보를 삭제.
	 */
	public int remove(String c_id) throws SQLException {
		String sql = "DELETE FROM Community WHERE C_ID=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {c_id});	// JDBCUtil에 delete문과 매개 변수 설정

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
	 * 주어진  ID에 해당하는 클래스 정보를 데이터베이스에서 찾아 class 도메인 클래스에 
	 * 저장하여 반환.
	 * CUST_ID, CATE_ID, -> 추가?
	 * LEFT OUTER JOIN CUSTOMER u ON c.chairId = u.userId 
	 * public ClassDTO(int c_id, String c_name, int c_personnel, String c_date, int c_isOnline, String c_local, String c_summary,
		String c_detail, int c_price, String c_file)
	 */
	public ClassDTO findClass(int c_id) throws SQLException {
        String sql = "SELECT C_NAME, C_PERSONNEL, C_ISONLINE, C_LOCAL, C_SUMMARY, C_DETAIL, C_DATE,  C_PRICE, C_FILE  "
        			+ "FROM CLASS c "
        			+ "WHERE C_ID=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {c_id});	// JDBCUtil에 query문과 매개 변수 설정
		ClassDTO class_ = null;
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// 학생 정보 발견
				class_ = new ClassDTO(		// Community 객체를 생성하여 커뮤니티 정보를 저장
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
			jdbcUtil.close();		// resource 반환
		}
		return class_;
	}

	/**
	 * 전체 커뮤니티 정보를 검색하여 List에 저장 및 반환
	 */
	public List<ClassDTO> findClassList() throws SQLException {
        String sql = "SELECT C_ID, C_NAME, C_LOCAL, C_PRICE, C_FILE "
        		   + "FROM CLASS "
        		   + "ORDER BY C_ID"; 
        
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정
			
		//(int c_id, String c_name, String c_local, int c_price, String c_file)
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<ClassDTO> classList = new ArrayList<ClassDTO>();	// Community들의 리스트 생성
			while (rs.next()) {
				ClassDTO class_ = new ClassDTO(			// Community 객체를 생성하여 현재 행의 정보를 저장
						rs.getInt("C_ID"),
						rs.getString("C_NAME"),
						rs.getString("C_LOCAL"),
						rs.getInt("C_PRICE"),
						rs.getString("C_FILE"));
				classList.add(class_);				// List에 Community 객체 저장
			}		
			return classList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	/**
	 * 주어진  ID에 해당하는 class가 존재하는지 검사 
	 */
	public boolean existingClass(String c_id) throws SQLException {
		String sql = "SELECT count(*) FROM CLASS WHRE C_ID=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {c_id});	// JDBCUtil에 query문과 매개 변수 설정

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
