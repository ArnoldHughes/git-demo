package com.pwc.sdc.calc.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.pwc.sdc.calc.antlr.Calculator;
import com.pwc.sdc.calc.dao.VarFormulaDao;
import com.pwc.sdc.calc.dao.impl.VarFormulaDaoImpl;
import com.pwc.sdc.calc.service.VarFormulaService;
import com.pwc.sdc.calc.vo.VarFormula;

public class VarFormulaServiceImpl implements VarFormulaService {
	
	private List<VarFormula> varFormulaList = new ArrayList<VarFormula>();

	@Override
	public void saveVarFormula(VarFormula vf) {
		VarFormulaDao vfd = new VarFormulaDaoImpl();

		String formula = vf.getFormula();
		//System.out.println("the formula we get here is=========>>>" + formula);
		
		if("".equals(formula) || null == formula){
			vf.setChildVarName("");
			vfd.insertVarFormula(vf);
		} else {
			List<String> childVarsList = Calculator.getVariablesFromFormula(formula);
			
			for(String childVar : childVarsList){
				vf.setChildVarName(childVar);
				vfd.insertVarFormula(vf);
			}
		}
		
	}

	@Override
	public Double calcResult(String varName) {
		
		getAllChildNodes(varName);
		
		sortVarFormula();
		
		StringBuffer sb = new StringBuffer();
		int size = varFormulaList.size();
		for(int i = 0; i < size - 1; i++){
			if("".equals(varFormulaList.get(i).getFormula()) || null == varFormulaList.get(i).getFormula()){
				sb.append(varFormulaList.get(i).getVarName()).append("=").append(varFormulaList.get(i).getVarValue()).append("\n");
			} else {
				sb.append(varFormulaList.get(i).getVarName()).append("=").append(varFormulaList.get(i).getFormula()).append("\n");
			}
		}
		sb.append(varFormulaList.get(size - 1).getFormula());
		String str = sb.toString();
		HashMap<String, Double> result = null;
		try {
			result = Calculator.getResult(str, varName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		updateTable(result);
		
		return result.get(varName);
	}

	private void updateTable(HashMap<String, Double> result) {
		Set<String> keySet = result.keySet();
		VarFormulaDao vfd = new VarFormulaDaoImpl();
		for(String key : keySet){
			vfd.updateVarValueByVarName(String.valueOf(result.get(key)), key);
		}
		
	}

	private void sortVarFormula() {
		int size = varFormulaList.size();
		VarFormula vfTemp = new VarFormula();
		
		for(int i = 0; i < size; i++){
			for(int j = i; j < size; j++){
				if(varFormulaList.get(i).getVfId() > varFormulaList.get(j).getVfId()){
					vfTemp = varFormulaList.get(i);
					varFormulaList.set(i, varFormulaList.get(j));
					varFormulaList.set(j, vfTemp);
				}
			}
		}
		
	}

	private void getAllChildNodes(String varName) {
		
		VarFormulaDao vfd = new VarFormulaDaoImpl();
		List<VarFormula> selectByVarName = vfd.selectByVarName(varName);
		if("".equals(selectByVarName.get(0).getFormula()) || null == selectByVarName.get(0).getFormula()){
			//System.out.println("varFormula is =========>>>" + selectByVarName.get(0).getVarName());
			varFormulaList.add(selectByVarName.get(0));
		} else {
			varFormulaList.add(selectByVarName.get(0));
			//System.out.println("varFormula is =========>>>" + selectByVarName.get(0).getVarName());
			for(VarFormula vf : selectByVarName){
				getAllChildNodes(vf.getChildVarName());
			}
		}
	}

}
