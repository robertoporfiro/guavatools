package com.jarden.courseware.spring.banking.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.jarden.courseware.spring.banking.Stock;
import com.jarden.courseware.spring.banking.audit.Auditor;


@Aspect
public class AuditAspect {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Before("execution(* com.jarden.courseware.spring.banking.StockDAO.update(..))")
	public void auditBefore(JoinPoint joinPoint){
		Auditor.incrementUpdateCount();
		log.warn("About to update stock: "+((Stock)joinPoint.getArgs()[0]).getSymbol());
	}
	
	
}
