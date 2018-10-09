package com.sunway.monitor.usage;

public class StringTest {

	public static void main(String[] args) {
	
		String test = "hello \n good test 12123\n 343434 ";
		
		String[] array = test.split("\n");
		
		for(String s : array)
		System.out.println(s);

	}

}
