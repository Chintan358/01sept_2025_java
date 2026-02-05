package bank;

import org.springframework.stereotype.Component;

@Component("normal")
public class NormalUser implements User {

	@Override
	public void userDetails() {
		System.out.println("Normal user");
	}

}
