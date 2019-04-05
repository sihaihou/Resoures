package com.reyco.core.springmvc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * service注解
 * @author reyco
 *
 */
@Target(value= {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
	
	String value() default "";
	
}
