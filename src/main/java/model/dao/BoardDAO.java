package model.dao;

import model.PostDTO;
import java.util.List;

public interface BoardDAO {
	public List<PostDTO> getPostList();
}
