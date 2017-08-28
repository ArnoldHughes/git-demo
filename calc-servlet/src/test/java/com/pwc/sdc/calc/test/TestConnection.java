package com.pwc.sdc.calc.test;

import java.util.List;

import com.pwc.sdc.calc.dao.VarFormulaDao;
import com.pwc.sdc.calc.dao.impl.VarFormulaDaoImpl;
import com.pwc.sdc.calc.vo.VarFormula;

public class TestConnection {
	
	public static void main(String[] args) {
		VarFormulaDao vfd = new VarFormulaDaoImpl();
		List<VarFormula> varFormulaList = vfd.selectByVarName("test1");
		for(VarFormula vf : varFormulaList){
			System.out.println(vf.getVfId());
		}
		
	}

}
