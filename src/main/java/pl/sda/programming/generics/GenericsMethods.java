package pl.sda.programming.generics;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GenericsMethods {

    public <T> List<T> fromArrayToList(T... a) {
        return Arrays.stream(a).collect(Collectors.toList());
    }

    public <T, G> List<G> fromArrayToList(T[] a, Function<T, G> mapperFunction) {
        return Arrays.stream(a)
                .map(mapperFunction)
                .collect(Collectors.toList());
    }

    public <T extends Number & Comparable> List<T> fromBoundedArrayToList(T... a) {
        return Arrays.stream(a).collect(Collectors.toList());
    }



    public void paintAllBuildings(List<Building> buldings) {
        System.out.println(buldings);
        buldings.forEach(Building::paint);
    }

    // PECS - Producer Extends, Consumer Super

    // the list is producer (you want to iterate over list)
    // The reasoning is that a Collection<? extends Building> could hold any subtype of Building,
    // and thus each element will behave as a Building when you perform your operation.
    // (You actually cannot add anything to a Collection<? extends Building>, because you cannot know at runtime
    // which specific subtype of Building the collection holds.)
    public void paintAllBuildingsV2(List<? extends Building> buldings) {
        System.out.println(buldings);
        buldings.forEach(Building::paint);
    }

    // Then the list is a consumer, so you should use a Collection<? super Building>.

    // The reasoning here is that unlike Collection<? extends Building>, Collection<? super Building> can always hold a Building
    // no matter what the actual parameterized type is. Here you don't care what is already in the list as long as it will allow a
    // Building to be added; this is what ? super Building guarantees.
    public void paintAllBuildingsV3(List<? super Building> buldings) {
        System.out.println(buldings);
//        buldings.forEach(Building::paint);
        buldings.add(new Building());
        buldings.add(new House());
    }

}
