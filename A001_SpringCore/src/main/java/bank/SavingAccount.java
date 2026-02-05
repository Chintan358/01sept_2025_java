package bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("saving")
public class SavingAccount implements Account {

	@Autowired
	@Qualifier("premium")
	User user;
	
	@Override
	public void deposite() {
		// TODO Auto-generated method stub
		System.out.println("Saving account deposite calling");
		user.userDetails();
	}

}
