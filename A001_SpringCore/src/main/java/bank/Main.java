package bank;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		ApplicationContext cx = new AnnotationConfigApplicationContext(Appconfig.class);
		
		Account saving = cx.getBean("saving",Account.class);
		Account current = cx.getBean("currentAccount",Account.class);
		
		saving.deposite();
		current.deposite();
		
	}
}
