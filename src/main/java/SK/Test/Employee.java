package SK.Test;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class Employee {
	private Date employeeFrom;
	private Date employeeTo;
	private int age;
	private int employeeId;
	private String name;
	private String surname;
	private Date dateOfBirth;
	private Gender gender;
	Address address;

	public Employee(int employeeId, String name, String surname, String dateOfBirth, Gender gender, int age,
			Address address, String dateFrom, String dateTo) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

		Objects.requireNonNull(employeeId);
		Objects.requireNonNull(name);
		Objects.requireNonNull(surname);
		Objects.requireNonNull(dateOfBirth);
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.age = age;
		this.address = address;

		try {
			this.dateOfBirth = (Date) formatter.parse(dateOfBirth);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {

			this.employeeFrom = (Date) formatter.parse(dateFrom);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (dateTo == null) {
				this.employeeTo = null;
			} else {
				this.employeeTo = (Date) formatter.parse(dateTo);
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Gender GetGender() {
		return this.gender;
	}

	public String GetName() {
		return this.name;
	}

	public String GetSurname() {
		return this.surname;
	}

	public int GetAge() {
		return this.age;
	}

	public String GetCityCode() {
		return this.address.GetCity().GetCityCode();
	}

	public String GetCityName() {
		return this.address.GetCity().GetCityName();
	}

	public String GetStateName() {
		return this.address.GetState().GetStateName();
	}

	public Date GetDateFrom() {
		return this.employeeFrom;
	}

	public Date GetDateTo() {
		return this.employeeTo;
	}

}
