package SK.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;



public class AppTest {
	List<Employee> employees = new ArrayList<Employee>();

	public AppTest() {
		State stateSK = new State("SK", "Slovakia");
		State stateCZ = new State("CZ", "Czechia");
		State stateAU = new State("AU", "Austria");

		City cityBA = new City("BA", "Bratislava");
		City cityPRG = new City("PRG", "Prague");
		City cityKE = new City("KE", "Kosice");
		City cityVIE = new City("VIE", "Vienna");

		Address address1 = new Address("Masarykova", "82456", cityPRG, stateCZ);
		Address address2 = new Address("Racianska", "853641", cityBA, stateSK);
		Address address3 = new Address("Kosicka", "41697", cityBA, stateSK);
		Address address4 = new Address("SNP", "02456", cityKE, stateSK);
		Address address5 = new Address("Tivoligasse", "55156", cityVIE, stateAU);

		List<Employee> employees = new ArrayList<Employee>();
		employees.add(
				new Employee(1, "Jana", "Banikova", "17-07-1999", Gender.female, 20, address4, "12-06-2015", null));
		employees.add(new Employee(2, "Filip", "Kostolnik", "01-06-1987", Gender.male, 32, address3, "12-06-2015",
				"24-01-2019"));
		employees.add(
				new Employee(3, "Tomas", "Banik", "04-11-1980", Gender.male, 39, address2, "12-06-2015", "12-06-2020"));
		employees.add(new Employee(4, "Jan", "Tutko", "15-04-1992", Gender.male, 27, address1, "12-06-2020", null));
		employees.add(new Employee(5, "Ernst", "Walter", "01-11-1988", Gender.male, 31, address5, "10-09-2018", null));

		this.employees = employees;
	}

	@Test
	public void getEmployeesByGender() {
		List<Employee> employeesGender = new ArrayList<Employee>();
		employeesGender.add(employees.get(0));
		System.out.print(employeesGender.get(0).GetAge() + "\n");

		assertEquals(employeesGender, TestClass.getEmployeesByGender(employees, Gender.female));
	}

	@Test
	public void sortEmployeesByAge() {
		List<Employee> employeesAge = new ArrayList<Employee>();
		employeesAge.add(employees.get(0));
		employeesAge.add(employees.get(3));
		employeesAge.add(employees.get(4));
		employeesAge.add(employees.get(1));
		employeesAge.add(employees.get(2));

		assertEquals(employeesAge, TestClass.sortEmployeesByAge(employees));
	}

	@Test
	public void getEmployeesByCity() {
		List<Employee> employeesCity = new ArrayList<Employee>();
		employeesCity.add(employees.get(1));
		employeesCity.add(employees.get(2));

		assertEquals(employeesCity, TestClass.getEmployeesByCity(employeesCity, "BA"));

	}

	@Test
	public void getActiveEmployees() {
		List<Employee> employeesActive = new ArrayList<Employee>();
		employeesActive.add(employees.get(0));
		employeesActive.add(employees.get(2));
		employeesActive.add(employees.get(4));

		assertEquals(employeesActive, TestClass.getActiveEmployees(employees));

	}

	@Test
	public void printEmployees() {
		TestClass.printEmployees(employees);
	}
}
