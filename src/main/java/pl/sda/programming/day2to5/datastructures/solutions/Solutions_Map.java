package pl.sda.programming.day2to5.datastructures.solutions;

import pl.sda.programming.day2to5.datastructures.tasks.Tasks_Map;
import pl.sda.programming.day2to5.datastructures.domain.Patient;
import pl.sda.programming.day2to5.datastructures.domain.Pesel;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Solutions_Map implements Tasks_Map {

    private Map<Pesel, Patient> record = new HashMap<>();

    @Override
    public void add(Patient patient) {
        if (this.record.containsKey(patient.getPesel())) {
            throw new IllegalArgumentException("The patient exist in db. Use update to modify the patient!");
        }
        this.record.put(patient.getPesel(), patient);
    }

    @Override
    public void update(Patient patient) {
        if (!this.record.containsKey(patient.getPesel())) {
            throw new IllegalArgumentException("There is no patient with given pesel. Use add function!");
        }
        this.record.put(patient.getPesel(), patient);
    }

    @Override
    public boolean exist(Pesel pesel) {
        return this.record.containsKey(pesel);
    }

    @Override
    public Optional<Patient> get(Pesel pesel) {
        return Optional.ofNullable(this.record.get(pesel));
    }

    @Override
    public int size() {
        return this.record.size();
    }

}
