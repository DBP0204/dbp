package model.dao;

import model.PostDTO;

import java.util.List;

import model.CommentaryDTO;

public interface PostDAO {
   public int createPost(PostDTO post);
   public int deletePost(int postId);
   public int updatePost(PostDTO post);
   public PostDTO findPost(int postId); // 게시글 찾기
   public List<CommentaryDTO> getCommentaryList(int postId); // 댓글 목록 보여주기
}