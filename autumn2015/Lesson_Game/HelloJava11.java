
/*
* Output "Hello, Java!"
*
* @author Riabchenko Aliona
* @version 1.00 18 Oct 2015
*
* Result:
*
* MacBook-Pro-Apple:Documents apple$ javac HelloJava11.java
* MacBook-Pro-Apple:Documents apple$ java HelloJava11
* Hello, Java!
*
* MacBook-Pro-Apple:Documents apple$ javac HelloJava11.java
* MacBook-Pro-Apple:Documents apple$ java HelloJava11
* Input 'Hello, Java' in command line!0
*
* MacBook-Pro-Apple:Documents apple$ javac HelloJava11.java
* MacBook-Pro-Apple:Documents apple$ java HelloJava11
* MacBook-Pro-Apple:Documents apple$ java HelloJava11 Hello,Java!
* You wrote: Hello,Java!
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
public class HelloJava11 {
	
	public static void main (String [] args) {	
		try{
			System.out.println("You wrote: "+args[0]);
		} catch (Exception e){
			System.out.println("Input 'Hello, Java' in command line!"+e.getMessage());
		}
	}
}
