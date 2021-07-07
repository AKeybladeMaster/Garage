package esGarage;

public class Motorbike extends Vehicle {
	private int n_stroke_engine;

	public Motorbike(String license_plate, String brand, int year_of_matriculation, int displacement, int n_stroke_engine) {
		super(license_plate, brand, year_of_matriculation, displacement);
		this.n_stroke_engine = n_stroke_engine;
	}

	public int getN_stroke_engine() {
		return n_stroke_engine;
	}

	@Override
	public String toString() {
		return "Bike - " + super.toString() + ", [" + n_stroke_engine + "]-stroke engine";
	}
}