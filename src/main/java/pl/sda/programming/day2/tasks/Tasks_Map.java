package pl.sda.programming.day2.tasks;

import pl.sda.programming.day2.tasks.domain.Patient;
import pl.sda.programming.day2.tasks.domain.Pesel;

import java.util.Optional;

/**
 * Patient registry
 */
public interface Tasks_Map {

    void add(Patient patient);

    void update(Patient patient);

    boolean exist(Pesel pesel);

    Optional<Patient> get(Pesel pesel);

    int size();

}
