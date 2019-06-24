package com.wrb.csi.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.wrb.csi.model.User;
import com.wrb.csi.util.MD5Util;

@Aspect
@Component
public class UserAspect {
	@Pointcut("execution(* com.wrb.csi.service.UserService.insert*(..))")
	public void print() {
		
	}
	
	@Before("print()")
    public void before(JoinPoint joinPoint) {
		User u = (User) joinPoint.getArgs()[0];
		u.setPassword(MD5Util.string2MD5(u.getPassword()));
	}
}
