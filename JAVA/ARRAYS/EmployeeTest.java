package arrays;

public class EmployeeTest {
	public static void main(String[] args) {
		
		Employee[] anArrayOfEmployees = new Employee[2];
		
		anArrayOfEmployees[0] = new Employee(10, "ramesh");
		anArrayOfEmployees[1] = new Employee(11, "john");

		// Each array element is accessed by its numerical index:
		System.out.println("Element 1 id: " + anArrayOfEmployees[0].getId());
		System.out.println("Element 1 Name: " + anArrayOfEmployees[0].getName());
		System.out.println("Element 2 id: " + anArrayOfEmployees[1].getId());
		System.out.println("Element 2 Name: " + anArrayOfEmployees[1].getName());
	}

}
