package pl.sda.programming.day2to5.datastructures.cars;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * # Przetwarzanie danych z pliku fules.csv za pomocą .stream() API
 *
 * 1. Napisz klase "CarModel" przechowującą dane z fuel.csv i wczytaj wiersze z fuel.csv do `List<Car>`
 * 2. 10 modeli o najmniejszym spalaniu
 *     wypisz nazwę + spalanie
 *     tip: sortowanie
 * 3. napisz kolejną klasę przechowującą informację o samochodach ale z spalaniem podanym w l/100km
 *     tip: projekcja
 * 4. poprzedni wynik posortuj dodatkowo alfabetycznie
 *     jeżeli 2 modele mają takie samo spalanie pierwszy powinien być ten który jest pierwszy alfabetycznie (po nazwie modelu nie producenta)
 * 5. 10 modeli o najmniejszym spalaniu dla wybranego przez Ciebie producenta
 *     tip: filtrowanie
 * 6. jeżeli istnieje wybierz taki model BMW który ma spalanie miejskie mniejsze niż 7 l/100Km
 *     tip: filtrowanie + findFirst
 * 7. jeżeli istnieje wybierz taki model McLaren który ma spalanie miejskie mniejsze niż 14 l/100Km
 *     tip: filtrowanie + findFirst
 * 8. sprawdź czy wszystkie modele są wyprodukowane przez Porshe
 *     tip: wszystkie -> ang. all, w stream() jest metoda All()
 * 9. sprawdzy czy istnieje jaki kolwiek model wyprodukowany przez "Fiat", to samo dla "Olds Mobile"
 *     tip: tak jak poprzednio przyda nam się angielskie słowo -> tym razem "any"
 * 10. ilu różnych producentów samochodów istnieje?
 *     wypisz producentów zgrupowanych po pierwszej literze.
 *     tip: distinct
 *
 *     przykład:
 * ```
 *     a: ALFA ROMEO, Aston Martin Lagonda Ltd, Audi, Acura
 *     b: BMW, Bentley, Buick
 *     c: Chevrolet, Cadillac, Chrysler, CHEVROLET
 *     ...
 * ```
 *
 * 11. używając grup z poprzedniego punktu wypisz liczebność każdej grupy
 *     tip: projekcja
 * 12. wypisz producentów dla których istnieje conajmniej 50 modeli/ 20 modeli
 *     tip: wszyskiego składowe już znasz ;)
 * 13. dla producentów dla których istnieje conajmniej 50 modeli wypisz wszystkie modele
 *     tip: flatMap
 */
public class CarsTask {

