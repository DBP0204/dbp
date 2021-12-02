package model.dao;

import java.util.List;

import model.ClassParticipateDTO;

public interface ClassParticipateDAO {
	public List<ClassParticipateDTO> getClassParticipateList();		// 전체 학과 정보를 획득
	public int participateClass(ClassParticipateDTO cla);	// 참여자가 클래스 참여
	public int cancelClass(ClassParticipateDTO cla);	// 참여자가 클래스를 참여내역에서 취소
}
