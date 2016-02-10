public class FibonacciTest {
	private static long result;
	public static void main(String[] args) {
		int n = 13;
		recursivefib(n);
		System.out.println(result);
		}
	
/**count the number of Fibonacci*/ 	
	public static long recursivefib(int n){
		if (n <= 0) return 0L; 
		else if(n == 1) return 1L;
		else {
			result = recursivefib(n-1)+recursivefib(n-2);
			return result;
			}
		}
}
