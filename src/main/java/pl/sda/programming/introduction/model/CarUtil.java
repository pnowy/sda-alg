package pl.sda.programming.introduction.model;

import java.util.List;

public class CarUtil {

    public static Car getFastestCar(Car ...cars /* varargs */) {
        if (cars.length == 0) {
            return null;
        }

        Car best = cars[0];
        for (int i = 1; i < cars.length; i++) {
            Car car = cars[i];
            if (car.getPower() > best.getPower()) {
                best = car;
            }
        }
        return best;
    }

    public static Car getFastestCar(List<Car> cars) {
        return getFastestCar(cars.toArray(new Car[0]));
    }
}
