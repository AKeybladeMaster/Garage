package esGarage;

public class Car extends Vehicle {
	private int number_of_doors;
	private String type_of_fuel;

	public Car(String license_plate, String brand, int year_of_matriculation, int displacement, int number_of_doors, String type_of_fuel) {
		super(license_plate, brand, year_of_matriculation, displacement);
		this.number_of_doors = number_of_doors;
		this.type_of_fuel = type_of_fuel;
	}

	public int getNumber_of_doors() {
		return number_of_doors;
	}

	public String getType_of_fuel() {
		return type_of_fuel;
	}

	@Override
	public String toString() {
		return "Car - " + super.toString() + ", number of doors=[" + number_of_doors + "], type of fuel=["
				+ type_of_fuel + "]";
	}
}