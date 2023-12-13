public class Person implements IPerson {
	private int id;
	private String firstName;
	private String lastName;
	
	public Person(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public int getId() {
		return this.id;	
	}
	
	@Override
	public String getFirstName() {
		return this.firstName;
	}

	@Override
	public String getLastName() {
		return this.lastName;
	}

	@Override
	public String toString() {
		return id + " " + this.firstName + " " + this.lastName;
	}
	
	@Override
	public int compareTo(IPerson p) {
		return (this.getId() == p.getId()) ? 0 : ((this.getId() > p.getId()) ? 1 : -1);
	}
}
