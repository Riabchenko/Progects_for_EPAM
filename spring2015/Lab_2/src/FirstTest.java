public class FirstTest {
	private static int mirrorOfResult;
	private static int countOfNumbers;
	private static int c;


	
/**подсчитывает количество цифр в числе*/	
	public static int countNumber(int number){		
		countOfNumbers = 0;
		for (  ; number != 0 ; number /= 10)
		    ++countOfNumbers;
		return countOfNumbers;
	}

/**возвращает число, записанное наоборот*/	
	public static int mirrorNumber(int number){				
		 mirrorOfResult = 0;
     do {
    	 mirrorOfResult = mirrorOfResult * 10 + number % 10;         
     } while ((number /= 10) != 0);
     return mirrorOfResult;		
	}

/**возводит число в степень*/	
  public static int pow(int x, int y) {
    if (y > 1){
    		c=x * pow(x, y - 1);
        return c;
        }
    else if (y == 1)
        return x;
    else if (y == 0)
        return 1;
    else
        return 0;
}

	public static void main(String[] args) {
		int number = 123;
		
		countNumber( number);
		System.out.println(number+" => count of numbers "+countOfNumbers);
		
		mirrorNumber( number);
    System.out.println(number+" => mirror of result "+mirrorOfResult);
    
    int x=10;
    int y=3;
    pow( x, y);
    System.out.println(x+" pow "+y+" = "+c);

    }
}
