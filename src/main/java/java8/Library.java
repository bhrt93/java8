/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package java8;

enum Idea {
	Bharat, has, a, plan;
}

public class Library {
    public boolean someLibraryMethod() {
    	String s1 = "abc";
    	String s2 = new String("abc");
    	s2 = s2.intern();
    	System.out.println(s1 ==s2);
		return s1 ==s2;
    }
    public static void main(String[] args) {
		Library library = new Library();
		library.someLibraryMethod();
		Idea idea = Idea.valueOf("has");
		System.out.println(idea.name());
	}
}