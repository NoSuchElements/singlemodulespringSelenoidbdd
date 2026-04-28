package com.nosuchelements.annotations;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.lang.annotation.*;

	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@Component
	@Lazy
	@Scope("prototype")
	public @interface PageObject {/*
		o	Bean name (optional)
		o	@return bean name
		*/
		String value() default "";
		}

