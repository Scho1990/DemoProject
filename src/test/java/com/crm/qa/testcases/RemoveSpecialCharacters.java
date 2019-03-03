package com.crm.qa.testcases;

public class RemoveSpecialCharacters {

	public static void main(String a[]) {
		
		String str="102.5K items found";
		
		str=str.replaceAll("[^0-9]", "");
		System.out.println(str);

	}
}
