package model;


//개설관계
public class ClassDTO {
   private int c_id = 0;
   private String c_name = null;
   private int c_personnel = 0;
   private String c_date = null;
   private int c_isOnline = 0;;
   private String c_local = null;
   private String c_summary = null;
   private String c_detail = null;
   private int c_price = 0;
   private String c_file = null;
   
   private String cate_id = null;
   private String cust_id = null;
   
   public ClassDTO() {
      super();
   }
  
   public ClassDTO(int c_id, String c_name, String c_local, int c_price, String c_file) {
	super();
	this.c_id = c_id;
	this.c_name = c_name;
	this.c_local = c_local;
	this.c_price = c_price;
	this.c_file = c_file;
}

public ClassDTO(int c_id, String c_name, int c_personnel, String c_date, int c_isOnline, String c_local, String c_summary,
		String c_detail, int c_price, String c_file) {
	super();
	this.c_id = c_id;
	this.c_name = c_name;
	this.c_personnel = c_personnel;
	this.c_date = c_date;
	this.c_isOnline = c_isOnline;
	this.c_local = c_local;
	this.c_summary = c_summary;
	this.c_detail = c_detail;
	this.c_price = c_price;
	this.c_file = c_file;
   }
   
 public ClassDTO(int c_id, String c_name, int c_personnel, String c_date, int c_isOnline, String c_local, String c_summary,
		String c_detail, int c_price, String c_file, String cate_id, String cust_id) {
	super();
	this.c_id = c_id;
	this.c_name = c_name;
	this.c_personnel = c_personnel;
	this.c_date = c_date;
	this.c_isOnline = c_isOnline;
	this.c_local = c_local;
	this.c_summary = c_summary;
	this.c_detail = c_detail;
	this.c_price = c_price;
	this.c_file = c_file;
	this.cate_id = cate_id;
	this.cust_id = cust_id;
}

public int getC_id() {
      return c_id;
   }

   public void setC_id(int c_id) {
      this.c_id = c_id;
   }

   public String getC_name() {
      return c_name;
   }

   public void setC_name(String c_name) {
      this.c_name = c_name;
   }

   public int getC_personnel() {
      return c_personnel;
   }

   public void setC_personnel(int c_personnel) {
      this.c_personnel = c_personnel;
   }

   public String getC_date() {
      return c_date;
   }

   public void setC_date(String c_date) {
      this.c_date = c_date;
   }

   public int getC_isOnline() {
      return c_isOnline;
   }

   public void setC_isOnline(int c_isOnline) {
      this.c_isOnline = c_isOnline;
   }

   public String getC_local() {
      return c_local;
   }

   public void setC_local(String c_local) {
      this.c_local = c_local;
   }

   public String getC_summary() {
      return c_summary;
   }

   public void setC_summary(String c_summary) {
      this.c_summary = c_summary;
   }

   public String getC_detail() {
      return c_detail;
   }

   public void setC_detail(String c_detail) {
      this.c_detail = c_detail;
   }
   
   public int getC_price() {
      return c_price;
   }

   public void setC_price(int c_price) {
      this.c_price = c_price;
   }

   public String getC_file() {
      return c_file;
   }

   public void setC_file(String c_file) {
      this.c_file = c_file;
   }

   public String getCate_id() {
      return cate_id;
   }

   public void setCate_id(String cate_id) {
      this.cate_id = cate_id;
   }

   public String getCust_id() {
      return cust_id;
   }

   public void setCust_id(String cust_id) {
      this.cust_id = cust_id;
   }
   
}