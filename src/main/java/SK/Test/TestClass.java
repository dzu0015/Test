package SK.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class TestClass {

	public static List<Employee> getEmployeesByGender(List<Employee> employees, Gender gender) {
		List<Employee> genderEmployees = new ArrayList<Employee>();
		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i).GetGender() == gender) {
				genderEmployees.add(employees.get(i));
			}
		}
		return genderEmployees;

	}

	public static List<Employee> sortEmployeesByAge(List<Employee> employees) {
		Collections.sort(employees, new Comparator<Employee>() {

			public int compare(Employee e0, Employee e1) {
				return e0.GetAge() - e1.GetAge();
			}
		});
		return employees;

	}

	public static List<Employee> getEmployeesByCity(List<Employee> employees, String cityCode) {
		List<Employee> employeesCityCode = new ArrayList<Employee>();

		for (int i = 0; i < employees.size(); i++) {

			if (employees.get(i).GetCityCode().equals(cityCode)) {
				employeesCityCode.add(employees.get(i));
			}
		}
		return employeesCityCode;

	}

	public static List<Employee> getActiveEmployees(List<Employee> employees) {

		Date date = new Date();
		List<Employee> activeEmployees = new ArrayList<Employee>();

		for (int i = 0; i < employees.size(); i++) {

			if ((employees.get(i).GetDateTo() == null) && (employees.get(i).GetDateFrom().compareTo(date) <= 0)) {

				activeEmployees.add(employees.get(i));
			} else if ((employees.get(i).GetDateFrom().compareTo(date) <= 0)
					&& (employees.get(i).GetDateTo().compareTo(date) > 0)) {

				activeEmployees.add(employees.get(i));
			}

		}

		return activeEmployees;

	}

	public static void printEmployees(List<Employee> employees) {
		/*
		 * Comparator<Employee> c = (s1, s2) ->
		 * s1.GetStateName().compareTo(s2.GetStateName()) ;
		 * 
		 * employees.sort(c);
		 */
		Collections.sort(employees, new Comparator<Employee>() {

			public int compare(Employee o1, Employee o2) {
				int c;
				c = o1.GetStateName().compareTo(o2.GetStateName());
				if (c == 0)
					c = o1.GetCityName().compareTo(o2.GetCityName());

				return c;
			}
		});

		String stateName = "";
		String cityName = "";

		for (int i = 0; i < employees.size(); i++) {

			if (!stateName.equals(employees.get(i).GetStateName())) {
				stateName = employees.get(i).GetStateName();
				System.out.print(stateName + "\n");
			}

			if (!cityName.equals(employees.get(i).GetCityName())) {
				cityName = employees.get(i).GetCityName();
				System.out.print("_ _" + cityName + "\n");
			}

			System.out.print("_ _ _ _" + employees.get(i).GetName() + " " + employees.get(i).GetSurname() + "\n");

		}

	}

	public static void main(String[] args) {

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
	}

}
