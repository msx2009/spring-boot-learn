package com.example.demo2;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class GlobalConfig {
	@InitBinder("a")
	public void init1(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("a.");
	}
	@InitBinder("b")
	public void init2(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("b.");
	}
}
