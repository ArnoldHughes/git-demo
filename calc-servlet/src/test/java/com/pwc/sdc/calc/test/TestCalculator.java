package com.pwc.sdc.calc.test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import com.pwc.sdc.calc.antlr.CalculatorBaseVisitorImpl;
import com.pwc.sdc.calc.antlr.generated.CalculatorLexer;
import com.pwc.sdc.calc.antlr.generated.CalculatorParser;

public class TestCalculator {

	public static void main(String[] args) throws IOException {
		ANTLRInputStream input = new ANTLRInputStream("a=1\nb=2\nc=3\na+b-c");
        Date date = new Date(System.currentTimeMillis());
        System.out.println("time begin============>" + date);
        
        getResult(input);

        Date date1 = new Date(System.currentTimeMillis());
        System.out.println("time begin============>" + date1);

	}
	
	public static void getResult(ANTLRInputStream input){
        CalculatorLexer lexer = new CalculatorLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();
        

        /*List<Token> tokensList = tokens.getTokens();
        for(Token token : tokensList){
        	if(token.getType() == 8){
        		System.out.println(token.getText());
        	}
        }
        */

        CalculatorParser parser = new CalculatorParser(tokens);
        //parser.r();
        ParseTree tree = parser.input();
        
        //System.out.println(tree.toString());

        CalculatorBaseVisitorImpl calcVisitor = new CalculatorBaseVisitorImpl();
        
        //calcVisitor.visitVariable(ctx);
        Double result = calcVisitor.visit(tree);
        System.out.println("Result: " + result);
    }

}
