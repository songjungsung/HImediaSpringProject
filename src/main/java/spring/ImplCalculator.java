package spring;

public class ImplCalculator implements Calculator {

	@Override
	public long factorial(long num) {
		long start = System.nanoTime();
		
		long result = 1;
		for (long i = num; i >= 1; i--) {
			result *= i;
		}
		
		long end = System.nanoTime();
		System.out.printf("ImplCalculator.factorial(%d) 실행시간 = %d\n",
				num, (end - start));
		return result;
	}
	public static void main(String[] args) {
		ImplCalculator c = new ImplCalculator();
		c.factorial(10);
		c.factorial(100);
	}

}
