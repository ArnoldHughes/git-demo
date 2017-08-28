package com.pwc.sdc.calc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pwc.sdc.calc.service.VarFormulaService;
import com.pwc.sdc.calc.service.impl.VarFormulaServiceImpl;
import com.pwc.sdc.calc.vo.VarFormula;

/**
 * Servlet implementation class VarFormulaController
 */
@WebServlet("/VarFormulaController")
public class VarFormulaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String choice = request.getParameter("choice");
		
		if("insert".equals(choice)){
			//System.out.println("=========now we do insert=========");
			
			String varName = request.getParameter("var_name");
			String formula = request.getParameter("formula");
			String varValue = request.getParameter("var_value");
			String varDescription = request.getParameter("var_description");
			VarFormula vf = new VarFormula();
			vf.setVarName(varName);
			vf.setFormula(formula);
			vf.setVarValue(varValue);
			vf.setVarDescription(varDescription);
			vf.setCreatedBy("arnold");
			
			VarFormulaService vfs = new VarFormulaServiceImpl();
			vfs.saveVarFormula(vf);
			
			request.getRequestDispatcher("calc.jsp").forward(request, response);
		} else if("calc".equals(choice)){
			String varName = request.getParameter("var_name");
			
			VarFormulaService vfs = new VarFormulaServiceImpl();
			Double result = vfs.calcResult(varName);
			
			request.setAttribute("result", result);
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}

}
