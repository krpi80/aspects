
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.JoinPoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;


@Aspect
public class MyAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(MyAspect.class);

	@Before("execution (* a.Library.foo(..))")
	public void before(JoinPoint joinPoint) {
		LOGGER.info("Aspect before " + joinPoint);
	}

	@After("execution (* a.Library.foo(..))")
	public void after(JoinPoint joinPoint) {
		LOGGER.info("Aspect after {}, args: {}", joinPoint, Arrays.toString(joinPoint.getArgs()));

	}

}
