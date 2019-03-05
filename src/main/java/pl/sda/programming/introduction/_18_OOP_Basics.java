package pl.sda.programming.introduction;


import pl.sda.programming.introduction.model.Car;
import pl.sda.programming.introduction.model.CarUtil;

import java.util.Random;

final class _18_OOP_Basics {

    public static void main(String[] args) {
        Car skoda = new Car("Sedan", "Skoda", 1.2f, 1350, "XSC3030404");
        System.out.println("Car is: type=" + skoda.getType() +
                ", model=" + skoda.getModel());

        // car is sold
        skoda.setRegistrationNumber("AW32030");
        skoda.setStatus("personal");

        System.out.println("Skoda is: " + skoda.getType() + ", regis.num: " +
                skoda.getRegistrationNumber());

        // change distance
        Random random = new Random();
        System.out.println("Skoda distance is: " + skoda.getDistance());
        skoda.addDistance(random.nextInt(500));
        skoda.addDistance(random.nextInt(200));
        System.out.println("Skoda distance is: " + skoda.getDistance());


        // second car
        Car lexus = new Car("Sedan", "Lexus", 4.0f, 1800, "EWE838292838");

        // add them to array and print
        Car[] cars = new Car[] { skoda, lexus };
        for (Car car : cars) {
            System.out.printf("car is %s, type=%s, engine=%s, weight=%s\n",
                    car.getModel(), car.getType(), car.getEngine(), car.getWeight());
        }

        lexus.setStatus(Car.STATUS_COMPANY);


        Car fastestCar = CarUtil.getFastestCar(cars);
        System.out.println("Fastest car is " + fastestCar.getModel());

        // overloaded method getFastestCar
        fastestCar = CarUtil.getFastestCar(skoda, lexus, lexus, skoda);
    }
}
