package data;

public class Person {

	private String firstName, lastName, fullName;
	private String email;
	private String telephone;
	private String billingStreet, billingAptNumber, billingCity, billingState, billingZip, billingCountry;
	private String ccNumber, ccExpMonth, ccExpYear, ccCVV;
	
	public Person(String firstName, String lastName, String email, String telephone, String billingStreet, String billingAptNumber, String billingCity, String billingState, String billingZip, String billingCountry, String ccNumber, String ccExpMonth, String ccExpYear, String ccCVV) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = firstName+" "+lastName;
		this.email = email;
		this.telephone = telephone;
		this.billingStreet = billingStreet;
		this.billingAptNumber = billingAptNumber;
		this.billingCity = billingCity;
		this.billingState = billingState;
		this.billingZip = billingZip;
		this.billingCountry = billingCountry;
		this.ccNumber = ccNumber;
		this.ccExpMonth = ccExpMonth;
		this.ccExpYear = ccExpYear;
		this.ccCVV = ccCVV;
		
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getFullName() {
		return fullName;
	}
	public String getEmail() {
		return email;
	}
	public String getTelephone() {
		return telephone;
	}
	public String getBillingStreet() {
		return billingStreet;
	}
	public String getBillingAptNumber() {
		return billingAptNumber;
	}
	public String getBillingCity() {
		return billingCity;
	}
	public String getBillingState() {
		return billingState;
	}
	public String getBillingZip() {
		return billingZip;
	}
	public String getBillingCountry() {
		return billingCountry;
	}
	public String getCcNumber() {
		return ccNumber;
	}
	public String getCcExpMonth() {
		return ccExpMonth;
	}
	public String getCcExpYear() {
		return ccExpYear;
	}
	public String getCcCVV() {
		return ccCVV;
	}
	
	
}
