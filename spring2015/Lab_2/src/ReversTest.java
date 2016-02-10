import java.lang.Math;

/**@author Riabchenko Aliona*/
/**<p>Class for  revers</p>*/ 

public class ReversTest {

	private static double maxNumber ;
	private static double minNumber;
	private static double sumNumber=0;
	private static double multiplyNumber=1;
	private static int sumNew;
	private static int multiplyNew;

	public static void main(String[] args) {
		int n = 5;
		createNumber(n);
		 		 
		}
	
/**<p> Create a min number</p>*/
	public static void min(int n){
		for(int i=1;i<=n;i++){
				double a=i*Math.pow(10,n-i);	
				minNumber= minNumber + a;
		}
	}
	
/**<p> Create a max number</p>*/
	public static void max(int n){
		int j=1;
		for(int i=n;i>0;i--){
				double a=i*Math.pow(10,n-j);	
				maxNumber = maxNumber + a;
				j++;
		}
	}

/**<p> Create a sum number</p>*/
	public static void sum(int n){
		for(int i=n;i>0;i--){	
				sumNumber = sumNumber + i;
		}
	}

/**<p> Numbers multiply</p>*/
	public static void multiply(int n){
		for(int i=1;i<=n;i++){	
				multiplyNumber = multiplyNumber * i;
		}
	}

/**<p> Expand the number</p>*/
	public static void expand(double i,int n){
		int num = 0;
		sumNew = 0;
		multiplyNew = 1;
		int j=1;
		while (i >0) {	
			num = (int) (i/Math.pow(10, n-j));
			i = i% Math.pow(10, n-j);	
			j++;
			if(num<=n){
			sumNew = sumNew + num;
			multiplyNew = multiplyNew * num;}
		}

	}
	
/**<p> Create number</p>*/
	public static void createNumber(int n){
		 min(n);
		 max(n);
		 sum(n);
		 multiply(n);
		 
		for(double i=minNumber;i<=maxNumber;i++){
			expand(i,n);
			if(sumNumber==sumNew && multiplyNumber==multiplyNew){
				System.out.println((int) i); //123
			}
		}
		
	}	
	
	
}
