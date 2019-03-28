package pl.sda.programming.generics;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

class GenericTests {
    private static final Logger log = LoggerFactory.getLogger(GenericTests.class);

    private GenericsMethods genericsMethods = new GenericsMethods();

    @Test
    void genericMethodTest() {
        List<String> list = genericsMethods.fromArrayToList("a", "b", "c");
        log.info("list={}", list);
    }

    @Test
    void givenArrayOfIntegers_thanListOfStringReturnedOK() {
        Integer[] intArray = {1, 2, 3, 4, 5};
        List<String> stringList
                = genericsMethods.fromArrayToList(intArray, Object::toString);
        log.info("string list={}", stringList);
    }

    @Test
    void wildcardTypes() {
        List<Building> buildings = new ArrayList<>();
        List<House> houses = new ArrayList<>();
        genericsMethods.paintAllBuildings(buildings);
//        genericsMethods.paintAllBuildings(houses);

        genericsMethods.paintAllBuildingsV2(buildings);
        genericsMethods.paintAllBuildingsV2(houses);
    }
}
