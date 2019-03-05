package pl.sda.programming.day1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvReaderUtils implements CsvReader {

    private static final Logger log = LoggerFactory.getLogger(CsvReaderUtils.class);

    @Override
    public List<String[]> readLines(File file) {
//        log.info("Read lines from file: {}", file.getAbsolutePath());
        String[] carParameters;
        List<String[]> listOfString = new ArrayList<>();
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            int i = 0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (i != 0) {
//                    log.debug("Reading single line: {}", line);
                    carParameters = line.split(";");
                    listOfString.add(carParameters);
                }
                i++;
            }
        } catch (IOException e) {
            log.error("File not found", e);
        }
        return listOfString;
    }

    @Override
    public List<Map<String, Object>> convert(List<String[]> lines) {

        List<Map<String, Object>> result = new ArrayList<>();

        for (String[] line : lines) {
            // procesowanie pojedynczego elementu - start
            Map<String, Object> element = convertSingleElement(line);
            result.add(element);
            // procesowanie pojedynczego elementu - stop
        }

        return result;
    }

    private Map<String, Object> convertSingleElement(String[] array) {
        Map<String, Object> map = new HashMap<>();
        map.put("MARKA", array[0]);
        map.put("MODEL", array[1]);
        map.put("ROK", Integer.valueOf(array[2]));
        map.put("KM", Integer.valueOf(array[3]));
        map.put("CENA", new BigDecimal(array[4]));
        return map;
    }

    @Override
    public List<Car> objects(List<Map<String, Object>> values) {
        List<Car> result = new ArrayList<>();
        log.info("Executing objects method");

        for (Map<String, Object> singleMap : values) {
            log.debug("Single map: {}", singleMap);
            Car car = convertMapToCarObject(singleMap);
            result.add(car);
        }

        return result;
    }

    private Car convertMapToCarObject(Map<String, Object> singleMap) {
        String marka = (String)singleMap.get("MARKA");
        String model = (String)singleMap.get("MODEL");
        Integer rok = (Integer)singleMap.get("ROK");
        Integer km = (Integer)singleMap.get("KM");
        BigDecimal cena = (BigDecimal) singleMap.get("CENA");

        return new Car(marka, model, rok, km, cena);
    }
}
