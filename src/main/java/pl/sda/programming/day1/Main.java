package pl.sda.programming.day1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        CsvReaderUtils csvReaderUtils = new CsvReaderUtils();
        List<String[]> listOfCars = csvReaderUtils.readLines(new File("cars.csv"));
        List<Map<String, Object>> maps = csvReaderUtils.convert(listOfCars);
        List<Car> cars = csvReaderUtils.objects(maps);
        cars.forEach(car -> {
            log.info("New car: {}", car);
        });

    }

}
