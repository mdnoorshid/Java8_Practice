package com.reactiveworks.learning.optionalclass;

import java.util.Optional;

public class Person {

	private Optional<Car> car; // A person might or might not a car so this
								// field has declared as Optional

	public Optional<Car> getCar() {
		return car;
	}
}

class Car {
	private Optional<Insurance> insurance; // A car might or might not have
											// insurance so this field has
											// declared as Optional

	public Optional<Insurance> getInsurance() {
		return insurance;
	}
}

class Insurance {
	private String name; // A insurance company must have a name so it is
							// declared directly as String

	public String getName() {
		return name;
	}
}