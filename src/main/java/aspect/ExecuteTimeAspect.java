package aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ExecuteTimeAspect {
	
	// 공통 기능을 적용할 대상을 설정
	// sping 패키지와 그 하위 패키지에 위치한 public 메서드를 Pointcut으로 설정
	@Pointcut("execution(public * spring..*(..))")
	private void publicTarget() {
		
	}
	
	// Around Advice를 설정
	// publicTarget() 메서드에 정의한 Pointcut에 공통 기능을 적용
	// measure => 사용자 정의 메서드 => 공통 기능을 구현
	// ProceedingJoinPoint => 프록시 대상 객체의 메서드를 호출할 때 사용 
	@Around("publicTarget()")
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.nanoTime();
		try {
			// 실제 대상 객체의 메서드를 실행
			Object result = joinPoint.proceed();
			return result;
		} finally {
			long end = System.nanoTime();
			System.out.printf("%s.%s(%s) 실행시간 = %dns\n", 
					joinPoint.getTarget().getClass().getSimpleName(), 
					joinPoint.getSignature().getName(),
					Arrays.toString(joinPoint.getArgs()),
					(end - start));
		}
	}
}

