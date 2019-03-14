package pl.sda.programming.day2to5.datastructures.cars;

public class CarModel {
    public int year;
    public String division;
    public String carline;
    public String engineDisplay;
    public int numberOfCylinders;
    public int cityFuelEfficiency;
    public int highwayFuelEfficiency;
    public int combinedFuelEfficiency;

    public CarModelEurope toEuropeanFuelConsumption() {
        CarModelEurope carModelEurope = new CarModelEurope();
        carModelEurope.year = this.year;
        carModelEurope.division = this.division;
        carModelEurope.carline = this.carline;
        carModelEurope.engineDisplay = this.engineDisplay;
        carModelEurope.numberOfCylinders = this.numberOfCylinders;
        carModelEurope.cityFuelConsumption = milesPerGallonToLitersPer100Km(this.cityFuelEfficiency);
        carModelEurope.highwayFuelConsumption = milesPerGallonToLitersPer100Km(this.highwayFuelEfficiency);
        carModelEurope.combinedFuelConsumption = milesPerGallonToLitersPer100Km(this.combinedFuelEfficiency);
        return carModelEurope;
    }

    private double milesPerGallonToLitersPer100Km(int milesPerGallon) {
        double gallonsPerMile = 1.0 / milesPerGallon;
        double gallonsPerMeter = gallonsPerMile / 1609.344;
        double litersPerMeter = gallonsPerMeter * 3.785411784;
        double litersPer100Km = litersPerMeter * 1000 * 100;
        return litersPer100Km;
    }

    @Override
    public String toString() {
        return "CarModel{" +
                "year=" + year +
                ", division='" + division + '\'' +
                ", carline='" + carline + '\'' +
                ", engineDisplay='" + engineDisplay + '\'' +
                ", numberOfCylinders=" + numberOfCylinders +
                ", cityFuelEfficiency=" + cityFuelEfficiency +
                ", highwayFuelEfficiency=" + highwayFuelEfficiency +
                ", combinedFuelEfficiency=" + combinedFuelEfficiency +
                '}';
    }
}
