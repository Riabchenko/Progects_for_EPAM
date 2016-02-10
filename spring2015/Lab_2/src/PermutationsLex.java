import java.util.ArrayList;

public class PermutationsLex {
	

		 
	private static int s;
	private static int n;

	//Main method
	 public static void main(String args[]) {
		 int n=3;
		 int first=1;
		 int rest=1;
		 vv(n);
		 String s1=String.valueOf(s);
	 String [] args1={s1};
	 if (args1.length!=1)
	 {
	 System.out.println("invalid input");
	 System.exit(0);
	 
	 }
	 
	 String inputStr=args1[0];
	 
	 System.out.println("Given Input :" + inputStr+"\n"); 
	 
	 ArrayList <String> result1 =new ArrayList<String>();
	 	 
	 findPermutation1(s,first,rest);
//	 findPermutation("", inputStr, result1);
	 
	 System.out.println(result1);	 	 
	 }

	 public static void vv(int n){
			for(int i=1;i<=n;i++){
					int a=(int) ((i)*Math.pow(10,n-i));	
					s=(int) ((int)s+a);
				int 	y=a/(int)Math.pow(10, n-i); 		
					System.out.print(y+",");		//1,2,3
			}
			System.out.println();	
			System.out.println(s); //123
		}

	//Method I
	 
	 public static void findPermutation(String first, String rest, ArrayList<String> resultArray) {
	 if (rest.length() <= 1)
	 resultArray.add(first+rest);
	 
	 else
	 for (int i = 0; i < rest.length(); i++) {
	 try {
	 String newString = rest.substring(0, i) + rest.substring(i + 1);
	 findPermutation(first + rest.charAt(i), newString, resultArray);
	 
	 } catch (Exception e) {
	 e.printStackTrace();
	 }
	 }
	 
	 }
	 
	 public static void findPermutation1(int first, int rest,int s) {
		 rest=first-n;
		 System.out.println(first+" "+rest);
		 if (rest <= 1)
		 System.out.println(first+rest);
		 
		 else
		 for (int i = 0; i < rest; i++) {
		 try {
//		 String newString = rest + rest.substring(i + 1);
//		 findPermutation1(first + rest, newString, resultArray);
		 
		 } catch (Exception e) {
		 e.printStackTrace();
		 }
		 }
		 
		 }
	 
//	 
	}

