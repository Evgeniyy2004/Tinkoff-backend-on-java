package edu.hw7;

import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

public class AddressPersonDataBase {

    HashMap<String,Person> all = new HashMap<>();
    public synchronized void add(Person person) {
        all.put(person.phoneNumber(), person);
    }
    public synchronized Person delete(@NotNull String address) {
        if (all.containsKey(address)) return all.remove(address);
        else return null;
    }
    public synchronized Person findBy(@NotNull String address) {
        if (all.containsKey(address)) return all.get(address);
        return null;
    }

}
