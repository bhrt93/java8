package java8.oops;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import junit.framework.Assert;

enum DaysOff {
	Thanksgiving, PresidentsDay, ValentinesDay
}

public class EnumSwitch {
	
	static boolean isValid(String s) {
		int x = s.length();
		s = s.replaceAll("\\(\\)|\\[\\]|\\{\\}", "");
		return s.length() == x ? false : s.length() < 1 || isValid(s);
	}
	
	public static boolean isValid1(String braces) {
	    java.util.Map<Character, Character> matchers = new HashMap();
	    matchers.put(')','(');
	    matchers.put(']','[');
	    matchers.put('}','{');
	    java.util.Stack<Character> s = new java.util.Stack();
	    for(int i=0;i<braces.length();i++){
	      if(null==matchers.get(braces.charAt(i))) {
	        s.push(braces.charAt(i));
	      } else {
	        if(s.empty() || !s.pop().equals(matchers.get(braces.charAt(i))))
	          return false;
	      }
	    }
		return (s.empty()?true:false);
	  }
	public static void main(String... unused) {
		
		//System.out.println(isValid("()"));
		Assert.assertEquals(false, isValid("["));
		Assert.assertEquals(false, isValid("]"));
		Assert.assertEquals(false, isValid("[(])"));
		Assert.assertEquals(true, isValid("(){}[]"));
		Assert.assertEquals(true, isValid("([{}])"));
		Assert.assertEquals(false, isValid("(}"));
		Assert.assertEquals(false, isValid("[(])"));
		Assert.assertEquals(false, isValid("[({})](]"));
		
		
		double d= Math.pow(0, -1);
		Long l = Double.valueOf(Math.pow(0, -1)).longValue();
		Long l2 = Long.MAX_VALUE;
		
		
		final DaysOff input = DaysOff.Thanksgiving;
		Stack<Character> s = new Stack<Character>();
	    Map<Character, Character> matchers = new HashMap();
	    matchers.put(')','(');
	    matchers.put(']','[');
	    matchers.put('}','{');
	    matchers.get('9');
		switch (input) {
		default:
		case ValentinesDay:
			System.out.print("1");
//		case DaysOff.PresidentsDay:// incorrectly use the enum name as well as the value 
//			System.out.print("2");
		}
	}
}

