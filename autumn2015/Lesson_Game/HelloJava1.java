import java.io.*;

/*
* Output "Hello, Java!"
*
* @author Riabchenko Aliona
* @version 1.00 18 Oct 2015
*
* Result:
*
* MacBook-Pro-Apple:Documents apple$ javac HelloJava1.java
* MacBook-Pro-Apple:Documents apple$ java HelloJava1
* Hello, Java!
*
* MacBook-Pro-Apple:Documents apple$ javac HelloJava1.java
* MacBook-Pro-Apple:Documents apple$ java HelloJava1
* Enter sentence: 
* Hello, Java!
* You wrote: Hello, Java!
*
*/

/**
* First example "Hello, Java!"
*/
// public class HelloJava1 {
// 
// 	public static void main (String [] args) {
//     	System.out.println("Hello, Java!");
//     }
// }

/**
* Second example "Hello, Java!" (input from keyboard)
*/
public class HelloJava1 {
	
	public static void main (String [] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader buf = new BufferedReader(isr);
		try{
			System.out.println("Enter sentence: ");
			String sentence = buf.readLine();
			System.out.println("You wrote: "+sentence);
		} catch (IOException e){
			System.out.println("Error! "+e);
		}
	}
}
