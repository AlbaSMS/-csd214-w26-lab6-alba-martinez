package csd214.app.pojos;

import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

/**
 * DTO for {@link csd214.app.entities.PhoneEntity}
 */
public class Phone extends Electronics {
    private boolean supports5G;
    public double price;

    public Phone(String brand, boolean supports5G, double price, int copies) {
        this.copies = copies;
        // set the productId
        setProductId(UUID.randomUUID().toString());
    }

    public Phone() {
    }

    public boolean isSupports5G() {
        return supports5G;
    }

    public void setSupports5G(boolean supports5G) {
        this.supports5G = supports5G;
    }

    @Override
    public void initialize(Scanner input) {
        super.initialize(input);
        System.out.println("Supports 5G? (true/false): ");
        supports5G = getInput(input, true);
        System.out.println("Enter warranty months: ");
        setWarrantyMonths(getInput(input, getWarrantyMonths()));

    }

    @Override
    public void edit(Scanner input) {
        super.edit(input);
        System.out.println("Supports 5G [" + supports5G + "]: ");
        supports5G = getInput(input, supports5G);
        price = supports5G ? 999.99 : 799.99;
        System.out.println("Warranty months [" + getWarrantyMonths() + "]: ");
        setWarrantyMonths(getInput(input, getWarrantyMonths()));
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Phone phone = (Phone) o;
        return supports5G == phone.supports5G && Double.compare(price, phone.price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), supports5G, price);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "supports5G=" + supports5G +
                ", price=" + price +
                '}';
    }
}