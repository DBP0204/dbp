package model;

/**
 * 사용자 관리를 위해 필요한 도메인 클래스. USERINFO 테이블과 대응됨
 */
public class CustomerDTO {
   private String cust_id;
   private String name;
   private String password;
   private String address;
   private String email;
   private String phone;
   private String local;
   private String interest;
   private String gender;
   private String birth;
   
   public CustomerDTO() {
	   super();
   }

   public CustomerDTO(String cust_id, String name, String password, String address, String email, String phone,
		String local, String interest, String gender, String birth) {
		super();
		this.cust_id = cust_id;
		this.name = name;
		this.password = password;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.local = local;
		this.interest = interest;
		this.gender = gender;
		this.birth = birth;
   }

	public String getCust_id() {
		return cust_id;
	}
	
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getLocal() {
		return local;
	}
	
	public void setLocal(String local) {
		this.local = local;
	}
	
	public String getInterest() {
		return interest;
	}
	
	public void setInterest(String interest) {
		this.interest = interest;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getBirth() {
		return birth;
	}
	
	public void setBirth(String birth) {
		this.birth = birth;
	}

	/* 비밀번호 검사 */
	public boolean matchPassword(String password) {
		if (password == null) {
			return false;
		}
		return this.password.equals(password);
	}
	
	public boolean isSameUser(String userid) {
        return this.cust_id.equals(userid);
    }
}