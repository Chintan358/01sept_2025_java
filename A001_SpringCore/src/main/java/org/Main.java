package org;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		
		ClassPathXmlApplicationContext cx = 
				new ClassPathXmlApplicationContext("applicationcontext2.xml");
		
		User user = cx.getBean("user",User.class);
		user.display();
	}
}
