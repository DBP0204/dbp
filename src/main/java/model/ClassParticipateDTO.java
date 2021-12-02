package model;

import java.util.Date;
//참여관계 DTO
public class ClassParticipateDTO {
	private String c_id = null;
	private String c_name = null;
	private Date c_date = null;
	private String cust_id = null;
	private String cust_name = null;
	
	public ClassParticipateDTO() {
		super();
	}
	
	public ClassParticipateDTO(String c_id, String c_name, Date c_date, String cust_id, String cust_name) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.c_date = c_date;
		this.cust_id = cust_id;
		this.cust_name = cust_name;
	}
	
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public Date getC_date() {
		return c_date;
	}
	public void setC_date(Date c_date) {
		this.c_date = c_date;
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	} 
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	} 

	
}
