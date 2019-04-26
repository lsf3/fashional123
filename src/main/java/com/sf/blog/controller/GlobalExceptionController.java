package com.sf.blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Configuration
public class GlobalExceptionController implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView mv=new ModelAndView();
		//判断不同错误类型,做不同视图跳转
		if (ex instanceof IllegalArgumentException) {
			
			mv.setViewName("errors/error1");
		}
		
		if (ex instanceof NullPointerException) {
			
			mv.setViewName("errors/error2");
		}
		
		if (ex instanceof Exception) {
			
			mv.setViewName("errors/error");
		}
		
		mv.addObject("error",ex.toString());
		
		// TODO Auto-generated method stub
		return mv;
	}

}
