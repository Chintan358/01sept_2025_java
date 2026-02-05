package com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		
		ClassPathXmlApplicationContext cx = 
				new ClassPathXmlApplicationContext("applicationcontext.xml");
		
		
		Student st = cx.getBean("std",Student.class);
		st.display();
		
	}
}
