package SK.Test;

import java.util.Objects;

public class City {
	private String code;
	private String name;

	public City(String code, String name) {
		Objects.requireNonNull(code);
		Objects.requireNonNull(name);

		this.code = code;
		this.name = name;
	}

	public String GetCityCode() {
		return this.code;
	}

	public String GetCityName() {
		return this.name;
	}

}
