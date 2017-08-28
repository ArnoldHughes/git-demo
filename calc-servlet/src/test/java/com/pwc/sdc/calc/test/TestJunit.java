package com.pwc.sdc.calc.test;

import org.junit.Test;

public class TestJunit {
	
	@Test
	public void testMathFunction(){
		long round = Math.round(23.556);
		System.out.println(round);
	}

}
