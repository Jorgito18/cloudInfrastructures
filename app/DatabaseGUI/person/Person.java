package person;

public class Person {
	private int personId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String phone;
	  
	public Person() {
	}
	
	public Person(int personId, String firstName, String middleName, String lastName, String email, String phone) {
		this.personId = personId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.middleName = middleName;
		this.phone = phone;
	}
	   
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}