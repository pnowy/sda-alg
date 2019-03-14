package pl.sda.programming.day2to5.sorting;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UserSorting {

    public static void main(String[] args) throws Exception {
        File file = new File(UserSorting.class.getResource("/users/users.csv").getFile());
        Path path = Paths.get(file.getAbsolutePath());
        List<String> allLInes = Files.readAllLines(path);
        List<User> users = allLInes
                .stream()
                .skip(1)
                .filter(x -> !x.isEmpty())
                .map(x -> {
                    String[] split = x.split(",");
                    User user = new User();
                    //id,first_name,last_name,email,gender,ip_address,age,insurance_number
                    user.id = Integer.parseInt(split[0]);
                    user.first_name = split[1];
                    user.last_name = split[2];
                    user.email = split[3];
                    user.gender = split[4];
                    user.ip_address = split[5];
                    user.age = Integer.parseInt(split[6]);
                    user.insurance_number = split[7];
                    return user;
                })
                .collect(Collectors.toList());

        // print some users
        users
                .stream()
                .limit(10)
                .forEach(UserSorting::printUser);

        Comparator<? super User> firstNameComparator = new FirstNameComparator();

        List<User> listClone = new ArrayList<>(users);

        // different ways to sort by first_name
        listClone.sort((a, b) -> a.first_name.compareTo(b.first_name));
        listClone.sort(Comparator.comparing(a -> a.first_name));
        listClone.sort(firstNameComparator);
        Collections.sort(listClone, (a, b) -> a.first_name.compareTo(b.first_name));

        List<User> sorted = listClone
                .stream()
                .sorted(Comparator.comparing(x -> x.first_name))
                .collect(Collectors.toList());

        System.out.println("---------------------");
        listClone = new ArrayList<>(users);
        listClone
                .stream()
                .limit(10)
                .forEach(UserSorting::printUser);

        System.out.println("---------------------");
        System.out.println("Sort by age");
        listClone = new ArrayList<>(users);
        listClone.sort(Comparator.comparingInt(x -> x.age));
        listClone
                .subList(0, 10)
                .forEach(UserSorting::printUser);
        System.out.println("...");
        listClone
                .subList(listClone.size() - 10, listClone.size())
                .forEach(UserSorting::printUser);

        System.out.println("---------------------");
        System.out.println("Sort by PESEL");
        listClone = new ArrayList<>(users);
        listClone.sort(Comparator.comparing(x -> x.insurance_number));
        listClone
                .subList(0, 10)
                .forEach(UserSorting::printUser);
        System.out.println("...");
        listClone
                .subList(listClone.size() - 10, listClone.size())
                .forEach(UserSorting::printUser);

        System.out.println("---------------------");
        System.out.println("Sort by age then by name");
        listClone = new ArrayList<>(users);
        listClone.sort(Comparator.comparing((User x) -> x.age).thenComparing((User x) -> x.first_name));
        listClone
                .subList(0, 10)
                .forEach(UserSorting::printUser);
        System.out.println("...");
        listClone
                .subList(listClone.size() - 10, listClone.size())
                .forEach(UserSorting::printUser);
    }

    private static void printUser(User user) {
        String line = String.format("%-12s %-12s %2d %s", user.first_name, user.last_name, user.age, user.insurance_number);
        System.out.println(line);
    }

}
