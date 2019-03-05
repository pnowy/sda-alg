package pl.sda.programming.day1;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface CsvReader {

    List<String[]> readLines(File file);

    List<Map<String, Object>> convert(List<String[]> lines);

    List<Car> objects(List<Map<String, Object>> values);

}
