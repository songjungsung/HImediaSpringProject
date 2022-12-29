package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import spring.Calculator;
import spring.ImplCalculator;
import spring.RecuCalculator;

public class MainAspect {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

		Calculator c = ctx.getBean("recucalculator", RecuCalculator.class);
		System.out.println(c.factorial(10));
		System.out.println(c.getClass().getName());
		
		Calculator c2 = ctx.getBean("implcalculator", ImplCalculator.class);
		System.out.println(c2.factorial(10));
		System.out.println(c2.getClass().getName());

	}

}
