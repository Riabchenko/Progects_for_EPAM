import java.lang.Math;

/**@author Riabchenko Aliona*/
/**<p>Class for count the function</p>*/ 

public class MathTest {
	private static double result;
	public static void main(String[] args) {
	  function();
	  if(result==-1.0){
	  	System.out.println("Invalid value for x");
	  }else{
	  	System.out.println(result);
			}
		}
	
/**<p>count the function</p>*/ 	
	public static double function(){
			Double x = 4.1;
			Double a = 2.0;
			if(x-4>0){
			result = Math.log(2)*(x-4)+Math.exp(2*a+x);
			}else{
				result=-1.0;
			}
			return result;			
		}
}
