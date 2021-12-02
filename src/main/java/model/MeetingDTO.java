package model;

/* 미팅 관리를 위해 필요한 도메인 클래스. Meeting 테이블과 대응됨 */

public class MeetingDTO {
	private String id;
	private String cate_id;
	private String local;
	private String personnel;
	private String name;
	private String customer_id;
	private String details;
	private String summary;
	
	public MeetingDTO() { } // 기본 생성자

	public MeetingDTO(String id, String cate_id, String local, String personnel, String name, String customer_id,
			String details, String summary) {
		super();
		this.id = id;
		this.cate_id = cate_id;
		this.local = local;
		this.personnel = personnel;
		this.name = name;
		this.customer_id = customer_id;
		this.details = details;
		this.summary = summary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCate_id() {
		return cate_id;
	}

	public void setCate_id(String cate_id) {
		this.cate_id = cate_id;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getPersonnel() {
		return personnel;
	}

	public void setPersonnel(String personnel) {
		this.personnel = personnel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

}
