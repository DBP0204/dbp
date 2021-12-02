package model.dao;

import java.util.List;
import model.MeetingDTO;

public interface MeetingDAO {
	public List<MeetingDTO> getMeetingList();
	public List<MeetingDTO> getMeetingListByCateName();
	public MeetingDTO getMeetingById(String meeting_id);
	public int openMeeting(MeetingDTO m);
	public int updateMeeting(MeetingDTO m);
	public int deleteMeeting(MeetingDTO m);
	public int sendInvitation(); // 초대장 보내기
	public List<MeetingDTO> receivedInvitation(String customer_id); // 초대장 내역
	public List<MeetingDTO> meetingParticipation(String customer_id); // 모임 참여 내역
	//메신저?
}
