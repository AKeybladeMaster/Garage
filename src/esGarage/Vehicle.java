package esGarage;

public abstract class Vehicle {

	private String license_plate;
	private String brand;
	private int year_of_matriculation;
	private int displacement;

	public Vehicle(String license_plate, String brand, int year_of_matriculation, int displacement) {
		this.license_plate = license_plate;
		this.brand = brand;
		this.year_of_matriculation = year_of_matriculation;
		this.displacement = displacement;
	}

	public String getLicense_plate() {
		return license_plate;
	}
	
	public String getBrand() {
		return brand;
	}

	public int getYear_of_matriculation() {
		return year_of_matriculation;
	}

	public int getDisplacement() {
		return displacement;
	}

	@Override
	public String toString() {
		return "license plate=[" + license_plate + "], brand=[" + brand + "], year of matriculation=[" + year_of_matriculation + "], displacement=["
				+ displacement + "]";
	}

}