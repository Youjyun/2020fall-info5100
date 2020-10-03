public class Professor {

	// required parameters
	private String firstName;
	private String lastName;

	// optional parameters
	private int id;

	public static class Builder {
		// required parameters
		private String firstName;
		private String lastName;

		// optional parameters
		private int id;

		public Builder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public Builder setId(int id) {
			this.id = id;
			return this;
		}

		public Professor build() {
			// call the private constructor in the outer class
			return new Professor(firstName, lastName, id);
		}
	}

	public Professor(String firstName, String lastName, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getId() {
		return id;
	}
	
	public String toString() {
        return this.getClass().getSimpleName() + ":{ "
                + "id:" + id + ", " 
                + "firstName:" + firstName + ", " 
                + "lastName:" + lastName + ", " 
                + " }";
    }
}

class Main {
	public static void main(String[] args) {
		Professor professor = new Professor.Builder("Siva", "Dosapati")
				.setId(51000000).build();
		System.out.println(professor);

	}
}
