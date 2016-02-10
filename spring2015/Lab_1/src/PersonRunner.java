/** <p>javac -d ./build/classes ./src/PersonRunner.java </p>
* 	<p>java -cp ./build/classes PersonRunner</p>
*	<p>javap -c -cp ./build/classes PersonRunner</p>
*	<p>java -verbose:class -cp ./build/classes PersonRunner</p>
*/

public class PersonRunner {
//	private String LastName,FirstName,Birthday,
	String info;
	
	public PersonRunner(String LastName,String FirstName,String Birthday) {
		info=LastName+" "+FirstName+" "+Birthday;
		System.out.println(info);
	}

	public static void main(String []arg){
		String LastName="Riabchenko";
		String FirstName="Aliona";
		String Birthday="09-07-1983";
		PersonRunner person= new PersonRunner(LastName,FirstName,Birthday);
	}
}
