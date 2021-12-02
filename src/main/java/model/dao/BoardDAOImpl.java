package model.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import model.PostDTO;

public class BoardDAOImpl implements BoardDAO {
	
	private JDBCUtil jdbcUtil = null;		// JDBCUtil ��ü�� �����ϱ� ���� ����
	// StudentDAOImpl ������
	public BoardDAOImpl() {			
		jdbcUtil = new JDBCUtil();		// StudentDAOImpl ��ü ���� �� JDBCUtil ��ü ����
	}

	@Override
	public List<PostDTO> getPostList() {
		String sql = "SELECT post_id, post_title, post_content, cust_id, post_date "
				+ "FROM POST ";
		jdbcUtil.setSql(sql);
		List<PostDTO> list = new ArrayList<PostDTO>();
		PostDTO post = null;
		try {
			ResultSet rs = jdbcUtil.executeQuery();		
			while (rs.next()) {
				post = new PostDTO(
						rs.getInt("post_id"),
						rs.getString("post_title"),
						rs.getString("post_content"),
						rs.getString("cust_id"),
						rs.getString("post_date"));
				list.add(post);
			}
			return list;			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

}
