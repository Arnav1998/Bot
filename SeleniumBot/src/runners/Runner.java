package runners;

import java.net.MalformedURLException;

import data.PersonGenerator;
import gridControllers.SupremeController;

public class Runner {
	
	private static PersonGenerator  personGenerator = new PersonGenerator();

	public static void main(String[] args) throws MalformedURLException {
		
		for (int i = 0; i < 5; i++) {
			SupremeController sc = new SupremeController(personGenerator);
			sc.start();
		}

	}

}
