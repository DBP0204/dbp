package model;

public class CategoryDTO {
	private String cate_id = null;
	private String cate_name = null;

	public CategoryDTO() {
		super();
	}

	public CategoryDTO(String cate_id, String cate_name) {
		super();
		this.cate_id = cate_id;
		this.cate_name = cate_name;
	}
	
	public String getCate_id() {
		return cate_id;
	}
	public void setCate_id(String cate_id) {
		this.cate_id = cate_id;
	}
	public String getCate_name() {
		return cate_name;
	}
	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}
	
	
}
