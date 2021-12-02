package model;

public class FundingDTO {
	private String f_id;
	private String f_name;
	private int targetAmount;
	private int currentAmount;
	private float progressRate;
	private String f_details;
	private String f_summary;
	
	public FundingDTO() {
		super();
	}
	public FundingDTO(String f_id, String f_name, int targetAmount, int currentAmount, float progressRate,
			String f_details, String f_summary) {
		super();
		this.f_id = f_id;
		this.f_name = f_name;
		this.targetAmount = targetAmount;
		this.currentAmount = currentAmount;
		this.progressRate = progressRate;
		this.f_details = f_details;
		this.f_summary = f_summary;
	}
	public String getF_id() {
		return f_id;
	}
	public void setF_id(String f_id) {
		this.f_id = f_id;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public int getTargetAmount() {
		return targetAmount;
	}
	public void setTargetAmount(int targetAmount) {
		this.targetAmount = targetAmount;
	}
	public int getCurrentAmount() {
		return currentAmount;
	}
	public void setCurrentAmount(int currentAmount) {
		this.currentAmount = currentAmount;
	}
	public float getProgressRate() {
		return progressRate;
	}
	public void setProgressRate(float progressRate) {
		this.progressRate = progressRate;
	}
	public String getF_details() {
		return f_details;
	}
	public void setF_details(String f_details) {
		this.f_details = f_details;
	}
	public String getF_summary() {
		return f_summary;
	}
	public void setF_summary(String f_summary) {
		this.f_summary = f_summary;
	}
	
	
}
