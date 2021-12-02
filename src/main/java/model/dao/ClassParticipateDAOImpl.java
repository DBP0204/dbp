package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ClassDTO;
import model.ClassParticipateDTO;
import model.DAOFactory;

public class ClassParticipateDAOImpl implements ClassParticipateDAO {

	private JDBCUtil jdbcUtil = null;		// JDBCUtil ��ü�� �����ϱ� ���� ����
	
	//Class�� �⺻ ������ �����ϴ� query ��
	private static String query = "SELECT CLASS.C_ID AS CLASS_ID, " +
								         "CLASS.C_NAME AS CLASS_NAME, " +
								         "CLASS.C_DATE AS CLASS_DATE, " +
								         "CLASS.CUST_ID AS CUSTOMER_ID "+
								         "CLASS.CUST_NAME AS CUSTOMER_NAME ";
	// ClassDAOImpl ������
	public ClassParticipateDAOImpl() {			
		jdbcUtil = new JDBCUtil();		// ClassDAOImpl ��ü ���� �� JDBCUtil ��ü ����
	}
	
	// �������� Ŭ�������������� List �� ��ȯ�ϴ� �޼ҵ�
	public List<ClassParticipateDTO> getClassParticipateList() {
		String allQuery = query + ", " + "CLASS.C_NAME AS CLASS.C_NAME, " +
								    "FROM CLASS " +
								    "CUST_ID = ?" ;		
		jdbcUtil.setSql(allQuery);		// JDBCUtil �� query ����
		
		try { 
			ResultSet rs = jdbcUtil.executeQuery();		// query �� ����			
			List<ClassParticipateDTO> list = new ArrayList<ClassParticipateDTO>();		// StudentDTO ��ü���� ������� list ��ü
			while (rs.next()) {	
				ClassParticipateDTO dto = new ClassParticipateDTO();		// �ϳ��� StudentDTO ��ü ���� �� ���� ����
				dto.setC_id(rs.getString("c_id"));


				list.add(dto);		// list ��ü�� ������ ������ StudentDTO ��ü ����
			}
			return list;		// �л������� ������ dto ���� ����� ��ȯ
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}		
		return null;	
	}

	//Ŭ���� �����ϱ�
	@Override
	public int participateClass(ClassParticipateDTO participate) {
		// TODO Auto-generated method stub
		int result = 0;
		String insertQuery = "INSERT INTO CLASSPARTICIPATE (C_ID, C_NAME, C_DATE, CUST_ID, CUST_NAME) " +
							 "VALUES (?, ?, ?, ?, ?) ";
		
		DAOFactory factory = new DAOFactory();		// ���������� �а������� �˾ƿ��� ���� DAO ��ü�� �����ϴ� factory ��ü ����

		// query ���� ����� �Ű����� ���� ���� �Ű����� �迭 ����
		Object[] param = new Object[] {participate.getC_id(), participate.getC_name(), participate.getC_date(),
				participate.getCust_id(), participate.getCust_name()};//ī�װ��� ���.?		
		jdbcUtil.setSql(insertQuery);			// JDBCUtil �� insert �� ����
		jdbcUtil.setParameters(param);			// JDBCUtil �� �Ű����� ����
				
		try {				
			result = jdbcUtil.executeUpdate();		// insert �� ����
			System.out.println(participate.getCust_name() + " ������ ������ ���ԵǾ����ϴ�.");
		} catch (SQLException ex) {
			System.out.println("�Է¿��� �߻�!!!");
			if (ex.getErrorCode() == 1)
				System.out.println("������ ���� ������ �̹� �����մϴ�."); 
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}		
		return result;		// insert �� ���� �ݿ��� ���ڵ� �� ��ȯ	
	}

	@Override
	//�����ڰ� ���� ���
	public int cancelClass(ClassParticipateDTO participate) {
		// TODO Auto-generated method stub
		String cancelQuery = "DELETE FROM CLASSPARTICIPATE WHERE C_ID = ?";
		
		jdbcUtil.setSql(cancelQuery);			// JDBCUtil �� query �� ����
		Object[] param = new Object[] {participate.getC_id()};
		jdbcUtil.setParameters(param);			// JDBCUtil �� �Ű����� ����
		
		try {
			int result = jdbcUtil.executeUpdate();		// delete �� ����
			return result;						// delete �� ���� �ݿ��� ���ڵ� �� ��ȯ
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();		
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}
		return 0;
	}

}
