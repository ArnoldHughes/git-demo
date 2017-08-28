package com.pwc.sdc.calc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pwc.sdc.calc.dao.VarFormulaDao;
import com.pwc.sdc.calc.util.DBOperator;
import com.pwc.sdc.calc.vo.VarFormula;

public class VarFormulaDaoImpl implements VarFormulaDao {

	@Override
	public List<VarFormula> selectByVarName(String varName) {
		List<VarFormula> varFormulaList = new ArrayList<VarFormula>();
		
		Connection connection = DBOperator.getConnection();
		
		String sql = "SELECT * FROM data_calc.var_formula where var_name = ?";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, varName);
			
			rs = ps.executeQuery();
			while(rs.next()){
				VarFormula vf = new VarFormula(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8), rs.getString(9), rs.getDate(10), rs.getString(11));
				varFormulaList.add(vf);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBOperator.closeAll(rs, ps, connection);
		}
		
		return varFormulaList;
	}

	@Override
	public int insertVarFormula(VarFormula vf) {
		int rowAffected = 0;
		
		Connection connection = DBOperator.getConnection();
		
		//String sql = "insert into data_calc.var_formula (var_name, formula, child_var_name, var_value, var_description, created_by, status) values(?, ?, ?, ?, ?, ?, '0')";
		
		/*PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, vf.getVarName());
			ps.setString(2, vf.getFormula());
			ps.setString(3, vf.getChildVarName());
			ps.setString(4, vf.getVarValue());
			ps.setString(5, vf.getVarDescription());
			ps.setString(6, vf.getCreatedBy());
			
			rowAffected = ps.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBOperator.closeAll(null, ps, connection);
		}*/
		

		String sql = "insert into data_calc.var_formula (var_name, formula, child_var_name, var_value, var_description, created_by, status) "
				+ "values('"
				+ vf.getVarName()
				+"', '"
				+ vf.getFormula()
				+ "', '"
				+ vf.getChildVarName()
				+ "', '"
				+ vf.getVarValue()
				+ "', '"
				+ vf.getVarDescription()
				+ "', '"
				+ vf.getCreatedBy()
				+ "', '0')";
		
		Statement statement = null;
		try {
			statement = connection.createStatement();
			boolean execute = statement.execute(sql);
			if(execute){
				rowAffected = 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return rowAffected;
	}

	@Override
	public int updateVarValueByVarName(String varValue, String varName) {
		int rowAffected = 0;
		
		Connection connection = DBOperator.getConnection();
		
		/*String sql = "update data_calc.var_formula set var_value = ? where var_name = ?";
		
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, varValue);
			ps.setString(2, varName);
			
			rowAffected = ps.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBOperator.closeAll(null, ps, connection);
		}*/
		
		String sql = "update data_calc.var_formula set var_value = '"
				+ varValue
				+ "' where var_name = '"
				+ varName
				+"'";
		
		Statement statement = null;
		try {
			statement = connection.createStatement();
			boolean execute = statement.execute(sql);
			if(execute){
				rowAffected = 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return rowAffected;
	}

}
