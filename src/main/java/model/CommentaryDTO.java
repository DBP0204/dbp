package model;

public class CommentaryDTO {
	private int postId;
	private int commentId;
	private String custId;
	private String commentContent;
	private String commentDate;
	
	public CommentaryDTO() {  }

	public CommentaryDTO(int postId, int commentId, String custId, String commentContent, String commentDate) {
		super();
		this.postId = postId;
		this.commentId = commentId;
		this.custId = custId;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	
}
