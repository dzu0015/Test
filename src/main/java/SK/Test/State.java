package SK.Test;

import java.util.Objects;

public class State {
	private String code;
	private String name;

	public State(String code, String name) {

		Objects.requireNonNull(code);
		Objects.requireNonNull(name);

		this.code = code;
		this.name = name;
	}

	public String GetStateName() {
		return this.name;
	}
}
