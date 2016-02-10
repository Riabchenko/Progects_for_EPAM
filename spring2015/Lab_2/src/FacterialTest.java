
public class FacterialTest {
	private int result;

/**фактериал числа*/	  
  	int fact(int n) {     
      if (n == 1)
          return 1;
      result = fact(n - 1) * n;
      return result;
  }
  
  public static void main(String [] arg){
  	int n=5;    
    FacterialTest f= new FacterialTest();
    f.fact(n);
    System.out.println(f.result);	
  }
	
}
