class Student {
	private String name;
	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	Student(String name, int id) {
		this.name = name;
		this.id = id;

	}

}

class Course {
	private String name;
	private Student[] students = new Student[10];
	private int numberOfStudents;

	public Course(String name) {
		this.name = name;
	}

	public void registerStudent(Student student) {
		if (isFull()) {
			return;
		}
		students[numberOfStudents] = student;
		numberOfStudents++;
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public String getName() {
		return name;
	}

	public Student[] getStudents() {
		return students;
	}

	public boolean isFull() {
		if (numberOfStudents == 10)
			return true;
		else
			return false;
	}

}

public class simpleRegistrationSystemTest {

	public static void main(String[] args) {
		Course courseA = new Course(" Application Engineering and Development");
		Student student1 = new Student("Alien", 6);
		courseA.registerStudent(student1);
		courseA.registerStudent(new Student("Ranie", 5));
		courseA.registerStudent(new Student("Kid", 2));
		Course courseB = new Course("Data Management and Database Design");
		courseB.registerStudent(student1);
		courseB.registerStudent(new Student("Ken", 3));
		int num1 = courseA.getNumberOfStudents();
		System.out.println("Total students in courseA: " + num1);
		Student[] students = courseA.getStudents();
		for (int i = 0; i < courseA.getNumberOfStudents(); i++) {
			String name = students[i].getName();
			int id = students[i].getId();
			System.out.println("ID:"+ id +" Name:"+ name);
		}
		System.out.println();
		System.out.println("Total students in courseB: " + courseB.getNumberOfStudents());
	}

}
