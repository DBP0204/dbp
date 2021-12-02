package model.dao;

import java.sql.ResultSet;

import model.CommentaryDTO;

public class CommentaryDAOImpl {
	
	private JDBCUtil jdbcUtil = null;		// JDBCUtil 객체를 지정하기 위한 변수
	// StudentDAOImpl 생성자
	public CommentaryDAOImpl() {			
		jdbcUtil = new JDBCUtil();		// StudentDAOImpl 객체 생성 시 JDBCUtil 객체 생성
	}
	
	public int createComment(CommentaryDTO comm) {
		String sql = "INSERT INTO Commentary VALUES (seq_comm.nextval, ?, ?, ?, ?)";
		Object[] param = new Object[] {comm.getPostId(), comm.getCommentContent(), comm.getCustId(), comm.getCommentDate()};
		jdbcUtil.setSqlAndParameters(sql, param);
		
		String key[] = {"com_id"};
		try {
	         jdbcUtil.executeUpdate(key);
	         ResultSet rs = jdbcUtil.getGeneratedKeys();
	         if (rs.next()) {
	            int generatedKey = rs.getInt(1);
	            comm.setCommentId(generatedKey);
	         }
	         return 1;
	      } catch (Exception ex) {
	         jdbcUtil.rollback();
	         ex.printStackTrace();
	      } finally {
	         jdbcUtil.commit();
	         jdbcUtil.close();   // resource 반환
	      }
	      return 0;
	}
	public int deleteComment(int postId, int commId) {
		String sql = "DELETE FROM Commentary WHERE post_id=? and com_id=?";
	      jdbcUtil.setSqlAndParameters(sql, new Object[] {postId, commId});
	      
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
	public int updateComment(CommentaryDTO comm) {
		String sql = "UPDATE Commentary "
	            + "SET com_content=?, post_date=? "
	            + "WHERE post_id=? and com_id=?";
	      Object[] param = new Object[] {comm.getCommentContent(), comm.getCommentDate(), comm.getPostId(), comm.getCommentId()};
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
}
