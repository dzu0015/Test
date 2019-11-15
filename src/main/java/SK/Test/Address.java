package SK.Test;

import java.util.Objects;

public class Address {
	private String street;
	private String zip;
	City city;
	State state;

	public Address(String street, String zip, City city, State state) {

		Objects.requireNonNull(street);
		Objects.requireNonNull(zip);

		this.street = street;
		this.zip = zip;
		this.city = city;
		this.state = state;
	}

	public City GetCity() {
		return this.city;
	}

	public State GetState() {
		return this.state;
	}

}
