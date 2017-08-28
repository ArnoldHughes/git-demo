package com.pwc.sdc.calc.dao;

import java.util.List;

import com.pwc.sdc.calc.vo.VarFormula;

public interface VarFormulaDao {
	
	List<VarFormula> selectByVarName(String varName);
	
	int insertVarFormula(VarFormula vf);
	
	int updateVarValueByVarName(String varValue, String varName);

}
