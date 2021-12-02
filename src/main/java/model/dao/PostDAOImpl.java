package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CommentaryDTO;
import model.PostDTO;

public class PostDAOImpl implements PostDAO {
	
	private JDBCUtil jdbcUtil = null;
	
	public PostDAOImpl() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
	
	@Override
	public int createPost(PostDTO post) {
		String sql = "INSERT INTO Post VALUES (seq_post.nextval, ?, ?, ?, ?)";
		Object[]param = new Object[] {post.getPostTitle(), post.getPostContent(), post.getCustId(), post.getPostDate()};
		jdbcUtil.setSqlAndParameters(sql, param);
		
		String key[] = {"post_id"};
		try {
			jdbcUtil.executeUpdate(key);
			ResultSet rs = jdbcUtil.getGeneratedKeys();
			if (rs.next()) {
				int generatedKey = rs.getInt(1);
				post.setPostId(generatedKey);
			}
			return 1;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}
		return 0;
	}
	@Override
	public int deletePost(int postId) {
		String sql = "DELETE FROM Post WHERE post_id=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {postId});
		
		try {
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return 0;
	}
	@Override
	public int updatePost(PostDTO post) {
		String sql = "UPDATE Post "
				+ "SET post_title=?, post_content=?, post_date=? "
				+ "WHERE post_id=?";
		Object[] param = new Object[] {post.getPostTitle(), post.getPostContent(), post.getPostDate(), post.getPostId()};
		jdbcUtil.setSqlAndParameters(sql,param);
		
		try {
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return 0;
	}
	@Override
	public PostDTO findPost(int postId) {
		String sql = "SELECT post_id, post_title, post_content, cust_id, post_date "
				+ "FROM Post WHERE post_id=? ";
		Object[] param = new Object[] {postId};
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 update문과 매개 변수 설정
		
		PostDTO post = null;
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
						post = new PostDTO(
						rs.getInt("post_id"),
						rs.getString("post_title"),
						rs.getString("post_content"),
						rs.getString("cust_id"),
						rs.getString("post_date"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return post;
	}
	@Override
	public List<CommentaryDTO> getCommentaryList(int postId) {
		String sql = "SELECT post_id, comment_id, cust_id, comment_content, comment_date "
				+ "FROM Commentary c JOIN Post p ON c.post_id = p.post_id ";
		jdbcUtil.setSqlAndParameters(sql, null);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<CommentaryDTO> commList = new ArrayList<CommentaryDTO>();
			while (rs.next()) {
				CommentaryDTO comment = new CommentaryDTO(
						rs.getInt("post_id"),
						rs.getInt("comment_id"),
						rs.getString("cust_id"),
						rs.getString("comment_content"),
						rs.getString("comment_date"));
				commList.add(comment);
			}
			return commList;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

}
