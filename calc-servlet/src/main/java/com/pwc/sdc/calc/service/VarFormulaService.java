package com.pwc.sdc.calc.service;

import com.pwc.sdc.calc.vo.VarFormula;

public interface VarFormulaService {
	
	void saveVarFormula(VarFormula vf);
	
	Double calcResult(String varName);

}
