package bank;

import org.springframework.stereotype.Component;

@Component("premium")
public class PremiumUser implements User {

	@Override
	public void userDetails() {
		System.out.println("premium user....");
		
	}

}
