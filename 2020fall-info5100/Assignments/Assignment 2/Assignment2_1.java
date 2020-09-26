import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * The deadline of this assignment is 09/25/2020 23:59 PST. Please feel free to
 * contact Yafei and Yaqi for any questions.
 */

class Employee {
	String name;
	int age;
	Gender gender;
	double salary;// salary per month

	// Constructor. Please set all the data in constructor.
	public Employee(String name, int age, Gender gender, double salary) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
	}

	// Getter for `name`. Return the current `name` data
	public String getName() {
		return name;
	}

	// Setter for `name`. Set `name` data
	public void setName(String name) {
		this.name = name;
	}

	public void raiseSalary(double byPercent) {
		this.salary = salary * byPercent * 0.01;

	}
}

enum Gender {
	MALE, FEMALE;
}

public class Assignment2_1 {
	// Assignment

	/**
	 * Write a method to calculate the Social Security Tax of an employee and print
	 * it. If the salary is less than or equal to 8900, the Social Security Tax is
	 * 6.2% of the salary. If the salary is more than 8900, the Social Security Tax
	 * is 6.2% of 106,800.
	 */
	public double socialSecurityTax(Employee employee) {
		double socialSecurityTax;
		if (employee.salary <= 8900) {
			socialSecurityTax = employee.salary * 0.062;
		} else {
			socialSecurityTax = 106800 * 0.062;
		}
		System.out.println("Social Security Tax=" + socialSecurityTax);
		return socialSecurityTax;
	}

	/**
	 * Write a method to calculate an employee's contribution for insurance coverage
	 * and print it. Amount of deduction is computed as follows: If the employee is
	 * under 35, rate is 3% of salary; if the employee is between 35 and
	 * 50(inclusive), rate is 4% of salary; If the employee is between 50 and
	 * 60(exclusive), rate is 5% of salary; If the employee is above 60, rate is 6%
	 * of salary.
	 */
	public double insuranceCoverage(Employee employee) {
		double rate = 0;
		if (employee.age < 35) {
			rate = employee.salary * 0.03;
		} else if (employee.age > 35 && employee.age <= 50) {
			rate = employee.salary * 0.04;
		} else if (employee.age > 50 && employee.age < 60) {
			rate = employee.salary * 0.05;
		} else if (employee.age > 60) {
			rate = employee.salary * 0.06;
		}
		System.out.println("Insurance Coverage Rate=" + rate);
		return rate;
	}

	/**
	 * Write a method to sort three employees' salary from low to high, and then
	 * print their name in order. For example, Alice's salary is 1000, John's salary
	 * is 500, Jenny's salary is 1200, you should print: John Alice Jenny
	 */
	public void sortSalary(Employee e1, Employee e2, Employee e3) {

		TreeMap<Double, String> salaryMap = new TreeMap<Double, String>();
		salaryMap.put(e1.salary, e1.getName());
		salaryMap.put(e2.salary, e2.getName());
		salaryMap.put(e3.salary, e3.getName());

//      selection sort
//		String[] salaries = { salaryMap.get(e1.salary), salaryMap.get(e2.salary), salaryMap.get(e3.salary) };
//		
//		for (int i = 0; i < salaries.length - 1; i++) {
//			int miniIndex = i;
//			for (int j = i + 1; j < salaries.length; j++) {
//				if (Double.parseDouble(salaries[j]) < Double.parseDouble(salaries[miniIndex])) {
//					miniIndex = j;
//				}
//			}

//			String temp = salaries[i];
//			salaries[i] = salaries[miniIndex];
//			salaries[miniIndex] = temp;
//		}
		
		Iterator<Double> iterator = salaryMap.keySet().iterator();
		while (iterator.hasNext()) {
			Object name = iterator.next();
			System.out.print(salaryMap.get(name) + " ");
		}
		System.out.println();
	}

	/**
	 * Write a method to raise an employee's salary to three times of his/her
	 * original salary. Eg: original salary was 1000/month. After using this method,
	 * the salary is 3000/month. Do not change the input of this method. Try to add
	 * a new method in Employee class: public void raiseSalary(double byPercent)
	 */
	public void tripleSalary(Employee employee) {
		employee.raiseSalary(300);
	}

	// Extra credit

	/**
	 * I have written some code below. What I want is to swap two Employee objects.
	 * One is Jenny and one is John. But after running it, I got the result below:
	 * Before: a=Jenny Before: b=John After: a=Jenny After: b=John There is no
	 * change after swap()! Do you know the reason why my swap failed? Write your
	 * understanding of the reason and explain it.
	 */
	/*
	 * Java copies and passes the reference by value. When you execute the swap method, 
	 * the only changing things are your copied reference and swapping those reference's memory addresses, 
	 * not the object connected with x, y object, so the attribute of the object would not be swapped.
	 * If you still want to swap those value, you need to set up a new value in those object, because it reference
	 * to the same object which are a, b objects only.
	 * 
	 */
	public static void main(String[] args) {
		Employee a = new Employee("Jenny", 20, Gender.FEMALE, 2000);
		Employee b = new Employee("John", 30, Gender.MALE, 2500);
		Employee c = new Employee("Alice", 40, Gender.MALE, 1500);

		Assignment2_1 a1 = new Assignment2_1();
		a1.sortSalary(a, b, c);

		System.out.println("Before: a=" + a.getName());
		System.out.println("Before: b=" + b.getName());
		swap(a, b);
		System.out.println("After: a=" + a.getName());
		System.out.println("After: b=" + b.getName());
	}

	public static void swap(Employee x, Employee y) {
		Employee temp = x;
		x = y;
		y = temp;
		
		//success
		//x.name="Jenny";
		//y.name="John";
		
	}
}