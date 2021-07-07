package esGarage;

public class Van extends Vehicle {
	private int max_capacity;

	public Van(String license_plate, String brand, int year_of_matriculation, int displacement, int max_capacity) {
		super(license_plate, brand, year_of_matriculation, displacement);
		this.max_capacity = max_capacity;
	}

	public int getMax_capacity() {
		return max_capacity;
	}

	@Override
	public String toString() {
		return "Van - " + super.toString() + ", max capacity=[" + max_capacity + "]";
	}
}