package csd214.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
public class VehicleEntity extends ProductEntity {
    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "vehicleYear")
    private int vehicleYear;

    @Column(name = "mileage")
    private int mileage;

    public VehicleEntity() {}

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

    public VehicleEntity(String make, int vehicleYear, int mileage, String model) {
        this.make = make;
        this.vehicleYear = vehicleYear;
        this.mileage = mileage;
        this.model = model;
    }

    public VehicleEntity(String name, double price, String make, int mileage, int vehicleYear, String model) {
        super(name, price);
        this.make = make;
        this.mileage = mileage;
        this.vehicleYear = vehicleYear;
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VehicleEntity that = (VehicleEntity) o;
        return vehicleYear == that.vehicleYear && mileage == that.mileage && Objects.equals(make, that.make) && Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), make, model, vehicleYear, mileage);
    }

    @Override
    public String toString() {
        return "VehicleEntity{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", vehicleYear=" + vehicleYear +
                ", mileage=" + mileage +
                '}';
    }
}