package data;

public class PersonGenerator {
	
	private static int id = 0;
	
	public Person getPerson() {
		
		id++;
		
		if (id == 1) {
			//generate as person and return it;
			return new Person("Jim1","Carry1","jimcarry1@gmail.com","7142161111","Main St.","1234","Anaheim","California","92807","USA","4477432155567889","02","2020","398");
		} else if (id == 2) {
			return new Person("Jim2","Carry2","jimcarry2@gmail.com","7142161111","Main St.","1234","Anaheim","California","92807","USA","4477432155567889","02","2020","398");
		} else if (id == 3) {
			return new Person("Jim3","Carry3","jimcarry3@gmail.com","7142161111","Main St.","1234","Anaheim","California","92807","USA","4477432155567889","02","2020","398");
		} else if (id == 4) {
			return new Person("Jim4","Carry4","jimcarry4@gmail.com","7142161111","Main St.","1234","Anaheim","California","92807","USA","4477432155567889","02","2020","398");
		} else if (id == 5) {
			return new Person("Jim5","Carry5","jimcarry5@gmail.com","7142161111","Main St.","1234","Anaheim","California","92807","USA","4477432155567889","02","2020","398");
		} else if (id == 6) {
			return new Person("Jim6","Carry6","jimcarry6@gmail.com","7142161111","Main St.","1234","Anaheim","California","92807","USA","4477432155567889","02","2020","398");
		} else {
			id = 0;
			getPerson();
		}
		
		
		return null;
		
	}

}
