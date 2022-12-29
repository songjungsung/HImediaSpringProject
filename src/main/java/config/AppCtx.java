package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import aspect.ExecuteTimeAspect;
import spring.Calculator;
import spring.ImplCalculator;
import spring.RecuCalculator;

@Configuration
@EnableAspectJAutoProxy
public class AppCtx {

	@Bean
	public ExecuteTimeAspect executeTimeAspect() {
		return new ExecuteTimeAspect();
		
	}
	
	@Bean
	public Calculator recucalculator() {
		return new RecuCalculator();
	}
	
	@Bean
	public Calculator implcalculator() {
		return new ImplCalculator();
	}//aa
}
