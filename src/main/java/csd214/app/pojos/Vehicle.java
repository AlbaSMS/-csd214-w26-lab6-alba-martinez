package csd214.app.pojos;

import java.util.Objects;
import java.util.Scanner;
/**
 * DTO for {@link csd214.app.entities.VehicleEntity}
 */
public class Vehicle extends Product {
    private String make;
    private String model;
    private int vehicleYear;
    private int mileage;
    public Vehicle() {
    }
    public Vehicle(String productID, String name, double price, String make, String model, int vehicleYear, int mileage) {
        super(productID, name, price); // Call Product constructor
        this.make = make;
        this.model = model;
        this.vehicleYear = vehicleYear;
        this.mileage = mileage;
    }
    @Override
    public void initialize(Scanner input) {
        System.out.println("Enter Make: ");
        this.make = getInput(input, "no make");
        System.out.println("Enter Model: ");
        this.model = getInput(input, "no model");
        System.out.println("Enter Year: ");
        this.vehicleYear = getInput(input, 1900);
        System.out.println("Enter Mileage: ");
        this.mileage = getInput(input, 0);
        super.initialize(input);

    }
    @Override
    public void edit(Scanner input) {
        System.out.println("Enter Make: ");
        this.make = getInput(input, getMake());
        System.out.println("Enter Model: ");
        this.model = getInput(input, getModel());
        System.out.println("Enter Year: ");
        this.vehicleYear = getInput(input, getVehicleYear());
        System.out.println("Enter Mileage: ");
        this.mileage = getInput(input, getMileage());
        super.edit(input);

    }


    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(int vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Override
    public void sellItem() {

    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Vehicle vehicle)) return false;
        return getVehicleYear() == vehicle.getVehicleYear() && getMileage() == vehicle.getMileage() && Objects.equals(getMake(), vehicle.getMake()) && Objects.equals(getModel(), vehicle.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMake(), getModel(), getVehicleYear(), getMileage());
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + vehicleYear +
                ", mileage=" + mileage +
                "} " + super.toString();
    }
}