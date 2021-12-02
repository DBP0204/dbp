package model.dao;

import model.CommentaryDTO;

public interface CommentaryDAO {
	public int createComment(CommentaryDTO comm);
	public int deleteComment(int postId, int commId);
	public int updateComment(CommentaryDTO comm);
}
