package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ClassDTO;
import model.ClassParticipateDTO;
import model.DAOFactory;

public class ClassParticipateDAOImpl implements ClassParticipateDAO {

	private JDBCUtil jdbcUtil = null;		// JDBCUtil 객체를 지정하기 위한 변수
	
	//Class의 기본 정보를 포함하는 query 문
	private static String query = "SELECT CLASS.C_ID AS CLASS_ID, " +
								         "CLASS.C_NAME AS CLASS_NAME, " +
								         "CLASS.C_DATE AS CLASS_DATE, " +
								         "CLASS.CUST_ID AS CUSTOMER_ID "+
								         "CLASS.CUST_NAME AS CUSTOMER_NAME ";
	// ClassDAOImpl 생성자
	public ClassParticipateDAOImpl() {			
		jdbcUtil = new JDBCUtil();		// ClassDAOImpl 객체 생성 시 JDBCUtil 객체 생성
	}
	
	// 참여자의 클래스참여정보를 List 로 반환하는 메소드
	public List<ClassParticipateDTO> getClassParticipateList() {
		String allQuery = query + ", " + "CLASS.C_NAME AS CLASS.C_NAME, " +
								    "FROM CLASS " +
								    "CUST_ID = ?" ;		
		jdbcUtil.setSql(allQuery);		// JDBCUtil 에 query 설정
		
		try { 
			ResultSet rs = jdbcUtil.executeQuery();		// query 문 실행			
			List<ClassParticipateDTO> list = new ArrayList<ClassParticipateDTO>();		// StudentDTO 객체들을 담기위한 list 객체
			while (rs.next()) {	
				ClassParticipateDTO dto = new ClassParticipateDTO();		// 하나의 StudentDTO 객체 생성 후 정보 설정
				dto.setC_id(rs.getString("c_id"));


				list.add(dto);		// list 객체에 정보를 설정한 StudentDTO 객체 저장
			}
			return list;		// 학생정보를 저장한 dto 들의 목록을 반환
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
		}		
		return null;	
	}

	//클래스 참여하기
	@Override
	public int participateClass(ClassParticipateDTO participate) {
		// TODO Auto-generated method stub
		int result = 0;
		String insertQuery = "INSERT INTO CLASSPARTICIPATE (C_ID, C_NAME, C_DATE, CUST_ID, CUST_NAME) " +
							 "VALUES (?, ?, ?, ?, ?) ";
		
		DAOFactory factory = new DAOFactory();		// 교수정보와 학과정보를 알아오기 위해 DAO 객체를 생성하는 factory 객체 생성

		// query 문에 사용할 매개변수 값을 갖는 매개변수 배열 생성
		Object[] param = new Object[] {participate.getC_id(), participate.getC_name(), participate.getC_date(),
				participate.getCust_id(), participate.getCust_name()};//카테고리는 어떻게.?		
		jdbcUtil.setSql(insertQuery);			// JDBCUtil 에 insert 문 설정
		jdbcUtil.setParameters(param);			// JDBCUtil 에 매개변수 설정
				
		try {				
			result = jdbcUtil.executeUpdate();		// insert 문 실행
			System.out.println(participate.getCust_name() + " 참여자 정보가 삽입되었습니다.");
		} catch (SQLException ex) {
			System.out.println("입력오류 발생!!!");
			if (ex.getErrorCode() == 1)
				System.out.println("동일한 참여 정보가 이미 존재합니다."); 
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
		}		
		return result;		// insert 에 의해 반영된 레코드 수 반환	
	}

	@Override
	//참여자가 참여 취소
	public int cancelClass(ClassParticipateDTO participate) {
		// TODO Auto-generated method stub
		String cancelQuery = "DELETE FROM CLASSPARTICIPATE WHERE C_ID = ?";
		
		jdbcUtil.setSql(cancelQuery);			// JDBCUtil 에 query 문 설정
		Object[] param = new Object[] {participate.getC_id()};
		jdbcUtil.setParameters(param);			// JDBCUtil 에 매개변수 설정
		
		try {
			int result = jdbcUtil.executeUpdate();		// delete 문 실행
			return result;						// delete 에 의해 반영된 레코드 수 반환
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();		
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
		}
		return 0;
	}

}
