package spring;

public class MainProxy {

	public static void main(String[] args) {
		ExecuteTimeCalculator c1 = new ExecuteTimeCalculator(new ImplCalculator());
		System.out.println(c1.factorial(10));
		
		ExecuteTimeCalculator c2 = new ExecuteTimeCalculator(new ImplCalculator());
		System.out.println(c2.factorial(10));

	}

}