    public static void main(String[] args) throws Exception {
        File file = new File(CarsTask.class.getResource("/cars/fuel.csv").getFile());
        Path path = Paths.get(file.getAbsolutePath());
        List<String> allLInes = Files.readAllLines(path);

        // Model Year,Division,Carline,Eng Displ,# Cyl,City FE,Hwy FE,Comb FE

        // Exercise 1 - read data from CSV into objects
        List<CarModel> carModels = allLInes
                .stream()
                .skip(1) // skip headers
                .map(x -> {
                    String[] split = x.split(",");
                    CarModel carModel = new CarModel();
                    carModel.year = Integer.parseInt(split[0]);
                    carModel.division = split[1];
                    carModel.carline = split[2];
                    carModel.engineDisplay = split[3];
                    carModel.numberOfCylinders = Integer.parseInt(split[4]);
                    carModel.cityFuelEfficiency = Integer.parseInt(split[5]);
                    carModel.highwayFuelEfficiency = Integer.parseInt(split[6]);
                    carModel.combinedFuelEfficiency = Integer.parseInt(split[7]);
                    return carModel;
                })
                .collect(Collectors.toList());

        // Exercise 2
        System.out.println("\nExercise 2 - 10 most fuel efficient cars (by city fuel efficiency)");
        printHeaders();
        carModels
                .stream()
                .sorted(Comparator.comparingInt(x -> -x.cityFuelEfficiency))
//                .sorted((a, b) -> b.cityFuelEfficiency - a.cityFuelEfficiency) // another way of comparing
                .limit(10)
                .forEach(CarsTask::printCarModel);

        // Exercise 3
        System.out.println("\nExercise 3 - 10 most fuel efficient cars (by l/100km)");
        List<CarModelEurope> carModelsEurope = carModels
                .stream()
                .map(CarModel::toEuropeanFuelConsumption)
                .collect(Collectors.toList());

        printHeadersEurope();
        carModelsEurope
                .stream()
                .sorted(Comparator.comparingDouble(x -> x.combinedFuelConsumption))
                .limit(10)
                .forEach(CarsTask::printCarModel);

        // Exercise 4
        System.out.println("\nExercise 4 - 10 most fuel efficient cars sorted by Carline");
        printHeaders();
        carModels
                .stream()
                .sorted(Comparator.comparingDouble((CarModel x) -> -x.cityFuelEfficiency).thenComparing(x -> x.carline))
                .limit(20)
                .forEach(CarsTask::printCarModel);

        // Exercise 5
        System.out.println("\nExercise 5 - 10 most fuel efficient cars from Mercedes-Benz");
        printHeadersEurope();
        carModelsEurope
                .stream()
                .filter(x -> x.division.equals("Mercedes-Benz"))
                .sorted(Comparator.comparingDouble(x -> x.cityFuelConsumption))
                .limit(10)
                .forEach(CarsTask::printCarModel);

        System.out.println("\nExercise 6 - if present find a BMW with city consumption less than 7 l/100Km");
        Optional<CarModelEurope> optionalBmw = carModelsEurope
                .stream()
                .filter(x -> x.division.equals("BMW"))
                .filter(x -> x.combinedFuelConsumption < 7)
                .findFirst();

        if (optionalBmw.isPresent()) {
            System.out.println("We have found a BMW Model with fuel consumption less than 7 l/100Km");
            printHeadersEurope();
            printCarModel(optionalBmw.get());
        } else {
            System.out.println("There is no BMW with fuel consumption less then 7 l/100Km");
        }

        // Exercise 7
        System.out.println("\nExercise 7 - if present find a McLaren with city consumption less than 14 l/100Km");
        Optional<CarModelEurope> optionalMcLaren = carModelsEurope
                .stream()
                .filter(x -> x.division.equals("McLaren"))
                .filter(x -> x.cityFuelConsumption < 14)
                .findFirst();
        if (optionalMcLaren.isPresent()) {
            System.out.println("We have found a McLaren Model with city fuel consumption less than 14 l/100Km");
            printHeadersEurope();
            printCarModel(optionalMcLaren.get());
        } else {
            System.out.println("There is no McLaren with city fuel consumption less then 14 l/100Km");
        }

        // Exercise 8
        System.out.println("\nExercise 8 - check if all cars are made by Porsche");
        boolean areAllByPorsche = carModelsEurope
                .stream()
                .allMatch(x -> x.division.equals("Porsche"));
        System.out.println("Are all cars made by Porsche: " + areAllByPorsche);

        // Exercise 9
        System.out.println("\nExercise 9 - check if there is any car made by Fiat");
        boolean anyFiat = carModelsEurope
                .stream()
                .anyMatch(x -> x.division.equals("Fiat"));
        System.out.println("Is there any car made by Fiat: " + (anyFiat ? "yes" : "no"));

        boolean anyFiat2 = carModelsEurope
                .stream()
                .anyMatch(x -> x.division.compareToIgnoreCase("Fiat") == 0);
        System.out.println("Is there any car made by Fiat (ignoring case): " + (anyFiat2 ? "yes" : "no"));

        boolean anyOldsMobile = carModelsEurope
                .stream()
                .anyMatch(x -> x.division.compareToIgnoreCase("Olds Mobile") == 0);
        System.out.println("Is there any car made by Olds Mobile (ignoring case): " + (anyOldsMobile ? "yes" : "no"));

        // Exercise 10
        System.out.println("\nExercise 10 - count all distinct car companies");
        List<String> carCompanies = carModelsEurope
                .stream()
                .map(x -> x.division)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("There are " + carCompanies.size() + " distinct car companies");
        Map<Character, List<String>> groupedByFirstCharacter = carCompanies
                .stream()
                .collect(Collectors.groupingBy(x -> Character.toLowerCase(x.charAt(0))));
        for (Character key : groupedByFirstCharacter.keySet()) {
            String collect = groupedByFirstCharacter.get(key)
                    .stream()
                    .collect(Collectors.joining(", ", "" + key + ": ", ""));
            System.out.println(collect);
        }

        // another way of counting car makers
        Map<String, List<CarModelEurope>> groupedByDivision = carModelsEurope
                .stream()
                .collect(Collectors.groupingBy(x -> x.division));
        System.out.println("Another way of counting car makers: " + groupedByDivision.keySet().size());

        // Exercise 11
        System.out.println("\nExercise 11 - count models made by each car maker");
        Map<String, List<CarModelEurope>> groupedByDivision2 = carModelsEurope
                .stream()
                .collect(Collectors.groupingBy(x -> x.division));

        Optional<Map.Entry<String, List<CarModelEurope>>> maxMaker = groupedByDivision2.entrySet().stream()
                .max(new Comparator<Map.Entry<String, List<CarModelEurope>>>() {
                    @Override
                    public int compare(Map.Entry<String, List<CarModelEurope>> o1, Map.Entry<String, List<CarModelEurope>> o2) {
                        return Integer.valueOf(o1.getValue().size()).compareTo(o2.getValue().size());
                    }
                });
        System.out.println("Max maker: "+ maxMaker.get().getKey());

        groupedByDivision2
                .keySet()
                .stream()
                .map(x -> String.format("%s (%d)", x, groupedByDivision2.get(x).size()))
                .forEach(System.out::println);

        // Exercise 12
        System.out.println("\nExercise 12 - car makers with at least 20 models");
        groupedByDivision2
                .keySet()
                .stream()
                .filter(x -> groupedByDivision2.get(x).size() > 20)
                .map(x -> String.format("%s (%d)", x, groupedByDivision2.get(x).size()))
                .forEach(System.out::println);

        System.out.println("\nExercise 12 - car makers with at least 50 models");
        groupedByDivision2
                .keySet()
                .stream()
                .filter(x -> groupedByDivision2.get(x).size() > 50)
                .map(x -> String.format("%s (%d)", x, groupedByDivision2.get(x).size()))
                .forEach(System.out::println);

        // Exercise 13
        System.out.println("\nExercise 13 - all models from car makers which have at least 50 models");
        printHeadersEurope();
        groupedByDivision2
                .values()
                .stream()
                .filter(x -> x.size() > 50)
                .flatMap(Collection::stream)
                .forEach(CarsTask::printCarModel);
    }

