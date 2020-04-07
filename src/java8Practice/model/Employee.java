package java8Practice.model;

public class Employee {
	private String name;
	private double salary;
	private String city;
	private String designation;

	public Employee(String name, double salary, String city, String designation) {
		super();
		this.name = name;
		this.salary = salary;
		this.city = city;
		this.designation = designation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", city=" + city + ", designation=" + designation
				+ "]";
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Employee) {
			Employee e = (Employee) o;
			return e.getCity().equals(this.city) && e.getDesignation().equals(this.designation)
					&& e.getName().equals(this.name) && e.getSalary() == salary;
		}
		return false;
	}

}
