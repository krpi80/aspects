
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.JoinPoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.SharedMetricRegistries;

@Aspect
public class MyAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(MyAspect.class);

	//private final MetricRegistry metric = new MetricRegistry();
	private final String name;

	private final MetricRegistry metrics = SharedMetricRegistries.getOrCreate("performance");

	public MyAspect() {
		this.name = "NOT DEFINED";
	}

	public MyAspect(final String name) {
		this.name = name;
	}

	@Pointcut("execution (* a.Library.foo(..))")
	void libfoo(){}

	@Before("execution (* a.Library.foo(..))")
	public void before(JoinPoint joinPoint) {
		LOGGER.info("Aspect before " + name + " " + joinPoint);
		System.setProperty("aspect", "true");
	}

	@After("execution (* a.Library.foo(..))")
	public void after(JoinPoint joinPoint) {
		LOGGER.info("Aspect after " + name + "{}, args: {}", joinPoint, Arrays.toString(joinPoint.getArgs()));
		System.setProperty("aspect", "true");
	}

	/*@Around("libfoo") 
	public Object aroundFoo(ProceedingJointPoint jp) throws Throwable {
		if (Boolean.getBoolean("perfLoggerEnabled")) {
			Context ctx = metrics.timer(name("perf", jp.getStaticPart().getShortName())).start();
			try {
				return jp.proceed();
			} finally {
				ctx.stop();
			}
		}
		return jp.proceed();
	}*/


}
