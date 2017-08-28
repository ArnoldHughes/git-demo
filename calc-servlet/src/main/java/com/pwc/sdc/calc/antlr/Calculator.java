package com.pwc.sdc.calc.antlr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import com.pwc.sdc.calc.antlr.generated.CalculatorLexer;
import com.pwc.sdc.calc.antlr.generated.CalculatorParser;

public class Calculator {
	
	public static List<String> getVariablesFromFormula(String formula){
		List<String> varNameList = new ArrayList<String>();

		ANTLRInputStream input = new ANTLRInputStream(formula);
		
		CalculatorLexer lexer = new CalculatorLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();

        List<Token> tokenList = tokens.getTokens();
        for(Token token : tokenList){
        	if(token.getType() == 8){
        		varNameList.add(token.getText());
        	}
        }
		
		return varNameList;
	}
	
	public static HashMap<String,Double> getResult(String str, String varName) throws IOException{
		ANTLRInputStream input = new ANTLRInputStream(str);
		
		CalculatorLexer lexer = new CalculatorLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalculatorParser parser = new CalculatorParser(tokens);
        ParseTree tree = parser.input();

        CalculatorBaseVisitorImpl calcVisitor = new CalculatorBaseVisitorImpl();
        Double result = calcVisitor.visit(tree);
        HashMap<String,Double> variables = calcVisitor.getVariables();
        variables.put(varName, result);
        
        return variables;
		
	}

}