    private static void printHeaders() {
        String line = String.format("|%10s|%30s|%30s|%10s|%10s|%10s|%10s|%10s|",
                "Model Year",
                "Division",
                "Carline",
                "Eng Displ",
                "# Cyl",
                "City FE",
                "Hwy FE",
                "Comb FE");
        System.out.println(line);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
    }

    private static void printHeadersEurope() {
        String line = String.format("|%10s|%30s|%30s|%10s|%10s|%10s|%10s|%10s|(l/100Km)",
                "Model Year",
                "Division",
                "Carline",
                "Eng Displ",
                "# Cyl",
                "City FC",
                "Hwy FC",
                "Comb FC");
        System.out.println(line);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");

    }

    private static void printCarModel(CarModel carModel) {
        String line = String.format("|%10d|%30s|%30s|%10s|%10d|%10d|%10d|%10d|",
                carModel.year,
                carModel.division,
                carModel.carline,
                carModel.engineDisplay,
                carModel.numberOfCylinders,
                carModel.cityFuelEfficiency,
                carModel.highwayFuelEfficiency,
                carModel.combinedFuelEfficiency);
        System.out.println(line);
    }

    private static void printCarModel(CarModelEurope carModelEurope) {
        String line = String.format("|%10d|%30s|%30s|%10s|%10d|%10f|%10f|%10f|",
                carModelEurope.year,
                carModelEurope.division,
                carModelEurope.carline,
                carModelEurope.engineDisplay,
                carModelEurope.numberOfCylinders,
                carModelEurope.cityFuelConsumption,
                carModelEurope.highwayFuelConsumption,
                carModelEurope.combinedFuelConsumption);
        System.out.println(line);
    }

}
