package model.dao;

import java.util.List;

import model.FundingDTO;

import java.util.ArrayList;
import java.sql.*;

public class FundingDAOImpl implements FundingDAO {
	private JDBCUtil jdbcUtil = null;
	
	private static String query = "SELECT";
	
	public FundingDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}
	
	public List<FundingDTO> getFundingList() {
		return null;
		
	}

	@Override
	public FundingDTO getFundingByNo(String f_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FundingDTO> getFundingByName(String f_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertFunding(FundingDTO fun) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateFunding(FundingDTO fun) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteFunding(String f_id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
