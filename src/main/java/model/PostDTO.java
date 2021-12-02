package model;

public class PostDTO {
	private int postId;
	private String custId;
	private String postTitle;
	private String postContent;
	private String postDate;
	
	public PostDTO() { }
	
	public PostDTO(int postId, String postTitle, String postContent, String custId, String postDate) {
		super();
		this.postId = postId;
		this.custId = custId;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postDate = postDate;
	}
	
	public PostDTO(String postTitle, String postContent, String custId, String postDate) {
		super();
		this.custId = custId;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postDate = postDate;
	}

	public PostDTO(String postTitle, String postContent) {
		super();
		this.postTitle = postTitle;
		this.postContent = postContent;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	
	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	
}
