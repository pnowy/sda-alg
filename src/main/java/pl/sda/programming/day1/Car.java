package pl.sda.programming.day1;


import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.math.BigDecimal;
import java.util.Objects;

public class Car {

    private final String brandName;
    private final String modelName;
    private final int productionYear;
    private final int powerInKM;
    private final BigDecimal carPrice;

    public Car(String brandName, String modelName, int productionYear, int powerInKM, BigDecimal carPrice) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.productionYear = productionYear;
        this.powerInKM = powerInKM;
        this.carPrice = carPrice;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public int getPowerInKM() {
        return powerInKM;
    }

    public BigDecimal getCarPrice() {
        return carPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return powerInKM == car.powerInKM &&
                Objects.equals(brandName, car.brandName) &&
                Objects.equals(modelName, car.modelName) &&
                Objects.equals(productionYear, car.productionYear) &&
                Objects.equals(carPrice, car.carPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandName, modelName, productionYear, powerInKM, carPrice);
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
