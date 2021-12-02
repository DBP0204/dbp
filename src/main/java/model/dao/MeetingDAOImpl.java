package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.MeetingDTO;
import model.dao.JDBCUtil;

public class MeetingDAOImpl implements MeetingDAO {

	private JDBCUtil jdbcUtil = null;		// JDBCUtil 객체를 지정하기 위한 변수
	
	// Meeting 의 기본 정보를 포함하는 query 문
	private static String query = "SELECT MEETING.M_ID AS MEETING_ID, " +
								         "MEETING.CATE_ID AS CATEGORY_ID, " +
								         "MEETING.M_LOCAL AS MEETING_LOCAL, " +
								         "MEETING.M_PERSONNEL_NO AS MEETING_PERSONNEL, " +
								         "MEETING.M_NAME AS MEETING_NAME, " +
								         "MEETING.CUSTOMER_ID AS CUSTOMER_ID, " +
								         "MEETING.M_DETAILS AS MEETING_DETAILS, " +
								         "MEETING.M_SUMMARY AS MEETING_SUMMARY ";
		
	// StudentDAOImpl 생성자
	public MeetingDAOImpl() {			
		jdbcUtil = new JDBCUtil();		// MeetingDAOImpl 객체 생성 시 JDBCUtil 객체 생성
	}
	
	@Override
	public List<MeetingDTO> getMeetingList() {
		// 기본 쿼리와 합쳐
				String allQuery = query + "FROM MEETING ORDER BY MEETING.M_ID ASC ";		
				jdbcUtil.setSql(allQuery);		// JDBCUtil 에 query 설정
				
				try { 
					ResultSet rs = jdbcUtil.executeQuery();		// query 문 실행			
					List<MeetingDTO> list = new ArrayList<MeetingDTO>();		// StudentDTO 객체들을 담기위한 list 객체
					while (rs.next()) {	
						MeetingDTO dto = new MeetingDTO();		// 하나의 StudentDTO 객체 생성 후 정보 설정
//						dto.setStuNo(rs.getString("STUDENT_NO"));
//						dto.setStuName(rs.getString("STUDENT_NAME"));
//						dto.setPwd(rs.getString("STUDENT_PASSWD"));
//						dto.setStuPhoneNo(rs.getString("STUDENT_PHONE_NO"));
//						dto.setYear(rs.getString("STUDENT_YEAR"));
//						dto.setProfCode(rs.getString("STUDENT_P_CODE"));
//						dto.setDeptCode(rs.getString("STUDENT_D_CODE"));
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
