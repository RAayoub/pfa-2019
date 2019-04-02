package aop;

import java.lang.reflect.Method;

import org.jboss.logging.Logger;
import org.springframework.aop.AfterReturningAdvice;

public class LogAopAfter implements AfterReturningAdvice {

	private Logger logger =Logger.getLogger(this.getClass());

	@Override
	public void afterReturning(Object returnValue, Method method, 
	Object[] args, Object target) throws Throwable {
	logger.info(method.getName());
	logger.info(args[0]);
	}


}
