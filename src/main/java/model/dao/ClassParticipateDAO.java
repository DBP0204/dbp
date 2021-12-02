package model.dao;

import java.util.List;

import model.ClassParticipateDTO;

public interface ClassParticipateDAO {
	public List<ClassParticipateDTO> getClassParticipateList();		// ��ü �а� ������ ȹ��
	public int participateClass(ClassParticipateDTO cla);	// �����ڰ� Ŭ���� ����
	public int cancelClass(ClassParticipateDTO cla);	// �����ڰ� Ŭ������ ������������ ���
}
