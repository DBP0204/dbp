package model.dao;

import java.util.List;
import model.FundingDTO;

public interface FundingDAO {
	public List<FundingDTO> getFundingList();
	public FundingDTO getFundingByNo(String f_id);
	public List<FundingDTO> getFundingByName(String f_name);
	public int insertFunding(FundingDTO fun);
	public int updateFunding(FundingDTO fun);
	public int deleteFunding(String f_id);
}
