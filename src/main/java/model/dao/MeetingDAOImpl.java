package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.MeetingDTO;
import model.dao.JDBCUtil;

public class MeetingDAOImpl implements MeetingDAO {

	private JDBCUtil jdbcUtil = null;		// JDBCUtil ��ü�� �����ϱ� ���� ����
	
	// Meeting �� �⺻ ������ �����ϴ� query ��
	private static String query = "SELECT MEETING.M_ID AS MEETING_ID, " +
								         "MEETING.CATE_ID AS CATEGORY_ID, " +
								         "MEETING.M_LOCAL AS MEETING_LOCAL, " +
								         "MEETING.M_PERSONNEL_NO AS MEETING_PERSONNEL, " +
								         "MEETING.M_NAME AS MEETING_NAME, " +
								         "MEETING.CUSTOMER_ID AS CUSTOMER_ID, " +
								         "MEETING.M_DETAILS AS MEETING_DETAILS, " +
								         "MEETING.M_SUMMARY AS MEETING_SUMMARY ";
		
	// StudentDAOImpl ������
	public MeetingDAOImpl() {			
		jdbcUtil = new JDBCUtil();		// MeetingDAOImpl ��ü ���� �� JDBCUtil ��ü ����
	}
	
	@Override
	public List<MeetingDTO> getMeetingList() {
		// �⺻ ������ ����
				String allQuery = query + "FROM MEETING ORDER BY MEETING.M_ID ASC ";		
				jdbcUtil.setSql(allQuery);		// JDBCUtil �� query ����
				
				try { 
					ResultSet rs = jdbcUtil.executeQuery();		// query �� ����			
					List<MeetingDTO> list = new ArrayList<MeetingDTO>();		// StudentDTO ��ü���� ������� list ��ü
					while (rs.next()) {	
						MeetingDTO dto = new MeetingDTO();		// �ϳ��� StudentDTO ��ü ���� �� ���� ����
//						dto.setStuNo(rs.getString("STUDENT_NO"));
//						dto.setStuName(rs.getString("STUDENT_NAME"));
//						dto.setPwd(rs.getString("STUDENT_PASSWD"));
//						dto.setStuPhoneNo(rs.getString("STUDENT_PHONE_NO"));
//						dto.setYear(rs.getString("STUDENT_YEAR"));
//						dto.setProfCode(rs.getString("STUDENT_P_CODE"));
//						dto.setDeptCode(rs.getString("STUDENT_D_CODE"));
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

	@Override
	public List<MeetingDTO> getMeetingListByCateName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MeetingDTO getMeetingById(String meeting_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int openMeeting(MeetingDTO m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMeeting(MeetingDTO m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMeeting(MeetingDTO m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int sendInvitation() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MeetingDTO> receivedInvitation(String customer_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MeetingDTO> meetingParticipation(String customer_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
