package com.spring.lc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class LoveCalculatorApplicationInitializer {
	//implements WebApplicationInitializer 

	public void onStartup(ServletContext servletContext) throws ServletException {
		//System.out.println("It is initializing automatically by tomcat");
//		XmlWebApplicationContext webApplicationContext=new XmlWebApplicationContext();
//		webApplicationContext.setConfigLocation("classpath:beans.xml");
//		
		AnnotationConfigWebApplicationContext webApplicationContext=new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(LoveCalculatorAppConfig.class);
		
		//create a DS Object here
		DispatcherServlet ds=new DispatcherServlet(webApplicationContext);
		
		//register DS with servlet context
		ServletRegistration.Dynamic myCustomDS = servletContext.addServlet("myDispactherServlet", ds);
		myCustomDS.setLoadOnStartup(1);
		myCustomDS.addMapping("/mywebsite.com/*");
	}

}
